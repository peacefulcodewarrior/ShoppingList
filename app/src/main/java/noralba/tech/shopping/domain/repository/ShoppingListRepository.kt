package noralba.tech.shopping.domain.repository

import noralba.tech.shopping.domain.model.ShoppingList

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 29/03/18.
 */

object ShoppingListRepository {

    private val store: Store<ShoppingList> by lazy {
        val result = lazyStore ?: throw IllegalStateException("store missing!")
        this.lazyStore = null // clean ref
        result
    }

    @Volatile
    private var lazyStore: Store<ShoppingList>? = null

    fun init(storeToSet: Store<ShoppingList>) {
        lazyStore = synchronized(this) {
            lazyStore ?: storeToSet
        }
    }

    fun getAllShoppingLists() = store.getAll()
}
