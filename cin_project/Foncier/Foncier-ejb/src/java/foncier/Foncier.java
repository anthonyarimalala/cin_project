
package foncier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Foncier {
    int id_foncier;
    String cin;
    String terrain;
    double superficie;
    
    public int insertLatLons(String cin, String terrain, double[][] latlon, double superficie) throws SQLException{
        int idFoncier = insertFoncierReturnID(cin, terrain);
        for(int i=0; i<latlon.length ;i++){
            this.insertLatLon(idFoncier, latlon[i][0], latlon[i][1]);
        }
        this.updateSuperficie(idFoncier, superficie);
        return 1;
    }
    
    public void updateSuperficie(int idFoncier, double superficie) throws SQLException{
        Connection connection = FoncierDB.getConnection();
        String deleteQuery = "UPDATE foncier SET superficie=? WHERE id_foncier=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setDouble(1, superficie);
        preparedStatement.setInt(2, idFoncier);
        
        preparedStatement.executeUpdate();
        connection.close();
    }
    public void insertLatLon(int idFoncier, double lat, double lon) throws SQLException{
        
        Connection connection = FoncierDB.getConnection();
        String sql = "INSERT INTO latlon (id_foncier, lat, lon) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idFoncier);
        preparedStatement.setDouble(2, lat);
        preparedStatement.setDouble(3, lon);
        preparedStatement.executeUpdate();
        connection.close();
        
    }
    public int insertFoncierReturnID(String cin, String terrain) throws SQLException{
        int idFoncier = -1;
        Connection connection = FoncierDB.getConnection();
        String sql = "INSERT INTO foncier (cin, terrain) VALUES (?, ?) RETURNING id_foncier";
        ResultSet rs = null;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Remplir les paramètres de la requête
        preparedStatement.setString(1, cin);
        preparedStatement.setString(2, terrain);

        // Exécution de la requête et récupération de l'ID généré
        rs = preparedStatement.executeQuery();
        if (rs.next()) {
            idFoncier = rs.getInt("id_foncier");
        }
        connection.close();
        return idFoncier;
    }

    public List<Foncier> findFoncier(String search) throws SQLException {
        Connection connection = FoncierDB.getConnection();
        List<Foncier> fonciers = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM foncier WHERE cin = ?"; // Remplacez "votre_table" par le nom de votre table
           
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, search);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                     Foncier foncier = new Foncier();
                    foncier.setId_foncier(resultSet.getInt("id_foncier"));
                    foncier.setCin(resultSet.getString("cin"));
                    foncier.setTerrain(resultSet.getString("terrain"));
                    foncier.setSuperficie(resultSet.getDouble("superficie"));
              
                    fonciers.add(foncier);
                }
            }
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return fonciers;
    }
    
    public void deleteFoncier(int id_foncier) throws SQLException{
        Connection connection = FoncierDB.getConnection();
        String deleteQuery = "DELETE FROM foncier WHERE id_foncier = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, id_foncier);
        int rowsDeleted = preparedStatement.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Ligne supprimée avec succès.");
        } else {
            System.out.println("Aucune ligne n'a été supprimée. Vérifiez l'ID de la banque.");
        }
        connection.close();
    }
    public void insertFoncier(String cin, String terrain) throws SQLException{
        Connection connection = FoncierDB.getConnection();
        String deleteQuery = "INSERT INTO foncier(cin, terrain) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setString(1, cin);
        preparedStatement.setString(2, terrain);
        
        int rowsDeleted = preparedStatement.executeUpdate();
        connection.close();
    }
    
    public Foncier() {
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public int getId_foncier() {
        return id_foncier;
    }

    public void setId_foncier(int id_foncier) {
        this.id_foncier = id_foncier;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }
    
    
}
