<%--
  Created by IntelliJ IDEA.
  User: Maha
  Date: 10/23/2024
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Assurance Auto</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/assuranceStyle.css">
</head>
<body>
<div class="container">
    <h1>Ajouter une Assurance Auto</h1>

    <form action="${pageContext.request.contextPath}/assuranceauto/createauto" method="post">

        <div class="form-group">
            <label for="ageConducteur">Âge du Conducteur:</label>
            <input type="number" id="ageConducteur" name="ageConducteur" required>
        </div>


        <div class="form-group">
            <label for="Utilisationvehicule">Utilisation du Véhicule:</label>
            <input type="text" id="Utilisationvehicule" name="Utilisationvehicule" required>
        </div>


        <div class="form-group">
            <label for="vehicule">Véhicule:</label>
            <select id="vehicule" name="vehiculeId" required>
                <c:forEach var="vehicule" items="${vehicules}">
                    <option value="${vehicule.id}">
                            ${vehicule.marque} - ${vehicule.model} - ${vehicule.type}
                    </option>
                </c:forEach>
            </select>
        </div>


        <div class="form-group">
            <input type="submit" value="Ajouter Assurance Auto">
        </div>
    </form>


    <c:if test="${not empty param.message}">
        <div class="message">${param.message}</div>
    </c:if>
</div>
</body>
</html>


