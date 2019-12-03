package vk.expencive.daggerkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vk.expencive.daggerkotlin.car.Car
import vk.expencive.daggerkotlin.dagger.CarComponent
import vk.expencive.daggerkotlin.dagger.DaggerCarComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    @Inject lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component: CarComponent = DaggerCarComponent.create()
        component.ingect(this)
        //car = component.getCar()
        car.drive()




    }
}
