package com.example.td2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NombreMystere extends AppCompatActivity {

    Integer nombreMystere;
    Integer nombreJoueur;

    Integer tentativeNumber = 0;
    TextView tentative;
    EditText reponseJoueur;
    Button submit;
    Button replay;
    Context cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cont = this;

        tentative = findViewById(R.id.tentative);

        nombreMystere = (int) (Math.random()*100);

        reponseJoueur = findViewById(R.id.number);

        submit = findViewById(R.id.submit);
        replay = findViewById(R.id.replay);

        submit.setOnClickListener(reponse);
        replay.setOnClickListener(rejoue);

        tentative.setText("Vous etes à : " + tentativeNumber);
        Log.e("test", String.valueOf(nombreMystere));


    }

    private View.OnClickListener reponse = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            nombreJoueur = Integer.parseInt(reponseJoueur.getText().toString());
            if(nombreJoueur == nombreMystere)
            {
               Toast toast = Toast.makeText(cont, "Vous avez gagné", Toast.LENGTH_LONG);
               toast.show();
            }
            else if(nombreJoueur < nombreMystere)
            {
                Toast.makeText(cont, "Plus", Toast.LENGTH_LONG).show();
                tentativeNumber = tentativeNumber + 1;
                tentative.setText("Vous etes à : " + tentativeNumber);
            }
            else if(nombreJoueur > nombreMystere)
            {
                Toast.makeText(cont, "Moins", Toast.LENGTH_LONG).show();
                tentativeNumber = tentativeNumber + 1;
                tentative.setText("Vous etes à : " + tentativeNumber);
            }
        }
    };

    private View.OnClickListener rejoue = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            nombreMystere = (int) (Math.random()*100);
            Toast.makeText(cont, "Nouveau nombre mystere", Toast.LENGTH_LONG).show();
            tentativeNumber = 0;
            tentative.setText("Vous etes à : " + tentativeNumber);
        }
    };
}