package com.example.pformalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class Generator extends AppCompatActivity {

    private ImageButton BtnMoveBack;
    private ImageView chestView;
    private Intent intent;
    private ArrayList<String> selectedParts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        BtnMoveBack = findViewById(R.id.backMainActivityBtn);
        chestView = findViewById(R.id.chest);
       // System.out.println("\n\n\n\n IT GOT TO HERER \n\n\n\n");

        selectedParts = getIntent().getStringArrayListExtra("selected");
       // System.out.println("\n\n\n\n IT GOT TO HERER \n\n\n\n");

        BtnMoveBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                moveToMainActivity();
            }
        });

        if(!selectedParts.isEmpty() && selectedParts.contains("chest")){
            chestView.setVisibility(View.VISIBLE);
        }
    }

    //function to move back to previous activity
    private void moveToMainActivity(){
        Intent goToMainActivity = new Intent(Generator.this, Routines.class);
        startActivity(goToMainActivity);
    }
}
