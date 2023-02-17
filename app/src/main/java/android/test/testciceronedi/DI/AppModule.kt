package android.test.testciceronedi.DI


import android.test.testciceronedi.Counter
import android.test.testciceronedi.CustomRouter
import android.test.testciceronedi.Navigation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Singleton

private const val START_COUNTER = 1

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideCicerone(): Cicerone <CustomRouter> = Cicerone.create(CustomRouter())

    @Provides
    fun provideRouter(cicerone: Cicerone<CustomRouter>): CustomRouter = cicerone.router

    @Provides
    fun provideNavigatorHolder(cicerone: Cicerone<CustomRouter>)
        : NavigatorHolder = cicerone.getNavigatorHolder()

    @Provides
    fun provideNavigation(router: CustomRouter): Navigation = Navigation(router)

    @Provides
    fun provideUUID(): UUID = UUID.randomUUID()

    @Provides
    fun provideStartCounter(): Int = START_COUNTER


}