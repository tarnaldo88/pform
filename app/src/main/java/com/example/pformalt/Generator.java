package com.example.pformalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator extends AppCompatActivity {

    private ImageButton BtnMoveBack;
    private ImageView chestView;
    private Intent intent;
    private ArrayList<String> selectedParts;
    private ListView listview;
    private String[] selectedArray = {"", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);
        selectedParts = getIntent().getStringArrayListExtra("selected");
        readWorkoutData();
        ArrayList<String> printableNames = whichID(selectedParts);

        for (int i = 0; i < printableNames.size(); i++){
            selectedArray[i] = printableNames.get(i);
        }
        for (int i = 0; i < 5; i++) {
            Log.d("myTag", "\n" + selectedArray[i]);
        }

        listview = (ListView) findViewById(R.id.listview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,selectedArray); //used to be printable names

        BtnMoveBack = findViewById(R.id.backMainActivityBtn);
        chestView = findViewById(R.id.chest);

        BtnMoveBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                moveToMainActivity();
            }
        });

        /*if(!selectedParts.isEmpty() && selectedParts.contains("chest")){
            chestView.setVisibility(View.VISIBLE);
        }*/
    }

    private List<workoutSample> workoutSamples = new ArrayList<>();
    private void readWorkoutData() {
        InputStream is = getResources().openRawResource(R.raw.workoutdata);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";

        try {
            //using this to step over the headers
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                //split by ,
                String[] tokens = line.split(",");

                //read the data
                workoutSample sample = new workoutSample();
                sample.setId(Integer.parseInt(tokens[0]));
                sample.setWName(tokens[1]);
                sample.setYTLink(tokens[2]);
                sample.setDescription(tokens[3]);
                workoutSamples.add(sample);
            }
        } catch (IOException e) {
            Log.wtf("ExerciseActivity", "Error reading csv file on line " + line, e);
            e.printStackTrace();
        }
    }

    private ArrayList<String> whichID(ArrayList<String> selectedParts) {
        int[] generated = {-1,-1,-1,-1,-1,-1};
        ArrayList<String> namesGenerated = new ArrayList<>();
        Random rand = new Random();
        int arms = 0, legs = 4, back = 9, chest = 12, shoulders = 17;
        for (int i = 0; i < selectedParts.size() - 1; i++){
            if (selectedParts.get(i).compareTo("arms") == 0) {
                generated[0] = rand.nextInt(((legs-1) - arms) + 1) + arms;
                namesGenerated.add(workoutSamples.get(generated[0] - 1).getWName());
            }
            else if (selectedParts.get(i).compareTo("legs") == 0) {
                generated[1] = rand.nextInt(((back-1) - legs) + 1) + legs;
                namesGenerated.add(workoutSamples.get(generated[1] - 1).getWName());
            }
            else if (selectedParts.get(i).compareTo("back") == 0) {
                generated[2] = rand.nextInt(((chest-1) - back) + 1) + back;
                namesGenerated.add(workoutSamples.get(generated[2] - 1).getWName());
            }
            else if (selectedParts.get(i).compareTo("chest") == 0) {
                generated[3] = rand.nextInt(((shoulders-1) - chest) + 1) + chest;
                namesGenerated.add(workoutSamples.get(generated[3] - 1).getWName());
            }
            else if (selectedParts.get(i).compareTo("shoulders") == 0) {
                generated[4] = rand.nextInt((20 - shoulders) + 1) + shoulders;
                namesGenerated.add(workoutSamples.get(generated[4] - 1).getWName());
            }
        }
        return namesGenerated;
    }

    //function to move back to previous activity
    private void moveToMainActivity(){
        Intent goToMainActivity = new Intent(Generator.this, Routines.class);
        startActivity(goToMainActivity);
    }
}
