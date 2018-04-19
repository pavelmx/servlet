/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.Init;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marchuk_15686
 */
public class Servlet extends HttpServlet {

   private String ServletParam;
   private int cnt=1;
   private int w;
   
 
    @Override
public void init(ServletConfig config) throws ServletException {
   super.init(config);
  
        ServletParam = config.getInitParameter("servletParam");
       w++;
      
}

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=windows-1251");
        PrintWriter out = response.getWriter();
        String enteredValue;
        String[] selectedOptions = request.getParameterValues("options");
        enteredValue = request.getParameter("enteredValue");
        PrintWriter printWriter;
        try{
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Привет</title>");            
            out.println("</head>");
            out.println("<body>");
            printWriter = response.getWriter();
            printWriter.print("parametr " + ServletParam + " connect: " + w + "</p>");
            printWriter.print("count connect "+cnt);
            printWriter.print("<p>Вы ввели:");
            printWriter.print(enteredValue);
            printWriter.print("</p>");
            printWriter.print("<p>Было выбрано:");
            printWriter.print("<br/>");
            if(selectedOptions != null){
                for(String option : selectedOptions){
                    printWriter.print(option);  
                    printWriter.print("<br/>"); 
            }
            }else{
            printWriter.print("Ничего");
            }
            printWriter.println("</p>");
            out.println("</body>");
            out.println("</html>");
        }finally{
        out.close();
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
         cnt++;
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

    /*@Override
    public ServletConfig getServletConfig() {
        return ServletConfig;
    }*/
    
}
