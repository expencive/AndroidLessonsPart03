package vk.expencive.daggerkotlin.car

import android.util.Log
import vk.expencive.daggerkotlin.car.Engine
import javax.inject.Inject




class  PetroilEngine @Inject constructor():
    Engine {
    private val TAG = "PetroilEngine"
    override fun wrom() {
        Log.d(TAG, "drive: Benzina rrrrrrrrrrrrrrrr ")
    }
}

