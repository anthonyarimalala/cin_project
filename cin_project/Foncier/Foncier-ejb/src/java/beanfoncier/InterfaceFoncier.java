/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanfoncier;

import foncier.Foncier;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface InterfaceFoncier {
    String sayHello();
    List<Foncier> findFoncier(String search) throws SQLException;
    int insertFoncier(String cin, String terrain, float superficie) throws SQLException;
    int deleteFoncier(int id_foncier) throws SQLException;
    double calculerSuperficiePolygone(double[][] coordonnees);
    int insertLatLons(String cin, String terrain, double[][] latlon, double superficie) throws SQLException;
}
