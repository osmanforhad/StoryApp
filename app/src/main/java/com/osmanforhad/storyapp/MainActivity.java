package com.osmanforhad.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    /* variable declaration **/
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* initial the xml ui **/
        listView = findViewById(R.id.list);

        /* initial the story Title form strings xml file**/
        String[] tStory = getResources().getStringArray(R.array.title_story);

        /* initial the story Details form strings xml file**/
        final String[] dStory = getResources().getStringArray(R.array.details_story);

        /* making array Adapter for displaying Story Title listView**/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tStory);

        /* setup Adapter into the listView **/
        listView.setAdapter(adapter);

        /* making a OnItemClickListener into listView**/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /* passing position for open Details after clicking the title**/
               String Story_Details = dStory[position];

               /* after clicking the title going to next activity **/
                Intent intent = new Intent(MainActivity.this, Main2Activity.clss);

                /* sending data into second activity **/
                intent.putExtra("story",Story_Details);

                /* open the 2nd activity **/
                startActivity(intent);

            }//end of the onItemClick method

        });//end of the setOnItemClickListener


    }//end of the onCreate method

}//end of the class
