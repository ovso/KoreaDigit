package io.github.ovso.koreadigit

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

const val TEST1 = "123456789011121314151617181920212223242526272829303132333435363738394041424344454647484950"
const val TEST2 = "123456000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
class ExampleUnitTest {
    private var digitNameProvider: DigitNameProvider? = null

    @Before
    fun setup() {
        digitNameProvider = DigitNameProvider()
    }

    @Test
    fun test() {
        digitNameProvider?.setListener {
//            assertTrue("1억2345만6789원" == it)
//            println(it)
        }
        digitNameProvider?.toKoreaDigit(TEST2)
    }
}
