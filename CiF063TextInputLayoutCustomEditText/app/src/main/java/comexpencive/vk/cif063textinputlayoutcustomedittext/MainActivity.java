package comexpencive.vk.cif063textinputlayoutcustomedittext;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputUserName;
    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

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

    private boolean validateUserName () {
        String usernameImput = textInputUserName.getEditText().getText().toString().trim();
        if (usernameImput.isEmpty()) {
            textInputUserName.setError("Поле не может быть пустым");
            return false;
        } else if (usernameImput.length()>15) {
            textInputUserName.setError("Поле слишком большое");
            return false;

        }else {
            textInputUserName.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            textInputPassword.setError("Поле не может быть пустым");
            return false;
        }else {
            textInputPassword.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateEmail() | !validateUserName() | !validatePassword()) {
            return;
        }
        String input = "Email: " + textInputEmail.getEditText().getText().toString();
        input += "\n";
        input += "Username: " + textInputUserName.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + textInputPassword.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();


    }
}
