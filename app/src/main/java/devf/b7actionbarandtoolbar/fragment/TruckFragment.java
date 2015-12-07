package devf.b7actionbarandtoolbar.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import devf.b7actionbarandtoolbar.ActTruckComment;
import devf.b7actionbarandtoolbar.FuckingShit2;
import devf.b7actionbarandtoolbar.Fucking_shit;
import devf.b7actionbarandtoolbar.R;
import devf.b7actionbarandtoolbar.SpecFoodTruck;
import devf.b7actionbarandtoolbar.adapters.TruckAdapter;
import devf.b7actionbarandtoolbar.interfaces.AdapterCallback;
import devf.b7actionbarandtoolbar.interfaces.AdapterCallback2;
import devf.b7actionbarandtoolbar.interfaces.MyOwnListener;
import devf.b7actionbarandtoolbar.model.TruckFood;

/**
 * Created by Luis Galvan on 11/29/2015.
 */

public class TruckFragment extends Fragment implements AdapterCallback2 {



    private RecyclerView mRecyclerView2;

    private List<TruckFood> truckFoodList;

    private String TAG = "¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿  =   ";

    private int AverageGradeDone;



    public TruckFragment() {
    }

// COMMENTED DUPLICATE
    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    */

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_foodtruck, container, false);

        mRecyclerView2 = (RecyclerView) rootView.findViewById(R.id.list_of_trucks);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecyclerView();

    }



    private void initRecyclerView() {

        truckFoodList = createTrucks();

        TruckAdapter truckAdapter = new TruckAdapter(getActivity(), truckFoodList);


        // *****
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView2.setAdapter(truckAdapter);

        // CALLING AVEREGE GRADE
        final int temp = truckAdapter.averageReturner();


        truckAdapter.setOnItemClickListener(new MyOwnListener() {
            @Override
            public void onItemClick(int position, View view, TruckFood truckFood) {

                String mTypeFood = truckFood.getTtypefood();
                String mName = truckFood.getTname();
                int mImagez = truckFood.getTimage();
                int mGradez = truckFood.getTstars();

                int mGradezT = temp;


                Log.e(TAG, " ///////////// FUC " + String.valueOf(mGradez));

                // ##### THIS IS WORKING ON

//                Intent intentActivity = new Intent(getActivity(), SpecFoodTruck.class);

                Intent intentActivity = new Intent(getActivity(), FuckingShit2.class);


                intentActivity.putExtra("my_key", mName);
                intentActivity.putExtra("my_keyz", mImagez);
                intentActivity.putExtra("my_keyz2", mGradezT);

                // *********  COMMENTED IMPLEMENT ActTruckComment
                /*
                intentActivity.putExtra("my_key", mName);
                intentActivity.putExtra("my_keyz", mImagez);
                intentActivity.putExtra("my_keyz2", mTypeFood);
                */


                startActivity(intentActivity);


            }
        });




    }




    @Override
    public void onDetach() {
        super.onDetach();
    }




    // public TruckFood(String tcomment, int timage, String tname, int tstars, String ttypefood)

    private List<TruckFood> createTrucks() {

//        int[] nameTruck = {"Burger King", "Don Burger", "Pizza MIa", "KTC", "CUISINE"};

        List<TruckFood> foodTruckers = new ArrayList<>();

        for(int i=0; i<12; i++){

            foodTruckers.add(new TruckFood("Best", R.drawable.barra_vieja_smallj, "Jack in the Box", i, "Fast Food"));
            foodTruckers.add(new TruckFood("Best", R.drawable.rockin_taco_logo, "Rockin' Taco", i, "Fast Food, tacos"));
            foodTruckers.add(new TruckFood("Best", R.drawable.primario_logo_small, "Primario, gourmet mexicano.", i, "Food Truck, gourmet mexicano."));
        }

        return foodTruckers;




    }


    @Override
    public int onMyCallback(int num) {
        return 0;
    }
}
