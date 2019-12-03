package vk.expencive.daggerkotlin.car

import android.util.Log
import javax.inject.Inject

class DieselEngine @Inject constructor(): Engine {
    private val TAG = "DieselEngine"
    override fun wrom() {
        Log.d(TAG, "drive: Diesel rrrrrrrrrrrrrrrr ")
    }
}