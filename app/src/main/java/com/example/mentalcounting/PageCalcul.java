package com.example.mentalcounting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class PageCalcul extends AppCompatActivity {
    private TextView textResultat;
    private TextView textProblem;
    private int _first = 0;
    private int result_Problem = 0;
    private boolean test_input = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_calcul);
        _first = -1;


        // les boutons chiffre
        ArrayList<Button> list = new ArrayList<Button>();
        list.add(findViewById(R.id.Button_1));
        list.add( findViewById(R.id.Button_2));
        list.add( findViewById(R.id.Button_3));
        list.add( findViewById(R.id.Button_4));
        list.add( findViewById(R.id.Button_5));
        list.add( findViewById(R.id.Button_6));
        list.add( findViewById(R.id.Button_7));
        list.add( findViewById(R.id.Button_8));
        list.add( findViewById(R.id.Button_9));
        list.add( findViewById(R.id.Button_0));


        // accès à la page suivante
        Button Enter = findViewById(R.id.ENTER);
        Enter.setOnClickListener(view -> Enter_Result());


        // effacer les données entrées par l'utilisateur
        Button Erase = findViewById(R.id.Erase);
        Erase.setOnClickListener(view -> eraseOperation());


        // prise du texte affiché à l'écran dans une variable
        textResultat = findViewById(R.id.text_Resultat);
        textProblem = findViewById(R.id.text_Problem);


        // Affichage de la valeur du bouton à l'écran
        for (Button b : list) {
            b.setOnClickListener(view -> writeNumber(b));
        }

        int result_problem = writeProblem();
    }





    // Gestion du menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        // Si on appuie sur le premier boutton, ça ouvre le menu principal
        switch (id) {
            case R.id.Button_Menu_1:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }

        // Si on appuie sur le second boutton, ça ouvre la page des scores
        switch (id) {
            case R.id.Button_Menu_2:
                Intent intent = new Intent(this, Page_Score.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }




    // Ecriture du probleme
    private int writeProblem()
    {
        int limite = 10;
        String first, second, operator;
        result_Problem = 0;

        // récupération du premier chiffre
        int alea = new Random().nextInt(limite);
        first = String.valueOf(alea);

        // récupération du second chiffre
        alea = new Random().nextInt(limite);
        second = String.valueOf(alea);

        // récupération de l'opérateur
        alea = new Random().nextInt(3);


        if(alea == 0)
        {
            operator = "+";
            result_Problem = Integer.parseInt(first) + Integer.parseInt(second);
        }
        else
        {
            if(alea == 1)
            {
                operator = "-";
                result_Problem = Integer.parseInt(first) - Integer.parseInt(second);

                // On interchange les deux valeurs pour éviter les chiffres négatifs
                if(Integer.parseInt(first) < Integer.parseInt(second))
                {
                    updateProblem(second, first, operator);
                    result_Problem = Integer.parseInt(second) - Integer.parseInt(first);
                    return(result_Problem);
                }
            }
            else
            {
                if(alea == 2)
                {
                    // On évite dans tous les cas la multiplication par 0
                    if(Integer.parseInt(first) == 0)
                        first = "1";

                    operator = "*";
                    result_Problem = Integer.parseInt(first) * Integer.parseInt(second);
                }
                // Au cas où alea arrive à aller au dessus de 2, on met operator à "+" pour éviter les bugs
                else
                {
                    operator = "+";
                }
            }
        }

        updateProblem(first, second, operator);
        return(result_Problem);
    }




    // Gestion des nouvelles données
    private void Enter_Result() {
        Intent intent = new Intent(this, Page_Resultat_Negatif.class);

        // On transfert les données à l'activité suivante
        intent.putExtra(Page_Resultat_Negatif.result_KEY, this.getResult());
        intent.putExtra(Page_Resultat_Negatif.input_KEY, this.getFirst());

        startActivity(intent);
    }




    // Creation du menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);

        return super.onCreateOptionsMenu(menu);
    }





    // ecriture du nombre sur l'écran
    private void writeNumber(Button b) {

        if(test_input == false)
        {
            eraseOperation();
            test_input = true;
        }

        CharSequence sequence = b.getText();
        String str = sequence.toString();

        String resultAsString = Integer.toString(getFirst()) + str;
        int result = Integer.parseInt(resultAsString);
        this.setFirst(result);

    }





    // mise à jour du probleme sur l'écran
    private void updateProblem(String First, String Second, String Operator) {
        String text = First + Operator + Second;

        System.out.println("text : " + text);
        textProblem.setText(text);
    }





    // suppression des données entrées par l'utilisateur
    private void eraseOperation() {
        String text = getString(
                // le template
                R.string.operation_template,
                // les variables qui sont injectées
                0
        );

        this.setFirst(0);
        this.textResultat.setText(text);
    }





    // mise à jour de l'opérateur sur l'écran
    private void updateOperation() {
        String text = getString(
                // le template
                R.string.operation_template,
                // les variables qui sont injectées
                getFirst()
        );

        this.textResultat.setText(text);
    }





    // les getter et setter
    private int getFirst() {
        return _first;
    }

    private void setFirst(int _first) {
        this._first = _first;
        this.updateOperation();
    }

    private int getResult() {return result_Problem; }

}