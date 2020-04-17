package com.example.pformalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ExerciseActivity extends YouTubeBaseActivity { //I removed the extends AppCompatActivity idk if it was needed but I couldn't extend two at once

        private ImageButton backToBodyGroups;
        private ImageButton playBtn;
        private YouTubePlayerView youtubePlayerView;
        private YouTubePlayer.OnInitializedListener onInitializedListener;
        TextView textView;

        private String[] selectedParts = {"", ""};
        int id = -1;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_exercise);

        System.out.println("\n\n\n\n IT GOT TO HERER \n\n\n\n");

            textView = (TextView) findViewById(R.id.description);

            readWorkoutData();

            selectedParts = getIntent().getStringArrayExtra("workoutSelected"); // {arms, first}

            String description = "";

            id = whichID(selectedParts);


            description = "this is the id we got " + id;
            description = workoutSamples.get(id - 1).getDescription();




        textView.setText(description);
            textView.setMovementMethod(new ScrollingMovementMethod());

            youtubePlayerView = findViewById(R.id.youtube_view);
            backToBodyGroups = findViewById(R.id.backMainActivityBtn);
            playBtn = findViewById(R.id.playButton);

            //youtubePlayerView.initialize("AIzaSyC8GktotpkFtqSWHVUGQjXBg4UVHD52qf0", onCreate); //API key don't change this

            onInitializedListener = new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    youTubePlayer.loadVideo(workoutSamples.get(id - 1).getYTLink()); //youtube video link lXwm62SiLQ8 /searchYTL(workoutSamples, 0)
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    //if it fails to find video have it do something
                }
            };

        playBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    youtubePlayerView.initialize("AIzaSyC8GktotpkFtqSWHVUGQjXBg4UVHD52qf0", onInitializedListener); //API key don't change this
                }
            });
            //listener to activate button upon click by user, selects chest
            backToBodyGroups.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    moveToBody();
                }
            });
        }

    private int whichID(String[] selectedParts) {
        if (selectedParts[0].compareTo("arms") == 0) {
            if (selectedParts[1].compareTo("first") == 0){
                return 1; //curl
            } else if (selectedParts[1].compareTo("second") == 0){
                return 2; //hammer curl
            } else if (selectedParts[1].compareTo("third") == 0) {
                return 3; //skull crusher
            }
        }
        if (selectedParts[0].compareTo("legs") == 0) {
            if (selectedParts[1].compareTo("first") == 0){
                return 4; //squats
            } else if (selectedParts[1].compareTo("second") == 0){
                return 5; //sumo squats
            } else if (selectedParts[1].compareTo("third") == 0) {
                return 6; //lunge
            } else if (selectedParts[1].compareTo("fourth") == 0){
                return 7; //reverse lunge
            } else if (selectedParts[1].compareTo("fifth") == 0) {
                return 8; //curtsy lunge
            }
        }
        if (selectedParts[0].compareTo("back") == 0) {
            if (selectedParts[1].compareTo("first") == 0){
                return 9; //deadlift
            } else if (selectedParts[1].compareTo("second") == 0){
                return 10; //reverse fly
            } else if (selectedParts[1].compareTo("third") == 0) {
                return 11; //reverse row
            }
        }
        if (selectedParts[0].compareTo("chest") == 0) {
            if (selectedParts[1].compareTo("first") == 0) {
                return 12; //chest press
            } else if (selectedParts[1].compareTo("second") == 0) {
                return 13; //decline chest press
            } else if (selectedParts[1].compareTo("third") == 0) {
                return 14; //incline chest press
            } else if (selectedParts[1].compareTo("fourth") == 0) {
                return 15; //fly
            } else if (selectedParts[1].compareTo("fifth") == 0) {
                return 16; //incline fly
            }
        }
        if (selectedParts[0].compareTo("shoulders") == 0) {
            if (selectedParts[1].compareTo("first") == 0){
                return 17; //reverse fly
            } else if (selectedParts[1].compareTo("second") == 0){
                return 18; //alt front raise
            } else if (selectedParts[1].compareTo("third") == 0) {
                return 19; //shoulders press
            } else if (selectedParts[1].compareTo("fourth") == 0){
                return 20; //upright row
            }
        }
        return -1;//error
    }

    private void moveToBody(){
        Intent goToBodyActivity = new Intent(ExerciseActivity.this, BodyGroups.class);
        startActivity(goToBodyActivity);
    }

    private List<workoutSample> workoutSamples = new ArrayList<>();
    private void readWorkoutData() {
        //workoutSample sample;
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
    public static String searchYTL (List<workoutSample> workouts, int id) {
        for (int i = 0; i < workouts.size(); i++) {
            if (workouts.get(i).getId() == id) {
                return workouts.get(i).getYTLink();
            }
        }
        return ""; //no link found
    }
    public static String searchDesc (List<workoutSample> workouts, int id) {
        for (int i = 0; i < workouts.size(); i++) {
            if (workouts.get(i).getId() == id) {
                return workouts.get(i).getDescription();
            }
        }
        return "Description not found.";
    }

}

