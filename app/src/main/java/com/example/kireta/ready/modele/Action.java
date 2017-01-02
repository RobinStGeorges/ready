package com.example.kireta.ready.modele;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kIRETA on 31/12/2016.
 */

public class Action {
    private String libelle;
    private int idSituationOrigine;
    private int idSituationResultante;

    public Action(String libelle,int idSituationOrigine, int idSituationResultante) {
        this.libelle = libelle;
        this.idSituationOrigine = idSituationOrigine;
        this.idSituationResultante = idSituationResultante;

    }
    public String getLibelle() {
        return libelle;
    }
    public int getIdSituationOrigine() {
        return idSituationOrigine;
    }
    public int getIdSituationResultante() {
        return idSituationResultante;
    }

    public JSONArray convertToJSONArray(){
        List uneListe =new ArrayList();
        uneListe.add(libelle);
        uneListe.add(idSituationOrigine);
        uneListe.add(idSituationResultante);

        JSONArray Jsona= new JSONArray(uneListe) ;
        return Jsona;
    }

}
