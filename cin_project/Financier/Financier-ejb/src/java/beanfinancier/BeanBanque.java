/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanfinancier;

import financier.Banque;
import financier.FinancierDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author antho
 */
@Stateless
public class BeanBanque implements InterfaceBanque{

    @Override
    public String getMessage(){
        return "Hello World";
    }
    
    @Override
    public String showMessage(String message){
        Banque banque = new Banque();
        return banque.showMessage(message);
    }

    @Override
    public String getget() throws SQLException {
        Connection con = FinancierDB.getConnection();
        return "Coco";
    }
    
    


}
