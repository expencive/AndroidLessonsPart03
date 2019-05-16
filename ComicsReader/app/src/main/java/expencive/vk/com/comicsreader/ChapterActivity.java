package expencive.vk.com.comicsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import expencive.vk.com.comicsreader.Adapter.MyChapterAdapter;
import expencive.vk.com.comicsreader.Common.Common;
import expencive.vk.com.comicsreader.Model.Comic;

public class ChapterActivity extends AppCompatActivity {

    RecyclerView recycler_chapter;
    TextView txt_chapter_name;

    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);



            //view

            txt_chapter_name = findViewById(R.id.txt_chapter_name);
            recycler_chapter = findViewById(R.id.recycler_chapter);
            recycler_chapter.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            recycler_chapter.setLayoutManager(layoutManager);
            recycler_chapter.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));
            //recycler_chapter.setAdapter(new MyChapterAdapter(this));


            Toolbar toolbar = findViewById(R.id.toolbar);

            toolbar.setTitle(Common.comicSelected.Name);
            toolbar.setNavigationIcon(R.drawable.ic_chevron_left_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            fetchChapter(Common.comicSelected);


    }

    private void fetchChapter(Comic comicSelected) {


            Common.chapterList = comicSelected.Chapters;
            recycler_chapter.setAdapter(new MyChapterAdapter(this, comicSelected.Chapters));
            txt_chapter_name.setText(new StringBuilder("CHAPTERS (").append(comicSelected.Chapters.size())
                    .append(")"));

    }
}
