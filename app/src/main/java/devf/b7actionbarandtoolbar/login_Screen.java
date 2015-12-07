package devf.b7actionbarandtoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login_Screen extends AppCompatActivity implements View.OnClickListener{

    private Button myButton;
    private TextView myText;
    private TextView myText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__screen);



        Toolbar myToolbar = (Toolbar) findViewById(R.id.login_toolbarz);
        myToolbar.setTitle("FoodTrucks");
        setSupportActionBar(myToolbar);


        //  BECAME LOGIN, COMMENTED OUT
        /*
        myButton = (Button) this.findViewById(R.id.buttonLogin1);
        myButton.setOnClickListener(this);
        */


        myText = (TextView) this.findViewById(R.id.welcome_ContinueMap);
        myText.setOnClickListener(this);

        myText2 = (TextView) this.findViewById(R.id.welcome_login);
        myText2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        if(v.getId() == R.id.welcome_ContinueMap) {

            Intent intent = new Intent(login_Screen.this, MainActivity.class);

            Toast.makeText(login_Screen.this, " BUTTON", Toast.LENGTH_SHORT).show();
            startActivity(intent);

        }else if (v.getId() == R.id.welcome_login) {

            Intent intent = new Intent(login_Screen.this, Login_Creater.class);

            Toast.makeText(login_Screen.this, " CONTINUE MAP", Toast.LENGTH_SHORT).show();

            startActivity(intent);
        }



    }
}
