<%@page import="Model.BEAN.OrderFood"%>
<%@page import="Model.BEAN.OrderFood"%>
<%@page import="java.util.List"%>
<%@page import="Model.BEAN.Order"%>
<%@page import="Model.BEAN.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Order Details</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
/* CSS kế thừa từ Order Manager */
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f7f7f7;
}

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

h1, h2 {
	text-align: center;
	color: #0077b6;
}

h3 {
	text-decoration: underline;
}

.table-container {
	margin: 40px auto;
	width: 80%;
	border-collapse: collapse;
	text-align: left;
}

.table-container th, .table-container td {
	border: 1px solid #ccc;
	padding: 10px;
}

.table-container th {
	background-color: #007BFF;
	color: white;
}

.action-icons {
	font-size: 18px;
	margin: 0 10px;
}

.btn-back {
	display: flex;
	align-items: center;
	justify-content: center;
	margin-top: 20px;
}

.btn {
	background-color: #007BFF;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	font-size: 18px;
	cursor: pointer;
}

.btn:hover {
	background-color: #0056b3;
}

.btn-back {
	display: flex;
	align-items: center;
	justify-content: center;
	margin-bottom: 30px;
}

.icon-action {
	display: flex;
}

.welcome-user {
	display: flex;
	gap: 20px;
}

.welcome-user span {
	color: white;
	margin-top: 7px;
	font-size: 20px;
}

.content {
	text-align: center;
	margin-bottom: 50px;
}
</style>
</head>

<body>
	<div class="navbar">
		<div class="links">
			<a href="FoodController?action=index">Menu</a> <a
				href="OrderController?action=create">Order Food</a>
				<a
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
	<%
	// Lấy thông tin đơn hàng và chi tiết đơn hàng từ request
	Order order = (Order) request.getAttribute("order");
	List<OrderFood> orderDetails = (List<OrderFood>) request.getAttribute("orderFoodList");

	if (order == null) {
	%>
	<h1>No Order Data Found</h1>
	<div class="btn-back">
		<a href="OrderManager.jsp"><button class="btn">Return</button></a>
	</div>
	<%
	} else {
	%>
	<h1>Order Details</h1>
	<div class="content">
		<h3>Order Information</h3>
		<p>
			<strong>Order ID:</strong>
			<%=order.getId()%></p>
		<p>
			<strong>Table Name:</strong>
			<%=order.getTable().getNumber()%></p>
		<p>
			<strong>Payment Method:</strong>
			<%=order.getPayment()%></p>
		<p>
			<strong>Total Amount:</strong>
			<%=order.getTotal()%>
			đ
		</p>
	</div>

	<h2>Items in Order</h2>
	<table class="table-container">
		<thead>
			<tr>
				<th>Food Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<%
			if (orderDetails != null && !orderDetails.isEmpty()) {
				for (OrderFood item : orderDetails) {
			%>
			<tr>
				<td><%=item.getFood().getFood()%></td>
				<td><%=item.getFood().getPrice()%></td>
				<td><%=item.getNumber()%></td>
				<td><%=item.getNumber() * item.getFood().getPrice()%> đ</td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="4">No items found in this order.</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<div class="btn-back">
		<a href="OrderManager.jsp"><button class="btn">Return</button></a>
	</div>
	<%
	}
	%>
</body>

</html>