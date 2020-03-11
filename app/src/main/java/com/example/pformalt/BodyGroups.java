package com.example.pformalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class BodyGroups extends AppCompatActivity {

    private ImageButton BtnMoveBack;
    private ImageButton BtnRotateBody;
    private Button armBtn;
    private Button chestBtn;
    private Button legs;
    static private int selected;
    // Bundle bundleParts = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_groups);
        View decorView = getWindow().getDecorView();

        BtnMoveBack = findViewById(R.id.backMainActivityBtn);
        BtnRotateBody = findViewById(R.id.RotateBtn);
        armBtn = findViewById(R.id.armBtn);
        chestBtn = findViewById(R.id.chestBtn);
        legs = findViewById(R.id.legBtn);

        //listener to activate button upon click by user, goes back to main page
        BtnMoveBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                moveToMainActivity();
            }
        });

        //listener to activate button upon click by user, goes to back view page
        BtnRotateBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                moveToBackSideBody();
            }
        });

        //listeners to move to workout page
        armBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                armsToWorkout();
            }
        });

        chestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                chestToWorkout();
            }
        });

        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                legsToWorkout();
            }
        });
    }

    private int getSelect(){
        return selected;
    }
    private void setSelect(int x) { selected = x;}



    private void legsToWorkout(){
        Intent goToWorkout = new Intent(BodyGroups.this, workoutActivity.class);
        goToWorkout.putExtra("value", "legs");
        startActivity(goToWorkout);
    }

    private void armsToWorkout(){
        Intent goToWorkout = new Intent(BodyGroups.this, workoutActivity.class);
        goToWorkout.putExtra("value", "arms");
        startActivity(goToWorkout);
    }

    private void chestToWorkout(){
        Intent goToWorkout = new Intent(BodyGroups.this, workoutActivity.class);
        goToWorkout.putExtra("value", "chest");
        startActivity(goToWorkout);
    }

    //function to move back to the main activity from the body groups page
    private void moveToMainActivity(){
        Intent goToMainActivity = new Intent(BodyGroups.this, MainActivity.class);
        startActivity(goToMainActivity);;
    }

    //function to move back to the main activity from the body groups page
    private void moveToBackSideBody(){
        Intent goToBackSide = new Intent(BodyGroups.this, BackSideBodyGroups.class);
        startActivity(goToBackSide);;
    }
}
