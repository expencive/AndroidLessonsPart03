package vk.expencive.daggerkotlin.dagger

import dagger.Component
import vk.expencive.daggerkotlin.MainActivity
import vk.expencive.daggerkotlin.car.Car

@Component(modules = [WheelsModule::class, DieselEngineModule::class])
interface CarComponent {

    fun getCar(): Car

    fun ingect(mainActivity: MainActivity)


}

