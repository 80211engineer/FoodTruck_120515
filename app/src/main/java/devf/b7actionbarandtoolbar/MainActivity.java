package devf.b7actionbarandtoolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import devf.b7actionbarandtoolbar.favorites.favorites;
import devf.b7actionbarandtoolbar.fragment.CreateFragment;
import devf.b7actionbarandtoolbar.fragment.FragmentDynamic;
import devf.b7actionbarandtoolbar.fragment.TruckFragment;
import devf.b7actionbarandtoolbar.interfaces.MyOwnListener;
import devf.b7actionbarandtoolbar.interfaces.OnSelectedListener;
import devf.b7actionbarandtoolbar.model.Truck;
import devf.b7actionbarandtoolbar.fragment.CreateFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnSelectedListener, OnMapReadyCallback {

    private DrawerLayout mDrawerLayout;

    private FragmentDynamic FragDyn;
    private String TextDyn = "Defaulting";
    private int ImageDyn;
    private MapsActivity2 mapsActivity2;

    private GoogleMap mMap;

    private String TAG = "   ********************** This is it";

    private String stringPasser = "b";


    private ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout.DrawerListener listener;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//       setupToolbar();
//        setupIconHomeActionBar();
//        setupDrawerLayout();
 //       setupNavigationView();

        /*
        if (savedInstanceState == null) {
            FragDyn = FragmentDynamic.newInstance(TextDyn, ImageDyn);
        } else {
            String bundlezName = savedInstanceState.getString(FragmentDynamic.KEY_NAME);
            int bundlezImage = savedInstanceState.getInt(FragmentDynamic.KEY_IMAGE);
            FragDyn = FragmentDynamic.newInstance(bundlezName, bundlezImage);
        }
        */

        setContentView(R.layout.activity_main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
        mapFragment.getMapAsync(this);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        // &&&&&&&&&&&&&&&&&&&&&&&&&&   ADDING TOP
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_favoritos:

                        stringPasser = "a";


                        // INTENT ENTER, commented out
                        /*
                        fragment = new FragmentDynamic();
                       replacerFragment(fragment, stringPasser);
                        */

                        fragment = new TruckFragment();
                        replacerFragment(fragment, stringPasser);







                        Toast.makeText(MainActivity.this, "Favoritos", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_search:

                        stringPasser = "b";

                        //fragment = new FragmentDynamic.newInstance("ok", 8)


                        fragment = new CreateFragment();
                        replacerFragment(fragment, stringPasser);
                        



                        // FRAGMENT ENTER, commented out
                        /*
                        Intent intent = new Intent(MainActivity.this, Settingz.class);
                        startActivity(intent);
                        */


                        Toast.makeText(MainActivity.this, "Busqueda", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_map:



                        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                        Fragment frog = getSupportFragmentManager().findFragmentByTag(stringPasser);
                        if(frog != null){

                            Toast.makeText(MainActivity.this, "Map Activity", Toast.LENGTH_SHORT).show();

                            transaction2.remove(frog);
                            transaction2.commit();

                        }



//                        mapsActivity2 = new MapsActivity2();
//                       replacerFragment(mapsActivity2);

                        break;

                    case R.id.action_settingz:

                        stringPasser = "b";

                        //fragment = new FragmentDynamic.newInstance("ok", 8)


                        fragment = new CreateFragment();
                        replacerFragment(fragment, stringPasser);




                        // FRAGMENT ENTER, commented out
                        /*
                        Intent intent = new Intent(MainActivity.this, Settingz.class);
                        startActivity(intent);
                        */


                        Toast.makeText(MainActivity.this, "Configuracion", Toast.LENGTH_SHORT).show();
                        break;
                }

                /*
                if (fragment != null) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();


                } else {
                    Log.e("MainActivity", "Error in creating fragment");
                }

                */


                item.setChecked(true);
                mDrawerLayout.closeDrawer(GravityCompat.START);

                return false;
            }
        });

        // &&&&&&&&&&&&&&&&&&&&&&&&&&&&&   ADDING BOTTOM









/*
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        */



/*
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, FragDyn);
        transaction.addToBackStack(null);
        transaction.commit();
        */



    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupIconHomeActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);




    }



    private void setupDrawerLayout() {
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


//        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.draw_open, R.string.draw_close);
//        mDrawerLayout.setDrawerListener(listener);



//        mDrawerLayout.setDrawerListener(this);
    }



    private void setupNavigationView () {


        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_call:

                        // TEMP COMMENTED OUT
                        /*
                        fragment = new FragmentDynamic();
                        replacerFragment(fragment);
                        */

                        Toast.makeText(MainActivity.this, R.string.action_call, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_search:

                        //fragment = new FragmentDynamic.newInstance("ok", 8)
                        fragment = new CreateFragment();
//                        replacerFragment(fragment);
//


                        Toast.makeText(MainActivity.this, R.string.action_search, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_settings:

//                        mapsActivity2 = new MapsActivity2();
//                       replacerFragment(mapsActivity2);
                        Toast.makeText(MainActivity.this, R.string.action_settings, Toast.LENGTH_SHORT).show();
                        break;
                }

                /*
                if (fragment != null) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();


                } else {
                    Log.e("MainActivity", "Error in creating fragment");
                }

                */


                item.setChecked(true);
                mDrawerLayout.closeDrawer(GravityCompat.START);

                return false;
            }
        });

    }





    private void replacerFragment(Fragment fragment, String xp) {

       // COMMENTED, FOR LONG VERS.
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.container, fragment, xp).commit();

        // Create new fragment and transaction
//        Fragment newFragment = new ExampleFragment();


        FragmentTransaction transactionz = getSupportFragmentManager().beginTransaction();
        transactionz.replace(R.id.container, fragment, xp);
//        transactionz.addToBackStack(null);
        transactionz.commit();







        /*
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, FragDyn);
        transaction.addToBackStack(null);
        transaction.commit();

        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //  CMMENTED, TO DO TEST

       getMenuInflater().inflate(R.menu.my_menu, menu);
//        return super.onCreateOptionsMenu(menu);
        return true;



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
//                Toast.makeText(this, R.string.fuck_it2, Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onOptionsItemSelected: ");
                break;
            case R.id.action_call:
                Toast.makeText(this, R.string.action_call, Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_search:
//                mDrawerLayout.openDrawer(GravityCompat.START);
                Toast.makeText(this, R.string.fuck_it, Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, R.string.action_settings, Toast.LENGTH_SHORT).show();
                break;


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onSelected(Truck truck) {
        FragDyn.updateView(truck);
        ImageDyn = truck.getmImageId();
        TextDyn = truck.getmName();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.setMyLocationEnabled(true);

        LatLng mexico  = new LatLng(19.434372, -99.1397591);
        LatLng mexico2 = new LatLng(19.4326018, -99.135399);
        LatLng mexico3 = new LatLng(19.435353, -99.1379671);
        LatLng mexico4 = new LatLng(19.438489, -99.1349741);

        mMap.addMarker(new MarkerOptions()
                .position(mexico)
                .title("Food Truck 1")
                .snippet("Mexican")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.fast_food_24)));

        mMap.addMarker(new MarkerOptions()
                .position(mexico2)
                .title("Food Truck 2")
                .snippet("Mexican")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.fast_food_24)));

        mMap.addMarker(new MarkerOptions()
                .position(mexico3)
                .title("Food Truck 3")
                .snippet("Chinese")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.fast_food_24)));

        mMap.addMarker(new MarkerOptions()
                .position(mexico4)
                .title("Food Truck 4")
                .snippet("Italian")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.fast_food_24)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mexico, 15));
    }


    // *****************   TROUBLE WITH INTERFACE MYOWNLISTERNR
 /*
    @Override
    public void onItemClick(View view) {



        Toast.makeText(MainActivity.this, " This the CLICKER ", Toast.LENGTH_SHORT).show();

//        if ()

    }
    */
}
