package org.tutorials.hectorsdesign.udemymaterialdesign.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.tutorials.hectorsdesign.udemymaterialdesign.R;
import org.tutorials.hectorsdesign.udemymaterialdesign.fragments.FragmentBoxOffice;
import org.tutorials.hectorsdesign.udemymaterialdesign.fragments.FragmentSearch;
import org.tutorials.hectorsdesign.udemymaterialdesign.fragments.FragmentUpcoming;
import org.tutorials.hectorsdesign.udemymaterialdesign.fragments.NavigationFragmentDrawer;
import org.tutorials.hectorsdesign.udemymaterialdesign.views.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    //  Dont know what for this variables
//    private MaterialTabHost tabHost;

    //    variable for JSON API stuff bellow
//    This variables are for the SlidingTabs and views inside of them
    private ViewPager mPager;
    private SlidingTabLayout mTabs;

    //    variables for positions of each tab
    public static final int MOVIES_SEARCH_RESULTS = 0;
    public static final int MOVIES_HITS = 1;
    public static final int MOVIES_UPCOMING = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        If i want the activity with the drawer to come up under the appbar
//        setContentView(R.layout.activity_main_appbar);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationFragmentDrawer drawerFragment = (NavigationFragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

//        Initializing variables for Tabs and viewPagers
        mPager = (ViewPager) findViewById(R.id.pager_id);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs_id);
        mTabs.setDistributeEvenly(true);

//        CustomTabColorizer gets removed and replaced with setBackgroundColor & setSelectedINdicator when the tabs get a background and ripple effect
//        mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer(){
//
//            @Override
//            public int getIndicatorColor(int position) {
//                return getResources().getColor(R.color.colorAccent);
//            }
//        });
        mTabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mTabs.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mTabs.setCustomTabView(R.layout.custom_tab_view, R.id.tabText_id);
        mTabs.setViewPager(mPager);


//        ******This is for the retrieval of data JSON API - but instructiosn follow a library i am not using
//
//        tabHost=(MaterialTabHost) findViewById(R.id.materialTabHost); //this is from the lib we are not using

//        viewPager=(ViewPager) findViewById(R.id.viewPager);       //this is already in place above using mPager
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(adapter);
//        viewPager.setOnPageChangeListener((SingleOnPageChangeListener) onPageSelected(position)...)
//        tabHost.setSelectedNavigationItem(position);
//        });
//        ******End of JSON API retrieval
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.navigate:
                startActivity(new Intent(this, SubActivity.class));
                // User chose the "Next" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    //  ****  This is for the SlidingTabs classes
//    class MyPagerAdapter extends FragmentPagerAdapter {
//    Testing out the change provided on the udemy course
    private class MyPagerAdapter extends FragmentStatePagerAdapter{
        int icons[]={R.drawable.search,
                R.drawable.ic_explosion,
                R.drawable.ic_events};
        String[] tabsText;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            tabsText =getResources().getStringArray(R.array.tabs);
        }

        //            Changing it up a bit to make it work for the movie w/ json api
//        @Override
//        public Fragment getItem(int position) {
//            MyFragment myFragment=MyFragment.getInstance(position);
        @Override
        public Fragment getItem(int num) {
            Fragment fragment=null;
//            HEre is a conditional for the movie fragments
            switch (num){
                case MOVIES_SEARCH_RESULTS:
                    fragment= FragmentSearch.newInstance("","");
                    break;
                case MOVIES_HITS:
                    fragment= FragmentBoxOffice.newInstance("","");
                    break;
                case MOVIES_UPCOMING:
                    fragment= FragmentUpcoming.newInstance("","");
                    break;
            }
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Drawable drawable=getResources().getDrawable(icons[position]);
            drawable.setBounds(0,0,36,36);
            ImageSpan imageSpan=new ImageSpan(drawable);
            SpannableString spannableString=new SpannableString(" ");
            spannableString.setSpan(imageSpan,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            return spannableString;
//              Could return text instead of images as below
//            return tabsText[position];
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    public static class MyFragment extends Fragment {
        //        create an instance of my fragment and return the object
        private TextView textView;

        public static MyFragment getInstance(int position) {
            MyFragment myFragment = new MyFragment();
            Bundle args = new Bundle();
            args.putInt("position",position); // should use a key instead of just writing "position" (trainer was lazy)
            myFragment.setArguments(args);
            return myFragment;
        }

        //        Display the layout with some place holder text
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragment_my, container, false);
            textView = (TextView) layout.findViewById(R.id.position);
            Bundle bundle = getArguments();
            if (bundle != null) {
                textView.setText("The Page Selected is " + bundle.getInt("position"));
            }
            return layout;
        }
    }
//    ***** End of classes for the SlidingTabs

    //        ******This is ALSO for the retrieval of data JSON API
//    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
//        int icons[]={R.drawable.ic_action_home,
//        R.drawable.ic_action_articles,
//        R.drawable.ic_action_personal};
//
//        public ViewPagerAdapter(FragmentManager fm){
//            super(fm);
//        }
////        Get position (num) and return the fragment for that position. Which fragment to instantiate based on position
//        public Fragment getItem(int num){
//            Fragment fragment=null;
//            switch (num){
//                case MOVIES_SEARCH_RESULTS:
//                    fragment= FragmentSearch.newInstance("","");
//                    break;
//                case MOVIES_HITS:
//                    fragment= FragmentBoxOffice.newInstance("","");
//                    break;
//                case MOVIES_UPCOMING:
//                    fragment= FragmentUpcoming.newInstance("","");
//                    break;
//            }
//            return fragment;
//        }
//
//        @Override
//        public int getCount(){return 3;}
//
//        @Override
//        public CharSequence getPageTitle(int position){};
//    }
//        ******End of JSON API retrieval

}
