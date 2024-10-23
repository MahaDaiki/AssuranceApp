<%--
  Created by IntelliJ IDEA.
  User: Maha
  Date: 10/22/2024
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Assurance App</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
<h1>${message}</h1>

<div class="button-container">
  <a class="button" href="${pageContext.request.contextPath}/auth/login">Login</a>
  <a class="button" href="${pageContext.request.contextPath}/auth/register">Register</a>
</div>
</body>
</html>
