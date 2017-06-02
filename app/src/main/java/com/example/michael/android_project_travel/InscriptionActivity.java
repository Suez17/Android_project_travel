package com.example.michael.android_project_travel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import bddRequest.BackgroundTask;

public class InscriptionActivity extends AppCompatActivity {

    EditText _nom, _prenom, _age, _phone, _ville, _email, _mdp;
    RadioButton _pro, _part;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription_activity);

        _nom = (EditText) findViewById(R.id.nomText);
        _prenom = (EditText) findViewById(R.id.prenomText);
        _age = (EditText) findViewById(R.id.ageText);
        _phone = (EditText) findViewById(R.id.phoneText);
        _ville = (EditText) findViewById(R.id.villeText);
        _email = (EditText) findViewById(R.id.emailText);
        _mdp = (EditText) findViewById(R.id.mdpText);

        _pro = (RadioButton) findViewById(R.id.radioProfessionnel);
        _part = (RadioButton) findViewById(R.id.radioParticulier);
    }

    public void userReg(View view) {
        String nom = _nom.getText().toString();
        String prenom = _nom.getText().toString();
        String age = _nom.getText().toString();
        String phone = _nom.getText().toString();
        String ville = _nom.getText().toString();
        String email = _nom.getText().toString();
        String mdp = _nom.getText().toString();
        String pro = _pro.getText().toString();
        String part = _part.getText().toString();

        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, nom, prenom, age, phone, ville, email, mdp);
        finish();
    }
}
