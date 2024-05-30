<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TRANSACTION</title>
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
<h1> ALL TRANSACTION:</h1>
<input type="button" value="create new Transaction" onclick="window.location.href='createTransaction'">
<table>
    <tr>
        <th>DATE TIME</th>
        <th>TIME</th>
        <th>AMOUNT</th>
        <th>TYPE</th>
        <th>NOTE</th>
        <th>OPERATIONS</th>





    </tr>
    <c:forEach var="transaction" items="${transaction}">
        <tr>
            <td>${transaction.date_time}</td>
            <td>${transaction.time}</td>
            <td>${transaction.amount}</td>
            <td>${transaction.type}</td>
            <td>${transaction.appointment.note}</td>


            <td>
                <form action="editTransaction" method="get" style="display:inline;">
                    <input type="hidden" name="id" value="${transaction.id}">
                    <input type="submit" value="Edit Transaction">
                </form>
                <form action="deleteTransaction" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${transaction.id}">
                    <input type="submit" value="Delete Transaction" onclick="return confirm('Are you sure you want to delete this transaction?');">
                </form>

            </td>



        </tr>
    </c:forEach>

</table>


<input type="button" value="Service Form" onclick="window.location.href='showService'">
<input type="button" value="Client Form" onclick="window.location.href='showClient'">
<input type="button" value="Appointment Form" onclick="window.location.href='showAppointment'">

<!--
<input type="button" value="create/upgrade new Technology" onclick="window.location.href='createTechnology'">
-->
</body>
</html>