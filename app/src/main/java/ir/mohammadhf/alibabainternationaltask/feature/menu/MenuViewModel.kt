package ir.mohammadhf.alibabainternationaltask.feature.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mohammadhf.alibabainternationaltask.data.model.User
import ir.mohammadhf.alibabainternationaltask.data.repo.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    var travelDestText: String = ""
        set(value) {
            onDestChanged(value)
            field = value
        }
    private val _destination = MutableLiveData<Boolean>(false)
    val destination: LiveData<Boolean> = _destination

    private var lastPage = 0
    private val _users = MutableLiveData<ArrayList<User>>()
    val users: LiveData<ArrayList<User>> = _users

    fun loadUsers() {
        viewModelScope.launch {
            lastPage++
            val gotUsers = userRepository.getUsers(lastPage)
            if (gotUsers.isEmpty()) lastPage--
            else {
                _users.value = _users.value?.apply { addAll(gotUsers) }
                    ?: arrayListOf<User>().apply { addAll(gotUsers) }
            }
        }
    }

    private fun onDestChanged(dest: String) {
        _destination.value = dest.isNotEmpty()
    }
}