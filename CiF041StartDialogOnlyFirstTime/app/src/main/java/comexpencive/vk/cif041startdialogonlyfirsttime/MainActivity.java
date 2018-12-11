package comexpencive.vk.cif041startdialogonlyfirsttime;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = pref.getBoolean("firstStart", true);

        if (firstStart) {
        showStartDialog();
        }
    }

    private void showStartDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Предупреждение")
                .setMessage("Будьте осторожны предупреждение включатеся только один раз")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();

        //Если приложение запускается не первый раз - то оно прописывает в булен фальс и диалог больше не запустится
        SharedPreferences pref = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }
}
