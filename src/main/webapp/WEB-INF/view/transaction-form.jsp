<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CREATING/EDITING TRANSACTIONS</title>
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
<h1>Create or Edit Transaction</h1>

<form:form action="saveTransaction" modelAttribute="transaction">
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
        <form:label path="amount">Amount</form:label>
        <form:input path="amount" placeholder="amount"/>
    </div>
    <div>
        <form:label path="type">Type</form:label>
        <form:input path="type" placeholder="type"/>
    </div>
    <div>
        <form:label path="appointment.id">Appointment</form:label>
        <form:select path="appointment.id">
            <form:options items="${appointment}" itemValue="id" itemLabel="note"/>
        </form:select>
    </div>

    <input type="submit" value="ok"/>
</form:form>




</body>
</html>


