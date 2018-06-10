package noralba.tech.shopping.domain.repository

import noralba.tech.shopping.domain.model.ShoppingList

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 29/03/18.
 */
interface ShoppingListStore: Store<ShoppingListError, ShoppingList> {
    fun getAll(): Result<ShoppingListError, List<ShoppingList>>
    fun create(name: String): Result<ShoppingListError, ShoppingList>
    fun getShoppingList(name: String): Result<ShoppingListError, ShoppingList>
}