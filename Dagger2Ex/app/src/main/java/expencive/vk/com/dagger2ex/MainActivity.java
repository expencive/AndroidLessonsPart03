package expencive.vk.com.dagger2ex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import expencive.vk.com.dagger2ex.car.Car;
import expencive.vk.com.dagger2ex.dagger.CarComponent;
import expencive.vk.com.dagger2ex.dagger.DaggerCarComponent;
import expencive.vk.com.dagger2ex.dagger.DieselEngineModule;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent component = DaggerCarComponent.builder()
                .dieselEngineModule(new DieselEngineModule(100))
                .build();
        component.inject(this);

        //car = component.getCar();

        car.drive();
    }
}
