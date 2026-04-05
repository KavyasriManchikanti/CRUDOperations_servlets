<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style> body { text-align: center; } .btn-container { margin-top: 30px; } button { padding: 10px 20px; margin: 10px; font-size: 16px; cursor: pointer; } </style>
<script>
        function loadPage(page) {
            fetch(page)
            .then(function(res) {
                return res.text();
            })
            .then(function(data) {
                document.getElementById("content").innerHTML = data;
            })
            .catch(function(error) {
                console.log("Error:", error);
            });
        }
    </script>
</head>
<body>

<h2>CRUD Operations</h2>
</br>
</br>
<button onclick="loadPage('register.jsp')">Register</button>
<button onclick="loadPage('update.jsp')">Update</button>
<button onclick="loadPage('delete.jsp')">Delete</button>
<button onclick="loadPage('retrieve.jsp')">Retrieve</button>

<div id="content"></div>
</body>
</html>