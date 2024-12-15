<%@page import="Model.BEAN.Food"%>
<%@page import="java.util.List"%>
<%@page import="Model.BEAN.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Menu</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
/* Giữ nguyên CSS navbar từ ban đầu */
.navbar {
	background-color: #007BFF;
	display: flex;
	justify-content: space-between;
	padding: 10px 20px;
}

.navbar .links {
	display: flex;
	gap: 20px;
}

.navbar a {
	padding: 8px 16px;
	font-size: 16px;
	color: white;
	text-decoration: none;
}

.navbar a:hover {
	background-color: #0056b3;
	border-radius: 4px;
}

.navbar .group-btn {
	display: flex;
	gap: 10px;
}

.btn, .btn-logout {
	background-color: #007BFF;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	font-size: 18px;
}

.btn:hover, .btn-logout:hover {
	background-color: #0056b3;
}

.btn-logout:focus {
	outline: none;
}

/* Main Content */
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f7f7f7;
}

h1, h2 {
	text-align: center;
	color: #0077b6;
	font-size: 28px;
	padding: 20px 0;
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

/* Responsive Design */
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

.welcome-user span {
	color: white;
}
</style>
</head>
<body>

	<div class="navbar">
		<div class="links">
			<a href="FoodController?action=index">Menu</a> <a
				href="OrderController?action=create">Order Food</a>
		</div>

		<!-- User Login Section -->
		<%
		User user = (User) session.getAttribute("user");
		if (user != null) {
		%>
		<form action="AuthController" method="post">
			<div class="welcome-user">
				<span>XIn chào, <%=user.getFullName()%></span>
				<button class="btn-logout" type="submit">Đăng xuất</button>
				<input type="hidden" value="logout" name="action">
			</div>
		</form>
		<%
		}
		%>
	</div>

	<div class="content">
		<h1>Menu Food</h1>
		<table class="table-container">
			<thead>
				<tr>
					<th>STT</th>
					<th>Name Food</th>
					<th>Price</th>
					<th>Food Description</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<%
				int stt = 0;
				List<Food> foodList = (List<Food>) request.getAttribute("foodList");
				if (foodList != null) {
					for (Food food : foodList) {
				%>
				<tr>
					<td><%=++stt%></td>
					<td><%=food.getFood()%></td>
					<td><%=food.getPrice()%> đ</td>
					<td><%=food.getDescription()%></td>
					<td><%=food.getStatus().getName()%></td>
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

	<script type="text/javascript">
		function viewFoodInfo(id, name, price, status) {
			alert('Xem chi tiết món ăn: ' + name);
		}
	</script>

</body>
</html>
