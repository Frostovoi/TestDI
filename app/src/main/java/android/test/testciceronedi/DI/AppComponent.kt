package android.test.testciceronedi.DI

import android.content.Context
import android.test.testciceronedi.FragmentItem
import android.test.testciceronedi.MainActivity
import android.test.testciceronedi.Navigation
import androidx.fragment.app.FragmentActivity
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component


@Component(modules = [AppModule::class])
interface AppComponent {
    val cicerone: Cicerone<Router>
    val router: Router
    val navigatorHolder: NavigatorHolder
    val navigation: Navigation
    //val navigator: Navigator

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: FragmentActivity): Builder

        fun build(): AppComponent

    }

}