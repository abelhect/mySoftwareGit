package org.tutorials.hectorsdesign.udemymaterialdesign.network;

/**
 * Created by abelhectMACHOME on 9/14/16.
 */
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import org.tutorials.hectorsdesign.udemymaterialdesign.udemymaterialdesign.MyApplication;

public class VolleySingleton {
    private static VolleySingleton ourInstance = null;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private VolleySingleton() {
//        this below requires a new custom application class
        mRequestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
        mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
//            Android template for cache below
//                    private final LruCache<String, Bitmap>
//                            cache = new LruCache<String, Bitmap>(20);

            //          Recommended cache by Udemy instructor
            private LruCache<String, Bitmap> cache=new LruCache<>((int)(Runtime.getRuntime().maxMemory()/1024)/8);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });
    }

    public static VolleySingleton getInstance() {
        if (ourInstance == null) {
            ourInstance = new VolleySingleton();
        }
        return ourInstance;
    }

    public RequestQueue getRequestQueue() {
//        if (mRequestQueue == null) {
//            // getApplicationContext() is key, it keeps you from leaking the
//            // Activity or BroadcastReceiver if someone passes one in.
//            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
//        }
        return mRequestQueue;
    }
    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

}
