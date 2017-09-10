package org.tutorials.hectorsdesign.udemymaterialdesign.udemymaterialdesign;

import android.app.Application;
import android.content.Context;

/**
 * Created by abelhectMACHOME on 9/11/16.
 */
public class MyApplication extends Application{
    public static final String API_KEY_THEMOVIEDB="83d601d7984d4e00270a840604c4c447";
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;

    }

    public static MyApplication getsInstance() {
        return sInstance;
    }

    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }
}
