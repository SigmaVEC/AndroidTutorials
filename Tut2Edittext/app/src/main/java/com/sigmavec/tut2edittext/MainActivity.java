package com.sigmavec.tut2edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Creating objects
    Button b;
    EditText e;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linking the id of the xml elements
        b = (Button) findViewById(R.id.btn);
        e = (EditText) findViewById(R.id.etInput);
        t = (TextView) findViewById(R.id.tvDisplay);

        // set an onclick listener to the button to get button clicks
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e.getText().toString();
                t.setText(text);
            }
        });

        // you can also create a onclick listener for other elements
        // just use object.setOnClickListener(....){}
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"you clicked the textview",Toast.LENGTH_LONG).show();
            }
        });
    }
}
