package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Page_Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_score);

        Button Back = findViewById(R.id.BackToMenu);

        Back.setOnClickListener(view -> BackToMenu());
    }

    private void BackToMenu() {
        finish();
    }
}