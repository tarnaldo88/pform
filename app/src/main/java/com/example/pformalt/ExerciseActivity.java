package com.example.pformalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ExerciseActivity extends AppCompatActivity {

    private ImageButton backToBodyGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        backToBodyGroups = findViewById(R.id.backMainActivityBtn);

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
