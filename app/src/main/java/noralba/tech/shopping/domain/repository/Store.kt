package noralba.tech.shopping.domain.repository

import noralba.tech.shopping.domain.model.ShoppingList

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 29/03/18.
 */
interface Store<T> {
    fun getAll(): List<T>
    fun create(name: String): ShoppingList?
}