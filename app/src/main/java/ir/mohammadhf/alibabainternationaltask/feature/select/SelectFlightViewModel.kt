package ir.mohammadhf.alibabainternationaltask.feature.select

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SelectFlightViewModel @Inject constructor() : ViewModel() {
    private val _onFormComplete = MutableLiveData<Boolean>(false)
    val onFormComplete: LiveData<Boolean> = _onFormComplete

    var travelDestTxt: String = ""
    set(value) {
        field = value
        changeOnFormComplete()
    }
    var travelFromTxt: String = ""
    set(value) {
        field = value
        changeOnFormComplete()
    }
    var selectedDate: String = ""
    set(value) {
        field = value
        changeOnFormComplete()
    }

    private fun changeOnFormComplete() {
        _onFormComplete.value =
            travelDestTxt.isNotEmpty()
                    && travelFromTxt.isNotEmpty()
                    && selectedDate.isNotEmpty()
    }
}