package noralba.tech.shopping.resolvers

import android.content.Context
import noralba.tech.shopping.view.ShoppingListDetailActivity

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 13/05/18.
 */
object ViewResolver {
    fun openDetailView(context:Context, name: String) {
        ShoppingListDetailActivity.open(context, name)
    }
}