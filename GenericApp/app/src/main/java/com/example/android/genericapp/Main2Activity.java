import android.support.v7.app.AppCompatActivity;

/**

import android.support.v7.app.AppCompatActivity;

import android.support.v7.app.AppCompatActivity;

package com.example.android.genericapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.genericapp.DatabaseHelper;

public class Main2Activity extends AppCompatActivity {
    DatabaseHelper userDb; /**created the first instance of the sqlite database*/

    /**created the editText variables for the user data we need to retrieve*/
/**    EditText editName, editSurname, editAge, editEmail, editPassword, editPassCheck, passToStr, passCheckToStr;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        userDb = new DatabaseHelper(this);

        editName= (EditText)findViewById(R.id.etName);
        editSurname= (EditText)findViewById(R.id.etSurname);
        editAge= (EditText)findViewById(R.id.etAge);
        editEmail= (EditText)findViewById(R.id.etEmail);
        editPassword= (EditText)findViewById(R.id.etPassword);
        String passToStr= editPassword.getText().toString();
        editPassCheck= (EditText)findViewById(R.id.etPassCheck);
        String passCheckToStr= editPassCheck.getText().toString();
        registerButton= (Button) findViewById(R.id.regButton);
        onClickRegisterUser();

       /**Would like to create a password confirm method
        if (!passToStr.equals(passCheckToStr)){
          Toast.makeText(Main2Activity.this, "Passwords don't match! Try again.",Toast.LENGTH_LONG).show();
        }
        else {

        }
        */
 /**   }

    public void onClickRegisterUser(){
        registerButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted=userDb.insertData(editName.getText().toString(),
                                editSurname.getText().toString(),
                                editAge.getText().toString(),
                                editEmail.getText().toString(),
                                editPassword.getText().toString());

                        /** Create a check method that gives feedback to the user saying if data
                         * was inserted successfully or not. Cool widget called toast!
                         **/
                      /**  if(isInserted) {
                            //Toast.makeText(Main2Activity.this,"Voala! Data inserted",Toast.LENGTH_LONG).show();
                        /**What i would like to do here is create a method that sends me to a
                         * profile page showing the data we inserted into the database rather
                         * than giving me a message.
                         */
                  /**          setContentView(R.layout.activity_profile);
                        } else {
                        Toast.makeText(Main2Activity.this,"Sorry, unsuccessful input to database!",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

    }

}
*/