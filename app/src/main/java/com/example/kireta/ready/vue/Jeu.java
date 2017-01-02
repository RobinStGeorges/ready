package com.example.kireta.ready.vue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.kireta.ready.R;
import com.example.kireta.ready.controleur.controle;
import com.example.kireta.ready.modele.Action;

import java.util.ArrayList;

public class Jeu extends AppCompatActivity {
private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        creerListe();
    }

    // affiche les première actions
    public void creerListe(){
        if (i>0) {
            ArrayList liste = new ArrayList<Action>();
            liste = controle.getLesActions();
            ListView listView = (ListView) findViewById(R.id.listActions);
            actionListAdapter adapter = new actionListAdapter(Jeu.this, liste);
            listView.setAdapter(adapter);
            i+=1;
        }
        ArrayList liste = new ArrayList<Action>();
        liste = controle.getLesActions();
        ListView listView = (ListView) findViewById(R.id.listActions);
        actionListAdapter adapter = new actionListAdapter(Jeu.this, liste);
        listView.setAdapter(adapter);
    }
    //affiche les actions une fois le bouton cliqué
}
