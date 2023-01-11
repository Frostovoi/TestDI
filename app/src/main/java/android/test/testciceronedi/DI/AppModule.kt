package android.test.testciceronedi.DI


import android.test.testciceronedi.Navigation
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @Singleton
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