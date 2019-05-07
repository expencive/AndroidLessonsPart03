package expencive.vk.com.dagger2ex.dagger;

import dagger.Component;
import expencive.vk.com.dagger2ex.MainActivity;
import expencive.vk.com.dagger2ex.car.Car;

@Component(modules = {WheelsModule.class, DieselEngineModule.class})
public interface CarComponent {

    Car getCar();

    void inject(MainActivity mainActivity);
}
