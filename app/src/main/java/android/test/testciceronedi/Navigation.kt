package android.test.testciceronedi

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class Navigation @Inject constructor (private val  router: CustomRouter) {


    private fun itemScreen() = object : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment =
            FragmentItem.newInstance()
    }

    fun openScreen() = router.navigateTo(itemScreen())

    fun backScreen() = router.back()


}
