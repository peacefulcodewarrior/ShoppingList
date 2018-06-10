package noralba.tech.shopping.doubles

import noralba.tech.shopping.domain.model.ShoppingList
import noralba.tech.shopping.domain.repository.Result
import noralba.tech.shopping.domain.repository.ShoppingListError
import noralba.tech.shopping.domain.repository.ShoppingListStore
import noralba.tech.shopping.domain.repository.Store
import java.io.IOError
import java.util.Arrays.asList

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 30/03/18.
 */
class DummyStore:ShoppingListStore {
    val data = mutableMapOf<String, ShoppingList>()

    override fun getAll(): Result<ShoppingListError, List<ShoppingList>> = Result(null,data.values.toList())

    override fun create(name: String): Result<ShoppingListError,ShoppingList> {
        data.put(name, ShoppingList(name))

        return getShoppingList(name)
    }

    override fun getShoppingList(name: String): Result<ShoppingListError, ShoppingList> {
        val list = data[name]

        if (list == null) {
            return Result(ShoppingListError.IOError, null)
        }
        return Result(null, list)
    }

}
