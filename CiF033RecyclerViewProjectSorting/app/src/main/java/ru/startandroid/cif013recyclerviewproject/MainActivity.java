package ru.startandroid.cif013recyclerviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecycleView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button btnInsert, btnDelete;
    private EditText etInsert, etDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();
        buildListView();


        EditText etSeach = (EditText) findViewById(R.id.etSeach);
        etSeach.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });



    }

    private void filter(String textSeach) {

        ArrayList<ExampleItem> filteredList = new ArrayList<>();

        for (ExampleItem item : mExampleList) {
            if (item.getText1().toLowerCase().contains(textSeach.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);

    }

    public void insertItem(int position) {

        if (position > mExampleList.size()) {
            position=mExampleList.size();

        }
        mExampleList.add(position, new ExampleItem(R.drawable.ic_android, "Добавлена позиция: " + position, "line 2"));

        mAdapter.notifyItemInserted(position);

    }

    public void  removeItem(int position) {

        if (position > mExampleList.size()) {

            Toast.makeText(this, "Вы пытаетесь удалить несуществующую строку", Toast.LENGTH_SHORT).show();

        }else {

        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);}

    }

    public  void  changeItem(int position, String text) {
        mExampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);


    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.ic_android, "Один", "line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_arrow, "Два", "line B"));
        mExampleList.add(new ExampleItem(R.drawable.ic_beach_access, "Три", "line II"));
        mExampleList.add(new ExampleItem(R.drawable.ic_android, "Четыре", "line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_arrow, "Пять", "line B"));
        mExampleList.add(new ExampleItem(R.drawable.ic_beach_access, "Шесть", "line II"));
        mExampleList.add(new ExampleItem(R.drawable.ic_android, "Семь", "line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_arrow, "Восемь", "line B"));
        mExampleList.add(new ExampleItem(R.drawable.ic_beach_access, "Девять", "line II"));
        mExampleList.add(new ExampleItem(R.drawable.ic_android, "Десять", "line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_arrow, "Одиннадцать", "line B"));
        mExampleList.add(new ExampleItem(R.drawable.ic_beach_access, "Двеннадцать", "line II"));
        mExampleList.add(new ExampleItem(R.drawable.ic_android, "Триннадцать", "line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_arrow, "Четырнадцать", "line B"));
        mExampleList.add(new ExampleItem(R.drawable.ic_beach_access, "Пятнадцать", "line II"));
        mExampleList.add(new ExampleItem(R.drawable.ic_android, "Шестнадцать", "line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_arrow, "Семнадцать", "line B"));
        mExampleList.add(new ExampleItem(R.drawable.ic_beach_access, "Восемьнадцать", "line II"));

    }

    public void buildRecyclerView() {
        mRecycleView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });

    }

    public void setButtons() {
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        etInsert = (EditText) findViewById(R.id.etInsert);
        etDelete = (EditText) findViewById(R.id.etDelete);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(etInsert.getText().toString());
                insertItem(position);

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(etDelete.getText().toString());
                removeItem(position);

            }
        });


    }
}
