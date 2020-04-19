package com.osmanforhad.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    /* declaring variable as my xml ui**/
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        /* initial the xml ui **/
        textView = findViewById(R.id.txt);
        button = findViewById(R.id.copy_btn);

        /* receive data which was send from 1st Activity **/
        final String dStory = getIntent().getStringExtra("story");

        /* show the data which received from 1st activity **/
        textView.setText(dStory);

        /* creating a OnClickListener for making this button dynamic or clickable**/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* for copying data **/
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                /* use dStory variable means the specific position form string array**/
                ClipData clip = ClipData.newPlainText("Text", dStory);
                clipboard.setPrimaryClip(clip);

                /* display message to ensure the data is copy successfully **/
                Toast.makeText(Main2Activity.this,"copied", Toast.LENGTH_SHORT).show();

            }//end of the OnClickListener method

        });//end of the setOnClickListener

    }//end of the onCreate method

}//end of the class
