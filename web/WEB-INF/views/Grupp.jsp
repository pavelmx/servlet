

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GruppList</title>
    </head>
    <body>
        <h1>ngfn</h1>
        
        <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>shifr</th>
          <th>nazvanie</th>
          <th>dataFormir</th>
          <th>kodPlana</th>
          <th>status</th>
          <th>statusDate</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${gruppList}" var="gr" >
          <tr>
             <td>${gr.shifr}</td>
             <td>${gr.nazvanie }</td>
             <td>${gr.dataFormir}</td>
             <td>${gr.kodPlana}</td>
             <td>${gr.status}</td>
             <td>${gr.statusDate}</td>
             <td>
             <a href="editProduct?code=${gr.shifr}">Edit</a>
             </td>
             <td>
                <a href="deleteProduct?code=${gr.shifr}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
        
    </body>
</html>
