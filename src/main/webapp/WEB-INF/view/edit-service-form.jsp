<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SERVICES FORM</title>
    <style>
    </style>
</head>
<body>
<h1>SERVICES FORM</h1>
<p>Editing service for barber: ${param.firstName} ${param.lastName}</p>
<form action="saveBarberServices" method="post">
    <input type="hidden" name="barberId" value="${barberId}">
    <table>
        <tr>
            <th>TITLE</th>
            <th>SELECT</th>
        </tr>
        <c:forEach var="tech" items="${allServices}">
            <tr>
                <td>${tech.title}</td>
                <td>
                    <input type="checkbox" name="serviceIds" value="${tech.id}"
                           <c:if test="${barberServices.contains(tech)}">checked</c:if>>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Save">
</form>
</body>
</html>