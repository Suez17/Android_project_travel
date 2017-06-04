package com.example.michael.android_project_travel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

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

    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.connexionButton :
                intent = new Intent(this, AccueilActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.inscriptionButton :
                intent = new Intent(this, CreateLoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }

    }
}
