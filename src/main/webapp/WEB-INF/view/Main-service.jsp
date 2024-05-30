<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SERVICES</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        h1 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        input[type="button"] {
            background-color: #4caf50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="button"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1> ALL SERVICES:</h1>
<input type="button" value="create new Service" onclick="window.location.href='createService'">
<table>
    <tr>
        <th>TITLE</th>
        <th>DESCRIPTION</th>
        <th>PRICE</th>
        <th>OPERATIONS</th>


    </tr>
    <c:forEach var="service" items="${service}">
        <tr>
            <td>${service.title}</td>
            <td>${service.description}</td>
            <td>${service.price}</td>


            <td>
                <form action="editService" method="get" style="display:inline;">
                    <input type="hidden" name="id" value="${service.id}">
                    <input type="submit" value="Edit Service">
                </form>
                <form action="deleteService" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${service.id}">
                    <input type="submit" value="Delete Service" onclick="return confirm('Are you sure you want to delete this service?');">
                </form>


            </td>


        </tr>
    </c:forEach>

</table>


<input type="button" value="Client Form" onclick="window.location.href='showClient'">
<input type="button" value="Appointment Form" onclick="window.location.href='showAppointment'">
<input type="button" value="Transaction Form" onclick="window.location.href='showTransaction'">
<!--
<input type="button" value="create/upgrade new Technology" onclick="window.location.href='createTechnology'">
-->
</body>
