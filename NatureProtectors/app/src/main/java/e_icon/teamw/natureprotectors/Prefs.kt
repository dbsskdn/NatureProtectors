package e_icon.teamw.natureprotectors

import android.app.Application

class Prefs : Application() {
    companion object { lateinit var infos: PreferenceUtil }
    override fun onCreate() {
        infos = PreferenceUtil(applicationContext)
        super.onCreate()
    }
}