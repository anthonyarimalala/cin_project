/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanfoncier;

import foncier.Foncier;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author antho
 */
@Stateless
@LocalBean
public class BeanFoncier implements InterfaceFoncier{

    @Override
    public String sayHello() {
        return "Hello, World ehh";
    }

    @Override
    public List<Foncier> findFoncier(String search) throws SQLException {
        Foncier foncier = new Foncier();
        List<Foncier> fonciers = foncier.findFoncier(search);
        return fonciers;
    }
    
    @Override
    public int insertFoncier(String cin, String terrain, float superficie) throws SQLException{
        Foncier foncier = new Foncier();
        try{
            foncier.insertFoncier(cin, terrain);
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        
    }
    
    @Override
    public int deleteFoncier(int id_foncier) throws SQLException{
        Foncier foncier = new Foncier();
        try{
            foncier.deleteFoncier(id_foncier);
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public double calculerSuperficiePolygone(double[][] coordonnees) {
        if (coordonnees.length < 3) {
            throw new IllegalArgumentException("Le polygone doit avoir au moins 3 sommets.");
        }

        int numPoints = coordonnees.length;
        double area = 0.0;

        for (int i = 0; i < numPoints; i++) {
            double lat1 = coordonnees[i][0];
            double lon1 = coordonnees[i][1];
            double lat2 = coordonnees[(i + 1) % numPoints][0];
            double lon2 = coordonnees[(i + 1) % numPoints][1];

            area += Math.toRadians(lon2 - lon1) *
                    (2 + Math.sin(Math.toRadians(lat1)) + Math.sin(Math.toRadians(lat2)));
        }

        area = area * 6378137.0 * 6378137.0 / 2.0; // Rayon de la Terre en mètres

        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(Math.abs(area))) ;
    }

    @Override
    public int insertLatLons(String cin, String terrain, double[][] latlon, double superficie) throws SQLException {
        Foncier foncier = new Foncier();
        foncier.insertLatLons(cin, terrain, latlon, superficie);
        return 1;
    }

}
