package main;

import java.util.ArrayList;
import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Personne {
    
    String cin;
    String nom;
    String prenom;
    Date dateNaissance;

    public static void main(String[] args) {
        List<Personne> personnes = objectify("[{\"cin\":\"PERS0003\",\"nom\":\"Johnson\",\"prenom\":\"Robert\",\"dateNaissance\":\"1978-12-10T00:00:00\",\"infos\":[{\"allergie\":\"Pollen\"}],\"antecedants\":[{\"antecedant\":\"Asthme\"}]}]");
        System.out.println(personnes.get(0));

    }


    public static List<Personne> objectify(String jsonString){

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

