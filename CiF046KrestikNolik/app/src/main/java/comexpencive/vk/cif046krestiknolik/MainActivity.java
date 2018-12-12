package comexpencive.vk.cif046krestiknolik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private  Button[][] buttons = new Button[3][3];

    private  boolean player1turn = true;

    private int roundcount;

    private int player1points;
    private int player2po1nts;

    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayer1 = (TextView) findViewById(R.id.text_view_p1);
        textViewPlayer2 = (TextView) findViewById(R.id.text_view_p2);

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = (Button) findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = (Button) findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!((Button) v).getText().toString().equals("")) {
                    return;
                }

                if (player1turn) {
                    ((Button) v).setText("X");
                }else {
                    ((Button) v).setText("O");
                }
                roundcount++;
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    private boolean checkForWin() {
        
    }
}
