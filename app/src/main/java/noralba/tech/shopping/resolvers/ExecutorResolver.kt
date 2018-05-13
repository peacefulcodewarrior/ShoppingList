package noralba.tech.shopping.resolvers

import java.util.concurrent.Executors

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 13/05/18.
 */
object ExecutorResolver {
    val executor = Executors.newFixedThreadPool(10)!!
}