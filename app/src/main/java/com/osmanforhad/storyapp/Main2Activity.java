package com.osmanforhad.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    /* declaring variable as my xml ui**/
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        /* initial the xml ui **/
        textView = findViewById(R.id.txt);

        /* receive data which was send from 1st Activity **/
        String dStory = getIntent().getStringExtra("story");

        /* show the data which received from 1st activity **/
        textView.setText(dStory);

    }//end of the onCreate method

}//end of the class
