/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import financier.Banque;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservice.Cours;

/**
 *
 * @author antho
 */
public class TransactionServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
                String cin = request.getParameter("cin");
                float solde = Float.parseFloat(request.getParameter("solde"));
                int id_banque_send = Integer.parseInt(request.getParameter("id_banque"));
                int id_banque_receive = Integer.parseInt(request.getParameter("id_banque_receive"));
                String unite = request.getParameter("symbole");
                double montant = Double.parseDouble(request.getParameter("montant"));
                Cours cours = Cours.selectCours(unite);
                
                double courss = cours.getValeurAriary();
                double coursVente = cours.getTauxVente();
                
                double vente = montant*coursVente;
                float echangeVente = (float) vente;

                double achat = montant*courss;
                float echange = (float) achat;
                
                if(achat>solde){
                    out.println("Vous ne possedez pas ce montant!");
                    
                }else if(achat<0){
                    out.println("Montant negatif! impossible!");
                }else{
                    Banque.transaction(id_banque_send, id_banque_receive, echange, echangeVente);
                    response.sendRedirect("FirstServlet?search="+cin);
                }
                
            }catch(Exception e){
                e.printStackTrace(out);
            }
            
            
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
