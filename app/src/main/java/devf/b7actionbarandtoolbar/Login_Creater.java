package devf.b7actionbarandtoolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Creater extends AppCompatActivity implements View.OnClickListener {

    private Button myButton;
    private TextView myText;
    private TextView myText2;
    private String TAG = " @@@@@   ";

    private EditText txtUserName1;
    private String strUserName1;
    private EditText txtUserName2;
    private String strUserName2;

    private String superUsername = "devf";
    private String superPassword = "devf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__creater);



        Toolbar myToolbar = (Toolbar) findViewById(R.id.login_toolbarz);
        myToolbar.setTitle("FoodTrucks");
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace_white_24dp);

        txtUserName1 = (EditText) findViewById(R.id.editTextLogin1);


        txtUserName2 = (EditText) findViewById(R.id.editTextLogin2);






        myButton = (Button) this.findViewById(R.id.creater_button);
        myButton.setOnClickListener(this);


        //  BECAME LOGIN, COMMENTED OUT
        /*
        myText = (TextView) this.findViewById(R.id.welcome_ContinueMap);
        myText.setOnClickListener(this);
         */

        myText2 = (TextView) this.findViewById(R.id.creater_registration);
        myText2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        if(v.getId() == R.id.creater_button) {

            strUserName1 = txtUserName1.getText().toString();
            strUserName2 = txtUserName2.getText().toString();

            strUserName1 = strUserName1.trim();
            strUserName2 = strUserName2.trim();

            Log.e(TAG, strUserName1);
            Log.e(TAG, strUserName2);

            if(TextUtils.isEmpty(strUserName1)) {

//                Toast.makeText(Login_Creater.this, strUserName1, Toast.LENGTH_SHORT).show();



                txtUserName1.setError("Escriba su Username");
                return;
            } else {

                txtUserName1.setError(null);
            }

            if(TextUtils.isEmpty(strUserName2)) {


                txtUserName2.setError("Escriba su Password");
                return;

            }  else {

                txtUserName2.setError(null);
            }

            Log.e(TAG, " MATCHER !!!: " + strUserName1 + "   " + superUsername);


            if(strUserName1.equalsIgnoreCase(superUsername)){

                Log.e(TAG, " MATCHER 222 !!!: " + strUserName1);

//                Toast.makeText(this, " MATCH ", Toast.LENGTH_SHORT).show();

                Log.e(TAG, " MATCHER !!!: " + strUserName1);


                if(strUserName2.equalsIgnoreCase(superPassword)){




                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);


                }else {

                    Toast.makeText(Login_Creater.this, " Username o Password Incorrecto",
                            Toast.LENGTH_LONG).show();

                    return;
                }





            }else {

                Toast.makeText(Login_Creater.this, " Username o Password Incorrecto", Toast.LENGTH_LONG).show();
                return;
            }



        }else if (v.getId() == R.id.creater_registration) {

            Intent intent = new Intent(this, Registration.class);

            Toast.makeText(this, " CONTINUE MAP", Toast.LENGTH_SHORT).show();

            startActivity(intent);
        }



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home:



//                Toast.makeText(Login_Creater.this, " hitting Home ", Toast.LENGTH_SHORT).show();
                onBackPressed();
                return  true;

            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
