package noralba.tech.shopping.domain.repository

import noralba.tech.shopping.domain.model.ShoppingList

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 13/05/18.
 */
interface ShoppingListRepository {
    fun getAllShoppingLists() : List<ShoppingList>

    fun createShoppingList(name: String): ShoppingList?
}