package io.github.ovso.koreadigit

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("io.github.ovso.koreadigit", appContext.packageName)
        val digits = appContext.resources.getStringArray(R.array.digits)
        DigitNameProvider().apply {
            setListener {
                assertTrue("12만3456원" == it)
            }
            digitSymbols = digits.toMutableList()
            toKoreaDigit("123456")
        }
    }
}
