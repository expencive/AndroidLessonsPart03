package vk.expencive.daggerkotlin.dagger

import dagger.Module
import dagger.Provides
import vk.expencive.daggerkotlin.car.Rims
import vk.expencive.daggerkotlin.car.Tires
import vk.expencive.daggerkotlin.car.Wheels

@Module
class WheelsModule {

    @Provides
    fun  provideRims(): Rims =
        Rims()

    @Provides
    fun provideTires(): Tires {
        var tires = Tires()
        tires.inflate()
        return tires;
    }

    @Provides
    fun provideWheels(rims: Rims, tires: Tires) =
        Wheels(rims, tires)


}