package com.example.homework5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Global objects
    EditText usernameET;
    ListView zodiacLV;

    //Use an Array List
    //Declaring the ArrayList
    ArrayList<String> yearofBirthAL;


    String characteristics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Define the objects and ArrayList
        usernameET = (EditText) findViewById(R.id.nameET);
        zodiacLV = (ListView) findViewById(R.id.yearsLV);
        yearofBirthAL = new ArrayList<String>();


        try {
            InputStreamReader isr = new InputStreamReader(getAssets().open("years.csv"));

            //second create a BufferedReader object
            BufferedReader reader = new BufferedReader(isr);

            //Strings that hold one line of the file at a time and the year of birth
            //from the line was read
            String fileLine, yob;

            ///loop through the csv file reading one line at a time
            while ((fileLine = reader.readLine()) != null) {

                //lets take this fileLine that was read and split it (break it)
                //by "comma" and get first element of the resulting array
                //and that will be the yob
                yob = fileLine.split(",")[0];

                //now let's populate the ArrayList with the yob value
                yearofBirthAL.add(yob);
            }

            //now we can create an ArrayAdapter object to the ListView
            ArrayAdapter<String> yearAA = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, yearofBirthAL);

            //we now set this ArrayAdapter to the ListView
            zodiacLV.setAdapter(yearAA);


            //setting up listener to LV
            zodiacLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    String zodiacString = (zodiacLV.getItemAtPosition(position).toString());


                    int zodiacInt = Integer.parseInt(zodiacString);

                    int zodiacIntTotal = (zodiacInt - 4) % 12;

                    if (zodiacIntTotal == 0) {

                        zodiacString = "Rat";
                        characteristics = "confident, vindictive";

                    } else if (zodiacIntTotal == 1) {


                        zodiacString = "Ox";
                        characteristics = "modest, critical";

                    } else if (zodiacIntTotal == 2) {


                        zodiacString = "Tiger";
                        characteristics = "stubborn, independent";

                    } else if (zodiacIntTotal == 3) {


                        zodiacString = "Rabbit";
                        characteristics = "naive, love-making";

                    } else if (zodiacIntTotal == 4) {


                        zodiacString = "Dragon";
                        characteristics = "authoritative, power-hungry";

                    } else if (zodiacIntTotal == 5) {


                        zodiacString = "Snake";
                        characteristics = "patient, narrow-minded";

                    } else if (zodiacIntTotal == 6) {


                        zodiacString = "Horse";
                        characteristics = "productive, hot-headed";

                    } else if (zodiacIntTotal == 7) {


                        zodiacString = "Goat";
                        characteristics = "prudent, calm";

                    } else if (zodiacIntTotal == 8) {


                        zodiacString = "Monkey";
                        characteristics = "intelligent, manipulator";

                    } else if (zodiacIntTotal == 9) {


                        zodiacString = "Rooster";
                        characteristics = "vain, hard-working";

                    } else if (zodiacIntTotal == 10) {


                        zodiacString = "Dog";
                        characteristics = "loyal, protective";

                    } else if (zodiacIntTotal == 11) {


                        zodiacString = "Pig";
                        characteristics = "sensible, intuitive";

                    }


                    //create an Intent and attach the vars
                    Intent gotoScreen2 = new Intent(MainActivity.this, Main2Activity.class);

                    gotoScreen2.putExtra("nameKey", usernameET.getText().toString());
                    gotoScreen2.putExtra("zodiacKey", zodiacString);
                    gotoScreen2.putExtra("characteristicsKey", characteristics);

                    startActivity(gotoScreen2);


                }
            });


        } catch (Exception e) {}


    }
}
