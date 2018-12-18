package comexpencive.vk.cif057jsonserialization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

        Address address = new Address("Germany", "Berlin");
        Employee employee = new Employee("John", 32, "john@gmail.com", address);

        String json = gson.toJson(employee);

        /*String json = "{\"first_name\":\"John\",\"age\":30,\"mail\":\"john@gmail.com\"}";
        Eployee employee = gson.fromJson(json, Eployee.class);*/
    }
}
