package expencive.vk.com.dagger2ex.car;

import android.util.Log;

import javax.inject.Inject;

public class PetroilEngine implements Engine {

    private static final String TAG = "PetroilEngine";

    @Inject
    public PetroilEngine(){}

    @Override
    public void start() {

        Log.d(TAG, "start: Petroil Engine...............................");
        
    }
}
