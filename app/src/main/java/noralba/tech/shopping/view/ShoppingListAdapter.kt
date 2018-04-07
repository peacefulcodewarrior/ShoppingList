package noralba.tech.shopping.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.shopping_list.view.*
import noralba.tech.shopping.R
import noralba.tech.shopping.domain.model.ShoppingList
import java.util.*

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 30/03/18.
 */
class ShoppingListAdapter(var items: List<ShoppingList>) : RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName?.text = items[position].name
        holder.created?.text = Date(items[position].created).toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.shopping_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtName = itemView.txtName
        val created = itemView.txtInfo
    }

}