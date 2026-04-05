<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update </title>
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
    <input type="hidden" name="action" value="update"/>

    <input type="tel" name="phone" placeholder="Enter Phone (Primary Key)" required/>
    <input type="text" name="name" placeholder="Enter New Name" required/>
    <input type="email" name="email" placeholder="Enter New Email" required/>

    <button type="submit">Update User</button>
</form>
</body>
</html>