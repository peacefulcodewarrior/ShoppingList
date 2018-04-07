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
import noralba.tech.shopping.R
import noralba.tech.shopping.domain.model.ShoppingList

class MainActivity : AppCompatActivity(), MainPresenter.MainView {
    private val presenter: MainPresenter by lazy {
        MainPresenter(this, (application as ShoppingListApplication).executor)
    }

    private val adapter = ShoppingListAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
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
        presenter.start()
    }

    override fun showShoppingLists(list: List<ShoppingList>) {
        if (list.isEmpty()) {
            empty_list.visibility = View.VISIBLE
            recyclerList.visibility = View.GONE
            return
        }
        empty_list.visibility = View.GONE
        recyclerList.visibility = View.VISIBLE
        adapter.items = list
        adapter.notifyDataSetChanged()
    }

    override fun showUnexpectedError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
