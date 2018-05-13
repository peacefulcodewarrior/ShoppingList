package noralba.tech.shopping.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.create_dialog.view.*
import noralba.tech.shopping.R
import noralba.tech.shopping.domain.model.ShoppingList
import noralba.tech.shopping.resolvers.PresenterResolver
import noralba.tech.shopping.resolvers.ViewResolver
import org.jetbrains.anko.alert
import org.jetbrains.anko.contentView
import org.jetbrains.anko.noButton
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity(), MainPresenter.MainView {
    private val presenter = PresenterResolver.resolveMainPresenter()
    private val adapter = ShoppingListAdapter(emptyList())
    private var resumed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.init(this)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            alert {
                title = getString(R.string.create_list_dialog_title)
                val layout = layoutInflater.inflate(R.layout.create_dialog, null)
                customView = layout
                yesButton {
                    presenter.createShoppingListRequested(layout.nameInputText.text.toString())
                }
                noButton {}
            }.show()
        }


        recyclerList.adapter = adapter
        recyclerList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
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

    override fun showShoppingLists(list: List<ShoppingList>) {
        runOnUiThread {
            if (!resumed) return@runOnUiThread

            if (list.isEmpty()) {
                empty_list.visibility = View.VISIBLE
                recyclerList.visibility = View.GONE
                return@runOnUiThread
            }

            empty_list.visibility = View.GONE
            recyclerList.visibility = View.VISIBLE
            adapter.items = list
            adapter.notifyDataSetChanged()
        }
    }

    override fun showUnexpectedErrorCreatingList() {
        runOnUiThread {
            if (!resumed) return@runOnUiThread

            Snackbar.make(contentView!!, "Unexpected error!!!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()

        }
    }

    override fun openShoppingLists(list: ShoppingList) {
        runOnUiThread {
            if (!resumed) return@runOnUiThread

            ViewResolver.openDetailView(this, list.name)
        }
    }
}
