package com.example.kireta.ready.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.kireta.ready.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creerMenu();
    }

    //bouton demarage du jeu
    public void creerMenu(){
        //appel de ecoute menu pour clic sur l'image start
        ecouteMenu((ImageButton)findViewById(R.id.btnStr),Jeu.class);


    }
    public void ecouteMenu(ImageButton a, final Class b){

        (a).setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                Intent c=new Intent(MainActivity.this,b);
                startActivity(c);
            }
        });


    }
}
