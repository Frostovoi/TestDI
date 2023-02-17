package android.test.testciceronedi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import java.util.*
import javax.inject.Inject

class StateViewModel(
    val uuid: UUID,
    var counter: Counter
    ) : ViewModel() {

    var liveDataCounter: LiveData<Counter> = MutableLiveData(counter)


    class Factory @Inject constructor(
        private val uuid: UUID,
        private val counter: Counter
            ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return StateViewModel(uuid, counter) as T
        }


    }





}