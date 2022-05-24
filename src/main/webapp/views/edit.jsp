<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Information</title>

    <style>
    </style>
</head>
<body>
    <h1>Edit Information</h1>
    <form:form action="./update"  method="post"
        modelAttribute="student">
        <div>
            <h3 style="width:fit-content ;">Name:</h3>
            <form:input type="text" value="${student.getName()}" path="name"/>
        </div>
        
        <div>
            <h3>Mark:</h3>
            <form:input type="number" step="any" value="${student.getMark()}" path="mark"/>
        </div>

        <div>
            <h3>Address:</h3>
            <form:input type="text" value="${student.getAddress()}" path="address"/>
        </div>

        <div>
            <h3>Image:</h3>
            <form:input type="text" value="${student.getImage()}" path="image"/>
        </div>

        <div>
            <h3>Note:</h3>
            <form:input type="text" value="${student.getNote()}" path="note"/>
        </div>

        <div>
            <h3>Class: </h3>
            <form:select path="idclass">
                <c:forEach var="cl" items="${classes}">
                    <option value="${cl.getId()}">${cl.getName()}</option>
                </c:forEach>
            </form:select>
        </div>
        <input type="submit" value="update">

    </form:form>
</body>
</html>