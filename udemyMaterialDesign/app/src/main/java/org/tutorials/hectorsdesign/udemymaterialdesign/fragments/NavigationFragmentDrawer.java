package org.tutorials.hectorsdesign.udemymaterialdesign.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.tutorials.hectorsdesign.udemymaterialdesign.R;
import org.tutorials.hectorsdesign.udemymaterialdesign.adapters.VivzAdapter;
import org.tutorials.hectorsdesign.udemymaterialdesign.pojo.Information;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragmentDrawer extends Fragment {

    public static final String PREF_FILE_NAME = "testpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private View containerView;
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    private RecyclerView recyclerView;
    //    creating an object of the recyclerView adapter
    private VivzAdapter adapter;

    public NavigationFragmentDrawer() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
        if (savedInstanceState != null) {
            mFromSavedInstanceState = true;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        //This is for the recyclerview
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
//        initializing the adapter with the context and the data
        adapter = new VivzAdapter(getActivity(), getData());
//        set the adapter in the recyclerview
        recyclerView.setAdapter(adapter);
//        set the layout manager with the linear layout view
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        this is for the recyclerView clicking action of items in the list
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getActivity(),"onClick "+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity(),"onLongClick "+position,Toast.LENGTH_SHORT).show();

            }
        }));
        return layout;
    }

    //initializing the data for the recyclerView Adapter. It cannot be dynamic data for the drawer
    //a static array will do
    public static List<Information> getData() {
        List<Information> data = new ArrayList<>();
        int[] icons = {R.drawable.ic_image_looks_one, R.drawable.ic_image_looks_two, R.drawable.ic_image_looks_3,
                R.drawable.ic_image_looks_4};
        String[] titles = {"Voyala", "Witi", "Laopesillo", "Rakataka"};
//        //loop to iterate and add each of the items from the array. This is for a 100 items repeat long list
//        for (int i = 0; i < 100; i++) {
//            Information current = new Information();
//            current.iconId = icons[i % icons.length];
//            current.title = titles[i % titles.length];
//            data.add(current);
//        }
        //loop to iterate and add each of the items from the array. This is for 4 items in list without repeat
        for (int i = 0; i < icons.length && i < titles.length; i++) {
            Information current = new Information();
            current.iconId = icons[i];
            current.title = titles[i];
            data.add(current);
        }
        return data;
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //If the user has ever seen the drawer before and save it to preferences
                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer + "");
                }
                //this indicates that the option menu has changed so it should be recreated
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //this indicates that the option menu has changed so it should be recreated
                getActivity().invalidateOptionsMenu();
            }

            //This is the method that allows for the animation of the drawer slider
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if (slideOffset < 0.6) {
                    toolbar.setAlpha(1 - slideOffset);
                }
            }
        };
        //if user has never seen the drawer before or the fragment is opened for the first time
        //display the drawer
        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            //open the drawer and pass the id of the view that needs to open
            mDrawerLayout.openDrawer(containerView);
        }
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        //in order to have the burger show up by using runnable and syncState
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    //    Part of the recyclerView clicking actions
    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;
        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            Log.d("Hector's debug msg", "RecyclerTouchListener constructor invoked ");
            this.clickListener=clickListener;
            gestureDetector=new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    Log.d("Hector's debug msg", "onSingleTapUp " + e);
                    return true;
//                      default
//                    return super.onSingleTapUp(e);
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    Log.d("Hector's debug msg", "onLongPress " + e);
                    super.onLongPress(e);
                    View child=recyclerView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clickListener!=null){
                        clickListener.onLongClick(child,recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clickListener!=null && gestureDetector.onTouchEvent(e)){
                clickListener.onClick(child,rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            Log.d("Hector's debug msg", "onTouchEvent " + e);
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    //    Part of the recyclerView clicking actions
    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);

    }


    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    public static String readFromPreferences(Context context, String preferenceName, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, defaultValue);
    }
}
