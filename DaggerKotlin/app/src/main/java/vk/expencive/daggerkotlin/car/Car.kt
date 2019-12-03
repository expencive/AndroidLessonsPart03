package vk.expencive.daggerkotlin.car

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(private var wheels: Wheels, private var engine: Engine) {
    private val TAG = "Car"
    
    fun drive(){

        engine.wrom()
        Log.d(TAG, "drive:  rrrrrrrrrrrrrrrrrrrr")
    }

    @Inject
    fun enableRemote (remote: Remote){
        remote.setListener()

    }
}