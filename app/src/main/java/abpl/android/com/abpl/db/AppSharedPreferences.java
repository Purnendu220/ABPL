package abpl.android.com.abpl.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import abpl.android.com.abpl.utils.AppContext;
import abpl.android.com.abpl.utils.device.LogUtils;


public class AppSharedPreferences {

    private static AppSharedPreferences instance;




    private String TAG = this.getClass().getSimpleName();
    private SharedPreferences mPrefs;
    private Editor mPrefsEditor;
    private String mAccessToken;

    public AppSharedPreferences(Context context) {
        this.mPrefs = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        this.mPrefsEditor = mPrefs.edit();
    }

    public static AppSharedPreferences getInstance() {

        if (instance == null) {
            instance = new AppSharedPreferences(AppContext.getInstance().getContext());
        }
        return instance;
    }



    public String getAccessToken() {
        return mPrefs.getString(mAccessToken, "");
    }

    public void setAccessToken(String value) {
        LogUtils.debug("setAccessToken = ", value);
        mPrefsEditor.putString(mAccessToken, value);
        mPrefsEditor.commit();
    }


}