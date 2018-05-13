package noralba.tech.shopping.domain.repository

import noralba.tech.shopping.domain.model.ShoppingList

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 29/03/18.
 */

class ShoppingListRepositoryImpl(private val store: Store<ShoppingList>) : ShoppingListRepository {

    override fun getAllShoppingLists() = store.getAll()

    override fun createShoppingList(name: String): ShoppingList? = store.create(name)
}
