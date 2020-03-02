package com.example.pformalt;

import androidx.appcompat.app.AppCompatActivity;

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
    private Button chest;
    private Button legs;
    private Button arms;
    private ImageView chestSelected;
    private ImageView armSelected;
    private ImageView legSelected;

    ArrayList<String> selectedParts;
    //ArrayList<String> selectedParts = bundleParts.getStringArrayList("list");

    /*
    To do:
    Make an array that stores the values of which body part is selected
    use bundle to move array back and forth between activities as user selects parts
    utilize a method that at start of activity displays the values of array that have been accessed
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routines);
        //list to store what areas user selects

        Bundle bundleParts = new Bundle();

        BtnMoveBack = findViewById(R.id.backMainActivityBtn);
        BtnRotateBody = findViewById(R.id.RotateBtn);
        chest = findViewById(R.id.chestBtn);
        legs = findViewById(R.id.legBtn);
        arms = findViewById(R.id.armBtn);


        //Image views that pop up when user selects a body part
        chestSelected =(ImageView) findViewById(R.id.chestSelected);
        armSelected =(ImageView) findViewById(R.id.armSelected);
        legSelected =(ImageView) findViewById(R.id.legSelected);

        selectedParts = new ArrayList<String>();
        selectedParts.add("test");


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
                moveToBackSideBody();
            }
        });
    }

    //function to move back to the main activity from the body groups page
    private void moveToMainActivity(){
        Intent goToMainActivity = new Intent(Routines.this, MainActivity.class);
        startActivity(goToMainActivity);;
    }

    //function to move to Routines Activity back view
    private void moveToBackSideBody(){
        Intent goToBackSide = new Intent(Routines.this, RoutinesBackSide.class);

        startActivity(goToBackSide);
    }
}
