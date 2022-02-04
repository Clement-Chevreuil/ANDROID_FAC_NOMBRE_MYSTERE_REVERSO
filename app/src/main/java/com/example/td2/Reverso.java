package com.example.td2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Reverso extends AppCompatActivity {

    EditText SaisieBase, SaisieInverse;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverso);

        SaisieBase = findViewById(R.id.SaisieBase);
        SaisieInverse = findViewById(R.id.SaisieInverse);
        reset = findViewById(R.id.reset);

        reset.setOnClickListener(resetGame);
        SaisieInverse.setOnKeyListener(OnKeyInverse);
        SaisieBase.setOnKeyListener(OnKeyBase);
    }

    private View.OnClickListener resetGame = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SaisieInverse.setBackgroundColor(Color.TRANSPARENT);
            SaisieBase.setText("");
            SaisieInverse.setText("");
        }
    };

    private View.OnKeyListener OnKeyInverse = new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {

            if (keyEvent.getAction() == KeyEvent.ACTION_UP )
            {
                String textBase = SaisieBase.getText().toString();
                StringBuilder strb = new StringBuilder(textBase);
                String textBaseInverse = strb.reverse().toString();

                String textInverse = SaisieInverse.getText().toString();
                Integer nbLettreInverse = textInverse.length();
                Integer nbLettreBase = textBaseInverse.length();

                if(nbLettreInverse >= 1 && nbLettreInverse <= nbLettreBase )
                {
                    String lettreBaseInverse =  textBaseInverse.substring(0, nbLettreInverse);
                    String lettreInverse =  textInverse.substring(0, nbLettreInverse);


                    if(lettreBaseInverse.equals(lettreInverse))
                    {
                        SaisieInverse.setBackgroundColor(Color.YELLOW);

                        if(textBase.length() == textInverse.length())
                        {
                            SaisieInverse.setBackgroundColor(Color.GREEN);
                        }
                    }
                    else
                    {
                        SaisieInverse.setBackgroundColor(Color.RED);
                    }
                }
                else if(nbLettreInverse > nbLettreBase)
                {
                    SaisieInverse.setBackgroundColor(Color.RED);
                }
                else
                {
                    SaisieInverse.setBackgroundColor(Color.TRANSPARENT);
                }

            }
            return false;
            //textwatcher onTextChange
        }
    };

    private View.OnKeyListener OnKeyBase = new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {

            if (keyEvent.getAction() == KeyEvent.ACTION_UP )
            {
                String textBase = SaisieBase.getText().toString();
                StringBuilder strb = new StringBuilder(textBase);
                String textBaseInverse = strb.reverse().toString();

                String textInverse = SaisieInverse.getText().toString();
                Integer nbLettreInverse = textInverse.length();
                Integer nbLettreBase = textBaseInverse.length();

                if(nbLettreInverse >= 1 && nbLettreInverse <= nbLettreBase )
                {
                    String lettreBaseInverse =  textBaseInverse.substring(0, nbLettreInverse);
                    String lettreInverse =  textInverse.substring(0, nbLettreInverse);


                    if(lettreBaseInverse.equals(lettreInverse))
                    {
                        SaisieInverse.setBackgroundColor(Color.YELLOW);

                        if(textBase.length() == textInverse.length())
                        {
                            SaisieInverse.setBackgroundColor(Color.GREEN);
                        }
                    }
                    else
                    {
                        SaisieInverse.setBackgroundColor(Color.RED);
                    }
                }
                else if(nbLettreInverse > nbLettreBase)
                {
                    SaisieInverse.setBackgroundColor(Color.RED);
                }
                else
                {
                    SaisieInverse.setBackgroundColor(Color.TRANSPARENT);
                }




            }



            return false;
            //textwatcher onTextChange
        }
    };

}