package comexpencive.vk.cif063textinputlayoutcustomedittext;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputUserName;
    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEmail = findViewById(R.id.text_input_email);
        textInputUserName = findViewById(R.id.text_input_username);
        textInputPassword = findViewById(R.id.text_input_password);
    }

    private boolean validateEmail() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEmail.setError("Поле не может быть пустым");
            return false;
        }else {
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean validaeUserName () {
        String userName = textInputUserName.getEditText().getText().toString().trim();
        if (userName.isEmpty()) {
            textInputUserName.setError("Поле не может быть пустым");
            return false;
        } else if (userName.length()>15) {
            textInputUserName.setError("Поле слишком большое");
            return false;

        }else {
            textInputUserName.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {

    }
}
