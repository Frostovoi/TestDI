package android.test.testciceronedi.DI

import android.content.Context
import android.test.testciceronedi.MainActivity
import android.test.testciceronedi.Navigation
import android.test.testciceronedi.R
import androidx.fragment.app.FragmentActivity
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    fun provideCicerone(): Cicerone <Router> = Cicerone.create()

    @Provides
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @Provides
    fun provideNavigatorHolder(cicerone: Cicerone<Router>)
        : NavigatorHolder = cicerone.getNavigatorHolder()

    @Provides
    fun provideNavigation(router: Router): Navigation = Navigation(router)

//    @Provides
//    fun provideNavigator(activity: FragmentActivity, containerId: Int)
//        : Navigator = AppNavigator(activity, containerId)
//
//    @Provides
//    fun provideContainerId(containerId: Int) = R.id.fragment_container
}