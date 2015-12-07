package devf.b7actionbarandtoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Settingz extends AppCompatActivity implements View.OnClickListener  {


    private String TAG = " ************  TAG, Settingz.class  ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingz);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.settin_toolbar);
        myToolbar.setTitle("Configuracion");
        setSupportActionBar(myToolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace_white_24dp);
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home:

                Toast.makeText(this, " THIS IS SUPER HOME ", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onOptionsItemSelected: ");

                onBackPressed();
                return true;

            default:
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
