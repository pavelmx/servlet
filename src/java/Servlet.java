

import entity.Gruppyi;
import entity.Studentyi;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Init;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import services.BeanLocal;

/**
 *
 * @author Marchuk_15686
 */
public class Servlet extends HttpServlet {

    @EJB BeanLocal b;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=windows-1251");
        PrintWriter out = response.getWriter();
        String enteredValue;
        String[] selectedOptions = request.getParameterValues("options");
        enteredValue = request.getParameter("enteredValue");
        PrintWriter printWriter;
     
        try{
            
            
            List<Gruppyi> gr=b.PrintGrupp();
            List<Studentyi> st=b.PrintGrupp();
           // List<Studentyi> delst=en.Delete();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            //out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"jsfcrud.css\">");
            out.println("<title>EJB</title>"); 
            out.println("Table: Studentyi");
            out.println("</br>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"post\" action=\"Servlet\">");
            out.println("</br>");
            out.println("<table border=1>");
            out.println("<tr><th>Familiya</th><th>Name</th><th>Patronimic</th><th>Kod</th><th>Options</th></tr");
            printWriter = response.getWriter();
           
            for (Studentyi u : st)
     {
            out.println("<tr>");
            out.println("<td width=100>"+u.getFamiliya()+"</td>" + 
                    " "+ "<td width=100>"+u.getImya()+"</td>" + 
                    " " + "<td width=100>"+u.getOtchestvo()+"</td>"+
                   " "+"<td width=100>"+u.getNomerZachetki()+"</td>"+
                    " " + "<td width=100></td>");
            out.println("</tr>");
     }
            out.println("</table>");
            out.println("</br>");
            out.println("<input type=\"button\" onclick=\"history.back();\" value=\"Назад\"/>\n");
            out.println("</form>");
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

    /*@Override
    public ServletConfig getServletConfig() {
        return ServletConfig;
    }*/
    
}
