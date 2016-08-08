package com.sigmavec.tut4sharedpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // (1).create object for layout elements
    Button b;
    TextView t;
    EditText e;

    // (5).create sharedPref obj
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // (6).initialize the sharedpref Object            (  name  ,     mode );
        sp = getSharedPreferences("MyPref", MODE_PRIVATE);

        // (2).bind the id of xml with the objects created
        b = (Button) findViewById(R.id.btn);
        t = (TextView) findViewById(R.id.textView);
        e = (EditText) findViewById(R.id.editText);

        // (3).create a listener for button click
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // (4). get and put the text to textview
                String a = e.getText().toString();
                t.setText(a);

                // (7).store the text to shared pref
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("key",a);
                // (7.1).save the changes to editor
                editor.commit();
            }
        });
        //(8).get the value stored in the shared pref
        String a = sp.getString("key", null);
        if ( a != null)
            t.setText(a);

    }
}
