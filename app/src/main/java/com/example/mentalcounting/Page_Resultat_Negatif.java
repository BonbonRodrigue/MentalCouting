package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Page_Resultat_Negatif extends AppCompatActivity {
    public final static String result_KEY = "Result";
    public final static String input_KEY = "Input";
    private TextView rightOrWrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_resultat_negatif);

        Intent intent = getIntent();
        int Result = intent.getIntExtra(result_KEY, 0);
        int Input = intent.getIntExtra(input_KEY, 0);
        System.out.println("Result : " + Result);
        System.out.println("Input : " + Input );

        rightOrWrong = findViewById(R.id.textRoW);

        Button M_Principal = findViewById(R.id.ToMain);
        Button M_Score = findViewById(R.id.ToScore);
        Button Button_Recommencer = findViewById(R.id.Recommencer);

        M_Principal.setOnClickListener(view -> MainButton());
        M_Score.setOnClickListener(view -> ScoreButton());
        Button_Recommencer.setOnClickListener(view -> TryButton());

        Win_Or_Lose(Input, Result);
        System.out.println(rightOrWrong.getText());
    }

    private void Win_Or_Lose(int input, int result)
    {
        if(input == -1)
        {
            rightOrWrong.setText(R.string.Null);
            rightOrWrong.setTextColor(Color.GRAY);
        }
        else
        {
            if(input != result)
            {
                rightOrWrong.setText(R.string.Lose);
                rightOrWrong.setTextColor(Color.RED);
            }
            else
            {
                rightOrWrong.setText(R.string.Win);
                rightOrWrong.setTextColor(Color.GREEN);
            }

        }
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