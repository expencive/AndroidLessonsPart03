package vk.expencive.daggerkotlin.dagger

import dagger.Binds
import dagger.Module
import vk.expencive.daggerkotlin.car.Engine
import vk.expencive.daggerkotlin.car.PetroilEngine


@Module
abstract class PetroilEngineModule {

    @Binds
    abstract fun bindPetroilEngine(engine: PetroilEngine): Engine
}