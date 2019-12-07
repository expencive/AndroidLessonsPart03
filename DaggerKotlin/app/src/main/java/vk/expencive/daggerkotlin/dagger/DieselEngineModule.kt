package vk.expencive.daggerkotlin.dagger

import dagger.Binds
import dagger.Module
import dagger.Provides
import vk.expencive.daggerkotlin.car.DieselEngine
import vk.expencive.daggerkotlin.car.Engine


@Module
class DieselEngineModule(private var horsePower: Int) {

    @Provides
    fun provideDieselEngine(): Engine = DieselEngine(horsePower)
}