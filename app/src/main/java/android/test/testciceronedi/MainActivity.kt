package android.test.testciceronedi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.test.testciceronedi.DI.AppComponent
import android.test.testciceronedi.DI.DaggerAppComponent
import android.util.Log
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

private val START_COUNTER = 1
private val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {



    private val navigator: Navigator = AppNavigator(this, R.id.fragment_container)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        appComponent.inject(this)
        if (savedInstanceState == null){
            App.NAVIGATION.openScreen(0)
        }
        Log.d(TAG, "MainActivity")
    }

    override fun onResume() {
        super.onResume()
        appComponent.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        appComponent.navigatorHolder.removeNavigator()

    }

}