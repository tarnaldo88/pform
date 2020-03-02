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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        area = findViewById(R.id.workoutImg);
        BtnMoveBack = findViewById(R.id.backMainActivityBtn);

        Intent intent = getIntent();
        String select = intent.getStringExtra("value");
        //int eq = select.compareTo("legs");
        //if statements determining which body group was selected
        if (select.compareTo("legs") == 0){
            area.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.legs));
        } else if(select.compareTo("arms") == 0){
            area.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.body_arms));
        } else if (select.compareTo("chest") == 0) {
            area.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.chest));
        } else if (select.compareTo("shoulders") == 0){
            area.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.shoulder));
        } else if (select.compareTo("back") == 0){
            area.setImageDrawable(ContextCompat.getDrawable(workoutActivity.this, R.drawable.body_back));
        }

        //listener to activate button upon click by user, goes back to main page
        BtnMoveBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                moveToMainActivity();
            }
        });
    }

    //function to move back to the main activity from the body groups page
    private void moveToMainActivity(){
        Intent goToMainActivity = new Intent(workoutActivity.this, BodyGroups.class);
        startActivity(goToMainActivity);;
    }
}