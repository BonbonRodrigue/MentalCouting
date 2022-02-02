package com.example.mentalcounting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

public class PageCalcul extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_calcul);

        Button Enter = findViewById(R.id.ENTER);

        Enter.setOnClickListener(view -> Enter_Result());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.Button_Menu_1:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }

        switch (id) {
            case R.id.Button_Menu_2:
                Intent intent = new Intent(this, Page_Score.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void GoMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void GoScore() {
        Intent intent = new Intent(this, Page_Score.class);
        startActivity(intent);
    }

    private void Enter_Result() {
        Intent intent = new Intent(this, Page_Resultat_Negatif.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);

        return super.onCreateOptionsMenu(menu);
    }

}