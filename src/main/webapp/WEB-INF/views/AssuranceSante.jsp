<%--
  Created by IntelliJ IDEA.
  User: Maha
  Date: 10/24/2024
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter une Assurance Santé</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/assuranceStyle.css">
</head>
<body>
<div class="container">
    <h1>Ajouter une Assurance Santé</h1>

    <form action="${pageContext.request.contextPath}/assurancesante/createsante" method="post">

        <div class="form-group">
            <label for="age">Âge:</label>
            <input type="number" id="age" name="age" required>
        </div>


        <div class="form-group">
            <label for="etatSante">État de Santé:</label>
            <input type="text" id="etatSante" name="etatSante" required>
        </div>

        <div class="form-group">
            <label for="typeDeCouverture">Type de Couverture:</label>
            <select id="typeDeCouverture" name="typeDeCouverture" required>
                <option value="basic">Basic</option>
                <option value="premium">Premium</option>
            </select>
        </div>

        <!-- Submit Button -->
        <div class="form-group">
            <input type="submit" value="Ajouter Assurance Santé">
        </div>
    </form>

    <!-- Display Success Message -->
    <c:if test="${not empty param.message}">
        <div class="message">${param.message}</div>
    </c:if>
</div>
</body>
</html>
