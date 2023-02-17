package android.test.testciceronedi

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
data class Counter @Inject constructor (private var counter: Int) {

    fun getValue(): Int = counter

    fun setValue(value: Int) {
        counter = value
    }
}