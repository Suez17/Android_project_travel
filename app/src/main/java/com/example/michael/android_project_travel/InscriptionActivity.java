package com.example.michael.android_project_travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import bddRequest.BackgroundTask;

public class InscriptionActivity extends AppCompatActivity {

    EditText getNom, getPrenom, getAge, getPhone, getVille, getEmail;
    RadioButton getPro, getPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription_activity);

        getNom = (EditText) findViewById(R.id.nomText);
        getPrenom = (EditText) findViewById(R.id.prenomText);
        getAge = (EditText) findViewById(R.id.ageText);
        getPhone = (EditText) findViewById(R.id.phoneText);
        getVille = (EditText) findViewById(R.id.villeText);
        getEmail = (EditText) findViewById(R.id.emailText);
        getPro = (RadioButton) findViewById(R.id.radioProfessionnel);
        getPart = (RadioButton) findViewById(R.id.radioParticulier);
    }

    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.validerInscription :
                String nom = getNom.getText().toString();
                String prenom =  getPrenom.getText().toString();
                String age =  getAge.getText().toString();
                String phone = getPhone.getText().toString();
                String ville = getVille.getText().toString();
                String email = getEmail.getText().toString();
                String pro = getPro.getText().toString();
                String part = getPart.getText().toString();

                intent = getIntent();
                String login = intent.getStringExtra("login");
                String pass = intent.getStringExtra("pass");

                String method = "register";
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute(method, nom, prenom, age, phone, ville, email, login, pass);
                finish();
                intent = new Intent(this, ConnexionActivity.class);
                startActivity(intent);
                break;

            case R.id.retourButton :
                intent = new Intent(this, CreateLoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
