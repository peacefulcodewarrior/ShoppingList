package noralba.tech.shopping.domain.repository

import noralba.tech.shopping.domain.model.ShoppingList

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 29/03/18.
 */

class ShoppingListRepositoryImpl(private val store: ShoppingListStore) : ShoppingListRepository {
    override fun getAllShoppingLists() = store.getAll()

    override fun createShoppingList(name: String): Result<ShoppingListError, ShoppingList> {
        return if (name.isBlank()) {
            Result(ShoppingListError.WrongInput, null)
        } else {
            store.create(name)
        }
    }

    override fun getShoppingList(name: String): Result<ShoppingListError, ShoppingList> = store.getShoppingList(name)
}
