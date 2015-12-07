package devf.b7actionbarandtoolbar.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import devf.b7actionbarandtoolbar.ActTruckComment;
import devf.b7actionbarandtoolbar.R;
import devf.b7actionbarandtoolbar.interfaces.AdapterCallback;
import devf.b7actionbarandtoolbar.interfaces.MyVeryOwnListener;
import devf.b7actionbarandtoolbar.model.TruckComment;

/**
 * Created by Luis Galvan on 12/2/2015.
 */
public class TruckCommentAdapter extends RecyclerView.Adapter<TruckCommentAdapter.CommentViewHolder> {



    private List<TruckComment> truckCommenter;
    private MyVeryOwnListener myVeryOwnListener;
    private LayoutInflater myInflater;

    private String TAG = " This is it ";

    private int CurrentCommentViewHolder;
    private int AvergeGrade = 0;
    private AdapterCallback adapterCallback;

    public TruckCommentAdapter(Context context, List<TruckComment> comments) {
        myInflater = LayoutInflater.from(context);
        this.truckCommenter = comments;

    }


    @Override
    public TruckCommentAdapter.CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = myInflater.inflate(R.layout.lis_comment, parent, false);

        CommentViewHolder viewHolderz = new CommentViewHolder(view,R.id.comment_comment, R.id.date_comment, R.id.likes_comment, R.id.NameUser_comment, R.id.image_UserComment );
//        CommentViewHolder(View itemView, TextView tcomment, TextView tdate, TextView tlikes, TextView tnameUser, ImageView tuserImage)

        Log.e(TAG, " $$$$$$$xx  onBindViewHolder: " + AvergeGrade);
        return viewHolderz;
    }


    @Override
    public void onBindViewHolder(TruckCommentAdapter.CommentViewHolder holder, int position) {


        TruckComment truckComment = truckCommenter.get(position);

        holder.setTcomment(truckComment.getTcomment());
        holder.setTdate(truckComment.getTdate());
        holder.setTlikes(truckComment.getTlikes());
        holder.setTnameUser(truckComment.getTnameUser());
        holder.setTuserImage(truckComment.getTuserImage());

        AvergeGrade = truckComment.getTlikes() + AvergeGrade;
//        holder.setTgrade(String.valueOf(position));

        CurrentCommentViewHolder = position;



    }

    @Override
    public int getItemCount() {

        return truckCommenter.size();
//        return 0;
    }

    public void setMyVeryOwnListener(MyVeryOwnListener myVeryOwnListenerz) {

        this.myVeryOwnListener = myVeryOwnListenerz;
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView TnameUser;
        private TextView Tdate;
        private TextView Tcomment;
        private ImageView TuserImage;
        private TextView tlikes;
        private TextView Tgrade;


        public CommentViewHolder(View itemView, int tcomment, int tdate, int tlikes, int tnameUser, int tuserImage) {
            super(itemView);
            Tcomment = (TextView) itemView.findViewById(tcomment);
            Tdate = (TextView) itemView.findViewById(tdate);
            this.tlikes = (TextView) itemView.findViewById(tlikes);
            TnameUser = (TextView) itemView.findViewById(tnameUser);
            TuserImage = (ImageView) itemView.findViewById(tuserImage);
            Tgrade = (TextView) itemView.findViewById(R.id.comment_grade);
        }

        /*
        public CommentViewHolder(View itemView) {
            super(itemView);


        }
        */


        public void setTcomment(String tcomment) {
            this.Tcomment.setText(tcomment);
        }

        public void setTdate(String tdate) {
            this.Tdate.setText(tdate);
        }

        public void setTlikes(int tlikes) {
            this.tlikes.setText( String.valueOf(tlikes));
        }

        public void setTnameUser(String tnameUser) {
            this.TnameUser.setText(tnameUser);
        }

        public void setTuserImage(int tuserImage) {
            this.TuserImage.setImageResource(tuserImage);
        }


        public void setTgrade(String tgrade) {
            this.Tgrade.setText(tgrade);
        }

        @Override
        public void onClick(View v) {

            TruckComment TruckerCommentz = truckCommenter.get(getAdapterPosition());

            myVeryOwnListener.onItemClick(getAdapterPosition(), v,TruckerCommentz);

        }
    }
}
