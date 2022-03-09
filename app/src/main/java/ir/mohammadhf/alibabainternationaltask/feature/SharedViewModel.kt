package ir.mohammadhf.alibabainternationaltask.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {
    private val _destination = MutableLiveData<String>("")
    val destination: LiveData<String> = _destination

    fun setDestination(dest: String) {
        _destination.value = dest
    }
}