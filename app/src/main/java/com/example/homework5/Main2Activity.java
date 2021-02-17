package com.example.homework5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //defining the objects (ImageView, TextView)
        EditText n = (EditText) findViewById(R.id.name);
        EditText zs = (EditText) findViewById(R.id.zSign);
        EditText c = (EditText) findViewById(R.id.Characteristic);

        //creating an intent to get the passing variables
        Intent getVars = getIntent();

        //now we can get the variables (name,index)
        String name = getVars.getExtras().getString("nameKey");
        String zodiac = getVars.getExtras().getString("zodiacKey");
        String characteristics = getVars.getExtras().getString("characteristicsKey");


        //placing the corresponding image in the imageView presPhotoTV

        n.setText(name);
        zs.setText(zodiac);
        c.setText(characteristics);





    }
}
