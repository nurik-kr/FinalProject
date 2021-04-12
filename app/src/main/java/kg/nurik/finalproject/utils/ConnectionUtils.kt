package kg.nurik.finalproject.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

object ConnectionUtils {

    @SuppressLint("ServiceCast")
    fun isNetworkAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo?.isConnected ?: false
    }
}