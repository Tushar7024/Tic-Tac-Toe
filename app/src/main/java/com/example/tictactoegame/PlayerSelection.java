package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerSelection extends AppCompatActivity {
    Button button, button2;
    EditText playerOneName, playerTwoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_selection);

        //Button
        button = findViewById(R.id.startGame2);
        button2 = findViewById(R.id.cancelbtn);
        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getplayerOneName = playerOneName.getText().toString();
                String getplayerTwoName = playerTwoName.getText().toString();
                if (getplayerOneName.isEmpty() || getplayerTwoName.isEmpty()){
                    Toast.makeText(PlayerSelection.this, "Enter Player Name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent secondActivityIntent = new Intent(PlayerSelection.this, PlayMode.class);
                    startActivity(secondActivityIntent);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayerSelection.this, MainActivity.class);
                intent.putExtra("Player One", getplayerOneName)
                startActivity(intent);
            }
        });

    }
}