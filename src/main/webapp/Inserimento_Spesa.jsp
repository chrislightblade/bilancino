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

        <form  action="AddSpesa" method="POST">

            <div>Inserire Categoria(Valida)</div>
            <select name="categoria">
                <c:forEach items="${categoriaSrv.findAll()}" var="cat">


                    <option value="${cat.id}" >   <c:out value="${cat.id}"/>  </option>


                </c:forEach>
            </select>
            <br>
            <br>
            <br>
            <div>Inserire Importo</div>

            <input type ="text" style="width: 120px "   size="20" value="" placeholder="importo/00" name="importo" >

            <br>
            <br>
            <br>
            <div>Inserire descrizione</div>

            <input type ="text" style="width: 120px "   size="255" value="" placeholder="Inserire descrizione!" name="descrizione" >
            <br>
            <br>
            <br>
            <input type="submit" value="Invio" name="pulsanteInvio" style="width: 100px ; height: 25px ; font-size:medium"> 


        </form>
    </body>
</html>
