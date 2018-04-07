package noralba.tech.shopping.domain.usecase

import noralba.tech.shopping.domain.model.ShoppingList
import noralba.tech.shopping.domain.repository.ShoppingListRepository

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 30/03/18.
 */
class GetAllShoppingListUseCase(
        private val successListener: ((result: List<ShoppingList>) -> Unit)? = null,
        private val failureListener: ((result: Error) -> Unit)? = null)
    : Runnable {

    override fun run() {
        println("Running")
        try {
            successListener?.invoke(ShoppingListRepository.getAllShoppingLists())
        } catch (t: Throwable) {
            failureListener?.invoke(Error.IOError)
        }
    }

}