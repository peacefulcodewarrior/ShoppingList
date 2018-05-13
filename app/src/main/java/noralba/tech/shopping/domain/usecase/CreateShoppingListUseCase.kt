package noralba.tech.shopping.domain.usecase

import noralba.tech.shopping.domain.model.ShoppingList
import noralba.tech.shopping.domain.repository.ShoppingListRepository

class CreateShoppingListUseCase(private val repository: ShoppingListRepository) {

    fun execute(name: String,
                successListener: ((result: ShoppingList) -> Unit)? = null,
                failureListener: ((result: Error) -> Unit)? = null) {

        try {
            repository.createShoppingList(name)
                    ?.let {
                        successListener?.invoke(it)
                        return
                    }
        } catch (ignored: Throwable) {
        }

        failureListener?.invoke(Error.IOError)
    }
}
