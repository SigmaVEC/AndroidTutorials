package com.sigmavec.tut6sqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // 1. create objects
    EditText id, name;
    Button save,show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.bind id

        id = (EditText) findViewById(R.id.etId);
        name = (EditText) findViewById(R.id.editText2);
        save = (Button) findViewById(R.id.btnSave);
        show = (Button) findViewById(R.id.btnShow);

        // 3 . create a DbHander class

        // 8.create on click listener for save
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();   // get data from user
                String i = id.getText().toString();
                DbHandler dH = new DbHandler(getBaseContext());  // create object for class to access insert() method
                dH.insert(i,n); // call the insert method
            }
        });

        // 11.create on click listener for show
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String i = id.getText().toString();   // get id from user
                DbHandler dH = new DbHandler(getBaseContext());  // create object
                String n = dH.get(i);   // get data corresponding to id
                name.setText(n);   // display the name

            }
        });


    }
}
