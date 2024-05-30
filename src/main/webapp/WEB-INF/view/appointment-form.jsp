<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CREATING/EDITING APPOINTMENTS</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        h1 {
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
        }

        div {
            margin-bottom: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Create or Edit Appointment</h1>

<form:form action="saveAppointment" modelAttribute="appointment">
    <form:hidden path="id" />
    <div>
        <form:label path="date_time">Date</form:label>
        <form:input path="date_time" placeholder="yyyy-MM-dd"/>
    </div>
    <div>
        <form:label path="time">Time</form:label>
        <form:input path="time" placeholder="HH:mm:ss"/>
    </div>
    <div>
        <form:label path="note">Note</form:label>
        <form:input path="note" placeholder="note"/>
    </div>
    <div>
        <form:label path="barber.id">Barber</form:label>
        <form:select path="barber.id">
            <form:options items="${barbers}" itemValue="id" itemLabel="firstName"/>
        </form:select>
    </div>
    <div>
        <form:label path="client.id">Client</form:label>
        <form:select path="client.id">
            <form:options items="${clients}" itemValue="id" itemLabel="firstName"/>
        </form:select>
    </div>
    <input type="submit" value="ok"/>
</form:form>
</body>
</html>
