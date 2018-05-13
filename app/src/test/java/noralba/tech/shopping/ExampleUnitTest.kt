package noralba.tech.shopping

import org.junit.Test

import org.junit.Assert.*
import java.lang.Double.POSITIVE_INFINITY
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun pruebas() {

        val bytes = 0b01111111_00000000_01010101_01010101_01010101_01010101_01010101_01010101
        println(bytes)

        val x:Int = (0xFFFFFFFC.toInt() ushr 0)

        println("is $x Int.MAX_VALUE? " + (Int.MAX_VALUE == x))

        val a = 2

        val f = 2.0F
        val nan = POSITIVE_INFINITY
        println("nan: $nan")
        println("is $f > $a ? " + (f >= a))

        val two = '2'
        val three:Int = two.toInt() - '0'.toInt() + 1
        println(three)

        val asc = Array(5, { (it * it).toString() })
        println(Arrays.toString(asc))

        val ascInt = Array(5, { it * it })
        println(Arrays.toString(ascInt))


    }
}
