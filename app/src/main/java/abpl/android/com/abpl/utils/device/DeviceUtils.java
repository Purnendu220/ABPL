package abpl.android.com.abpl.utils.device;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Vibrator;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


import java.util.Random;

import abpl.android.com.abpl.db.AppSharedPreferences;
import abpl.android.com.abpl.utils.AppContext;


public class DeviceUtils {

    public boolean isAirplaneModeOn(Context context) {

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            return Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
        } else {
            return Settings.System.getInt(context.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) != 0;
        }
    }

    public boolean isInternetOn(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isScreenRotationOn(Context ctx) {
        if (Settings.System.getInt(ctx.getContentResolver(),
                Settings.System.ACCELEROMETER_ROTATION, 0) == 1) {
            return true;

        } else {
            return false;
        }
    }

    public void hideSoftKeyboard(Activity context) {

        InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = context.getCurrentFocus();
        if (inputManager != null && view != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            view.clearFocus();
        }
    }

    public void showSoftKeyboard(Activity context) {

        InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = context.getCurrentFocus();
        if (inputManager != null && view != null) {
            inputManager.showSoftInputFromInputMethod(view.getWindowToken(), InputMethodManager.SHOW_FORCED);
        }
    }

    public void vibrateDevice(Context context) {

        vibrateDevice(context, 250);
    }

    public void vibrateDevice(Context context, long duration) {

        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(duration);
    }

    public int getAPIVersion() {
        return Build.VERSION.SDK_INT;
    }

    public String getAndroidID(Context ctx) {

        String android_id = Secure.getString(ctx.getContentResolver(), Secure.ANDROID_ID);
        return android_id;
    }

    public String getDeviceType() {
        String device_type = "Android";
        return device_type;
    }

    /*public String getDeviceToken() {
        return AppSharedPreferences.getInstance().getGcmId();
    }*/

    /**
     * This will return the screen width .
     */
    public int getScreenWidth(Activity context) {
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        return mDisplayMetrics.widthPixels;
    }

    public int getScreenHeight(Activity context) {
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        return mDisplayMetrics.heightPixels;
    }

    public int getFullImageWidthHeight(Activity context) {
        int width = getScreenWidth(context);
        int height = getScreenHeight(context);
        if (width < height) {
        } else {
            width = height;
        }
        return width;
    }

    /**
     * Get the screen's density scale. Convert the dps to pixels, based on density scale
     */
    public int pxTodpConvert(Context activity, int pixels) {
        float scale = activity.getResources().getDisplayMetrics().density;
        float dips = pixels * scale + 0.5f;
        return (int) dips;
    }

    public int dpTopxConvert(Context activity, int dips) {
        float scale = activity.getResources().getDisplayMetrics().density;
        float pixels = dips / scale;
        return (int) pixels;
    }

    public String getDeviceID(Context context) {
        String identifier = null;
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null)
            identifier = tm.getDeviceId();
        if (identifier == null || identifier.length() == 0)
            identifier = Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);

        return identifier;
    }

    public String getEmiailID(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        Account account = getAccount(accountManager);
        if (account == null) {
            return null;
        } else {
            return account.name;
        }
    }

    private  Account getAccount(AccountManager accountManager) {
        Account account;
        try {
            Account[] accounts = accountManager.getAccountsByType("com.google");
            if (accounts.length > 0) {
                account = accounts[0];
            } else {
                account = null;
            }
        }
        catch (Exception e){
            account = null;
        }

        return account;
    }
    public  String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

//        String phrase = "";
        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
//                phrase += Character.toUpperCase(c);
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
//            phrase += c;
            phrase.append(c);
        }

        return phrase.toString();
    }
}
