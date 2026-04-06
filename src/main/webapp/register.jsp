<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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


<form action="/userServlet" method="post">
    <input type="hidden" name="action" value="register"/>
    
    <input type="text" name="name" placeholder="Enter Name" required/>
    <input type="email" name="email" placeholder="Enter Email" required/>
    <input type="tel" name="phone" placeholder="Enter Phone" required/>
    
    <button type="submit">Register</button>
</form>
</body>
</html>
