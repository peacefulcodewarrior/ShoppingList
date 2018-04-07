package noralba.tech.shopping.domain.model

import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import noralba.tech.shopping.domain.model.ShoppingList.ListItem
import noralba.tech.shopping.domain.repository.ShoppingListRepository
import noralba.tech.shopping.domain.repository.Store

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 27/03/18.
 */
class ProductTest {

    @Test
    fun getName() {

        var list = ShoppingList("eo")
        println(list)
        list = ShoppingList("oe", mutableListOf(ListItem(Product("papel"))))
        println(list)
        list.add(ListItem(Product("laca")))
        println(list)

        val product = Product("Salchichas")

        val actual = product.name

        assertThat(actual, `is`(equalTo("Salchichas")))
    }

}