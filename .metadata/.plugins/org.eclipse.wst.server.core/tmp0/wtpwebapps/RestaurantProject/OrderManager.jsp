<%@page import="Model.BEAN.Order"%>
<%@page import="java.util.List"%>
<%@page import="Model.BEAN.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Manage Order List</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

h1, h2 {
	text-align: center;
	color: #0077b6;
}

a {
	text-decoration: none;
	color: white;
}

a:hover {
	background-color: #0056b3;
	border-radius: 4px;
}

button {
	cursor: pointer;
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

.content {
	margin: 20px auto;
	width: 80%;
}

.form-container {
	background-color: #fff;
	padding: 30px;
	box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
	border-radius: 12px;
	width: 400px;
	margin: 20px auto;
}

label {
	font-weight: bold;
	display: block;
	margin-bottom: 8px;
}

.input-field, select {
	width: 100%;
	padding: 12px;
	margin: 8px 0 16px;
	border: 1px solid #ddd;
	border-radius: 8px;
	font-size: 14px;
}

.input-field:focus, select:focus {
	border-color: #0077b6;
	box-shadow: 0 0 5px rgba(0, 119, 182, 0.5);
	outline: none;
}

.form-buttons {
	display: flex;
	justify-content: space-between;
	margin-top: 20px;
}

/* Table */
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

.action-icons.edit {
	color: #4CAF50;
}

.action-icons.delete {
	color: #FF5733;
}

.action-icons:hover {
	opacity: 0.7;
}

/* Responsive Design */
@media ( max-width : 768px) {
	.form-container, .content {
		width: 90%;
		padding: 20px;
	}
	.btn {
		font-size: 14px;
		padding: 10px;
	}
}

.btn-back {
	display: flex;
	align-items: center;
	justify-content: center;
	margin-bottom: 30px;
}

.icon-action{
	display: flex;
	justify-content: space-around;
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
</style>
</head>

<body>
	<%
	User user = (User) session.getAttribute("user");
	if (user == null || user.getRole() == null) {
	%>
	<div class="navbar">
		<div class="links">
			<a href="WelcomeUser.jsp">Home Page</a> <a href="WelcomeAdmin.jsp">Admin
				Page</a>
		</div>
		<div class="group-btn">
			<a href="Login.jsp">Đăng nhập</a> <a href="Register.jsp">Đăng ký</a>
		</div>
	</div>
	<div class="content">
		<h1>Bạn cần đăng nhập để thực hiện chức năng này</h1>
	</div>
	<%
	} else {
	%>
	<div class="navbar">
		<div class="links">
			<a href="WelcomeUser.jsp">Home Page</a> <a href="WelcomeAdmin.jsp">Admin
				Page</a>
		</div>

		<form action="AuthController" method="post">
			<div class="welcome-user">
				<span>Xin chào, <%=user.getFullName()%></span>
				<button class="btn-logout" type="submit">Đăng xuất</button>
				<input type="hidden" value="logout" name="action">
			</div>
		</form>
	</div>
	<div class="content">
		<h1>Manage Order List</h1>
	</div>

	<table class="table-container">
		<thead>
			<tr>
				<th>ID</th>
				<th>Table ID</th>
				<th>Payment</th>
				<th>Total</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Order> orderList = (List<Order>) request.getAttribute("orderList");
			if (orderList != null) {
				for (Order order : orderList) {
			%>
			<tr>
				<td><%=order.getId()%></td>
				<td><%=order.getTableId()%></td>
				<td><%=order.getPayment()%></td>
				<td><%=order.getTotal()%> đ</td>
				<td>
					<div class="icon-action">
						<a href="OrderController?action=orderdetail&id=<%=order.getId()%>"
							class="action-icons edit"> <i class="fas fa-pencil-alt"></i>
							Order Details
						</a>
						<form action="OrderController?action=delete&id=<%=order.getId()%>"
							method="post" onsubmit="return confirmDelete();">
							<button type="submit" class="action-icons delete">
								<i class="fas fa-trash-alt"></i>
							</button>
						</form>
					</div>
				</td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="6">No data available</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<div class="btn-back">
		<a href="WelcomeAdmin.jsp"><button class="btn">Return</button></a>
	</div>
	<%
	}
	%>
</body>

<script type="text/javascript">
	function fillOrderInfo(id, tableId, payment, total, statusId) {
		document.querySelector('input[name="id"]').value = id;
		document.querySelector('input[name="tableId"]').value = tableId;
		document.querySelector('input[name="payment"]').value = payment;
		document.querySelector('input[name="total"]').value = total;

		// Cập nhật giá trị cho dropdown statusId
		var statusSelect = document.querySelector('select[name="statusId"]');
		statusSelect.value = statusId;

		// Kiểm tra giá trị statusId và chọn option tương ứng
		if (statusId == 4) {
			statusSelect.selectedIndex = 0; // Chọn option đầu tiên (Completed)
		} else if (statusId == 3) {
			statusSelect.selectedIndex = 1; // Chọn option thứ hai (Pending)
		}
	}

	// Hàm xác nhận trước khi xóa
	function confirmDelete() {
		return confirm("Bạn có chắc chắn muốn xóa mục này không?");
	}

	//action for form

	function setAction(action) {
		// Cập nhật action của form khi nhấn nút
		var form = document.getElementById("orderForm");
		var orderId = document.getElementById("orderId").value; // Lấy giá trị từ input type="hidden"

		// Thay đổi action tùy theo button được nhấn
		if (action === 'create') {
			form.action = "FoodController?action=create";
		} else if (action === 'edit' && foodId) {
			form.action = "OrderController?action=edit&id=" + foodId;
		} else if (action === 'delete' && foodId) {
			form.action = "OrderController?action=delete&id=" + foodId;
		}

		// Submit form sau khi cập nhật action
		form.submit();
	}
</script>

</html>