/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Personne {
    String cin;
    String nom;
    String prenom;
    Date dateNaissance;

    public static void main(String[] args) {
        
        ConnectionWebService.jsonToString("SelectByCin/PERS0003");
        
        List<Personne> personnes = personify(ConnectionWebService.jsonToString("SelectByCin/PERS0001"));
        System.out.println(personnes.get(0).getNom());
        // System.out.println(ConnectionWebService.jsonToString("SelectByCin/PERS0003"));

    }
    public static List<Personne> findPersonne(String search){
        return personify(ConnectionWebService.jsonToString("SelectByCin/"+search));
    }
    
    public static List<Personne> selectAll(){
        return personify(ConnectionWebService.jsonToString(""));
    }
    
    public static List<Personne> personify(String jsonString){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
        List<Personne> personnes = gson.fromJson(jsonString, new TypeToken<List<Personne>>() {}.getType());

        return personnes;
    }

    public Personne(){

    }
    
    public String getCin() {
        return cin;
    }public Date getDateNaissance() {
        return dateNaissance;
    }public String getNom() {
        return nom;
    }public String getPrenom() {
        return prenom;
    }public void setCin(String cin) {
        this.cin = cin;
    }public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }public void setNom(String nom) {
        this.nom = nom;
    }public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
