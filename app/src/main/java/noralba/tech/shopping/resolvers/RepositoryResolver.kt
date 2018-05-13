package noralba.tech.shopping.resolvers

import noralba.tech.shopping.domain.repository.ShoppingListRepositoryImpl
import noralba.tech.shopping.doubles.DummyStore

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 13/05/18.
 */
object RepositoryResolver {

    val store = DummyStore()
    val shoppingListRepository = ShoppingListRepositoryImpl(store)
}