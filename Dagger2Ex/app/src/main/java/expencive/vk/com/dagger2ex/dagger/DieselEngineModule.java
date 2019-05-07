package expencive.vk.com.dagger2ex.dagger;


import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import expencive.vk.com.dagger2ex.car.DieselEngine;
import expencive.vk.com.dagger2ex.car.Engine;

@Module
public  class DieselEngineModule {

    private int horsePower;

    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @Provides
    Engine provideEngine(){
        return new DieselEngine(horsePower);
    }

}
