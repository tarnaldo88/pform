package com.example.pformalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton BtnMoveBodyG, BtnMoveRoutine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnMoveBodyG = findViewById(R.id.ExercisesBtn);
        BtnMoveRoutine = findViewById(R.id.routineBtn);

        BtnMoveBodyG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                moveToActivityBodyGroup();
            }
        });

        BtnMoveRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
              moveToActivityRoutines();
            }
        });
    }

   //method to move the screen to the Body Group page
    private void moveToActivityBodyGroup(){
        Intent goToBodyG = new Intent(MainActivity.this, BodyGroups.class);

        startActivity(goToBodyG);;
    }
    //method to move to Routines page
    private void moveToActivityRoutines(){
        Intent goToRoutine = new Intent(MainActivity.this, Routines.class);

        startActivity(goToRoutine);;
    }

}
