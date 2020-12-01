/**
 * This class loads the Liberty Science Center information into the tickets.xml file
 * @author Christopher Clemente, Nick Rytelewski
 */

package com.example.pa5;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LibertyScienceCenter extends AppCompatActivity {

    //XML Elements
    private Button ticketPrices;
    private TextView ticketCost;
    private TextView taxCost;
    private TextView totalCost;
    private TextView seniorText;
    private TextView studentText;
    private TextView adultText;
    private TextView name;
    private ImageButton MuseumPicture;
    private ImageButton backButton;
    private Spinner spinnerSenior;
    private Spinner spinnerStudent;
    private Spinner spinnerAdult;

    //Class Variables
    private int SENIOR_PRICE = 14;
    private int STUDENT_PRICE = 11;
    private int ADULT_PRICE = 15;
    private double TAX_AMOUNT = 0.06625;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set Viewer's XML To 'tickets.xml' and assign items on screen to items defined in class
        setContentView(R.layout.tickets);
        MuseumPicture = findViewById(R.id.museumImage);
        MuseumPicture.setImageResource((R.drawable.liberty_science_center));
        name = findViewById(R.id.museumName);
        name.setText(getResources().getText(R.string.museum_four));
        ticketPrices = findViewById(R.id.calculateButton);
        seniorText = findViewById(R.id.seniorText);
        studentText = findViewById(R.id.studentText);
        adultText = findViewById(R.id.adultText);
        seniorText.setText(getResources().getText(R.string.LSC_senior));
        studentText.setText(getResources().getText(R.string.LSC_student));
        adultText.setText(getResources().getText(R.string.LSC_adult));
        backButton = findViewById(R.id.backButton);
        ticketCost = findViewById(R.id.price_amount);
        taxCost = findViewById(R.id.tax_amount);
        totalCost = findViewById(R.id.total_amount);

        //Set Contents For Each Spinner
        spinnerSenior = (Spinner) findViewById(R.id.seniorSpinner);
        spinnerStudent = (Spinner) findViewById(R.id.studentSpinner);
        spinnerAdult = (Spinner) findViewById(R.id.adultSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tickets_selected, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSenior.setAdapter(adapter);
        spinnerStudent.setAdapter(adapter);
        spinnerAdult.setAdapter(adapter);

        //Toast Text To State Maximum Ticket Amount Per Age Category
        Toast.makeText(LibertyScienceCenter.this, "Maximum Of 5 Tickets For Each!", Toast.LENGTH_SHORT).show();

        //ON CLICK -> MUSEUM IMAGE SWITCHES SCENES TO MUSEUM WEBSITE
        MuseumPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a new intent to load a new chrome app window
                //Pass the selected museum text so that the website link can be loaded
                String urlString = (String) getResources().getText(R.string.url_lsc);
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
                browser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                browser.setPackage("com.android.chrome");
                try {
                    startActivity(browser);
                }
                catch (ActivityNotFoundException ex) {
                    // Chrome browser may not installed ---> Allow user to choose instead
                    browser.setPackage(null);
                    startActivity(browser);
                }
            }
        });

        //ON CLICK -> BACK BUTTON RETURNS TO ORIGINAL SCREEN
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pop Scene Off Stack
                finish();
            }
        });

        //ON CLICK -> CALCULATE TICKET PRICES AND UPDATE FIELDS
        ticketPrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                //Calculate Prices
                int price = (SENIOR_PRICE * Integer.parseInt(spinnerSenior.getSelectedItem().toString()));
                price += (STUDENT_PRICE * Integer.parseInt(spinnerStudent.getSelectedItem().toString()));
                price += (ADULT_PRICE * Integer.parseInt(spinnerAdult.getSelectedItem().toString()));

                Double tax = price * TAX_AMOUNT;
                ticketCost.setText("$" + price);
                taxCost.setText("$" + String.format("%.2f", tax));
                totalCost.setText("$" + String.format("%.2f", price + tax));
            }
        });
    }
}