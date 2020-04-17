package com.example.pformalt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class Routines extends AppCompatActivity {

    private ImageButton BtnMoveBack;
    private ImageButton BtnRotateBody;
    private ImageButton rotateToFront;
    private ImageButton clearBtn;
    private ImageButton generate;
    private Button chest;
    private Button legs;
    private Button arms;
    private Button shoulder;
    private Button backPart;
    private ImageView chestSelected;
    private ImageView armSelected;
    private ImageView legSelected;
    private ImageView backSelect;
    private ImageView shoulderSelected;
    private ImageView bg;
    private ArrayList<String> selectedParts = new ArrayList<String>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routines);

        bg = findViewById(R.id.background);
        clearBtn = findViewById(R.id.clear);
        BtnMoveBack = findViewById(R.id.backMainActivityBtn);
        BtnRotateBody = findViewById(R.id.RotateBtn);
        rotateToFront = findViewById(R.id.rotateFromBack);
        chest = findViewById(R.id.chestBtn);
        legs = findViewById(R.id.legBtn);
        arms = findViewById(R.id.armBtn);
        shoulder = findViewById(R.id.shoulderBtn);
        backPart = findViewById(R.id.backBodyPt);
        generate = findViewById(R.id.generateBtn);

        //Image views that pop up when user selects a body part
        chestSelected =(ImageView) findViewById(R.id.chestSelected);
        armSelected =(ImageView) findViewById(R.id.armSelected);
        legSelected =(ImageView) findViewById(R.id.legSelected);
        backSelect =(ImageView) findViewById(R.id.backSelected);
        shoulderSelected =(ImageView) findViewById(R.id.shoulderSelected);

        //selectedParts = new ArrayList<String>();

        //listener to activate button upon click by user, selects chest
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //button activity goes in here, check that user has not already selected area
                if(!selectedParts.isEmpty()) {
                    goToGenerator();
                }
            }
        });

        //listener to activate button upon click by user, selects chest
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //button activity goes in here, check that user has not already selected area
                if(!selectedParts.contains("chest")) {
                    selectedParts.add("chest");
                }
                chestSelected.setVisibility(View.VISIBLE);
            }
        });

        //listener to activate button upon click by user, selects arms
        arms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //button activity goes in here, check that user has not already selected area
                if(!selectedParts.contains("arms")) {
                    selectedParts.add("arms");
                }
                armSelected.setVisibility(View.VISIBLE);
            }
        });

        //listener to activate button upon click by user, selects legs
        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //button activity goes in here
                if(!selectedParts.contains("legs")) {
                    selectedParts.add("legs");
                }
                legSelected.setVisibility(View.VISIBLE);
            }
        });

        //listener to activate button upon click by user, selects chest
        shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //button activity goes in here, check that user has not already selected area
                if(!selectedParts.contains("shoulder")) {
                    selectedParts.add("shoulder");
                }
                shoulderSelected.setVisibility(View.VISIBLE);
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
                backSelect.setVisibility(View.VISIBLE);
            }
        });

        //listener to activate button upon click by user, goes back to main page
        BtnMoveBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                moveToMainActivity();
            }
        });

        //listener to activate button upon click by user, turns body around
        BtnRotateBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                moveToBackSideBody();
            }
        });

        //listener to activate button upon click by user, turns body around
        rotateToFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                moveToFrontSideBody();
            }
        });

        //listener to activate button upon click by user, clears list
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                clearAll(selectedParts);
            }
        });
    }

    //function to move back to the main activity from the body groups page
    private void moveToMainActivity(){
        Intent goToMainActivity = new Intent(Routines.this, MainActivity.class);
        startActivity(goToMainActivity);
    }

    private void goToGenerator(){
        Intent goToGen = new Intent(Routines.this, Generator.class);
        goToGen.putStringArrayListExtra("selected", selectedParts);
        if(!selectedParts.isEmpty()) {
            startActivity(goToGen);
        }
    }


    private void clearAll(ArrayList x){
        x.clear();
        shoulderSelected.setVisibility(View.INVISIBLE);
        legSelected.setVisibility(View.INVISIBLE);
        armSelected.setVisibility(View.INVISIBLE);
        chestSelected.setVisibility(View.INVISIBLE);
        backSelect.setVisibility(View.INVISIBLE);
    }

    //function to move to Routines Activity back view
    private void moveToBackSideBody(){
        //change chest arm and leg button invisible
        legs.setVisibility(View.GONE);
        chest.setVisibility(View.GONE);
        arms.setVisibility(View.GONE);
        shoulder.setVisibility(View.VISIBLE);
        backPart.setVisibility(View.VISIBLE);
        rotateToFront.setVisibility(View.VISIBLE);
        BtnRotateBody.setVisibility(View.GONE);
        bg.setImageDrawable(ContextCompat.getDrawable(Routines.this, R.drawable.routine_back));
    }

    //function to rotate back to front facing body
    private void moveToFrontSideBody(){
        legs.setVisibility(View.VISIBLE);
        chest.setVisibility(View.VISIBLE);
        arms.setVisibility(View.VISIBLE);
        shoulder.setVisibility(View.GONE);
        backPart.setVisibility(View.GONE);
        BtnRotateBody.setVisibility(View.VISIBLE);
        rotateToFront.setVisibility(View.GONE);
        bg.setImageDrawable(ContextCompat.getDrawable(Routines.this, R.drawable.bg_routines));
    }
}
