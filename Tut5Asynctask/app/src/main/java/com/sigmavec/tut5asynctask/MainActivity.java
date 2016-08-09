package com.sigmavec.tut5asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // (1).Create object for xml elements
    Button b;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // (2).Bind the id to objects
        b = (Button) findViewById(R.id.button);
        t = (TextView) findViewById(R.id.textView);

        // (3).Create an Onclicklistener for button obj
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //(6).create object for async class and execute it
                BackTask b = new BackTask();
                b.execute(1000);
            }
        });
    }

    // (4).Create a async class
    public class BackTask extends AsyncTask<Integer , String , String>{

        //(5). Generate the necessary override methods

        @Override
        protected String doInBackground(Integer... params) { //this method runs the background task

            // have your logic here
            for (int i =1 ; i <= 10; i++){
                try {
                    Thread.sleep(params[0] / 10);
                    publishProgress( i*10 + " % " ); //call progressUpdate
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            //logic end
            String s =  "finished sleeping";
            return s;
        }

        @Override
        protected void onPreExecute() { //is executed before background task
            super.onPreExecute();
            t.setText("Going to sleep");
        }

        @Override
        protected void onPostExecute(String s) {  //is executed after background task
            super.onPostExecute(s);
            t.setText(s);
        }

        @Override
        protected void onProgressUpdate(String... values) { // is called from background task
            super.onProgressUpdate(values);
            t.setText("sleeping" +values[0] );
        }
    }
}
