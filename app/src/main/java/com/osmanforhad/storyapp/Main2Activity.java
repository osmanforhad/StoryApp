package com.osmanforhad.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    /* declaring variable as my xml ui**/
    TextView textView;
    Button button;
    Button share_btn;
    Button next_btn, previous_btn;

    /* declaring Global variable **/
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        /* initial the xml ui **/
        textView = findViewById(R.id.txt);
        button = findViewById(R.id.copy_btn);
        share_btn = findViewById(R.id.share_btn);
        next_btn = findViewById(R.id.next_btn);
        previous_btn = findViewById(R.id.prev_btn);

        /* receive data which was send from 1st Activity **/
        //final String dStory = getIntent().getStringExtra("story");

        /* receive data into a string array which was send from 1st Activity **/
        final String[] dStory = getIntent().getStringArrayExtra("story");

        /* get the position which was send from 1st Activity or MainActivity**/
        position = getIntent().getIntExtra("next story", 0);

        /* show the data which received from 1st activity **/
        textView.setText(dStory[position]);

        /* creating a OnClickListener for making copy button dynamic or clickable**/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* code for copying data **/
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                /* use dStory variable means the specific position form string array**/
                ClipData clip = ClipData.newPlainText("Text", dStory[position]);
                clipboard.setPrimaryClip(clip);

                /* display message to ensure the data is copy successfully **/
                Toast.makeText(Main2Activity.this, "copied", Toast.LENGTH_SHORT).show();

            }//end of the onClick method

        });//end of the setOnClickListener

        /* creating a OnClickListener for making share button dynamic or clickable**/
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* code for share data **/
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                /* use dStory variable means the specific position form string array**/
                intent.putExtra(Intent.EXTRA_TEXT, dStory[position]);

                /* type of data which we want to share **/
                intent.setType("text/plain");
                /* choose the platform for share the text **/
                intent = Intent.createChooser(intent, "Share by");
                /* time to share data **/
                startActivity(intent);

            }//end of the onClick method

        });//end of the OnClickListener

        /* code for next button **/
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = (position + 1) % dStory.length;
                /* use dStory variable means the specific position form string array**/
                textView.setText(dStory[position]);

            }//end of the onClick method

        });//end of the setOnClickListener

        /* code for previous button **/
        previous_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = (position - 1) % dStory.length;
                /* use dStory variable means the specific position form string array**/
                textView.setText(dStory[position]);

            }//end of the onClick method

        });//end of the setOnClickListener

    }//end of the onCreate method

}//end of the class
