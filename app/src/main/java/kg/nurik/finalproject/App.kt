package kg.nurik.finalproject

import android.app.Application
import kg.nurik.finalproject.di.appModules
import kg.nurik.finalproject.data.local.sharedPreferences.PreferenceHelper
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.initPreference(applicationContext)
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }

}