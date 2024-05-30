<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CREATING SERVICE</title>
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
<h1>Create or Edit Service</h1>

<form:form action="saveService" modelAttribute="service">
    <form:hidden path="id" />
    <div>
        <form:input path="title" placeholder="title"/>
    </div>
    <div>
        <form:input path="description" placeholder="description"/>
    </div>
    <div>
        <form:input path="price" placeholder="price"/>
    </div>
    <input type="submit" value="ok"/>
</form:form>
</body>
</html>
