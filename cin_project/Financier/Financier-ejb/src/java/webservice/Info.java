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
public class Info {
    String allergie;
    
    public static List<Info> findInfo(String search){
        return infonify(ConnectionWebService.jsonToString("SelectInfoByCin/"+search));
    }
    
    public static List<Info> infonify(String jsonString){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
        List<Info> infos = gson.fromJson(jsonString, new TypeToken<List<Info>>() {}.getType());

        return infos;
    }

    public String getAllergie() {
        return allergie;
    }public void setAllergie(String allergie) {
        this.allergie = allergie;
    }
}
