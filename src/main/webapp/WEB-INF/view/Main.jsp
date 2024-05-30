<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>BARBER'S SERVICES</title>

    <script>
        function sortBarbers(sortBy) {
            window.location.href = 'sortBarbers?sortBy=' + sortBy;
        }
    </script>

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
<h1> ALL BARBERS:</h1>
<input type="button" value="create new Barber" onclick="window.location.href='createBarber'">
<table>
    <tr>
        <th>
            FIRST NAME
            <input type="button" value="(Sort)" onclick="sortBarbers('firstName')">
        </th>
        <th>
            LAST NAME
            <input type="button" value="(Sort)" onclick="sortBarbers('lastName')">
        </th>
        <th>DATE OF BIRTH</th>
        <th>PHONE</th>
        <th>EMAIL</th>
        <th>SERVICES</th>
        <th>OPERATIONS</th>
    </tr>
    <c:forEach var="barber" items="${barber}">
        <tr>
            <td>${barber.firstName}</td>
            <td>${barber.lastName}</td>
            <td>${barber.getAge()}</td>
            <td>${barber.phone}</td>
            <td>${barber.email}</td>
            <td>
                <c:forEach var="service" items="${barber.services}">
                    ${service.title}<br>
                </c:forEach>
            </td>

            <td>
                <form action="editBarber" method="get" style="display:inline;">
                    <input type="hidden" name="id" value="${barber.id}">
                    <input type="submit" value="Edit Barber">
                </form>
                <form action="deleteBarber" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${barber.id}">
                    <input type="submit" value="Delete Barber" onclick="return confirm('Are you sure you want to delete this barber?');">
                </form>

                <form action="editServiceBarber" method="post">
                    <input type="hidden" name="barberId" value="${barber.id}">
                    <input type="hidden" name="firstName" value="${barber.firstName}">
                    <input type="hidden" name="lastName" value="${barber.lastName}">
                    <input type="submit" value="Upgrade">
                </form>
            </td>


        </tr>
    </c:forEach>

</table>
<input type="button" value="Service Form" onclick="window.location.href='showService'">
<input type="button" value="Client Form" onclick="window.location.href='showClient'">
<input type="button" value="Appointment Form" onclick="window.location.href='showAppointment'">
<input type="button" value="Transaction Form" onclick="window.location.href='showTransaction'">
</body>
</html>
