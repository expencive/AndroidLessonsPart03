package ru.startandroid.vkinfo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import ru.startandroid.vkinfo.Utils.NetworkUtils;

import static ru.startandroid.vkinfo.Utils.NetworkUtils.generateURL;
import static ru.startandroid.vkinfo.Utils.NetworkUtils.getResponseFromURL;

public class MainActivity extends AppCompatActivity {
    EditText etSeachFild;
    Button btnSeachVK;
    TextView tvResult, tvQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSeachFild = (EditText) findViewById(R.id.etSeachFild);
        btnSeachVK = (Button) findViewById(R.id.btnSeachVK);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvQuery = (TextView) findViewById(R.id.tvQuery);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL generatedURL = generateURL(etSeachFild.getText().toString());

                new VKqueryTask().execute(generatedURL);
                tvQuery.setText(String.valueOf(generatedURL));



            }
        };

        btnSeachVK.setOnClickListener(onClickListener);

        NetworkUtils url = new NetworkUtils();




    }
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

            String firstName = null;
            String lastName = null;

            try {
                JSONObject jsonResponse = new JSONObject(response);
                JSONArray jsonArray = jsonResponse.getJSONArray("response");
                JSONObject userInfo = jsonArray.getJSONObject(0);
                firstName = userInfo.getString("first_name");
                lastName = userInfo.getString("last_name");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            String resultingString = "Имя: " + firstName + "\n" + "Фамилия: " + lastName;
            tvResult.setText(response);
            tvQuery.setText(resultingString);



        }
    }

}
