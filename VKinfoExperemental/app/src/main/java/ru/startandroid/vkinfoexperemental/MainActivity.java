package ru.startandroid.vkinfoexperemental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import ru.startandroid.vkinfoexperemental.Utils.NetworkUtils;

import static ru.startandroid.vkinfoexperemental.Utils.NetworkUtils.generateURL;
import static ru.startandroid.vkinfoexperemental.Utils.NetworkUtils.getResponseFromURL;

public class MainActivity extends AppCompatActivity {

    EditText etSeachFild;
    Button btnSeachVK;
    TextView tvResult, tvErrorMessage;
    ProgressBar pbLoadIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSeachFild = (EditText) findViewById(R.id.etSeachFild);
        btnSeachVK = (Button) findViewById(R.id.btnSeachVK);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvErrorMessage = (TextView) findViewById(R.id.tvErrorMessage);
        pbLoadIndicator = (ProgressBar) findViewById(R.id.pbLoadIndicator);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL generatedURL = generateURL(etSeachFild.getText().toString());

                new VKqueryTask().execute(generatedURL);



            }
        };

        btnSeachVK.setOnClickListener(onClickListener);

        NetworkUtils url = new NetworkUtils();
    }

    private void showResultTextView() {
        tvResult.setVisibility(View.VISIBLE);
        tvErrorMessage.setVisibility(View.INVISIBLE);
    }

    private void showErrorTextView() {
        tvResult.setVisibility(View.INVISIBLE);
        tvErrorMessage.setVisibility(View.VISIBLE);
    }

    class VKqueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute () {
            pbLoadIndicator.setVisibility(View.VISIBLE);
        }

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

            if (response !=null && !response.equals("")) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray jsonArray = jsonResponse.getJSONArray("response");

                    String resultingString = "";

                    for (int i=0; i<jsonArray.length(); i++) {
                        JSONObject userInfo = jsonArray.getJSONObject(i);
                        firstName = userInfo.getString("first_name");
                        lastName = userInfo.getString("last_name");
                        resultingString = "Имя: " + firstName + "\n" + "Фамилия: " + lastName + "\n\n";
                        tvResult.append(resultingString);

                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }



                showResultTextView();

            }else {
                showErrorTextView();

            }
            pbLoadIndicator.setVisibility(View.INVISIBLE);

        }
    }
}
