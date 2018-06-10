package noralba.tech.shopping.resolvers

import noralba.tech.shopping.domain.usecase.CreateShoppingListUseCase
import noralba.tech.shopping.domain.usecase.GetAllShoppingListUseCase
import noralba.tech.shopping.domain.usecase.GetShoppingListUseCase

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 13/05/18.
 */
object UseCaseResolver {
    fun resolveCreateShoppingListUseCase() : CreateShoppingListUseCase {
        return CreateShoppingListUseCase(RepositoryResolver.shoppingListRepository)
    }

    fun resolveGetAllShoppingListUseCase() : GetAllShoppingListUseCase {
        return GetAllShoppingListUseCase(RepositoryResolver.shoppingListRepository)
    }

    fun resolveGetShoppingListUseCase(): GetShoppingListUseCase {
        return GetShoppingListUseCase(RepositoryResolver.shoppingListRepository)
    }
}