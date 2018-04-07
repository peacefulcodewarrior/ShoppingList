package noralba.tech.shopping.domain.repository

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 29/03/18.
 */
interface Store<T> {
    fun getAll(): List<T>

}