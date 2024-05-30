<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>APPOINTMENTS</title>
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
<h1> ALL APPOINTMENTS:</h1>
<input type="button" value="create new Appointment" onclick="window.location.href='createAppointment'">
<table>
    <tr>
        <th>DATE TIME</th>
        <th>TIME</th>
        <th>NOTE</th>
        <th>CLIENT FIRST NAME</th>
        <th>CLIENT LAST NAME</th>
        <th>BARBER FIRST NAME</th>
        <th>BARBER LAST NAME</th>
        <th>OPERATIONS</th>





    </tr>
    <c:forEach var="appointment" items="${appointment}">
        <tr>
            <td>${appointment.date_time}</td>
            <td>${appointment.time}</td>
            <td>${appointment.note}</td>
            <td>${appointment.client.firstName}</td>
            <td>${appointment.client.lastName}</td>
            <td>${appointment.barber.firstName}</td>
            <td>${appointment.barber.lastName}</td>


            <td>
                <form action="editAppointment" method="get" style="display:inline;">
                    <input type="hidden" name="id" value="${appointment.id}">
                    <input type="submit" value="Edit Appointment">
                </form>
                <form action="deleteAppointment" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${appointment.id}">
                    <input type="submit" value="Delete Appointment" onclick="return confirm('Are you sure you want to delete this appointment?');">
                </form>

            </td>



        </tr>
    </c:forEach>

</table>

<input type="button" value="Service Form" onclick="window.location.href='showService'">
<input type="button" value="Client Form" onclick="window.location.href='showClient'">
<input type="button" value="Transaction Form" onclick="window.location.href='showTransaction'">

<!--
<input type="button" value="create/upgrade new Technology" onclick="window.location.href='createTechnology'">
-->
</body>
</html>
