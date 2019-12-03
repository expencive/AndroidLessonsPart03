package vk.expencive.daggerkotlin.dagger

import dagger.Binds
import dagger.Module
import vk.expencive.daggerkotlin.car.DieselEngine
import vk.expencive.daggerkotlin.car.Engine


@Module
abstract class DieselEngineModule {

    @Binds
    abstract fun bindDieselEngine(engine: DieselEngine): Engine
}