package ru.startandroid.cif005sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvSavedText;
    EditText etTextInsert, etTextInsert2, etTextInsert3;
    Button btnApplyText, btnSaveText;
    Switch switchButton;
    public static final String SHARED_PREF = "sharedPrefs";
    public static final String TEXT1 = "text1";
    public static final String TEXT2 = "text2";
    public static final String TEXT3 = "text3";

    public static final String SWITCH_BUTTON = "switchButton";
    private String text;
    private String text2;
    private String text3;
    private Boolean switcOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSavedText = (TextView) findViewById(R.id.tvSavedText);
        etTextInsert = (EditText) findViewById(R.id.etTextInsert);
        etTextInsert2 = (EditText) findViewById(R.id.etTextInsert2);
        etTextInsert3 = (EditText) findViewById(R.id.etTextInsert3);
        btnApplyText = (Button) findViewById(R.id.btnApplyText);
        btnSaveText = (Button) findViewById(R.id.btnSaveText);
        switchButton = (Switch) findViewById(R.id.switchButton);
        btnApplyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();

            }
        });
        btnSaveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();
            }
        });

        loadData();
        updateViews();




    }


    public void saveData() {
        SharedPreferences sharePreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharePreferences.edit();
        editor.putString(TEXT1, etTextInsert.getText().toString());
        editor.putString(TEXT2, etTextInsert2.getText().toString());
        editor.putString(TEXT3,etTextInsert3.getText().toString());
        editor.putBoolean(SWITCH_BUTTON, switchButton.isChecked());
        editor.apply();
        Toast.makeText(this, "Текст Сохранен", Toast.LENGTH_SHORT).show();


    }
    public void loadData() {

        SharedPreferences sharePreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        text = sharePreferences.getString(TEXT1, "");
        text2 = sharePreferences.getString(TEXT2, "");
        text3 = sharePreferences.getString(TEXT3, "");
        switcOnOff = sharePreferences.getBoolean(SWITCH_BUTTON, false);
        switchButton.setChecked(switcOnOff);
        etTextInsert.setText(text);
        etTextInsert2.setText(text2);
        etTextInsert3.setText(text3);

    }

    public void updateViews() {
        tvSavedText.setText(text +"\n" + text2 +"\n"+ text3);
        switchButton.setChecked(switcOnOff);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveData();
    }
}
