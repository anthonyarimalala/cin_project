/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import beanfoncier.InterfaceFoncier;
import financier.Banque;
import foncier.Foncier;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservice.Antecedantt;
import webservice.Info;
import webservice.Personne;

/**
 *
 * @author antho
 */
public class FirstServlet extends HttpServlet {
    
    Banque banque = new Banque();
    
    @EJB
    InterfaceFoncier iff;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String search = request.getParameter("search");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FirstServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
                List<Banque> banques = banque.selectAll();
                List<Banque> banquee = banque.findBanque(search);
                List<Foncier> fonciers = iff.findFoncier(search);
                List<Personne> personnes = Personne.findPersonne(search);
                List<Antecedantt> antecedants = Antecedantt.findAntecedant(search);
                List<Info> infos = Info.findInfo(search);
                
                request.setAttribute("banques", banquee);
                request.setAttribute("fonciers", fonciers);
                request.setAttribute("personnes", personnes);
                request.setAttribute("antecedants", antecedants);
                request.setAttribute("infos", infos);
                
                
                try{
                    request.setAttribute("cin", personnes.get(0).getCin()+": ");
                }catch(Exception e){
                    request.setAttribute("cin", "No CIN found!");
                }
                
                /*out.println("<h2>Message: " + banques.get(0).getBanque() + "</h2>");
                out.println("<h2>Pers: " + banquee.get(0).getBanque() + "</h2>");
                out.println("<h2>Foncier: " + fonciers.get(0).getTerrain() + "</h2>");
                out.println("<h1>interface: " + iff.sayHello() + "</h1>");
                out.println("test");
                */
                
                
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("about.jsp");
                dispatcher.forward(request, response);
                
            }catch(SQLException e){
                out.println("non");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
