package abpl.android.com.abpl;

import android.app.Application;

import abpl.android.com.abpl.utils.AppContext;

/**
 * Created by Purnendu on 1/6/2017.
 */

public class ABPLApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.getInstance().setContext(this);

    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.exit(0);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
