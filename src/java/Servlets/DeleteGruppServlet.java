/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ServicesBean;

/**
 *
 * @author павел
 */
public class DeleteGruppServlet extends HttpServlet {

    public ServicesBean ServicesBean;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      String shifr = (String)request.getParameter("shifr");
        
        ServicesBean.Delete(shifr);
         response.sendRedirect(request.getContextPath() + "/GruppList");
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);;
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
