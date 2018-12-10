package comexpencive.vk.cif037recyclerviewjsonparsing;

/**
 * Created by Настик on 10.12.2018.
 */

public class ExampleItem {

    private String mImageUrl;
    private String mCreator;
    private int mLikes;

    public ExampleItem(String imageUrl, String creator, int likes) {
        mImageUrl = imageUrl;
        mCreator = creator;
        mLikes = likes;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getCreator() {
        return mCreator;
    }

    public int getLikes() {
        return mLikes;
    }
}
