package com.example.android.tutorialmenuapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView mangoTextViewVar = (TextView) findViewById(R.id.menu_item_1);
                String mangoTextToString = mangoTextViewVar.getText().toString();
                Log.v("MainActivity.java",mangoTextToString);
        // Find second menu item TextView and print the text to the logs
        TextView blueberryTextViewVar = (TextView) findViewById(R.id.menu_item_2);
        String blueberryTextToString = blueberryTextViewVar.getText().toString();
        Log.v("MainActivity.java",blueberryTextToString);
        // Find third menu item TextView and print the text to the logs
        TextView chocolateTextViewVar = (TextView) findViewById(R.id.menu_item_3);
        String chocolateTextToString = chocolateTextViewVar.getText().toString();
        Log.v("MainActivity.java",chocolateTextToString);
    }
}
