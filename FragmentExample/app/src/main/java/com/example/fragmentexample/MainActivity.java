package com.example.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//            BlueFragment myFragment = new BlueFragment();
//            replaceFragment(myFragment);






    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                BlueFragment bluefragment = new BlueFragment();
                replaceFragment(bluefragment);
                break;
            case R.id.button2:
//                RedFragment redfragment = new RedFragment();
//                replaceFragment(redfragment);

                BlankFragment blankFragment = BlankFragment.newInstance("1", "2");
                replaceFragment(blankFragment);
                break;
        }


    }

    private void replaceFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, f, f.getClass().getName())
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
