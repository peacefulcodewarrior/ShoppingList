package noralba.tech.shopping.doubles

import noralba.tech.shopping.domain.model.ShoppingList
import noralba.tech.shopping.domain.repository.Store

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 30/03/18.
 */
class DummyStore:Store<ShoppingList> {
    val data = mutableListOf(ShoppingList("lista primera"), ShoppingList("Lista segunda"), ShoppingList("Lista tercera"), ShoppingList("Lista cuarta"), ShoppingList("Lista quinta"), ShoppingList("Lista sexta"), ShoppingList("Lista sépima"), ShoppingList("Lista octava"), ShoppingList("Lista novena"))

    override fun getAll(): List<ShoppingList> = data.toList()

    override fun create(name: String): ShoppingList? {
        val list = ShoppingList(name)
        val added = data.add(list)

        return if (added) list else null
    }

}