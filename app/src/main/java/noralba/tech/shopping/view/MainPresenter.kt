package noralba.tech.shopping.view

import noralba.tech.shopping.domain.model.ShoppingList
import noralba.tech.shopping.domain.usecase.CreateShoppingListUseCase
import noralba.tech.shopping.domain.usecase.GetAllShoppingListUseCase
import java.util.concurrent.Executor

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 30/03/18.
 */
class MainPresenter(private val getAllShoppingListUseCase: GetAllShoppingListUseCase,
                    private val createShoppingListUseCase: CreateShoppingListUseCase,
                    private val executor: Executor) {

    interface MainView {
        fun showShoppingLists(list: List<ShoppingList>)
        fun showUnexpectedErrorCreatingList()
        fun openShoppingLists(list: ShoppingList)
    }

    @Volatile
    private var lazyView: MainView? = null

    private val view: MainView by lazy {
        val result = lazyView ?: throw IllegalStateException("store missing!")
        this.lazyView = null // clean ref
        result
    }

    internal fun init(view: MainView) {
        lazyView = lazyView ?: view
    }

    fun start() {
        executor.execute {
            getAllShoppingListUseCase.execute(
                { view.showShoppingLists(it) },
                { view.showUnexpectedErrorCreatingList() }
            )
        }
    }

    fun createShoppingListRequested(text: String?) {
        text?: return

        executor.execute {
            createShoppingListUseCase.execute(
                text,
                { view.openShoppingLists(it) },
                { view.showUnexpectedErrorCreatingList() }
            )
        }
    }
}