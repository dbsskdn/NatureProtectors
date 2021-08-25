package e_icon.teamw.natureprotectors

import android.app.Application

class Prefs : Application() {
    companion object { lateinit var userInfo: PreferenceUtil }
    override fun onCreate() {
        userInfo = PreferenceUtil(applicationContext)
        super.onCreate()
    }
}