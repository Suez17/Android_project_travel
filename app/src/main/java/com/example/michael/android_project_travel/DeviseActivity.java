package com.example.michael.android_project_travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import bddRequest.BackgroundTask;
import tools.AlerteMessage;

public class DeviseActivity extends AppCompatActivity {
    EditText getmontantText, getmontantConversionText;
    Spinner getdeviseListConv, getlistDeviseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devise);

        try {
            Spinner s = (Spinner) findViewById(R.id.deviseListConv);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, recupDevises());
            s.setAdapter(adapter);

            Spinner s1 = (Spinner) findViewById(R.id.listDeviseRef);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, recupDevises());
            s1.setAdapter(adapter1);
        }
        catch(Throwable e) {
            throw new RuntimeException(e);
        }

        getmontantText = (EditText) findViewById(R.id.montantText);
        getdeviseListConv = (Spinner) findViewById(R.id.deviseListConv);
        getmontantConversionText = (EditText) findViewById(R.id.montantConversionText);
        getlistDeviseRef = (Spinner) findViewById(R.id.listDeviseRef);


        Button convertButton = (Button) findViewById(R.id.conversion);

        convertButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                float montant1 = Float.valueOf(getmontantText.getText().toString());
                float tx1 = 0, tx2 = 0;

                String devise1name = getlistDeviseRef.getSelectedItem().toString();

                String devise2name = getdeviseListConv.getSelectedItem().toString();

                try {
                    tx1 = recupRateDevise(devise1name);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                try {
                    tx2 = recupRateDevise(devise2name);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }

                float x = montant1/tx1;
                float y = x * tx2;

                new AlerteMessage(DeviseActivity.this, Float.toString(y));
            }

        });

        Button boutonRetour = (Button) findViewById(R.id.backButton);

        boutonRetour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeviseActivity.this, OutilsVoyageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public String[] recupDevises() throws Throwable {
        String[] devises;
        String method = "recup_devises";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method);
        String requestResult = backgroundTask.get().toString();
        devises = requestResult.split("_");
        return devises;
    }


    public float recupRateDevise(String devise_name) throws Throwable {
        String[] rateDevis;
        String method = "recup_deviseRate";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, devise_name);
        String requestResult = backgroundTask.get().toString();
        rateDevis = requestResult.split("_");
        return Float.valueOf(rateDevis[0]);
    }
}
