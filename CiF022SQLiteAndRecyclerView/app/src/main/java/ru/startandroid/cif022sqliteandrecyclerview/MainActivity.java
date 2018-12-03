package ru.startandroid.cif022sqliteandrecyclerview;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase mDatabase;
    private GroceryAdapter mAdapter;
    private EditText etName;
    private TextView tvAmount;
    private int mAmount = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GroceryDBHelper dbHelper = new GroceryDBHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new GroceryAdapter(this, getAllItems());
        recyclerView.setAdapter(mAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                removeItem((long) viewHolder.itemView.getTag());

            }
        }).attachToRecyclerView(recyclerView);

        etName = (EditText) findViewById(R.id.etName);
        tvAmount = (TextView) findViewById(R.id.tvAmount);

        Button btnIncrease = (Button) findViewById(R.id.btnIncrease);
        Button btnDecrease = (Button) findViewById(R.id.btnDecrease);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();

            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease();

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();


            }
        });
    }



    private void increase() {
        mAmount++;
        tvAmount.setText(String.valueOf(mAmount));
    }

    private void decrease() {
        if (mAmount > 0) {
        mAmount--;
        tvAmount.setText(String.valueOf(mAmount));}

    }

    private void addItem() {
        if (etName.getText().toString().trim().length()==0 || mAmount ==0) {
            etName.setText("");
            Toast.makeText(this, "Введите название", Toast.LENGTH_SHORT).show();
            return;


        }

        String name = etName.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(GroceryContract.GroceryEntry.COLUMN_NAME, name);
        cv.put(GroceryContract.GroceryEntry.COLUMN_AMOUNT, mAmount);
        mDatabase.insert(GroceryContract.GroceryEntry.TABLE_NAME,null, cv);

        mAdapter.swapCursor(getAllItems());

        etName.getText().clear();
        mAmount=1;
        tvAmount.setText(String.valueOf(mAmount));
    }

    private Cursor getAllItems () {
        return mDatabase.query(GroceryContract.GroceryEntry.TABLE_NAME, null, null, null, null, null,
                GroceryContract.GroceryEntry.COLUMN_TIMESTAMP + " DESC");
    }

    private void removeItem(long id) {
        mDatabase.delete(GroceryContract.GroceryEntry.TABLE_NAME, GroceryContract.GroceryEntry._ID + "=" + id,
                null);
        mAdapter.swapCursor(getAllItems());
    }
}
