package noralba.tech.shopping.view

import noralba.tech.shopping.domain.model.ShoppingList
import noralba.tech.shopping.domain.repository.ShoppingListRepository
import noralba.tech.shopping.doubles.DummyStore
import org.junit.Test
import java.util.concurrent.Executor

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 30/03/18.
 */
class MainPresenterTest {

    @Test
    fun start() {
        //ShoppingListRepository.init(DummyStore())
        val executor:Executor = Executor {
            it.run()
        }

        val presenter = MainPresenter(object : MainPresenter.MainView {
            override fun showShoppingLists(list: List<ShoppingList>) {
                println("success: $list")
            }

            override fun showUnexpectedError() {
                println("error: ")
            }
        }, executor)

        presenter.start()
    }
}