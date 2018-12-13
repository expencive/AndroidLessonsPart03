package comexpencive.vk.cif036jsonparsingusingvolley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Настик on 13.12.2018.
 */

public class VolleySingleton {

    private static VolleySingleton mInstance;
    private RequestQueue mRequestQue;

    public VolleySingleton(Context context) {
        mRequestQue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if(mInstance==null) {
            mInstance= new VolleySingleton(context);
        }

        return mInstance;

    }

    public RequestQueue getmRequestQue() {
        return mRequestQue;
    }
}
