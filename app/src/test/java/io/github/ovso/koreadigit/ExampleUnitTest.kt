package io.github.ovso.koreadigit

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

const val TEST1 =
    "123456789011121314151617181920212223242526272829303132333435363738394041424344454647484950"
const val TEST2 =
    "123456000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
const val TEST3 = "1234567890"
const val TEST4 =
    "1234567890111213141516171819202000000072829303132330000000738394041424344454647484950"

class ExampleUnitTest {
    private var digitNameProvider: DigitNameProvider? = null

    @Before
    fun setup() {
        digitNameProvider = DigitNameProvider()
    }

    @Test
    fun test() {
        digitNameProvider?.setListener {
            println(it)
            assertTrue("1234567890111213141516무량대수1718불가사의1920나유타2122아승기2324항하사2526극2728재2930정3132간3334구3536양3738자3940해4142경4344조4546억4748만4950원" == it)

        }
        digitNameProvider?.toKoreaDigit(TEST1)

        digitNameProvider?.setListener {
            println(it)
            assertTrue("1234560000000000000000무량대수원" == it)

        }
        digitNameProvider?.toKoreaDigit(TEST2)
        digitNameProvider?.setListener {
            println(it)
            assertTrue("12억3456만7890원" == it)

        }
        digitNameProvider?.toKoreaDigit(TEST3)
        digitNameProvider?.setListener {
            println(it)
            assertTrue("12345678901112131무량대수4151불가사의6171나유타8192아승기0200항하사0728재2930정3132간3300구0738자3940해4142경4344조4546억4748만4950원" == it)

        }
        digitNameProvider?.toKoreaDigit(TEST4)
    }
}
