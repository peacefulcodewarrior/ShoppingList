package noralba.tech.shopping.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout

import kotlinx.android.synthetic.main.activity_shopping_list_detail.*
import kotlinx.android.synthetic.main.content_shopping_list_detail.*
import kotlinx.android.synthetic.main.create_new_list_dialog.view.*
import kotlinx.android.synthetic.main.create_new_list_item_dialog.view.*
import noralba.tech.shopping.R
import noralba.tech.shopping.domain.model.ShoppingList
import noralba.tech.shopping.presenter.DetailPresenter
import noralba.tech.shopping.resolvers.PresenterResolver
import org.jetbrains.anko.*

class ShoppingListDetailActivity : AppCompatActivity(), DetailPresenter.DetailView {

    companion object {

        private const val INTENT_LIST_NAME = "list_name"

        fun open(context: Context, name: String) {
            val intent = Intent(context, ShoppingListDetailActivity::class.java)
            intent.putExtra(INTENT_LIST_NAME, name)
            context.startActivity(intent)
        }
    }

    private val presenter = PresenterResolver.resolveDetailPresenter()
    private var resumed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list_detail)

        val name = intent.getStringExtra(INTENT_LIST_NAME)
        presenter.init(this, name)

        setSupportActionBar(detailToolbar)

        supportActionBar?.title = name

        detailFab.setOnClickListener {
            createNewItemAlertBuilder().show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerListDetail.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this, LinearLayout.VERTICAL, false)
    }

    @SuppressLint("InflateParams")
    private fun createNewItemAlertBuilder(): AlertBuilder<DialogInterface> {
        return alert {
            title = getString(R.string.create_list_item_dialog_title)
            val layout = layoutInflater.inflate(R.layout.create_new_list_item_dialog, null)
            customView = layout
            yesButton {
                val name = layout.nameInputText.text.toString()
                val quantity = layout.productQuantityInput.text.toString().toInt()
                val price = layout.productPriceInput.text.toString().toFloat()
                presenter.createItemRequested(name, quantity, price)
            }
            noButton {}
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings ->
                return true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        resumed = true
        presenter.start()
    }

    override fun onPause() {
        super.onPause()
        resumed = false
    }

    override fun showShoppingList(list: ShoppingList) {
        runOnUiThread {
            if (!resumed) return@runOnUiThread

            if (list.isEmpty()) {
                detailEmptyList.visibility = View.VISIBLE
                recyclerListDetail.visibility = View.GONE
                return@runOnUiThread
            }

            detailEmptyList.visibility = View.GONE
            recyclerListDetail.visibility = View.VISIBLE

            val adapter = ShoppingListAdapter(list)
            recyclerListDetail.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }

    override fun showUnexpectedErrorCreatingProduct() {
        runOnUiThread {
            if (!resumed) return@runOnUiThread

            Snackbar.make(contentView!!, "Unexpected error!!!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()

        }
    }

}
