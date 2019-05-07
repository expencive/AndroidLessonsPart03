package expencive.vk.com.dagger2ex.car;

import android.util.Log;

import javax.inject.Inject;

public class DieselEngine implements Engine {
    private static final String TAG = "DieselEngine";

    @Inject
    public DieselEngine() {
    }

    @Override
    public void start() {

        Log.d(TAG, "start: Diesel Engine...............................");

    }

}

