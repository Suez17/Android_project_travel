package com.example.michael.android_project_travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import tools.AlerteMessage;

public class CreateLoginActivity extends AppCompatActivity {

    EditText getLogin, getPass, getConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_login_activity);

        getLogin = (EditText) findViewById(R.id.loginText);
        getPass = (EditText) findViewById(R.id.passText);
        getConfirmPass = (EditText) findViewById(R.id.confirmPassText);
    }

    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.nextButton :
                String login = getLogin.getText().toString();
                String pass = getPass.getText().toString();
                String confirmPass = getConfirmPass.getText().toString();

                if (pass.equals("") == false) {
                    if (pass.equals(confirmPass)) {
                        intent = new Intent(this, InscriptionActivity.class);
                        intent.putExtra("login", login);
                        intent.putExtra("pass", pass);
                        startActivity(intent);
                        finish();
                    } else {
                        new AlerteMessage(this, "Les mots de passes ne sont pas identiques !");
                    }
                }
                else {
                    new AlerteMessage(this, "Veuillez entrer un mot de passe !");
                }
                break;

            case R.id.retourButton :
                intent = new Intent(this, ConnexionActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
