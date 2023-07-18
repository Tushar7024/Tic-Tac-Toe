package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    //Variable
    private static final int SPLASH_SCREEN = 3000;
    Animation topAnimation;
    ImageView imageView, tttText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen2);
        //FONT COLORING
//        TextView textView2 = findViewById(R.id.tttText);
//        String html = "<font color=" + Color.GREEN
//                + ">Tic</font><font color="
//                + Color.BLACK + "> Tac</font>";
//        textView.setText(Html.fromHtml(html));

        //Animation
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);


        //Hooks
        imageView= findViewById(R.id.tttText);
        tttText= findViewById(R.id.tttText);


        tttText.setAnimation(topAnimation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}