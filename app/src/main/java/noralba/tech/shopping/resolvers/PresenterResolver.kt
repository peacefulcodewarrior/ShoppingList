package noralba.tech.shopping.resolvers

import noralba.tech.shopping.view.DetailPresenter
import noralba.tech.shopping.view.MainPresenter

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 13/05/18.
 */
object PresenterResolver {

    fun resolveMainPresenter(): MainPresenter {
        return MainPresenter(UseCaseResolver.resolveGetAllShoppingListUseCase(),
                UseCaseResolver.resolveCreateShoppingListUseCase(),
                ExecutorResolver.executor
        )
    }

    fun resolveDetailPresenter(): DetailPresenter {
        return DetailPresenter(UseCaseResolver.resolveGetShoppingListUseCase(),
                ExecutorResolver.executor
        )
    }
}