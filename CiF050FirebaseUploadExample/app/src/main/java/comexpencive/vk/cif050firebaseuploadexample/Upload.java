package comexpencive.vk.cif050firebaseuploadexample;

/**
 * Created by Настик on 14.12.2018.
 */

public class Upload {

    private String mName;
    private String mImageUrl;

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

    public String grtImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl=imageUrl;
    }
}
