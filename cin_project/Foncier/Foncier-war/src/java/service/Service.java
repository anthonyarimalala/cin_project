/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author antho
 */
@Stateless
@Path("/Service")
public class Service {
    @GET
    public String getService(){
        return "Voici le service";
    }
    
}