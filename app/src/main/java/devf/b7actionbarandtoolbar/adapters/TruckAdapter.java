package devf.b7actionbarandtoolbar.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import devf.b7actionbarandtoolbar.R;
import devf.b7actionbarandtoolbar.interfaces.MyOwnListener;
import devf.b7actionbarandtoolbar.model.TruckFood;

/**
 * Created by Luis Galvan on 11/29/2015.
 */
public class TruckAdapter extends RecyclerView.Adapter<TruckAdapter.TruckViewHolder>{


    private List<TruckFood> mFoodTruck;
    private LayoutInflater mInflater;
    private MyOwnListener myOwnListenerx;

    private int currentViewHolder;
    private int AvergeGradeTA;


    //   Testing adding Stars
    private TruckFood truckFoodz;



    private String TAG = " *************** THIS IS IT = ";


    private ImageView imageView;

    public TruckAdapter(Context context, List<TruckFood> truckFoods) {
        mInflater = LayoutInflater.from(context);
        this.mFoodTruck = truckFoods;

        int sizeArray = mFoodTruck.size();



        for(int i=0; i<sizeArray; i++){

            truckFoodz = mFoodTruck.get(i);
            AvergeGradeTA = truckFoodz.getTstars() + AvergeGradeTA;
        }

        AvergeGradeTA = AvergeGradeTA / sizeArray;

        Log.e(TAG, "555 AvergeGradeTA: " + AvergeGradeTA );


    }

    public void setOnItemClickListener(MyOwnListener myOwnListener) {
        this.myOwnListenerx = myOwnListener;
    }

    public int averageReturner(){
        return 911;
    }


    @Override
    public TruckViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemVIew = mInflater.inflate(R.layout.item_truck, parent, false);

        TruckViewHolder viewHolder = new TruckViewHolder(itemVIew, R.id.truck_image, R.id.truck_name, R.id.truck_type);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(TruckViewHolder holder, int position) {
        TruckFood truck = mFoodTruck.get(position);
//        holder.setViewPosition(position);



        currentViewHolder = position + currentViewHolder;

//        Log.e(TAG, "!!!!!!!!!!!!!!!!!!!!!!!  onBindViewHolder: " + currentViewHolder);



       // STUFF MISSING
        holder.setTcomment(truck.getTcomment());
        holder.setTimage(truck.getTimage());
        holder.setTname(truck.getTname());

        holder.setTstars(truck.getTstars());
//        Log.e(TAG, " $$$$$$$$$  onBindViewHolder: " + truck.getTstars());
        holder.setTtypefood(truck.getTtypefood());




    }

    @Override
    public int getItemCount() {
        return mFoodTruck.size();
    }

    public class TruckViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private String Tname;
        private int Tstars;
        private String Ttypefood;
        private int Timage;
        private String Tcomment;

        private TextView Tname2;
        private int Tstars2;
        private TextView Ttypefood2;
        private ImageView Timage2;
        private TextView Tcomment2;
        private int Tgrade;

        public TruckViewHolder(View itemView, int idImage, int idText1, int idText2) {
            super(itemView);

            itemView.setOnClickListener(this);

            Timage2 = (ImageView) itemView.findViewById(R.id.truck_image);
            Tname2 = (TextView) itemView.findViewById(R.id.truck_name);
            Ttypefood2 = (TextView) itemView.findViewById(R.id.truck_type);

        }



        @Override
        public void onClick(View v) {

            TruckFood truckFood = mFoodTruck.get(getAdapterPosition());

            myOwnListenerx.onItemClick(getAdapterPosition(),v, truckFood);

        }


        public void setTcomment(String tcomment) {

//            this.Tcomment = tcomment;
        }

        public void setTimage(int timage) {
            this.Timage2.setImageResource(timage);
        }

        public void setTname(String tname) {
            this.Tname2.setText(tname);
        }

        public void setTstars(int tstars) {

           this.Tstars = tstars;

//            Log.e(TAG, "!!!!!!!!!!!!!!!!!!!!!!! 22 onBindViewHolder: " + Tstars);
        }

        public void setTtypefood(String ttypefood) {
            this.Ttypefood2.setText(ttypefood);
        }


        public void setTgrade(int tgrade) {
            Tgrade = currentViewHolder;
        }
    }



}
