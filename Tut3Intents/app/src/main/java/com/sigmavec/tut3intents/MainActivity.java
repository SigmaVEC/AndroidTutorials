package com.sigmavec.tut3intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //create the necessary objects
    Button b;
    String msg = "message from MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link the id
        b = (Button) findViewById(R.id.btn);

        //clickListner of button
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create an Intent object
                Intent i = new Intent(MainActivity.this,NextActivity.class);

                //for passing values via Intent
                i.putExtra("key",msg);

                startActivity(i);
            }
        });



    }
}
