package vk.expencive.daggerkotlin.car

import android.content.ContentValues.TAG
import android.util.Log
import javax.inject.Inject

class Remote @Inject constructor() {

    fun setListener(){
        Log.d(TAG, "drive: remote connected ")

    }

}
