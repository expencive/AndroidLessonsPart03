package expencive.vk.com.comicsreader;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import expencive.vk.com.comicsreader.Common.Common;
import expencive.vk.com.comicsreader.Model.Chapter;

public class ViewComicActivity extends AppCompatActivity {

    ViewPager viewPager;
    TextView txt_chapter_name;

    View back, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comic);

        viewPager = findViewById(R.id.view_pager);
        txt_chapter_name = findViewById(R.id.txt_chapter_name_);
        back = findViewById(R.id.chapter_back);
        next = findViewById(R.id.chapter_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.chapterIndex==0) {
                    Toast.makeText(ViewComicActivity.this, "You are reading first chapter", Toast.LENGTH_SHORT).show();
                }else {
                    Common.chapterIndex--;
                    fetchLinks(Common.chapterList.get(Common.chapterIndex));
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Common.chapterIndex==Common.chapterList.size()-1) {
                    Toast.makeText(ViewComicActivity.this, "You are reading last chapter", Toast.LENGTH_SHORT).show();
                }else {
                    Common.chapterIndex++;
                    fetchLinks(Common.chapterList.get(Common.chapterIndex));
                }

            }
        });

        fetchLinks(Common.chapterSelected);
    }

    private void fetchLinks(Chapter chapter) {
        if (chapter.Links!=null){

            if (chapter.Links.size()>0){

                MyViewPagerAdapter adapter = new MyViewPagerAdapter(getBaseContext(), chapter.Links)

            }else{
                Toast.makeText(this, "No image here", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "This chapter is translating", Toast.LENGTH_SHORT).show();
        }
    }
}
