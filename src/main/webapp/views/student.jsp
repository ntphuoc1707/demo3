<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Student list</title>
        <style>
            table,
            th,
            td {
                border: 1px solid black;
            }
        </style>
    </head>

    <body>
        <h1>Student list</h1>
        <!-- Display students in a table-->
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.getId()}</td>
                    <td>${student.getName()}</td>
                    <td><a href="http://localhost:8082/students/${student.getId()}">Detail</a></td>
                </tr>
            </c:forEach>
        </table>

    </body>

    </html>