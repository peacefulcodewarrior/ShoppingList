package noralba.tech.shopping.domain.model

/**
 * TODO add description
 *
 * @author Santiago Cañada
 * Created on 27/03/18.
 */
data class Product(var name: String, var category: String = "") {
    var description: String = ""
    var image: String = ""

    override fun toString(): String {
        return "Product(name='$name', category='$category', description='$description', image='$image')"
    }
}