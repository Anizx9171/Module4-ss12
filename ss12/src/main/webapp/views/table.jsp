<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 29/11/2023
  Time: 5:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        a {
            margin-right: 5px;
            text-decoration: none;
            color: blue;
        }
        .pagi{
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>birthday</th>
        <th>sex</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="emp">
        <tr>
            <th>${emp.id}</th>
            <th>${emp.name}</th>
            <th>${emp.birthday}</th>
            <th>${emp.sex}</th>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <div class="pagi">
        <div>
            <c:forEach var="i" begin="1" end="${totalPage}">
                <a href="/EmployeeController?page=${i}" >${i}</a>
            </c:forEach>
        </div>
    </div>
</body>
</html>
