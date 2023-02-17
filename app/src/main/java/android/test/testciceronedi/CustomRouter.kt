package android.test.testciceronedi

import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class CustomRouter : Router() {

    fun back() {
        executeCommands(Back())
    }
}