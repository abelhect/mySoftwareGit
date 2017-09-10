package com.example.android.tutorialloginactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by abelhectMACHOME on 3/4/16.
 */
public class BottomFragment extends Fragment {

    //Displaying the bottom fragment layout view
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottom, container, false);
    }

    //Pulling the results of a query method that will be created on main activity under the
    // search for flight calculations and displaying it on the bottom fragment layout
    // view that is interfaced with the main activity layout view bottom container
    public void displayFlightQueryResult(String result) {
        EditText resultField = (EditText)getActivity().findViewById(R.id.flightQueryResult);
        resultField.setText(result);

    }
}
