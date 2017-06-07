package com.example.michael.android_project_travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import bddRequest.BackgroundTask;
import tools.AlerteMessage;

public class MesGroupesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_groupes);
    }

    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.ajouterGroupe :
                intent = new Intent(this, CreationGroupeActivity.class);
                intent.putExtra("idUser", getIntent().getStringExtra("idUser"));
                startActivity(intent);
                finish();
                break;

            case R.id.rechercherButton :
                intent = new Intent(this, RechercheGroupe.class);
                intent.putExtra("idUser", getIntent().getStringExtra("idUser"));
                startActivity(intent);
                finish();
                break;
        }
    }
}
