package e_icon.teamw.natureprotectors

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil (context: Context) {
    private val userInfo: SharedPreferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE)
    private val isRegistered: SharedPreferences = context.getSharedPreferences("userRegister", Context.MODE_PRIVATE)
    private val gardenInfo: SharedPreferences = context.getSharedPreferences("gardenInfo", Context.MODE_PRIVATE)
    private val gardenPlants: SharedPreferences = context.getSharedPreferences("gardenPlants", Context.MODE_PRIVATE)
    private val isGardenRegistered: SharedPreferences = context.getSharedPreferences("gardenRegister", Context.MODE_PRIVATE)
    private val gardenLocation: SharedPreferences = context.getSharedPreferences("gardenLocation", Context.MODE_PRIVATE)

    fun userInfoGetString(key: String, defValueStr: String): String {
        return userInfo.getString(key, defValueStr).toString()
    }
    fun userInfoSetString(key: String, str: String) {
        userInfo.edit().putString(key, str).apply()
    }
    fun registerSetBool(key: String, bool: Boolean) {
        isRegistered.edit().putBoolean(key, bool).apply()
    }
    fun registerGetBool(key: String, defValueBool: Boolean): Boolean {
        return isRegistered.getBoolean(key, defValueBool)
    }
    fun gardenInfoGetString(key: String, defValueStr: String): String {
        return gardenInfo.getString(key, defValueStr).toString()
    }
    fun gardenInfoSetString(key: String, str: String) {
        gardenInfo.edit().putString(key, str).apply()
    }
    fun gardenPlantsSetStringSet(key: String, set: Set<String>) {
        gardenPlants.edit().putStringSet(key, set).apply()
    }
    fun gardenPlantsGetStringSet(key: String, defValueSet: Set<String>): MutableSet<String>? {
        return gardenPlants.getStringSet(key, defValueSet)
    }
    fun gardenRegisterSetBool(key: String, bool: Boolean) {
        isGardenRegistered.edit().putBoolean(key, bool).apply()
    }
    fun gardenRegisterGetBool(key: String, defValueBool: Boolean): Boolean {
        return isGardenRegistered.getBoolean(key, defValueBool)
    }
    fun gardenLocationSetLocation(key: String, float1: Float, float2: Float) {
        gardenLocation.edit().putFloat(key + "x", float1).apply()
        gardenLocation.edit().putFloat(key + "y", float2).apply()
    }
    fun gardenLocationGetLocation(key: String): List<Float> {
        return listOf(
            gardenLocation.getFloat(key + "x", 1.0f),
            gardenLocation.getFloat(key + "y", 1.0f)
        )
    }

}