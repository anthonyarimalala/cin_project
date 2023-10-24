/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.List;

/**
 *
 * @author antho
 */
public class Unite {
    String symbole;
    String libelle;
    
    public static List<Unite> selectAll(){
        return unitify(ConnectionWebService.jsonToString("SelectAllUnites"));
    }
    
    public static List<Unite> unitify(String jsonString){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
        List<Unite> unites = gson.fromJson(jsonString, new TypeToken<List<Unite>>() {}.getType());

        return unites;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Unite() {
    }
    
    
}
