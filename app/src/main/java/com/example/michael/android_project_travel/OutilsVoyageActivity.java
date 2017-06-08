package com.example.michael.android_project_travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import bddRequest.BackgroundTask;
import tools.AlerteMessage;

public class OutilsVoyageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outils_voyage);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        ImageButton deviseButton = (ImageButton) findViewById(R.id.deviseButton);
        ImageButton vacButton = (ImageButton) findViewById(R.id.vaccinButton);

        deviseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(OutilsVoyageActivity.this, DeviseActivity.class);
                startActivity(intent);
                finish();
            }

        });

        Button boutonRetour = (Button) findViewById(R.id.backButton);

        boutonRetour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OutilsVoyageActivity.this, AccueilActivity.class);
                startActivity(intent);
                finish();
            }
        });

        vacButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(OutilsVoyageActivity.this, VaccinsActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }
}
