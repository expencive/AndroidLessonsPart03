package expencive.vk.com.fragmentbottomnavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static expencive.vk.com.fragmentbottomnavigation.HomeFragment.EXTRA_NUMBER;
import static expencive.vk.com.fragmentbottomnavigation.HomeFragment.EXTRA_TITLE;
import static expencive.vk.com.fragmentbottomnavigation.HomeFragment.EXTRA_URL;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String number = intent.getStringExtra(EXTRA_NUMBER);
        int title = intent.getIntExtra(EXTRA_TITLE, 0);

        ImageView imageView = (ImageView) findViewById(R.id.image_view_detail);
        TextView textViewCreator = (TextView) findViewById(R.id.text_view_number_detail);
        TextView textViewLikes = (TextView) findViewById(R.id.text_view_title_detail);

        Picasso.get().load(imageUrl).fit().centerInside().into(imageView);
        textViewCreator.setText(number);
        textViewLikes.setText(title);
    }
}
