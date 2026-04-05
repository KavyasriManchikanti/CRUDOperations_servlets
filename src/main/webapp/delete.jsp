<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
<style>
    form {
        display: flex;
        flex-direction: column;
        gap: 10px;
    }

    input {
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    button {
        background-color: green;
        color: white;
        padding: 10px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    button:hover {
        background-color: darkgreen;
    }
</style>

</head>
<body>

<form action="userServlet" method="post">
    <input type="hidden" name="action" value="delete"/>

    <input type="tel" name="phone" placeholder="Enter Phone (Primary Key)" required/>

    <button type="submit">Delete User</button>
</form>
</body>
</html>