package expencive.vk.com.fragmentbottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFrament = null;

            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    selectedFrament = new HomeFragment();
                    break;
                case R.id.nav_favorits:
                    selectedFrament = new FavoritsFragment();
                    break;
                case R.id.nav_search:
                    selectedFrament = new SearchFragment();
                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFrament).commit();

            return true;
        }

    };
}
