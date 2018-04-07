package noralba.tech.shopping.domain.usecase

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 30/03/18.
 */
class Result<Failure, Success>(val error:Failure?, val success:Success?) {
    fun isSuccess()= error == null
}