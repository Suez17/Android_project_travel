package com.example.michael.android_project_travel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import bddRequest.BackgroundTask;
import tools.AlerteMessage;

/**
 * Created by Isidore on 18/05/2017.
 */
public class ConnexionActivity extends AppCompatActivity {

    EditText getLogin, getPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion_activity);

        getLogin = (EditText) findViewById(R.id.loginEditText);
        getPass = (EditText) findViewById(R.id.passwordEditText);
    }

    public void onClick(View v) throws Throwable {
        Intent intent;

        switch (v.getId()) {
            case R.id.connexionButton :
                String login = getLogin.getText().toString();
                String pass = getPass.getText().toString();

                String method = "login";
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute(method, login, pass);
                String requestResult = backgroundTask.get().toString();

                if (requestResult.equals("1")) {
                    intent = new Intent(this, AccueilActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    new AlerteMessage(this, "Le login ou le mot de passe est incorrect !");
                }

                break;

            case R.id.inscriptionButton :
                intent = new Intent(this, CreateLoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
