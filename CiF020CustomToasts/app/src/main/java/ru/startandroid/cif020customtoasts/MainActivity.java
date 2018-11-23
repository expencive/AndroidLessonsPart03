package ru.startandroid.cif020customtoasts;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToastError(View v) {
        switch (v.getId()) {
            case R.id.btnError:
                Toasty.error(this, "this is a error toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSucces:
                Toasty.success(this, "this is a succes toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnInfo:
                Toasty.info(this, "this is a info toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnWarning:
                Toasty.warning(this, "this is a warning toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnNormal:
                Toasty.normal(this, "this is a normal toast", Toast.LENGTH_SHORT, ContextCompat.getDrawable(this, R.drawable.ic_arrow)).show();
                break;

        }

    }
}
