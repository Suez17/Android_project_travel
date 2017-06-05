package com.example.michael.android_project_travel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.IOException;

import bddRequest.BackgroundTask;
import tools.AlterteMessage;

public class CreationGroupeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation_groupe_activity);

        try {
            Spinner s = (Spinner) findViewById(R.id.destinationCombo);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, recupCountries());
            s.setAdapter(adapter);
        }
        catch(Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /*public void onClick(View v) throws Throwable {
        switch (v.getId()) {
            case R.id.destinationCombo:
                String[] arraySpinner;
                arraySpinner = new String[] {
                        "1", "2", "3", "4", "5"
                };
                Spinner s = (Spinner) findViewById(R.id.destinationCombo);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, arraySpinner);
                s.setAdapter(adapter);
                break;
        }
    }*/

    public String[] recupCountries() throws Throwable {
        String[] countries;
        String method = "recup_country";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method);
        String requestResult = backgroundTask.get().toString();
        countries = requestResult.split("_");
        return countries;
    }
}
