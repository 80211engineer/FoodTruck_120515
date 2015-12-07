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

public class Registration extends AppCompatActivity implements View.OnClickListener {


    private EditText Reg_Name;
    private EditText Reg_LastName;
    private EditText Reg_Email;

    private EditText Reg_Password1;
    private EditText Reg_Password2;

    private Button Reg_Buttonz;

    private String TAG = " ^^^^^^^   ";

    private TextView jumping;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.registration_toolbarz);
        myToolbar.setTitle("FoodTruck Finder");
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace_white_24dp);


        Reg_Name = (EditText) findViewById(R.id.registrationText_FirstName);
        Reg_LastName = (EditText) findViewById(R.id.registrationText_LastName);
        Reg_Email = (EditText) findViewById(R.id.registrationText_Email);

        Reg_Password1= (EditText) findViewById(R.id.registrationText_contrasena);
        Reg_Password2 = (EditText) findViewById(R.id.registrationText_contrasena_confi);

        jumping = (TextView) findViewById(R.id.registration_jump);

        Reg_Buttonz = (Button) findViewById(R.id.registration_button);
        Reg_Buttonz.setOnClickListener(this);
        jumping.setOnClickListener(this);




    }



    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    @Override
    public void onClick(View v) {

        String userRegPassword1 = Reg_Email.getText().toString();
        String userRegEmail = Reg_Email.getText().toString();
        String userNamez = Reg_Name.getText().toString();



        if(v.getId() == R.id.registration_button) {


//            Toast.makeText(this, "LISTENER REGIS", Toast.LENGTH_SHORT).show();

            if(TextUtils.isEmpty(userNamez)) {

//                Toast.makeText(Login_Creater.this, strUserName1, Toast.LENGTH_SHORT).show();

                Log.e(TAG, "onClick: " + Reg_Name.getText().toString());



                Reg_Name.setError("Escriba su Nombre");
                return;
            }

            if(TextUtils.isEmpty(Reg_LastName.getText().toString())){

//                Toast.makeText(Login_Creater.this, strUserName1, Toast.LENGTH_SHORT).show();



                Reg_LastName.setError("Escriba su Apellido");


                return;
            }

            if(TextUtils.isEmpty(userRegEmail)) {

//                Toast.makeText(Login_Creater.this, strUserName1, Toast.LENGTH_SHORT).show();



                Reg_Email.setError("Escriba su Email");


            }

            if(TextUtils.isEmpty(Reg_Password1.getText().toString())) {

//                Toast.makeText(Login_Creater.this, strUserName1, Toast.LENGTH_SHORT).show();



                Reg_Password1.setError("Escoja una contrasena");
                return;
            }

            if(TextUtils.isEmpty(Reg_Password2.getText().toString())) {

//                Toast.makeText(Login_Creater.this, strUserName1, Toast.LENGTH_SHORT).show();



                Reg_Password2.setError("Confirme su contrasena");
                return;
            }

            if(isValidEmail(userRegEmail)){

            }else {
                Reg_Email.setError("Escriba un Email valido");
                return;
            }



            Intent intent = new Intent(this, Registration_2.class);

//            Toast.makeText(this, "Registrarse", Toast.LENGTH_SHORT).show();
            intent.putExtra("my_key", userNamez);
            startActivity(intent);





        }else if(v.getId() == R.id.registration_jump){

            Intent intent = new Intent(this, Registration_2.class);

//            Toast.makeText(this, "Registrarse", Toast.LENGTH_SHORT).show();
            startActivity(intent);


        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home:

                Toast.makeText(Registration.this, " HITTING HOME ", Toast.LENGTH_SHORT).show();

                onBackPressed();
                return  true;

            default:
                break;


        }

        return super.onOptionsItemSelected(item);
    }
}
