package com.sigmavec.tut1button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //create objects for button and textview used in the xml file
    Button b;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // linking the id from layout files (XML)
        b = (Button) findViewById(R.id.btnClickMe);
        t = (TextView) findViewById(R.id.tvDisplay);

        //creating a function to listen if button is clicked
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //the code here get executed on button click
                t.setText("Button clicked"); //this displays the string to textview
                Toast.makeText(getBaseContext(),"This is toast",Toast.LENGTH_LONG).show();
            }
        });
    }
}
