package devf.b7actionbarandtoolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Registration_2 extends AppCompatActivity implements View.OnClickListener {

    private TextView UserName;
    private TextView ContinueButton;
    private Button SelectPicButton;

    private String UserNameTest = "Jorge";
    private String ReceivedUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_2);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.registration2_toolbarz);
        myToolbar.setTitle("FoodTruck Finder");
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace_white_24dp);

        UserName = (TextView) findViewById(R.id.registration2_UserName);
        ContinueButton = (TextView) findViewById(R.id.registration2_ContinueButt);
        SelectPicButton = (Button) findViewById(R.id.registration2_SelectPic);

        ContinueButton.setOnClickListener(this);
        SelectPicButton.setOnClickListener(this);

        Intent intent = getIntent();
        ReceivedUserName = intent.getStringExtra("my_key");

        UserName.setText(ReceivedUserName + "!");




    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.registration2_ContinueButt:

                Intent intent = new Intent(this, MainActivity.class);

//                Toast.makeText(this, "Registrarse", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.registration2_SelectPic:

                Toast.makeText(Registration_2.this, " SELECT PIC TO UPLOAD ", Toast.LENGTH_SHORT).show();

                break;
            default:
                break;



        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

                Toast.makeText(Registration_2.this, " HITTING HOME ", Toast.LENGTH_SHORT).show();

                onBackPressed();
                return  true;

            default:
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
