/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.Date;
import java.util.List;

/**
 *
 * @author antho
 */
public class Cours {
    int idCours;
    String symbole;
    double valeurAriary;
    Date dateCours;
    double tauxVente;

    public static Cours selectCours(String symbole){
        return coursify(ConnectionWebService.jsonToString("SelectCours/"+symbole));
    }
    
    public static Cours coursify(String jsonString){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
        Cours cours = gson.fromJson(jsonString, new TypeToken<Cours>() {}.getType());

        return cours;
    }
    
    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public double getValeurAriary() {
        return valeurAriary;
    }

    public void setValeurAriary(double valeurAriary) {
        this.valeurAriary = valeurAriary;
    }

    public Date getDateCours() {
        return dateCours;
    }

    public void setDateCours(Date dateCours) {
        this.dateCours = dateCours;
    }

    public Cours() {
    }

    public double getTauxVente() {
        return tauxVente;
    }

    public void setTauxVente(double tauxVente) {
        this.tauxVente = tauxVente;
    }
    
    
}
