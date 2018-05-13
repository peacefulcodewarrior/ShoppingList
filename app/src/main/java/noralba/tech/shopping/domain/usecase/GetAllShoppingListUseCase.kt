package noralba.tech.shopping.domain.usecase

import noralba.tech.shopping.domain.model.ShoppingList
import noralba.tech.shopping.domain.repository.ShoppingListRepository

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 30/03/18.
 */
class GetAllShoppingListUseCase(private val repository: ShoppingListRepository) {

    fun execute(successListener: ((result: List<ShoppingList>) -> Unit)? = null,
                failureListener: ((result: Error) -> Unit)? = null) {
        try {
            val list = repository.getAllShoppingLists()
            successListener?.invoke(list)
        } catch (t: Throwable) {
            failureListener?.invoke(Error.IOError)
        }
    }

}