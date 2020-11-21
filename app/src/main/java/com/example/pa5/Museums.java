package com.example.pa5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Museums extends AppCompatActivity {

    private Button museumButtonOne;
    private Button museumButtonTwo;
    private Button museumButtonThree;
    private Button museumButtonFour;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.museums);

        //Set Buttons To Correct ID
        museumButtonOne = findViewById(R.id.museumButtonOne);
        museumButtonTwo = findViewById(R.id.museumButtonTwo);
        museumButtonThree = findViewById(R.id.museumButtonThree);
        museumButtonFour = findViewById(R.id.museumButtonFour);

        museumButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("1");

                startActivity(new Intent(Museums.this, NJStateMuseum.class));

            }
        });

        museumButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("2");
            }
        });

        museumButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("3");
            }
        });

        museumButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("4");
            }
        });





    }

}
