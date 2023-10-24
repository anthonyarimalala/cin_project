/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import financier.Banque;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservice.Personne;

/**
 *
 * @author antho
 */
public class SupprimerBanqueServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Banque banque = new Banque();
        try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("id_banque");
            int id_banque = Integer.parseInt(id);
            try{
                Banque.deleteBanque(id_banque);
                String search = request.getParameter("cin");
                try{
                    List<Banque> banquee = banque.findBanque(search);
                    List<Personne> personnes = Personne.findPersonne(search);
                    request.setAttribute("personnes", personnes);
                    request.setAttribute("banques", banquee);
                     try{
                        request.setAttribute("cin", personnes.get(0).getCin()+": ");
                    }catch(Exception e){
                        request.setAttribute("cin", "No CIN found!");
                    }
                    RequestDispatcher dispatcher = request.getRequestDispatcher("modifFinancier.jsp");
                    dispatcher.forward(request, response);
                }catch(Exception e){
                    e.printStackTrace(out);
                }
            }catch(Exception e){
                e.printStackTrace(out);
            }
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SupprimerBanqueServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SupprimerBanqueServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
