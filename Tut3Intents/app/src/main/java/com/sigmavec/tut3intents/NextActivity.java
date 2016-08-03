package com.sigmavec.tut3intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by root on 3/8/16.
 */
//first extend the Activity Base class
public class NextActivity extends Activity {

    //create the oncreate Method
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign a layout (xml) file to the activity
        setContentView(R.layout.next);

        //assign id
        t = (TextView) findViewById(R.id.textView);

        //to get the valuse sent by Intent
        Intent i = getIntent();
        String m = i.getStringExtra("key");

        //display the value
        t.setText(m);


    }
}
