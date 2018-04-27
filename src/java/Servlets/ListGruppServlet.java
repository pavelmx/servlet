package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entity.Gruppyi;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ServicesBean;
import services.ServicesInterfaces;


/**
 *
 * @author павел
 */
@WebServlet(urlPatterns = { "/GruppList" })
public class ListGruppServlet extends HttpServlet {
@EJB
 ServicesInterfaces ServicesBean;
private static final long serialVersionUID = 1L;
 
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServicesBean en =new ServicesBean();
        List<Gruppyi> list = null;
       list = en.Print();
        
        request.setAttribute("gruppList", list);
        
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/Grupp.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
  
}

