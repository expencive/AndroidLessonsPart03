package comexpencive.vk.cif030videoview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = (VideoView) findViewById(R.id.video_view);

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;

        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(MainActivity.this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
