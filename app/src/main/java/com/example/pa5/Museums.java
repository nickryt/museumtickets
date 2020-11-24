/**
 * This class contains buttons that the user can select to redirect them to a ticket calculator for the museum they selected.
 * @author Christopher Clemente, Nick Rytelewski
 */

package com.example.pa5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Museums extends AppCompatActivity {

    //XML Elements
    private Button museumButtonOne;
    private Button museumButtonTwo;
    private Button museumButtonThree;
    private Button museumButtonFour;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set Viewer's XML To 'museums.xml' and assign items on screen to items defined in class
        setContentView(R.layout.museums);
        museumButtonOne = findViewById(R.id.museumButtonOne);
        museumButtonTwo = findViewById(R.id.museumButtonTwo);
        museumButtonThree = findViewById(R.id.museumButtonThree);
        museumButtonFour = findViewById(R.id.museumButtonFour);

        //ON CLICK -> SCENE SWITCHES TO NEW JERSEY ART MUSEUM
        museumButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Museums.this, NJStateMuseum.class));
            }
        });

        //ON CLICK -> SCENE SWITCHES TO NEWARK MUSEUM OF ART
        museumButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Museums.this, NewarkMuseumOfArt.class));
            }
        });

        //ON CLICK -> SCENE SWITCHES TO MONTCLAIR ART MUSEUM
        museumButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Museums.this, MontclairArtMuseum.class));
            }
        });

        //ON CLICK -> SCENE SWITCHES TO LIBERTY SCIENCE CENTER
        museumButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Museums.this, LibertyScienceCenter.class));
            }
        });
    }
}
