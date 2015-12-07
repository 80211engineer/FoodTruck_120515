package devf.b7actionbarandtoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import devf.b7actionbarandtoolbar.interfaces.MyOwnListener;
import devf.b7actionbarandtoolbar.interfaces.MyVeryOwnListener;

public class SpecFoodTruck extends AppCompatActivity implements View.OnClickListener {


    private String TAG = " ************  TAG, SpecFoodTruck  ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spec_food_truck);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.Spec_toolbar);
        myToolbar.setTitle("Favoritoxxx");
        setSupportActionBar(myToolbar);


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        Intent intent = getIntent();
        String textSome = intent.getStringExtra("my_key");
        int ImageSome = intent.getIntExtra("my_keyz", 0);
        String textSome2 =  intent.getStringExtra("my_keyz2");



//          COMMENTED OUT

        ImageView ImageViewSecondAct = (ImageView) findViewById(R.id.image_second_activity);
        ImageViewSecondAct.setImageResource(ImageSome);

        TextView textViewSecondActivity = (TextView) findViewById(R.id.text_view_second_activity);
        textViewSecondActivity.setText(textSome2);

        TextView textViewSecondActivity2 = (TextView) findViewById(R.id.text_view2_second_activity);
        textViewSecondActivity2.setText(textSome);







        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace_white_24dp);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });    */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_back, menu);
        return true;
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

    @Override
    public void onClick(View v) {

    }


    /*
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    */


}