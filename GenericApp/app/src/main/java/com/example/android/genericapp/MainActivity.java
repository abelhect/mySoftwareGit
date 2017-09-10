import android.support.v7.app.AppCompatActivity;

/**
 * package com.example.android.genericapp;

 import android.content.Intent;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;

 public class MainActivity extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

//
Button signin_button = (Button) findViewById(R.id.signin_button);
signin_button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Intent intent = new Intent(v.getContext(), Main2Activity.class);
startActivityForResult(intent, 0);
}
});
}

 */
import android.support.v7.app.AppCompatActivity;


import android.support.v7.app.AppCompatActivity;


    /**
     * Need to create a method that checks if the user is already registered
     * If is registered send to the profile page
     * else send the new user to the registration page
     */

    /**
     * Need to create a method that allows the user to register with google account
     */

    /**
     * Need to create a method that allows the user to register with facebook account
     */

    /**
     * Need to create a method that allows the user to register with twitter account
     */
}
