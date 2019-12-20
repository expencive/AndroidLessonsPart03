package vk.expencive.kotlinsingletonexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import vk.expencive.kotlinsingletonexample.models.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("DEBUG: ${ExampleSingleton.singletonUser}")
        println("DEBUG: ${ExampleSingleton.singletonUser.hashCode()}")
        
    }
}
