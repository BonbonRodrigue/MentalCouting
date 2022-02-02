package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Lancer_jeu = findViewById(R.id.Lancer_Jeu);
        Button Score = findViewById(R.id.Acces_Score);

        Lancer_jeu.setOnClickListener(view -> LancerJeu());
        Score.setOnClickListener(view -> AccesScore());
    }

    private void LancerJeu(){
        Intent intent = new Intent(this, PageCalcul.class);
        startActivity(intent);
    }

    private void AccesScore(){
        Intent intent = new Intent(this, Page_Score.class);
        startActivity(intent);
    }
}