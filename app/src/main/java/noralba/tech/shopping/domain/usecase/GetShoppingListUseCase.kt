package noralba.tech.shopping.domain.usecase

import noralba.tech.shopping.domain.model.ShoppingList
import noralba.tech.shopping.domain.repository.ShoppingListError
import noralba.tech.shopping.domain.repository.ShoppingListRepository

class GetShoppingListUseCase(private val repository: ShoppingListRepository) {

    fun execute(name: String,
                successListener: ((result: ShoppingList) -> Unit)? = null,
                failureListener: ((result: ShoppingListError) -> Unit)? = null) {

        val result = repository.getShoppingList(name)
        if (result.isSuccess()) {
            successListener?.invoke(result.data!!)
            return
        }
        failureListener?.invoke(result.error!!)
    }
}
