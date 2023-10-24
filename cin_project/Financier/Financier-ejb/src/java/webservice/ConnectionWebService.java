package webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ConnectionWebService {
     public static String jsonToString(String method){
        try {
            // URL de base de votre service Web API
            String baseUrl = "http://localhost:5289/Personne"; // Remplacez par l'URL de votre service

            // Exemple d'appel à SelectAll
            URL urlAll = new URL(baseUrl + "/" + method);
            HttpURLConnection connAll = (HttpURLConnection) urlAll.openConnection();
            connAll.setRequestMethod("GET");

            int responseCodeAll = connAll.getResponseCode();
            if (responseCodeAll == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connAll.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                String jsonResponseAll = response.toString();
                //System.out.println(jsonResponseAll);
                return jsonResponseAll;
                // Traitez ici la réponse JSON de l'endpoint SelectAll
            } else {
                System.out.println("Erreur : " + responseCodeAll);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         return null;
    }
}
