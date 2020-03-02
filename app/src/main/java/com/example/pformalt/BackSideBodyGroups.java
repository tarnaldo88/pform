package com.example.pformalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BackSideBodyGroups extends AppCompatActivity {

    private ImageButton BtnMoveBack;
    private ImageButton BtnRotateBody;
    private Button shoulder;
    private Button backBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_side_body_groups);


        BtnMoveBack = findViewById(R.id.backMainActivityBtn);
        BtnRotateBody = findViewById(R.id.RotateBtn);
        shoulder = findViewById(R.id.shoulderBtn);
        backBody = findViewById(R.id.backBodyPt);

        //listener to activate button upon click by user, goes to shoulder page
        shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                shoullderToWorkout();
            }
        });

        //listener to activate button upon click by user, goes to back page
        backBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                backToWorkout();
            }
        });

        //listener to activate button upon click by user, goes back to main page
        BtnMoveBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                moveToMainActivity();
            }
        });

        //listener to activate button upon click by user, goes back to main page
        BtnRotateBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                moveToFrontSideBody();
            }
        });
    }

    //function to move to workout lists page
    private void shoullderToWorkout(){
        Intent goToWorkout = new Intent(BackSideBodyGroups.this, workoutActivity.class);
        goToWorkout.putExtra("value", "shoulders");
        startActivity(goToWorkout);
    }

    private void backToWorkout(){
        Intent goToWorkout = new Intent(BackSideBodyGroups.this, workoutActivity.class);
        goToWorkout.putExtra("value", "back");
        startActivity(goToWorkout);
    }

    //function to move back to the main activity from the body groups page
    private void moveToMainActivity(){
        Intent goToMainActivity = new Intent(BackSideBodyGroups.this, MainActivity.class);
        startActivity(goToMainActivity);;
    }

    //function to move back to the main activity from the body groups page
    private void moveToFrontSideBody(){
        Intent goToFrontSide = new Intent(BackSideBodyGroups.this, BodyGroups.class);
        startActivity(goToFrontSide);;
    }
}
