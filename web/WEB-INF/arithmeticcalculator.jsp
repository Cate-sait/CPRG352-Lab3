<%-- 
    Document   : arithmeticcalculator
    Created on : 23-Sep-2021, 9:12:03 PM
    Author     : Ya-Yun Haung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="POST" action="arithmetic">
            <label>First: </label>
            <input type="text"  name="v1" value="${v1}">
            <br>
            <label>Second: </label>
            <input type="text"  name="v2" value="${v2}">
            <br>
            <input type="submit" value="+" name="add"> 
            <input type="submit" value="-" name="subtract"> 
            <input type="submit" value="*" name="multiply"> 
            <input type="submit" value="%" name="modulur"> 
        </form>
        <p>${message}</p>
        
        <a href="age">Age Calculator</a>

    </body>
</html>
