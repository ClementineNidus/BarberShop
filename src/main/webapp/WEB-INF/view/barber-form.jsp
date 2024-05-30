<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CREATING TEACHER</title>
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
<h1>Create or Edit Barber</h1>
<c:if test="${not empty errorMessage}">
    <div class="error">${errorMessage}</div>
</c:if>
<form:form action="saveBarber" modelAttribute="barber">
    <form:hidden path="id" />
    <div>
        <form:input path="firstName" placeholder="first name"/>
    </div>
    <div>
        <form:input path="lastName" placeholder="last name"/>
    </div>
    <div>
        <form:input path="dateOfBirth" placeholder="dateOfBirth"/>
    </div>
    <div>
        <form:input path="phone" placeholder="phone"/>
    </div>
    <div>
        <form:input path="email" placeholder="email"/>
    </div>
    <input type="submit" value="ok"/>
</form:form>
</body>
</html>