package ru.startandroid.vkinfo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

import static ru.startandroid.vkinfo.Utils.NetworkUtils.generateURL;
import static ru.startandroid.vkinfo.Utils.NetworkUtils.getResponseFromURL;

public class MainActivity extends AppCompatActivity {
    EditText etSeachFild;
    Button btnSeachVK;
    TextView tvResult;
    class VKqueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            String response = null;
            try {
                response = getResponseFromURL(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }

        @Override
        protected void onPostExecute (String response) {
            tvResult.setText(response);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSeachFild = (EditText) findViewById(R.id.etSeachFild);
        btnSeachVK = (Button) findViewById(R.id.btnSeachVK);
        tvResult = (TextView) findViewById(R.id.tvResult);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL generatedURL = generateURL(etSeachFild.getText().toString());

                new VKqueryTask().execute(generatedURL);

            }
        };

        btnSeachVK.setOnClickListener(onClickListener);
    }
}
