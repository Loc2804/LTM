<%@page import="Model.BEAN.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
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
        cursor: pointer; /* Thay đổi con trỏ khi hover */
    }

    .btn-logout:hover {
        background-color: #0056b3; /* Màu nền xanh đậm hơn khi hover */
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
}
    
</style>
</head>
<body>
    <div class="navbar">
        <div class="links">
            <a href="WelcomeUser.jsp">Home Page</a>
            <a href="WelcomeAdmin.jsp">Admin Page</a>
        </div>
        <%
        	User user = (User) session.getAttribute("user");
        	if(user == null || user.getRole() == null){
        %>
        <div class="group-btn">
            <a href="Login.jsp">Đăng nhập</a>
            <a href="Register.jsp">Đăng ký</a>
        </div>
        <% }
        	else{
        %>
        <form action="AuthController" method="post">
        	<div class="welcome-user">
	        		<span>Xin chào, <%=user.getFullName() %></span>
	            	<button class="btn-logout" type="submit">Đăng xuất</button>
	            	<input  type="hidden" value="logout" name="action">
	        </div>
        </form>
        <%
        	}
        %>
    </div>

      <div class="content">
       	<h1>Admin Page</h1>
       	<a href="ManageRole.jsp">Manage Role</a>
       	<a href="ManageUser.jsp">Manage User</a>
       	<a href="ManageStatus.jsp">Manage Status</a>
       	<a href="Index_booking.jsp">Manage Booking</a>
       	<a href="Index_Tables.jsp">Manage Table</a>
       	<a href="FoodController?action=manager">Manage Food</a> 
		<a href="OrderController?action=manager">Manage Order</a>
   	</div>
   	
   		
     
    
</body>
</html>
