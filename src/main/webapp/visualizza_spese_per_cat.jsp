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

        <form  action="visualizza_spese_per_cat.jsp" method="GET">
            <div>Inserire Categoria(Valida)</div>
            <select name="categoria">
                <option>scegli una categoria</option>
                <c:forEach items="${categoriaSrv.findAll()}" var="cat">

                    <c:if test="${param.categoria eq cat.id}">
                        <option value="${cat.id}" selected>   <c:out value="${cat.id}"/>  </option>
                    </c:if>

                    <c:if test="${param.categoria != cat.id}">
                        <option value="${cat.id}" >   <c:out value="${cat.id}"/>  </option>
                    </c:if>

                </c:forEach>
            </select>

            <select name="tempo">

                <option>scegli un periodo di tempo</option>
                <option value="7gg" >7 Giorni</option>
                <option value="1mese" >1 Mese</option>
                <option value="tutto" >tutte</option>


            </select>


            <input type="submit" value="Invio" name="PulsanteInvio" style="width: 100px ; height: 25px ; font-size:medium">             
        </form>

        <table style="margin: 0 auto">

            <th>Categoria</th>
            <th>Importo</th>
            <th>Data Creazione</th>
            <th>Descrizione</th>


            <c:forEach items="${speseSrv.scegli(param.tempo,param.categoria)}" var="spese"> 
                
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
