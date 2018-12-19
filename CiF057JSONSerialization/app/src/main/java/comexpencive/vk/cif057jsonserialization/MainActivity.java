package comexpencive.vk.cif057jsonserialization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

        Address address = new Address("Germany", "Berlin");
        List<FamilyMember> family = new ArrayList<>();
        family.add(new FamilyMember("father", 40));
        family.add(new FamilyMember("mother", 35));
        family.add(new FamilyMember("son", 13));
        Employee employee = new Employee("John", 32, "john@gmail.com", address, family);

        String json = gson.toJson(employee);

        /*String json = "{\"first_name\":\"John\",\"age\":30,\"mail\":\"john@gmail.com\"}";
        Eployee employee = gson.fromJson(json, Eployee.class);*/
    }
}
