package com.example.pformalt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class workoutActivity extends AppCompatActivity {

    private ImageButton BtnMoveBack;
    private ImageView area;
    private ImageButton firstBtn;
    private ImageButton secondBtn;
    private ImageButton thirdBtn;
    private ImageButton fourthBtn;
    private ImageButton fifthBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        area = findViewById(R.id.workoutImg);
        BtnMoveBack = findViewById(R.id.backMainActivityBtn);
        firstBtn = findViewById(R.id.oneWork);
        secondBtn = findViewById(R.id.twoWork);
        thirdBtn = findViewById(R.id.thirdWork);
        fourthBtn = findViewById(R.id.fourthWork);
        fifthBtn = findViewById(R.id.fifthWork);

        String select = getIntent().getStringExtra("value");

        //if statements determining which body group was selected
        if (select.compareTo("legs") == 0){
            legWorkouts();
        } else if(select.compareTo("arms") == 0){
            armWorkout();
        } else if (select.compareTo("chest") == 0) {
            chestWorkout();
        } else if (select.compareTo("shoulders") == 0){
            shoulderWorkout();
        } else if (select.compareTo("back") == 0){
            backWorkout();
        }
        //listener to activate button upon click by user, goes back to main page
        BtnMoveBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                moveToMainActivity();
            }
        });

        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                goToExercise();
            }
        });
        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                goToExercise();
            }
        });
        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                goToExercise();
            }
        });
        fourthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                goToExercise();
            }
        });
        fifthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                goToExercise();
            }
        });
    }

    private void goToExercise(){
        Intent goToEx = new Intent(workoutActivity.this, ExerciseActivity.class);
        startActivity(goToEx);
    }


    private void legWorkouts(){
        //sets the title
        area.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.legs));
        //sets the buttons
        firstBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.exercise_legs_squat));
        secondBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.exercise_legs_sumo));
        thirdBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.exercise_legs_lunge));
        fourthBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.exercise_legs_reverselunge));
        fifthBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.exercise_legs_curtsylunge));
    }

    private void armWorkout(){
        area.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.body_arms));

        firstBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.curl));
        secondBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.hammercurl));
        thirdBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.skullcrusher));
        fifthBtn.setVisibility(View.INVISIBLE);
        fourthBtn.setVisibility(View.INVISIBLE);
        // fourthBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.exercise_legs_reverselunge));
        // fifthBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.exercise_legs_curtsylunge));
    }

    private void chestWorkout(){
        area.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.chest));

        firstBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.chest_press));
        secondBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.declinechest));
        thirdBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.inc_chestpress));
        fourthBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.fly));
        fifthBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.inclinefly));
    }

    private void shoulderWorkout(){
        area.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.shoulder));

        firstBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.reversefly));
        secondBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.altfrontraise));
        thirdBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.shouldpress));
        fourthBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.uprightrow));
        fifthBtn.setVisibility(View.INVISIBLE);
    }

    private void backWorkout(){
        area.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.body_back));

        firstBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.deadlift));
        secondBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.reversefly));
        thirdBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.revrow));
        fifthBtn.setVisibility(View.INVISIBLE);
        fourthBtn.setVisibility(View.INVISIBLE);
       // fourthBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.exercise_legs_reverselunge));
       // fifthBtn.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.exercise_legs_curtsylunge));
    }

    //function to move back to the main activity from the body groups page
    private void moveToMainActivity(){
        Intent goToMainActivity = new Intent(workoutActivity.this, BodyGroups.class);
        startActivity(goToMainActivity);;
    }
}