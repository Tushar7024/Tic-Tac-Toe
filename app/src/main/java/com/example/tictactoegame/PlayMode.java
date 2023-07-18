package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayMode extends AppCompatActivity {
     ImageView playerTurn;

     TextView activeText;

    Boolean gameAvtive = true;
    //PLAYER REPRESENTATION :
        // 0-x
        // 1-o
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
        //0-X
        //1-o
        //2-Null!
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
                            {0,3,6}, {1,4,7}, {2,5,8},
                            {0,4,8}, {2,4,6}};

    public void playTab (View view) {
        ImageView img = (ImageView) view;


        int tappedImage = Integer.parseInt(img.getTag().toString());
        if (!gameAvtive){
            gameReset(view);
        }

        if (gameState[tappedImage] == 2){
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);

            TextView activeText = findViewById(R.id.activeText);
            if (activePlayer == 0){
                img.setImageResource(R.drawable.cross);
                ImageView  status = findViewById(R.id.playerTurn);
                status.setImageResource(R.drawable.circle);
                activeText.setText("Turn");
                activePlayer = 1;

            }
            else {
                img.setImageResource(R.drawable.circle);
                ImageView status = findViewById(R.id.playerTurn);
                status.setImageResource(R.drawable.cross);
                activeText.setText("Turn");
                activePlayer = 0;
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        //Winning
        for(int[] winPositon: winPositions){
            if(gameState[winPositon[0]] == gameState[winPositon[1]] && gameState[winPositon[1]] == gameState[winPositon[2]]
            && gameState[winPositon[0]] != 2)
            {
               // String winnerstr;
                TextView activeText = findViewById(R.id.activeText);
                ImageView status = findViewById(R.id.playerTurn);
                gameAvtive = false;
                if (gameState[winPositon[0]] == 0){
                   status.setImageResource(R.drawable.cross);
                    Intent secondActivityIntent = new Intent(PlayMode.this, Winner.class);
                    startActivity(secondActivityIntent);

                }
                else{
                status.setImageResource(R.drawable.circle);
                    Intent secondActivityIntent = new Intent(PlayMode.this, Winner.class);
                    startActivity(secondActivityIntent);

                }
            }
        }
    }

    public void gameReset (View view){
        gameAvtive = true;
        activePlayer = 0;
        for(int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_mode);
        ImageView status = findViewById(R.id.playerTurn);
        status.setImageResource(R.drawable.cross);
        TextView activeText = findViewById(R.id.activeText);
        activeText.setText("Turn");
    }
}