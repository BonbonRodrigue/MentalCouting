package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Page_Resultat_Negatif extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_resultat_negatif);

        Button M_Principal = findViewById(R.id.ToMain);
        Button M_Score = findViewById(R.id.ToScore);
        Button Button_Recommencer = findViewById(R.id.Recommencer);

        M_Principal.setOnClickListener(view -> MainButton());
        M_Score.setOnClickListener(view -> ScoreButton());
        Button_Recommencer.setOnClickListener(view -> TryButton());
    }

    private void MainButton() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void ScoreButton() {
        Intent intent = new Intent(this, Page_Score.class);
        startActivity(intent);
    }

    private void TryButton() {
        Intent intent = new Intent(this, PageCalcul.class);
        startActivity(intent);
    }
}