package comexpencive.vk.cif050firebaseuploadexample;

import com.google.firebase.database.Exclude;

/**
 * Created by Настик on 14.12.2018.
 */

public class Upload {

    private String mName;
    private String mImageUrl;
    private String mKey;

    public Upload() {
        //emty constructor needs

    }

    public Upload (String name, String imageUrl) {
        if (name.trim().equals("")) {
            mName = "No Name";
        }

        mName = name;
        mImageUrl = imageUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl=imageUrl;
    }

    @Exclude
    public String getKey() {
        return mKey;
    }
    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}
