package com.example.pa5;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NJStateMuseum extends AppCompatActivity {

    private ImageView MuseumPicture;
    private TextView name;

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

    }




}
