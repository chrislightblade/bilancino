<%-- 
    Document   : BilancinoUtente
    Created on : 3-apr-2017, 9.40.54
    Author     : tss
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elenco Transazioni Utente</title>
    </head>
    <body>
        
       <table style="margin: 0 auto">
            
            <th>Categoria</th>
            <th>Importo</th>
            <th>Data Creazione</th>
            <th>Descrizione</th>
            
            <!--  
            
                Ci permette di visualizzare le transazioni del tipo.
            
            -->
            <c:forEach items="${speseSrv.findSpeseById()}" var="spese">
              
            <tr>
                <td>   <c:out value="${spese.categoria.id}"/>  </td>
                <td>   <c:out value="${spese.importo}"/>  </td>
                <td>   <c:out value="${spese.dataCreazione}"/>  </td>
                <td>   <c:out value="${spese.descrizione}"/>  </td>
                
            </tr>
            </c:forEach>
        </table>
        
        
        
        
    </body>
</html>
