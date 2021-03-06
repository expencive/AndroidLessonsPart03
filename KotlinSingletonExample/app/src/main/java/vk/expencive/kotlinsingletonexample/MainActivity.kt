package vk.expencive.kotlinsingletonexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import vk.expencive.kotlinsingletonexample.models.User

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("DEBUG: ${ExampleSingleton.singletonUser}")
        println("DEBUG: ${ExampleSingleton.singletonUser.hashCode()}")

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.user.observe(this, Observer {
            println("DEBUG: $it")
        })

        viewModel.setUserId("1")

        println("DEBUG: ExampleSingleton: ${ExampleSingleton}")
    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }
}
