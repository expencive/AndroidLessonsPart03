package ru.startandroid.vkinfo.Utils;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Настик on 02.11.2018.
 */

public class NetworkUtils {

    private static final String VK_API_BASE_URL = "https://api.vk.com";
    private static final String VK_USERS_GET = "/method/users.get";
    private static final String PARAM_USER_ID = "user_id";
    private static final String PARAM_VERSION = "v";
    private static final String ACCESS_TOKEN = "acces_token";

    public static URL generateURL(String userId) {

        String token = VK_API_BASE_URL + VK_USERS_GET + "?" + PARAM_USER_ID + "=" + userId + "&" + PARAM_VERSION + "=5.8" + "&" + ACCESS_TOKEN +
                "=842f64a9842f64a9842f64a9c684498efc8842f842f64a9dfcc65279d362a84d26ab0a5";




        Uri builtUri = Uri.parse(VK_API_BASE_URL + VK_USERS_GET)
                .buildUpon()
                .appendQueryParameter(PARAM_USER_ID, userId)
                .appendQueryParameter(PARAM_VERSION, "5.8")
                .appendQueryParameter(ACCESS_TOKEN, "842f64a9842f64a9842f64a9c684498efc8842f842f64a9dfcc65279d362a84d26ab0a5")
                .build();

        URL url = null;
        try {
            url = new URL("https://api.vk.com/method/users.get?user_id=" + userId + "&v=5.8&access_token=842f64a9842f64a9842f64a9c684498efc8842f842f64a9dfcc65279d362a84d26ab0a5");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;

    }
    public static String getResponseFromURL(URL url) throws IOException {

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();


            Scanner scanner = new Scanner(in);

            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        }catch (UnknownHostException e){
            return null;
        }finally {urlConnection.disconnect();
        }

    }
}
