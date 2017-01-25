package abpl.android.com.abpl.activity;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import abpl.android.com.abpl.R;
import abpl.android.com.abpl.adapter.ModelAdapter;
import abpl.android.com.abpl.adapter.VerticalChatAdapter;
import abpl.android.com.abpl.base.BaseActivity;
import abpl.android.com.abpl.listener.RecyclerTouchListener;
import abpl.android.com.abpl.utils.VerticalDividerItemDecoration;
import abpl.android.com.abpl.utils.device.AlertUtils;

public class ListDetailActivity extends BaseActivity implements RecyclerTouchListener.ClickListener {

    private RecyclerView list;
    private ListDetailActivity mContext;
    private VerticalChatAdapter mListAdapter;
    private ArrayList<ModelAdapter> mDatalist=new ArrayList<>();
    String imageUrl="https://propitious-leather.000webhostapp.com/uploads/1483357248926_1484171834.jpg";
    String imageurl2="https://propitious-leather.000webhostapp.com/uploads/1483428953495_1484169945.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);
        mContext=ListDetailActivity.this;
        SetTitle("DETAILS");
        setlist();
        list = (RecyclerView)findViewById(R.id.rvFeed);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);

        list.addItemDecoration(new VerticalDividerItemDecoration(20,false));
        list.setLayoutManager(layoutManager);
        mListAdapter = new VerticalChatAdapter(mContext, mDatalist);
        list.setAdapter(mListAdapter);
        list.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), list, this));
    }

    private void setlist() {
        for (int i=0;i<=10;i++){
            if(i%2==0){
                mDatalist.add(new ModelAdapter(imageUrl,"Purnendu Mishra","This is Description of Item fdgdf fdgdf fdgdfgd ","This is Sub Description Item kfjkldf dgkfg kfdjgdfklj fkjgdlkfj "));
            }
            else{
                mDatalist.add(new ModelAdapter(imageurl2,"Purnendu Mishra","This is Description of Item","This is Sub Description Item"));

            }

        }

    }

    @Override
    public void onClick(View view, int position) {
        AlertUtils.getInstance().showToast(mContext,"On Click");
        Intent intent = new Intent(this, LoginActivity.class);
// Pass data object in the bundle and populate details activity.
     //   intent.putExtra(DetailsActivity.EXTRA_CONTACT, contact);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view, "profile");
        startActivity(intent, options.toBundle());
    }

    @Override
    public void onLongClick(View view, int position) {
        AlertUtils.getInstance().showToast(mContext,"On Long Click");
    }
}
