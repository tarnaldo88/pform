package com.example.pformalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class RoutinesBackSide extends AppCompatActivity {

   // Bundle bundleParts = getIntent().getExtras();
    ArrayList<String> selectedParts;//= bundleParts.getStringArrayList("list");
    private ImageButton BtnMoveBack;
    private ImageButton BtnRotateBody;
    private Button shoulder;
    private Button backPart;
    private ImageView backSelected;
    private ImageView shoulderSelected;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routines_back_side);

        BtnMoveBack = findViewById(R.id.backMainActivityBtn);
        BtnRotateBody = findViewById(R.id.RotateBtn);
        shoulder = findViewById(R.id.shoulderBtn);
        backPart = findViewById(R.id.backBodyPt);

        //image views that become visible when user selects body part
        backSelected =(ImageView) findViewById(R.id.backSelected);
        shoulderSelected =(ImageView) findViewById(R.id.shoulderSelected);

        //listener to activate button upon click by user, selects chest
        shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //button activity goes in here, check that user has not already selected area
                if(!selectedParts.contains("shoulder")) {
                    selectedParts.add("shoulder");
                }
                backSelected.setVisibility(View.VISIBLE);
            }
        });

        //listener to activate button upon click by user, selects arms
        backPart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //button activity goes in here, check that user has not already selected area
                if(!selectedParts.contains("back")) {
                    selectedParts.add("back");
                }
                shoulderSelected.setVisibility(View.VISIBLE);
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

    //function to move back to the main activity from the body groups page
    private void moveToMainActivity(){
        Intent goToMainActivity = new Intent(RoutinesBackSide.this, MainActivity.class);
        startActivity(goToMainActivity);;
    }

    //function to move to Routines Activity back view
    private void moveToFrontSideBody(){
        Intent goToFrontSide = new Intent(RoutinesBackSide.this, Routines.class);
        //bundleParts.putStringArrayList("list", selectedParts);
        //goToFrontSide.putExtras(bundleParts);
        startActivity(goToFrontSide);
    }
}
