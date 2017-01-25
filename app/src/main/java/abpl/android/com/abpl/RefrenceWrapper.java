package abpl.android.com.abpl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Typeface;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import abpl.android.com.abpl.db.AppSharedPreferences;
import abpl.android.com.abpl.utils.FragmentCallingUtils;
import abpl.android.com.abpl.utils.PictureUtils;
import abpl.android.com.abpl.utils.RestAPI;
import abpl.android.com.abpl.utils.ServiceCallsUtils;
import abpl.android.com.abpl.utils.ServiceConstants;
import abpl.android.com.abpl.utils.StringUtils;
import abpl.android.com.abpl.utils.date.DateTimeUtils;
import abpl.android.com.abpl.utils.device.AlertUtils;
import abpl.android.com.abpl.utils.device.DeviceUtils;
import abpl.android.com.abpl.utils.device.FontTypeFace;
import abpl.android.com.abpl.utils.device.LogUtils;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RefrenceWrapper {

    public static RefrenceWrapper refrenceWrapper;
    private Context context;
    private StringUtils mStringUtilHandler;
    private DeviceUtils mDeviceUtilHandler;
    private DateTimeUtils mDateTimeUtils;
    private FragmentCallingUtils mFragmentCallingUtilsHandler;
    private FontTypeFace fontTypeFace;
    private PictureUtils mPictureUtilHandler;
    private RestAPI service;
    private ServiceCallsUtils mServiceCallHandler;
    private AlertUtils mAlertUtils;

    public RefrenceWrapper(Context activity) {
        this.context = activity;
    }

    public static RefrenceWrapper getRefrenceWrapper(Context context) {
        if (refrenceWrapper == null) {
            refrenceWrapper = new RefrenceWrapper(context);
        }
        return refrenceWrapper;
    }

    public void destroyInstance() {
        if (refrenceWrapper != null) {
            refrenceWrapper = null;
        }
    }
 /*   RequestInterceptor requestInterceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
            String accessToken = AppSharedPreferences.getInstance().getAccessToken();
            String versionName = refrenceWrapper.getmDeviceUtilHandler().getVersionCode(context);
            LogUtils.debug("Version Name " + versionName);
            LogUtils.debug("AccessToken " + accessToken);
            if (accessToken != null && accessToken.length() > 0) {
                request.addHeader("AccessToken", accessToken);
                request.addHeader("AppVersion", versionName);
            }

        }
    };*/

    public RestAPI getService() {
        return (service == null) ? setService() : service;
    }

    private RestAPI setService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
       /* httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("AccessToken", "ohdhaQha02jLr4xOVFcwDI18Ov4kKV8u")
                        .addHeader("AppVersion", "1.0");

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });*/
        httpClient.addInterceptor(interceptor);
        OkHttpClient client = httpClient.build();

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(ServiceConstants.WebConstants.BASE_URL_CONSTANT).client(client).addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit = builder.client(client).build();
        service = retrofit.create(RestAPI.class);
        return service;

    }

    public FragmentCallingUtils getmFragmentCallingUtilsHandler() {
        if (mFragmentCallingUtilsHandler == null) {
            mFragmentCallingUtilsHandler = new FragmentCallingUtils();
        }
        return mFragmentCallingUtilsHandler;
    }


    public StringUtils getmStringUtilHandler() {
        if (mStringUtilHandler == null) {
            mStringUtilHandler = new StringUtils();
        }
        return mStringUtilHandler;
    }


    public DeviceUtils getmDeviceUtilHandler() {
        if (mDeviceUtilHandler == null) {
            mDeviceUtilHandler = new DeviceUtils();
        }
        return mDeviceUtilHandler;
    }

    public DateTimeUtils getDateTimeUtilHandler(){
        if(mDateTimeUtils==null){
            mDateTimeUtils=new DateTimeUtils();
        }
        return mDateTimeUtils;
    }


    public String getApplicationPackage(Context ctx) {
        String version = "";
        try {
            PackageInfo pInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
            version = pInfo.packageName;
        } catch (Exception e) {
            version = "performix.com.performix";
        }
        return version;
    }
    public FontTypeFace getFontTypeFace() {
        if (fontTypeFace == null) {
            fontTypeFace = new FontTypeFace();
        }
        return fontTypeFace;
    }
    public PictureUtils getmPictureUtilHandler() {
        if (mPictureUtilHandler == null) {
            mPictureUtilHandler = new PictureUtils(context);
        }
        return mPictureUtilHandler;
    }
    public ServiceCallsUtils getmServiceCallHandler() {
        if (mServiceCallHandler == null) {
            mServiceCallHandler = new ServiceCallsUtils();
        }
        return mServiceCallHandler;
    }
    public AlertUtils getmAlertUtils() {
        if (mAlertUtils == null) {
            mAlertUtils = new AlertUtils();
        }
        return mAlertUtils;
    }
}