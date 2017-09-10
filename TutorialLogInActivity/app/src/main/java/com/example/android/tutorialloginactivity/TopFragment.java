package com.example.android.tutorialloginactivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by abelhectMACHOME on 3/4/16.
 */
public class TopFragment extends Fragment {

    //variable for the interfaceImplementor
    private FlightSearcher interfaceImplementor;

    //Method for the interface that allows the communication with the parent activity
    public interface FlightSearcher {
        public void searchForFlights(String origin, String destination);
    }

    //attaches the fragment to the main activity as its first method in the lifecycle
    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        this.interfaceImplementor = (FlightSearcher) context;
    }

    //after attaching to the main activity we inflate the view for the fragment
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

    //Create the listener method for the button
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button flightSearchButton = (Button) getActivity().findViewById(R.id.button);
        flightSearchButton.setOnClickListener(new View.OnClickListener() {
            //onClick method that stores the reference to each spinner on the click of the button
            @Override
            public void onClick(View v) {
                Spinner originSpinner = (Spinner)getActivity().findViewById(R.id.origin);
                Spinner destinationSpinner = (Spinner)getActivity().findViewById(R.id.destination);
                //implementing the interface here with the user between the layout spinners to the main activity
                // interface and the attached method
                interfaceImplementor.searchForFlights(originSpinner.getSelectedItem().toString(),
                        destinationSpinner.getSelectedItem().toString());
            }
        });
    }
}
