/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antho
 */
public class Banque {
    int idBanque;
    String cin;
    float solde;
    String banque;
    
    public static void transaction(int id_banque_send, int id_banque_receive, float montant, float montantVente) throws SQLException{
        moinBanque(id_banque_send, montant);
        plusBanque(id_banque_receive, montantVente);
    }
    
    public static void plusBanque(int id_banque, float update) throws SQLException{
        Connection connection = FinancierDB.getConnection();
        String deleteQuery = "UPDATE banque SET solde=(solde + ?) WHERE id_banque=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setFloat(1, update);
        preparedStatement.setFloat(2, id_banque);
        // Exécutez la requête pour supprimer la ligne
        int rowsDeleted = preparedStatement.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Ligne updaté avec succès.");
        } else {
            System.out.println("Aucune ligne n'a été updaté. Vérifiez l'ID de la banque.");
        }
        connection.close();
//        if(update<=0){
//            throw new SQLException("La valeur doit etre superieur à 0");
//        }
    }
    
    public static void moinBanque(int id_banque, float update) throws SQLException{
        Connection connection = FinancierDB.getConnection();
        String deleteQuery = "UPDATE banque SET solde=(solde - ?) WHERE id_banque=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setFloat(1, update);
        preparedStatement.setFloat(2, id_banque);
        // Exécutez la requête pour supprimer la ligne
        int rowsDeleted = preparedStatement.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Ligne updaté avec succès.");
        } else {
            System.out.println("Aucune ligne n'a été updaté. Vérifiez l'ID de la banque.");
        }
        connection.close();
        
//        if(update<=0){
//            throw new SQLException("La valeur doit etre superieur à 0");
//        }
    }
    
   public List<Banque> findBanqueTransaction(String search) throws SQLException {
        Connection connection = FinancierDB.getConnection();
        List<Banque> banques = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM banque WHERE cin != ? ORDER BY id_banque ASC"; // Remplacez "votre_table" par le nom de votre table
           
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, search);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                     Banque banque = new Banque();
                    banque.setIdBanque(resultSet.getInt("id_banque"));
                    banque.setCin(resultSet.getString("cin"));
                    banque.setSolde(resultSet.getFloat("solde"));
                    banque.setBanque(resultSet.getString("banque"));
              
                    banques.add(banque);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        connection.close();
        
        return banques;
    } 
   public List<Banque> findBanque(String search) throws SQLException {
        Connection connection = FinancierDB.getConnection();
        List<Banque> banques = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM banque WHERE cin = ? ORDER BY id_banque ASC"; // Remplacez "votre_table" par le nom de votre table
           
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, search);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                     Banque banque = new Banque();
                    banque.setIdBanque(resultSet.getInt("id_banque"));
                    banque.setCin(resultSet.getString("cin"));
                    banque.setSolde(resultSet.getFloat("solde"));
                    banque.setBanque(resultSet.getString("banque"));
              
                    banques.add(banque);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        connection.close();
        
        return banques;
    }

    public int getIdBanque() {
        return idBanque;
    }

    public void setIdBanque(int idBanque) {
        this.idBanque = idBanque;
    }
    
    public static List<Banque> selectAll() throws SQLException {
        Connection connection = FinancierDB.getConnection();
        List<Banque> banques = new ArrayList<>();
        String sql = "SELECT * FROM banque ORDER BY id_banque ASC"; // Remplacez "votre_table" par le nom de votre table

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Banque banque = new Banque();
                banque.setIdBanque(resultSet.getInt("id_banque"));
                banque.setCin(resultSet.getString("cin"));
                banque.setSolde(resultSet.getFloat("solde"));
                banque.setBanque(resultSet.getString("banque"));
              
                banques.add(banque);
            }
        }
        connection.close();
        return banques;
    }
    
    public static void deleteBanque(int id_banque) throws SQLException{
        Connection connection = FinancierDB.getConnection();
        String deleteQuery = "DELETE FROM banque WHERE id_banque = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, id_banque);
        // Exécutez la requête pour supprimer la ligne
        int rowsDeleted = preparedStatement.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Ligne supprimée avec succès.");
        } else {
            System.out.println("Aucune ligne n'a été supprimée. Vérifiez l'ID de la banque.");
        }
        connection.close();
    }
    
    public static void updateBanque(int id_banque, float update) throws SQLException{
        Connection connection = FinancierDB.getConnection();
        String deleteQuery = "UPDATE banque SET solde=(solde + ?) WHERE id_banque=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setFloat(1, update);
        preparedStatement.setFloat(2, id_banque);
        // Exécutez la requête pour supprimer la ligne
        int rowsDeleted = preparedStatement.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Ligne updaté avec succès.");
        } else {
            System.out.println("Aucune ligne n'a été updaté. Vérifiez l'ID de la banque.");
        }
        connection.close();
    }

    public String showMessage(String message){
        return message;
    }
    public Banque() {
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }
    
    
}
