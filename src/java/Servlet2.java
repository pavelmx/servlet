/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import services.ServicesBean;
import entity.Gruppyi;
import entity.Studentyi;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author павел
 */
public class Servlet2 extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
        response.setContentType("text/html;charset=windows-1251");
        PrintWriter out = response.getWriter();
        String enteredValue;
        String[] selectedOptions = request.getParameterValues("options");
        enteredValue = request.getParameter("enteredValue");
        PrintWriter printWriter;
     
        try{
            
            ServicesBean en =new ServicesBean();
            List<Gruppyi> gr=en.PrintGrupp();
            List<Studentyi> st=en.PrintStud();
             
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            //out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"jsfcrud.css\">");
            out.println("<title>EJB</title>"); 
            out.println("Table: Gruppyi");
            out.println("</br>");
            out.println("</head>");
            out.println("<body>");
            out.println("</br>");
            out.println("<table border=1>");
            out.println("<tr><th>Shifr</th><th>Nazvanie</th><th>Studentyi</th><th>DataFormir</th></tr");
            printWriter = response.getWriter();
           
            for (Gruppyi u : gr)
     {
            out.println("<tr>");
            out.println("<td width=20>"+u.getShifr()+"</td>" + 
                    " "+ "<td width=50>"+u.getNazvanie()+"</td>" + 
                    " " + "<td width=700>"+u.getStudentyiCollection()+"</td>"+
                    " "+"<td width=100>"+u.getDataFormir()+"</td>");
            out.println("</tr>");
     }
            out.println("</table>");
            out.println("</br>");
            out.println("<input type=\"button\" onclick=\"history.back();\" value=\"Назад\"/>\n");
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
