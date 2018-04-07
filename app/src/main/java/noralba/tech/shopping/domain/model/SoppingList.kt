package noralba.tech.shopping.domain.model

import java.util.*

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 27/03/18.
 */
data class ShoppingList(var name: String, val list: MutableList<ListItem> = mutableListOf()): MutableList<ShoppingList.ListItem> by list {
    data class ListItem(val product: Product, var quantity:Int = 1, var price:Float = 0F)

    val created = Date().time
    var modified = created

    override fun toString(): String {
        return "SoppingList(name=$name, created=$created, modified=$modified, list=$list)"
    }
}