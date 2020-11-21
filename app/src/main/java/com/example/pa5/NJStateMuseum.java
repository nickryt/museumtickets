package com.example.pa5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NJStateMuseum extends AppCompatActivity {

    private int SENIOR_PRICE = 17;
    private int STUDENT_PRICE = 12;
    private int ADULT_PRICE = 25;

    private ImageView MuseumPicture;
    private TextView name;
    private Button ticketPrices;
    private TextView ticketCost;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tickets);

        MuseumPicture = findViewById(R.id.museumImage);
        MuseumPicture.setImageResource((R.drawable.new_jersey_state_museum));

        name = findViewById(R.id.museumName);
        name.setText(getResources().getText(R.string.museum_one));

        Spinner spinner = (Spinner) findViewById(R.id.seniorSpinner);
        Spinner spinnerStudent = (Spinner) findViewById(R.id.studentSpinner);
        Spinner spinnerAdult = (Spinner) findViewById(R.id.adultSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tickets_selected, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinnerStudent.setAdapter(adapter);
        spinnerAdult.setAdapter(adapter);

        ticketPrices = findViewById(R.id.calculateButton);

        ticketPrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double price = (SENIOR_PRICE * Double.parseDouble(spinner.getSelectedItem().toString()));
                price +=  (STUDENT_PRICE * Double.parseDouble(spinnerStudent.getSelectedItem().toString()));
                price += (ADULT_PRICE * Double.parseDouble(spinnerAdult.getSelectedItem().toString()));

                ticketCost = findViewById(R.id.price_amount);
                ticketCost.setText(price.toString());
            }
        });


    }
}
