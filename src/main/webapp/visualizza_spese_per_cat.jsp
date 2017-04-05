<%-- 
    Document   : visualizza_spese_per_cat
    Created on : 5-apr-2017, 12.26.18
    Author     : tss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form  action="AddSpesa" method="GET">

            <div>Inserire Categoria(Valida)</div>
            <select name="categoria">
                <c:forEach items="${categoriaSrv.findAll()}" var="cat">


                    <option value="${cat.id}" >   <c:out value="${cat.id}"/>  </option>


                </c:forEach>
            </select>

            <table style="margin: 0 auto">

                <th>Categoria</th>
                <th>Importo</th>
                <th>Data Creazione</th>
                <th>Descrizione</th>


                <c:forEach items="${speseSrv.findSpeseByCategoriaAnd7Gg()}" var="spese">

                    <tr>
                        <td>   <c:out value="${spese.categoria.id}"/>  </td>
                    <td>   <c:out value="${spese.importo}"/>  </td>
                    <td>   <c:out value="${spese.dataCreazione}"/>  </td>
                    <td>   <c:out value="${spese.descrizione}"/>  </td>

                    </tr>
                </c:forEach>

            </table>
        </form>
    </body>
</html>
