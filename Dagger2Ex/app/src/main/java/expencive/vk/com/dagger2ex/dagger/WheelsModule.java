package expencive.vk.com.dagger2ex.dagger;


import dagger.Module;
import dagger.Provides;
import expencive.vk.com.dagger2ex.car.Rims;
import expencive.vk.com.dagger2ex.car.Tires;
import expencive.vk.com.dagger2ex.car.Wheels;

@Module
public class WheelsModule {

    @Provides
    static Rims provideRims() {
        return new Rims();
    }

    @Provides
    static Tires provideTires() {
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    @Provides
    static Wheels provideWheels(Rims rims, Tires tires) {
        return new Wheels(rims,tires);
    }
}
