package com.example.michael.android_project_travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import bddRequest.BackgroundTask;
import tools.AlerteMessage;

public class RechercheGroupe extends AppCompatActivity {

    EditText getDateDebut, getDateFin, getNbVoyageurs;
    Spinner getDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_groupe);

        try {
            Spinner s = (Spinner) findViewById(R.id.paysList);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, recupCountries());
            s.setAdapter(adapter);
        }
        catch(Throwable e) {
            throw new RuntimeException(e);
        }

        getDestination = (Spinner) findViewById(R.id.paysList);
        getDateDebut = (EditText) findViewById(R.id.dateDebutText);
        getDateFin = (EditText) findViewById(R.id.dateFinText);
        getNbVoyageurs = (EditText) findViewById(R.id.nbParticipantsText);
    }

    public void onClick(View v) throws Throwable {
        Intent intent;

        switch (v.getId()) {
            case R.id.fetchButton :
                String destination = getDestination.getSelectedItem().toString();
                String dateDebut = getDateDebut.getText().toString();
                String dateFin = getDateFin.getText().toString();
                String nbVoyageurs = getNbVoyageurs.getText().toString();

                String method = "search_group";
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute(method, destination, dateDebut, dateFin, nbVoyageurs);

                String requestResult = backgroundTask.get().toString();

                if (!requestResult.equals("0")) {
                    intent = new Intent(this, SearchResultActivity.class);
                    intent.putExtra("groupsInfo", requestResult);
                    startActivity(intent);
                    finish();
                }
                else {
                    new AlerteMessage(this, "Aucun groupe ne correspond à votre recherche");
                }
                break;

            case R.id.backButton :
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
