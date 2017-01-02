package com.example.kireta.ready.vue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.kireta.ready.R;
import com.example.kireta.ready.modele.Action;
import com.example.kireta.ready.outils.MesOutils;

import java.util.ArrayList;

import static android.view.LayoutInflater.from;
import static com.example.kireta.ready.R.id.txtSituation;

/**
 * Created by kIRETA on 29/12/2016
 */

public class actionListAdapter extends BaseAdapter {
    private ArrayList<Action> lesActions ;
    private LayoutInflater inflater ;
    public actionListAdapter (Context context, ArrayList<Action> listeDeActions){
        lesActions = listeDeActions;
        LayoutInflater inflater = from(context);

    }
    @Override
    public int getCount() {
        return lesActions.size();
    }

    @Override
    public Object getItem(int position) {
        return lesActions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    private class ViewHolder{
        private TextView txtAction;

        private Button btnAction;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // holder est un objet de la petite classe
        ViewHolder holder ;
        // si la ligne n'existe pas encore
        if (convertView == null) {
            holder = new ViewHolder() ;
            // la ligne est construite à partir de la structure de la ligne (récupéré dans layout_list_histo)
            convertView = inflater.inflate(R.layout.layout_liste_action, null) ;
            // chaque propriété de holder (correspondant aux objets graphiques) est liée à un des objets graphiques
            holder.txtAction = (TextView)convertView.findViewById(R.id.txtAction) ;
            holder.btnAction = (Button)convertView.findViewById(R.id.btnAction) ;

            // affecte un tag (un indice) à la ligne (qui permettra de la repérer facilement)
            convertView.setTag(holder) ;
        }else{
            // si la ligne existe déjà, holder récupère le contenu (à partir de son tag, donc son indice)
            holder = (ViewHolder)convertView.getTag();
        }
        // holder est maintenant lié à la ligne graphique
        // valorisation des propriétés de holder avec le profil de lesProfils (à un indice précis : position)

                                        //Il faut faire en sorte de recuperer le texte de l'action
                                        //via une fonction "getTexteAction" dans MesOutils

        holder.txtAction.setText(lesActions.get(position).getLibelle()) ;

        holder.btnAction.setTag(position) ;
        // gestion de l'événement clic sur le bouton de suppression
        holder.btnAction.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // code a exécuter sur le clic d'un bouton suppr
                //  appel de la fonction de set text sur le txtSituation en fonctiondu idSituationResultante
                //de l'action selectionné.

                //selectionner le texte de la situation suivante selon l'idsituationresultante
               /* txtSituation.setText(MesOutils.renvoiTexteSituation());*/
            }
        }) ;
        return convertView ;
    }
}
