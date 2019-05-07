package expencive.vk.com.dagger2ex.dagger;


import dagger.Binds;
import dagger.Module;
import expencive.vk.com.dagger2ex.car.DieselEngine;
import expencive.vk.com.dagger2ex.car.Engine;

@Module
public abstract class DieselEngineModule {

    @Binds
    abstract Engine bindEngine(DieselEngine engine);

}
