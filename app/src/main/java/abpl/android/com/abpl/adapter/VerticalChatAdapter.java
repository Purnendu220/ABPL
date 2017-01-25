package abpl.android.com.abpl.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

import abpl.android.com.abpl.R;
import abpl.android.com.abpl.RefrenceWrapper;
import abpl.android.com.abpl.activity.LoginActivity;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mobikasa on 8/26/2016.
 */
public class VerticalChatAdapter extends RecyclerView.Adapter<VerticalChatAdapter.VerticalChatHolder> {
    private ArrayList<ModelAdapter> mDataList = new ArrayList<>();
    private Context mContext;
    private RefrenceWrapper refrenceWrapper;
    private Button mBtnRetry;
    public VerticalChatHolder mh;
    public VerticalChatAdapter(Context context, ArrayList<ModelAdapter> DataList) {
        mDataList.addAll(DataList);
        this.mContext = context;
        refrenceWrapper = RefrenceWrapper.getRefrenceWrapper(mContext);

    }

    @Override
    public VerticalChatHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_view, null);
         mh = new VerticalChatHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(VerticalChatHolder holder, int position) {

        refrenceWrapper.getmPictureUtilHandler().setPictureFromPicasso(mContext, mDataList.get(position).getmImageUrl(), holder.mImg_View, R.drawable.ic_user);
        refrenceWrapper.getFontTypeFace().setTypeFace(mContext, holder.mTxt_Description,holder.mTxt_sub_Description);
        refrenceWrapper.getFontTypeFace().setTypeFaceMedium(mContext, holder.mTxt_Item);
        holder.mTxt_Item.setText(mDataList.get(position).getmItemTitle());
        holder.mTxt_Description.setText(mDataList.get(position).getmItemDescription());
        holder.mTxt_sub_Description.setText(mDataList.get(position).getmItemSubDescription());



    }

    @Override
    public int getItemCount() {
        return (null != mDataList ? mDataList.size() : 0);
    }

    public class VerticalChatHolder extends RecyclerView.ViewHolder {
        protected TextView mTxt_Item, mTxt_Description, mTxt_sub_Description;
        public ImageView mImg_View;
        protected ProgressBar progressImageUplaod;

        public VerticalChatHolder(View view) {
            super(view);
            this.mTxt_Item = (TextView) view.findViewById(R.id.text_item_name);
            this.mImg_View = (ImageView) view.findViewById(R.id.img_user);
            this.mTxt_Description = (TextView) view.findViewById(R.id.text_item_desc);
            this.mTxt_sub_Description = (TextView) view.findViewById(R.id.text_item__sub_desc);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {




                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    return false;
                }
            });
        }
    }


}