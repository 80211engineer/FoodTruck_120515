package devf.b7actionbarandtoolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import devf.b7actionbarandtoolbar.adapters.TruckCommentAdapter;
import devf.b7actionbarandtoolbar.interfaces.MyVeryOwnListener;
import devf.b7actionbarandtoolbar.model.TruckComment;

/**
 * Created by Luis Galvan on 12/2/2015.
 */
public class ActTruckComment extends AppCompatActivity implements AdapterView.OnItemClickListener, MyVeryOwnListener {


    private RecyclerView recyclerView2;


    private String fdComment = " Best food ever";
    private String fdNameUser = "Peter Pan";
    private String fdDate = "2-Dec-2015";
    private int fdLikes = 8;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments_truck);
        
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

        recyclerView2 = (RecyclerView) findViewById(R.id.list_of_comments);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView2.setLayoutManager(layoutManager2);

        TruckCommentAdapter truckCommentAdapter = new TruckCommentAdapter(this, createComments());
        recyclerView2.setAdapter(truckCommentAdapter);
        truckCommentAdapter.setMyVeryOwnListener(this);


    }

    private List<TruckComment> createComments() {


        List<TruckComment> comments = new ArrayList<>();


        for(int i=0; i<10; i++){



//            public TruckComment(String tcomment, String tdate, int tlikes, String tnameUser, int tuserImage) {
            comments.add(new TruckComment(fdComment,fdDate, fdLikes, fdNameUser, R.drawable.myself));


        }

        return comments;

    }

    @Override
    public void onItemClick(int position, View v, TruckComment truckComment) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
