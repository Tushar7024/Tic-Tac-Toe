package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Winner extends AppCompatActivity {
    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        //BUTTON FUNCTIONALITY
        button = findViewById(R.id.reset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivityIntent = new Intent(Winner.this, MainActivity.class);
                startActivity(secondActivityIntent);
            }
        });
        //IMAGE MANIPULATION
        imageView = findViewById(R.id.imageView12);
        imageView.setImageResource(R.drawable.cross2);
    }
}