package noralba.tech.shopping.view

import noralba.tech.shopping.domain.model.ShoppingList
import noralba.tech.shopping.domain.usecase.GetAllShoppingListUseCase
import java.util.concurrent.Executor

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 30/03/18.
 */
class MainPresenter(private val view: MainView, private val executor: Executor) {

    interface MainView {
        fun showShoppingLists(list: List<ShoppingList>)
        fun showUnexpectedError()
    }

    fun start() {
        executor.execute(
                GetAllShoppingListUseCase(
                        { view.showShoppingLists(it) },
                        { view.showUnexpectedError() }
                )
        )
    }
}