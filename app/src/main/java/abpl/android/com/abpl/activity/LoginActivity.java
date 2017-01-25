package abpl.android.com.abpl.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.File;
import java.io.IOException;

import abpl.android.com.abpl.R;
import abpl.android.com.abpl.RefrenceWrapper;
import abpl.android.com.abpl.base.BaseActivity;
import abpl.android.com.abpl.utils.GPSTracker;
import abpl.android.com.abpl.utils.GetFilePathFromDevice;
import abpl.android.com.abpl.utils.PermissionUtility;
import abpl.android.com.abpl.utils.StringUtils;
import abpl.android.com.abpl.utils.device.AlertUtils;
import abpl.android.com.abpl.utils.device.LogUtils;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private RefrenceWrapper mRefrenceWrapper;
    private RelativeLayout mRelativeLayout;
    private String mUserEmail,mDeviceID,mDeviceModel,mFCM_id,mLocation,mTimestamp;
    LoginActivity mLoginActivity;
    private GPSTracker mGpsTracker;
    private int galleryRequestCode=101;
    private String TAG="LoginActivity";
    private Button mBtn_Login;
    private ImageView img;
    TextInputLayout mTextInptUid,mTxtInptPassword;
    EditText mEdtUid,mEdtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SetTitle("LOGIN");
        mLoginActivity=LoginActivity.this;
        mRelativeLayout=(RelativeLayout)findViewById(R.id.login_layout);
        mBtn_Login=(Button)findViewById(R.id.login_btnSignUp);
        img=(ImageView)findViewById(R.id.img_user);
        mEdtUid=(EditText)findViewById(R.id.input_uid);
        mEdtpassword=(EditText)findViewById(R.id.input_password);
        mTextInptUid=(TextInputLayout)findViewById(R.id.input_layout_uid);
        mTxtInptPassword=(TextInputLayout)findViewById(R.id.input_layout_password);
        mRefrenceWrapper=RefrenceWrapper.getRefrenceWrapper(mLoginActivity);
        mBtn_Login.setOnClickListener(this);
        if (!(Build.VERSION.SDK_INT < Build.VERSION_CODES.M))
            PermissionUtility.verifyGetAccountPermissions(mLoginActivity);

        /*mBtn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mLoginActivity,ListDetailActivity.class);
                startActivity(i);
            }
        });*/

/*button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent pickIntent = new Intent(Intent.ACTION_PICK);
        pickIntent.setType("image*//*");
        pickIntent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        startActivityForResult(pickIntent, galleryRequestCode);
      *//*  mGpsTracker=new GPSTracker(mLoginActivity);
        setUserDetail();
        mRefrenceWrapper.getmServiceCallHandler().doRegistration(mLoginActivity,mRelativeLayout,mUserEmail,mDeviceID,mDeviceModel,mFCM_id,mLocation,mTimestamp);
*//*
    }
});*/

    }

    private void setUserDetail() {
        mUserEmail=mRefrenceWrapper.getmDeviceUtilHandler().getEmiailID(mLoginActivity);
        if(mUserEmail==null){mUserEmail="Not Found";}
        mDeviceID=mRefrenceWrapper.getmDeviceUtilHandler().getDeviceID(mLoginActivity);
        mDeviceModel=mRefrenceWrapper.getmDeviceUtilHandler().getDeviceName();
        mFCM_id="dsadssadsd";
        mLocation= mGpsTracker.getLatitude()+","+mGpsTracker.getLongitude();
        mTimestamp=String.valueOf(System.currentTimeMillis());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PermissionUtility.REQUEST_GETACCOUNTS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mRefrenceWrapper.getmAlertUtils().showSnackBar(LoginActivity.this,"Permission Granted",mRelativeLayout);

                }
                else{
                    mRefrenceWrapper.getmAlertUtils().showSnackBar(LoginActivity.this,"Permission Denied",mRelativeLayout);
                }

                break;
            case PermissionUtility.REQUEST_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mRefrenceWrapper.getmAlertUtils().showSnackBar(LoginActivity.this,"Location Permission Granted",mRelativeLayout);

                }
                else{
                    mRefrenceWrapper.getmAlertUtils().showSnackBar(LoginActivity.this,"Location Permission Denied",mRelativeLayout);
                }

                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == galleryRequestCode&& resultCode == Activity.RESULT_OK) {
            Uri selectedAudio = data.getData();
            String mediaPath = GetFilePathFromDevice.getPath(this, selectedAudio);
            LogUtils.error("FILE UPLOAD",mediaPath);
            File file = new File(mediaPath);
            RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
            RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());
            mRefrenceWrapper.getmServiceCallHandler().dofileUpload(mLoginActivity,mRelativeLayout,fileToUpload,filename);
        }
    }
    @Override
    public void onBackPressed() {
        ActivityCompat.finishAfterTransition(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btnSignUp:
                if(StringUtils.isUserIdValid(mEdtUid.getText().toString())){
                    mTextInptUid.setErrorEnabled(false);
                    if(StringUtils.isPasswordLengthValid(mEdtpassword.getText().toString(),6)){
                        mRefrenceWrapper.getmAlertUtils().showToastSuccess(mLoginActivity,"Login Success");
                        mTxtInptPassword.setErrorEnabled(false);
                    }else{
                        mRefrenceWrapper.getmAlertUtils().showToastError(mLoginActivity,"Please Enter Valid Password");
                        mTxtInptPassword.setError("Please Enter Valid Password");
                    }
                }
                else{
                    mRefrenceWrapper.getmAlertUtils().showToastError(mLoginActivity,"Please Enter Valid Userid");
                    mTextInptUid.setError("Please Enter Valid Userid");
                }
                break;
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_uid:
                          if(StringUtils.isUserIdValid(editable.toString())){

                          }
                    else{

                          }
                    break;
                case R.id.input_password:
                    if(StringUtils.isPasswordLengthValid(editable.toString(),6)){

                    }
                    else{

                    }
                    break;
            }
        }
    }
}
