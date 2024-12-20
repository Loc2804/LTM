<%@page import="Model.BEAN.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Model.BEAN.Food"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<style type="text/css">
	 body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        overflow: hidden;
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
.content {
	margin: 20px auto;
	width: 90%;
	max-width: 1200px;
}

.table-container {
	margin: 40px auto;
	width: 100%;
	border-collapse: collapse;
	text-align: left;
	background-color: white;
	border-radius: 8px;
	overflow: hidden;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.table-container th, .table-container td {
	padding: 12px 18px;
	border-bottom: 1px solid #ddd;
}

.table-container th {
	background-color: #007BFF;
	color: white;
}

.table-container tr:nth-child(even) {
	background-color: #f9f9f9;
}

.table-container tr:hover {
	background-color: #f1f1f1;
}

@media ( max-width : 768px) {
	.navbar {
		flex-direction: column;
		align-items: center;
	}
	.navbar .links {
		flex-direction: column;
		gap: 10px;
	}
	.table-container {
		width: 100%;
	}
	.btn {
		font-size: 16px;
		padding: 10px 16px;
	}
}
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
          	<a href="MenuUser.jsp">Menu</a> 
           	<a href="OrderTable.jsp">Order Table</a>
       </div>
        <div class="group-btn">
            <a href="Login.jsp">Đăng nhập</a>
            <a href="Register.jsp">Đăng ký</a>
        </div>
     </div>
        <% }
        	else{
        %>
        <div class="navbar">
	       <div class="links">
	          	<a href="WelcomeUser.jsp">Home Page</a> 
          		<a href="MenuUser.jsp">Menu</a> 
           	<a href="TablesController?action=order">Order Table</a>
           	<a href="BookingController?action=history">Order History</a>


	       </div>
	        <form action="AuthController" method="post">
	        	<div class="welcome-user">
	        		<span>Xin chào, <%=user.getFullName() %></span>
	            	<button class="btn-logout" type="submit">Đăng xuất</button>
	            	<input  type="hidden" value="logout" name="action">
	        	</div>
	        </form>
        </div>
       <%
        	}
       %>
       <div class="content">
		<h1>Menu Food</h1>
		<table class="table-container">
			<thead>
				<tr>
					<th>STT</th>
					<th>Name Food</th>
					<th>Price</th>
					<th>Food Description</th>
				</tr>
			</thead>
			<tbody>
				<%
				int stt = 0;
				List<Food> foodList = (List<Food>) session.getAttribute("menu");
				if (foodList != null) {
					for (Food food : foodList) {
				%>
				<tr>
					<td><%=++stt%></td>
					<td><%=food.getFood()%></td>
					<td><%=food.getPrice()%> đ</td>
					<td><%=food.getDescription()%></td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="4">Không có dữ liệu</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             