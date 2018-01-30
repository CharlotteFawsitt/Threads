package com.example.n00146163.threads;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.tvText);
    }

    public void onButtonClicked(View view) {
        MyThread thread = new MyThread();
        thread.execute();
    }

    public void onClearClicked(View view) {
        output.setText("");
    }

    public void updateDisplay(String message) {
        output.append(message + "\n");
    }


    private class MyThread extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            return "Hello";
        }

        @Override
        protected void onPreExecute() {
            updateDisplay("Task Starting");
        }

        @Override
        protected void onPostExecute(String s) {
            updateDisplay(s);

        }
    }

}
