package expencive.vk.com.dagger2ex.dagger;


import dagger.Binds;
import dagger.Module;
import expencive.vk.com.dagger2ex.car.Engine;
import expencive.vk.com.dagger2ex.car.PetroilEngine;

@Module
public abstract class PetroilEngineModule {

    @Binds
    abstract Engine bindEngine(PetroilEngine engine);

}
