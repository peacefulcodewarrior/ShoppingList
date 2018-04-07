package noralba.tech.shopping.view

import android.app.Application
import noralba.tech.shopping.domain.repository.ShoppingListRepository
import noralba.tech.shopping.doubles.DummyStore
import java.util.concurrent.Executors

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 30/03/18.
 */
class ShoppingListApplication: Application() {

    val executor = Executors.newFixedThreadPool(10);

    override fun onCreate() {
        super.onCreate()
        ShoppingListRepository.init(DummyStore())
    }
}