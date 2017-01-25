package abpl.android.com.abpl.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Timer;
import java.util.TimerTask;

import abpl.android.com.abpl.R;
import abpl.android.com.abpl.RefrenceWrapper;

/**
 * Created by Aarshi on 12-12-2016.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected AppCompatActivity mContext;
    private RefrenceWrapper mRefrenceWrapper;
    private ImageView mToolbaLeftImage,mToolbarRightImage;
    private Toolbar mToolbar;
    private TextView mToolbarTitle,mToolbarTitleRight;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        mContext = this;
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        mRefrenceWrapper=RefrenceWrapper.getRefrenceWrapper(BaseActivity.this);
        //Crittercism.initialize(getApplicationContext(), getResources().getString(R.string.crittercism));
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.base_layout);
        FrameLayout layout = (FrameLayout) findViewById(R.id.container);
        mToolbar=(Toolbar)findViewById(R.id.toolbar) ;
        mToolbaLeftImage=(ImageView)mToolbar.findViewById(R.id.toolbar_img_left);
        mToolbarRightImage=(ImageView)mToolbar.findViewById(R.id.toolbar_img_right);
        mToolbarTitle=(TextView)mToolbar.findViewById(R.id.toolbar_title);
        mToolbarTitleRight=(TextView)mToolbar.findViewById(R.id.toolbar_text_right);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View innerView = inflater.inflate(layoutResID, null);
        layout.addView(innerView);
        mRefrenceWrapper.getFontTypeFace().setTypeFace(BaseActivity.this,mToolbarTitle,mToolbarTitleRight);
    }

    public ImageView getmToolbaLeftImage() {
        return mToolbaLeftImage;
    }

    public ImageView getmToolbarRightImage() {
        return mToolbarRightImage;
    }

    public Toolbar getmToolbar() {
        return mToolbar;
    }

    public TextView getmToolbarTitle() {
        return mToolbarTitle;
    }

    public TextView getmToolbarTitleRight() {
        return mToolbarTitleRight;
    }

    public void activityCleanSwitcher(Class<?> classToSwtich) {
        Intent i = new Intent(this, classToSwtich);
        startActivity(i);
        finish();
    }
    public void activitySwitcher(Class<?> classToSwtich) {
        Intent i = new Intent(this, classToSwtich);
        startActivity(i);
    }
    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Get an Analytics tracker to report app starts & uncaught exceptions etc.
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Stop the analytics tracking
    }
    public void showTextView(final TextView view, String message) {
        view.setVisibility(View.VISIBLE);
        view.setText(message);
        Timer t = new Timer(false);
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        mRefrenceWrapper = RefrenceWrapper.getRefrenceWrapper(BaseActivity.this);
                        view.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }, 3000);
    }
    public void SetTitle(String title){
        mToolbarTitle.setText(title);
    }
}
