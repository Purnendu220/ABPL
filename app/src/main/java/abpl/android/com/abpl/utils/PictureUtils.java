package abpl.android.com.abpl.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import abpl.android.com.abpl.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class PictureUtils {
    private Context mContext;
    private List<ImgTarget> mTargets;

    public PictureUtils(Context ctx) {
        mContext = ctx;
        mTargets = new ArrayList<ImgTarget>();
    }

    public void setPictureFromPicasso(Context context, String url, ImageView imageView, int placeholder) {
        if (placeholder == 0) {
            Picasso.with(context).load(url).placeholder(R.drawable.ic_user).into(imageView);
        } else {
            Picasso.with(context).load(url).placeholder(placeholder).error(placeholder).into(imageView);
        }
    }
    public void setPictureFromPicassoWithProgress(Context context, String url, CircleImageView imageView, ProgressBar mProgressProfileImage){
       ImgTarget target=new ImgTarget(imageView,mProgressProfileImage);
       Picasso.with(context).load(url).placeholder(R.drawable.camera).into(target);
       mTargets.add(target);
   }


    final class ImgTarget implements Target {

        private CircleImageView mUserImageView;
        private ProgressBar mProgressProfileImage;
        private TextView txtDot;
        private String mReadStatus;

        public ImgTarget(CircleImageView mUserImageView, ProgressBar mProgressProfileImage) {

            this.mUserImageView = mUserImageView;
            this.mProgressProfileImage = mProgressProfileImage;
        }

        public ImgTarget(CircleImageView mUserImageView, ProgressBar mProgressProfileImage, TextView txtDot, String ReadStatus) {

            this.mUserImageView = mUserImageView;
            this.mProgressProfileImage = mProgressProfileImage;
            this.txtDot = txtDot;
            mReadStatus = ReadStatus;
        }

        @Override
        public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
            Log.e("IMG Downloader", "onBitmapLoaded ...");
            mProgressProfileImage.setVisibility(View.GONE);
            mUserImageView.setImageBitmap(bitmap);
        }

        @Override
        public void onBitmapFailed(Drawable drawable) {
            Log.e("IMG Downloader", "Bitmap Failed...");
            mProgressProfileImage.setVisibility(View.GONE);
        }

        @Override
        public void onPrepareLoad(Drawable drawable) {
            Log.e("IMG Downloader", "Bitmap Preparing Load...");
           // mProgressProfileImage.setVisibility(View.VISIBLE);
        }

    }



}
