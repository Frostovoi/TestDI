package android.test.testciceronedi

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class Navigation @Inject constructor (private val  router: Router) {


    private fun itemScreen(counter: Int) = object : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment =
            FragmentItem.newInstance(counter)
    }

    fun openScreen(counter: Int) = router.navigateTo(itemScreen(counter))


}