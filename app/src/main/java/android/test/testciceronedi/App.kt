package android.test.testciceronedi

import android.app.Application
import android.content.Context
import android.test.testciceronedi.DI.AppComponent
import android.test.testciceronedi.DI.DaggerAppComponent
import androidx.fragment.app.FragmentActivity
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import javax.inject.Inject


class App : Application() {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var cicerone: Cicerone<Router>
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var navigatorHolder: NavigatorHolder


    override fun onCreate() {
        super.onCreate()

            appComponent = DaggerAppComponent.builder().build()


        INSTANCE = this

        NAVIGATION = Navigation(router)
    }


    companion object {
        internal lateinit var INSTANCE: App
            private set

        internal lateinit var NAVIGATION: Navigation

    }
}

val Context.appComponent: AppComponent
    get() = when(this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }
