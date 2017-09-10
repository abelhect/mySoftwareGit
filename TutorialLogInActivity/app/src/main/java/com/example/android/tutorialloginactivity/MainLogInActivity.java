package com.example.android.tutorialloginactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainLogInActivity extends AppCompatActivity implements TopFragment.FlightSearcher {

    //Initializing the method for the interface that connects the main layout bottom fragment container
    //to the actual bottom fragment class
    //also performs the calculation to pick the origin and destinations that will be displayed
    //in the bottom fragment container
    @Override
    public void searchForFlights(String origin, String destination) {
        BottomFragment bottomFragment = (BottomFragment)getFragmentManager().findFragmentById(R.id.bottomFragment);
        int randomPrice = (int)(Math.random()*200);
        String resultString = origin + " - " + destination + " = " + "$" + randomPrice;
        bottomFragment.displayFlightQueryResult(resultString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_log_in);
    }
}