package vk.expencive.daggerkotlin.car

import android.util.Log
import javax.inject.Inject

class DieselEngine (private val horsePower: Int): Engine {
    private val TAG = "DieselEngine"



    override fun wrom() {
        Log.d(TAG, "drive: Diesel rrrrrrrrrrrrrrrr: horsePower ${horsePower} ")
    }
}