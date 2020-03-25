package com.example.pformalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ExerciseActivity extends YouTubeBaseActivity { //AppCompatActivity,

        private ImageButton backToBodyGroups;
        Button button;
        private YouTubePlayerView youtubePlayerView;
        private YouTubePlayer.OnInitializedListener onInitializedListener;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_exercise);

            youtubePlayerView = findViewById(R.id.youtube_view);
            backToBodyGroups = findViewById(R.id.backMainActivityBtn);

            onInitializedListener = new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    youTubePlayer.loadVideo( "lXwm62SiLQ8"); //youtube video link

                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                }
            };

            button = findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    youtubePlayerView.initialize("AIzaSyC8GktotpkFtqSWHVUGQjXBg4UVHD52qf0", onInitializedListener); //API key
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

    private void moveToBody(){
        Intent goToBodyActivity = new Intent(ExerciseActivity.this, BodyGroups.class);
        startActivity(goToBodyActivity);
    }
}
