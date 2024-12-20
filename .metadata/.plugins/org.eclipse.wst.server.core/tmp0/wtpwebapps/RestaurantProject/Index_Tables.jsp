<%@page import="Model.BEAN.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Bàn</title>
    <style>
       body {
           font-family: Arial, sans-serif;
	        margin: 0;
	        padding: 0;
        }
        .header {
            text-align: center;
            margin-bottom: 30px;
        }
        .header h1 {
            font-size: 28px;
            color: #333;
        }
        .button-container {
            text-align: center;
            margin-bottom: 20px;
        }
        .button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            margin: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }
        .button:hover {
            background-color: #45a049;
        }
         h1{
    	text-align: center;
    }
    .navbar {
        background-color: #007BFF; /* Màu xanh chủ đạo */
        overflow: hidden;
        display: flex;
        justify-content: space-between;
        padding: 10px 20px;
    }
    .navbar a {
        color: white;
        text-decoration: none;
        padding: 8px 16px;
        font-size: 16px;
    }
    .navbar a:hover {
        background-color: #0056b3; /* Màu xanh đậm hơn khi hover */
        border-radius: 4px;
    }
    .links {
        display: flex;
        gap: 20px;
    }
    .content {
        margin: 20px;
    }
    .content a {
        display: inline-block;
        background-color: #007BFF; /* Màu nền xanh chủ đạo */
        color: white;
        text-decoration: none;
        padding: 10px 20px;
        border-radius: 5px;
        margin: 5px 0;
        font-size: 18px;
    }
    .content a:hover {
        background-color: #0056b3; /* Màu nền xanh đậm hơn khi hover */
    }
    .btn-logout {
        background-color: #007BFF; /* Màu nền xanh chủ đạo */
        color: white; /* Màu chữ */
        text-decoration: none;
        padding: 10px 20px; /* Khoảng cách bên trong */
        border: none; /* Bỏ viền */
        border-radius: 5px; /* Bo góc */
        font-size: 18px; /* Kích thước chữ */
        cursor: pointer;
    }

    .btn-logout:hover {
        background-color: #0056b3; 
    }

    .btn-logout:focus {
        outline: none; /* Bỏ viền focus mặc định */
    }
    .group-btn{
    	margin-top:10px;
    }
    .welcome-user{
    	display: flex;
    	gap:20px;
    }
    .welcome-user span{
	color: white;
	margin-top:7px;
	font-size: 20px;
    </style>
</head>
<body>
<%
        	User user = (User) session.getAttribute("user");
        	if(user == null || user.getRole() == null){
        %>
      <div class="navbar">
       <div class="links">
           <a href="WelcomeUser.jsp">Home Page</a>
           <a href="WelcomeAdmin.jsp">Admin Page</a>
       </div>
        <div class="group-btn">
            <a href="Login.jsp">Đăng nhập</a>
            <a href="Register.jsp">Đăng ký</a>
        </div>
     </div>
     <div class="content">
       	<h1>Bạn cần đăng nhập để thực hiện chức năng này</h1>
   	</div>
        <% }
        	else{
        %>
        <div class="navbar">
	       <div class="links">
	           <a href="WelcomeUser.jsp">Home Page</a>
	           <a href="WelcomeAdmin.jsp">Admin Page</a>
	       </div>
	        <form action="AuthController" method="post">
	        	<div class="welcome-user">
	        		<span>Xin chào, <%=user.getFullName() %></span>
	            	<button class="btn-logout" type="submit">Đăng xuất</button>
	            	<input  type="hidden" value="logout" name="action">
	        	</div>
	        </form>
        </div>
        <div class="header">
        <h1>Quản Lý Bàn</h1>
    </div>

    <div class="button-container">
        <!-- Nút Create Table -->
        <a href="TablesController?action=create" class="button">Create Table</a>
        <!-- Nút View Tables -->
        <a href="TablesController?action=view" class="button">View Tables</a>
        <!-- Nút Search Table -->
        <a href="TablesController?action=search" class="button">Search Table</a>
        <!-- Nút Delete Table -->
        <a href="TablesController?action=delete" class="button">Delete Table</a>
        <!-- Nút Update Table -->
        <a href="TablesController?action=update" class="button">Update Table</a>
        <!-- Nút Quay lại -->
        <a href="WelcomeAdmin.jsp" class="button" style="background-color: #007BFF;">Return</a>
    </div>
        <%
        	}
        %>
    
</body>
</html>
