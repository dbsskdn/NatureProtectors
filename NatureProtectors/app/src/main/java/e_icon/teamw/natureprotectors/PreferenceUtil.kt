package e_icon.teamw.natureprotectors

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil (context: Context) {
    private val userInfo: SharedPreferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE)
    private val isRegistered: SharedPreferences = context.getSharedPreferences("isRegistered", Context.MODE_PRIVATE)
    private val gardenInfo: SharedPreferences = context.getSharedPreferences("gardenInfo", Context.MODE_PRIVATE)

    fun getString(key: String, defValueStr: String): String {
        return userInfo.getString(key, defValueStr).toString()
    }
    fun setString(key: String, str: String) {
        userInfo.edit().putString(key, str).apply()
    }
    fun setBool(key: String, bool: Boolean) {
        isRegistered.edit().putBoolean(key, bool).apply()
    }
    fun getBool(key: String, defValueBool: Boolean): Boolean {
        return isRegistered.getBoolean(key, defValueBool)
    }
    fun setList(key: String, set: MutableSet<String>) {
        userInfo.edit().putStringSet(key, set).apply()
    }
}