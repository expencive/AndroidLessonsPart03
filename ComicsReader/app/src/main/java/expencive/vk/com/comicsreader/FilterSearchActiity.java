package expencive.vk.com.comicsreader;

import android.support.annotation.NonNull;
import android.support.design.chip.ChipGroup;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import expencive.vk.com.comicsreader.Common.Common;

public class FilterSearchActiity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    RecyclerView recycler_filter_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_search_actiity);

        recycler_filter_search = findViewById(R.id.recycler_filter_search);
        recycler_filter_search.setHasFixedSize(true);
        recycler_filter_search.setLayoutManager(new GridLayoutManager(this, 2));


        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.inflateMenu(R.menu.main_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.action_filter:
                        showFiltersDialog();
                        break;
                    case R.id.action_search:
                        showSearchDialog();
                        break;
                        default:
                            break;
                }
                return true;
            }
        });
    }

    private void showSearchDialog() {
    }

    private void showFiltersDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(FilterSearchActiity.this);
        alertDialog.setTitle("Select Category");

        LayoutInflater inflater = this.getLayoutInflater();

        View filter_layout = inflater.inflate(R.layout.dialog_options, null);

        final AutoCompleteTextView txt_category = filter_layout.findViewById(R.id.txt_category);

        ChipGroup chipGroup = filter_layout.findViewById(R.id.chip_group);

        //create autocomplete

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, Common.categories);

        txt_category.setAdapter(adapter);
        txt_category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //clear

                txt_category.setText("");

                //create tags
            }
        });
    }
}
