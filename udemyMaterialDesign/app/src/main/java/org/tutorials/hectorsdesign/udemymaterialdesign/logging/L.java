package org.tutorials.hectorsdesign.udemymaterialdesign.logging;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by abelhectMACHOME on 9/18/16.
 * Loggind class for debugging
 */
public class L {
    public static void m(String message){
        Log.d("HECTOR", "" + message);}

    public static void t(Context context, String message){
        Toast.makeText(context, message + "", Toast.LENGTH_SHORT).show();
    }

    public static void T(Context context, String message){
        Toast.makeText(context, message + "", Toast.LENGTH_LONG).show();
    }
}
