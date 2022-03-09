package ir.mohammadhf.alibabainternationaltask

import android.net.ConnectivityManager
import android.net.NetworkInfo
import javax.inject.Inject

class InternetChecker @Inject constructor(
    private val networkInfo: NetworkInfo?
) {

    fun isNetworkAvailable(): Boolean =
        networkInfo != null && networkInfo.isAvailable && networkInfo.isConnected

}