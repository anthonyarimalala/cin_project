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


public class Antecedantt {
    String antecedant;
    
    public static List<Antecedantt> findAntecedant(String search){
        return antecedantify(ConnectionWebService.jsonToString("SelectAntecedantByCin/"+search));
    }
    
    public static List<Antecedantt> antecedantify(String jsonString){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
        List<Antecedantt> antecedants = gson.fromJson(jsonString, new TypeToken<List<Antecedantt>>() {}.getType());
        return antecedants;
    }
    
    public Antecedantt() {
    }
    public String getAntecedant() {
        return antecedant;
    }public void setAntecedant(String antecedant) {
        this.antecedant = antecedant;
    }
}
