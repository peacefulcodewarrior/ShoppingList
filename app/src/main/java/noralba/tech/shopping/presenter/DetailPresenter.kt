package noralba.tech.shopping.presenter

import noralba.tech.shopping.domain.model.ShoppingList
import noralba.tech.shopping.domain.usecase.GetShoppingListUseCase
import java.util.concurrent.Executor

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 30/03/18.
 */
class DetailPresenter(private val getShoppingListUseCase: GetShoppingListUseCase,
                      private val executor: Executor) {

    interface DetailView {
        fun showShoppingList(list: ShoppingList)
        fun showUnexpectedErrorCreatingProduct()
    }

    @Volatile
    private var lazyView: DetailView? = null

    private val view: DetailView by lazy {
        val result = lazyView ?: throw IllegalStateException("DetailView missing!")
        this.lazyView = null // clean ref
        result
    }

    @Volatile
    private var lazyShoppingList: ShoppingList? = null

    private var shoppingListName = ""
    private var shoppingList: ShoppingList? = null

    internal fun init(view: DetailView, name: String) {
        lazyView = lazyView ?: view
        shoppingListName = name
    }

    fun start() {
        executor.execute {
            getShoppingListUseCase.execute(
                shoppingListName,
                { view.showShoppingList(it) },
                { view.showUnexpectedErrorCreatingProduct() }
            )
        }
    }

    fun createItemRequested(text: String, quantity: Int?, price: Float?) {

        executor.execute {
//            createShoppingListUseCase.execute(
//                text,
//                { view.openShoppingLists(it) },
//                { view.showUnexpectedErrorCreatingList() }
//            )
        }
    }
}