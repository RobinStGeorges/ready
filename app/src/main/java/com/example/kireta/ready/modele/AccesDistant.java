package com.example.kireta.ready.modele;

import android.util.Log;

import com.example.kireta.ready.controleur.controle;
import com.example.kireta.ready.outils.AsyncResponse;
import com.example.kireta.ready.outils.AccesHTTP;
import com.example.kireta.ready.outils.MesOutils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kIRETA on 29/12/2016.
 */

public class AccesDistant implements AsyncResponse {
    final String SERVERADDR ="http://192.168.43.18/coach/serveurReady.php";
    public AccesDistant() {
        super();
    }
    @Override
    public void processFinish(String output) {
        Log.d("serveur", "************" + output);
        String[] message = output.split("%");
        if (message.length>1) {
            if (message[0].equals("situation")) {
                Log.d("*******************", "situation" + message);

            }
            if (message[0].equals("action")) {
                Log.d("*******************", "action" + message);

                    try {

                        //recuperation de toutes les actions
                        JSONArray tab = new JSONArray(message[1]);
                        ArrayList listActions = new ArrayList<Action>();
                        for (int i = 0; i < tab.length(); i++) {
                            JSONObject info = (JSONObject) (tab.get(i));
                            String labelle = info.getString("labelle");
                            Integer idSituationOrigine = info.getInt("idSituationOrigine");
                            Integer idSituationResultante = info.getInt("idSituationResultante");

                            listActions.add(new Action(labelle, idSituationOrigine, idSituationResultante));
                        }
                        //  controle.setLesActions(listActions);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    public void envoi(String operation, JSONArray lesDonneesJSON){
        AccesHTTP accesDonnees = new AccesHTTP();
        accesDonnees.delegate = this;
        accesDonnees.addParam("operation", operation);
        accesDonnees.addParam("lesdonnees", lesDonneesJSON.toString());
        accesDonnees.execute(SERVERADDR);
    }

}
