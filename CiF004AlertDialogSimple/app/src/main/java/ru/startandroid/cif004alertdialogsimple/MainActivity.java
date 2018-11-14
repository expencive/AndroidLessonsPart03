package ru.startandroid.cif004alertdialogsimple;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnOpenDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenDialog = (Button) findViewById(R.id.btnStartDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }


        });
    }
    private void openDialog() {
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Вы открыли диалог")
                .setMessage("Теперь можете закрыть")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(MainActivity.this,"Вы нажали ок°",Toast.LENGTH_LONG).show();
                        

                    }
                })

                .setNegativeButton("Отмена", null)
                .create();
        dialog.show();

    }
}
