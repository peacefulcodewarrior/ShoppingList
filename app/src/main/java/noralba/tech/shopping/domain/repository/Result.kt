package noralba.tech.shopping.domain.repository

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 30/03/18.
 */
class Result<Failure, Data>(val error:Failure?, val data:Data?) {
    fun isSuccess()= error == null
}