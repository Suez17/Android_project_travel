package com.example.michael.android_project_travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import bddRequest.BackgroundTask;

public class CreationGroupeActivity extends AppCompatActivity {

    EditText getNomGroupe, getDateDebut, getDateFin, getNbVoyageurs;
    Spinner getDestination;

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

        getNomGroupe = (EditText) findViewById(R.id.nomGroupeText);
        getDestination = (Spinner) findViewById(R.id.destinationCombo);
        getDateDebut = (EditText) findViewById(R.id.dateDebut);
        getDateFin = (EditText) findViewById(R.id.dateFin);
        getNbVoyageurs = (EditText) findViewById(R.id.nbVoyageurText);
    }

    public void onClick(View v) throws Throwable {
        Intent intent;

        switch (v.getId()) {
            case R.id.creerGroupeButton :
                String nomGroupe = getNomGroupe.getText().toString();
                String destination = getDestination.getSelectedItem().toString();
                String dateDebut = getDateDebut.getText().toString();
                String dateFin = getDateFin.getText().toString();
                String nbVoyageurs = getNbVoyageurs.getText().toString();

                String method = "create_group";
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute(method, nomGroupe, destination, dateDebut, dateFin, nbVoyageurs);

                intent = new Intent(this, MesGroupesActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.retourButton :
                intent = new Intent(this, MesGroupesActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

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
