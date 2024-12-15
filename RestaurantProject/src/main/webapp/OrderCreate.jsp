<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="Model.BEAN.Food"%>
<%@ page import="Model.BEAN.User"%>
<%@ page import="Model.BEAN.Tables"%>
<%@ page import="Model.BEAN.OrderFood"%>
<!DOCTYPE html>
<html lang="vi">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Đặt Món Ăn</title>
	<!-- Link Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

	<style>
		/* General Style Improvements */
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

		.btn,
		.btn-logout {
			background-color: #007BFF;
			color: white;
			padding: 10px 20px;
			border: none;
			border-radius: 5px;
			font-size: 18px;
		}

		.btn:hover,
		.btn-logout:hover {
			background-color: #0056b3;
		}

		.btn-logout:focus {
			outline: none;
		}

		h1,
		h2 {
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

		.table-container th,
		.table-container td {
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
		@media (max-width : 768px) {
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

			.form-group input,
			.form-group select {
				width: 100%;
			}
		}

		/* Center align form elements */
		.form-group {
			margin-bottom: 1.5rem;
			display: flex;
			align-items: center;
			justify-content: space-between;
		}

		.form-group label {
			font-size: 16px;
			margin-bottom: 8px;
			text-align: left;
		}

		.form-group input,
		.form-group select {
			width: 80%;
			/* Adjust this value as needed */
			max-width: 400px;
			padding: 8px;
			font-size: 16px;
			border: 1px solid #ddd;
			border-radius: 5px;
		}

		.form-actions {
			text-align: center;
			margin-top: 20px;
		}

		.welcome-user {
			display: flex;
			align-items: center;
			justify-content: center;
		}

		.welcome-user span {
			color: white;
			margin-right: 10px;
		}

		/* Add Custom Styling for Table Rows */
		tbody tr:hover {
			background-color: #e9ecef;
		}

		.form-actions button {
			margin: 5px;
		}
	</style>
</head>

<body>

	<div class="navbar">
		<div class="links">
			<a href="FoodController?action=index">Menu</a> <a href="OrderController?action=create">Order Food</a>
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
		<h2>Đặt Món Ăn</h2>

		<form action="OrderController?action=create" id="formInput" method="post" onsubmit="return validateOrder()">
			<div class="form-group">
				<label for="customerName">Tên Khách Hàng:</label> <input type="text" id="customerName"
					name="customerName" value="Khách hàng đang ăn tại quán" required>
			</div>

			<div class="form-group">
				<label for="table">Chọn bàn:</label> <select id="tableSelect" name="tableId" required>
					<option value="">-- Chọn Bàn --</option>
					<%
					// Lấy danh sách bàn từ request attribute
					List<Tables> tableList = (List<Tables>) request.getAttribute("tableList");
					if (tableList != null) {
						// Lặp qua danh sách các bàn
						for (Tables table : tableList) {
							// Chỉ hiển thị các bàn có trạng thái là "empty"
							if ("empty".equals(table.getStatus().getName())) {
					%>
					<option value="<%=table.getId()%>"><%=table.getNumber()%></option>
					<%
					}
					}
					}
					%>
				</select>
			</div>



			<div class="form-group">
				<label for="foodSelect">Chọn Món Ăn:</label> <select id="foodSelect">
					<option value="">-- Chọn Món Ăn --</option>
					<%
					List<Food> foodList = (List<Food>) request.getAttribute("foodList");
					if (foodList != null) {
						for (Food food : foodList) {
					%>
					<option value="<%=food.getId()%>" data-name="<%=food.getFood()%>" data-price="<%=food.getPrice()%>">
						<%=food.getFood()%> (Giá:
						<%=food.getPrice()%>)
					</option>
					<%
					}
					}
					%>
				</select>
			</div>

			<div class="form-group">
				<label for="quantity">Số Lượng:</label> <input type="number" id="quantity" min="1" value="1">
			</div>

			<div class="form-actions">
				<button type="button" class="btn btn-primary" onclick="addFood()">Thêm
					Món</button>
			</div>

			<h3>Danh Sách Món Ăn</h3>
			<table id="orderDetailsTable" class="table-container">
				<thead>
					<tr>
						<th>Tên Món Ăn</th>
						<th>Số Lượng</th>
						<th>Giá</th>
						<th>Thành Tiền</th>
						<th>Hành Động</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>

			<div class="form-group">
				<label for="totalAmount">Tổng Tiền:</label> <input type="text" id="totalAmount" name="totalAmount"
					readonly value="0">
			</div>

			<div class="form-group">
				<label for="payment">Phương thức thanh toán:</label> <select id="payment" name="payment" required>
					<option value="">-- Chọn phương thức --</option>
					<option value="cash">Tiền mặt</option>
					<option value="transfer">Chuyển khoản</option>
				</select>
			</div>

			<div class="form-actions">
				<button type="submit" class="btn btn-success">Lưu Order</button>
				<button type="reset" class="btn btn-danger">Làm Lại</button>
			</div>
		</form>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		let orderDetails = [];
		let tableIdGl;

		function addFood() {
			const foodSelect = document.getElementById("foodSelect");
			const tableSelect = document.getElementById("tableSelect");
			const quantityInput = document.getElementById("quantity");
			const selectedOption = foodSelect.options[foodSelect.selectedIndex];

			if (!foodSelect.value) {
				alert("Vui lòng chọn món ăn!");
				return;
			}

			if (!tableSelect.value) {
				alert("Vui lòng chọn bàn ăn!");
				return;
			}

			const foodId = selectedOption.value;
			const foodName = selectedOption.getAttribute("data-name");
			const price = parseFloat(selectedOption.getAttribute("data-price"));
			const quantity = parseInt(quantityInput.value);
			const tableId = tableSelect.value;


			if (tableId != tableIdGl) {
				orderDetails = [];
				tableIdGl = tableId;
			}

			const existingFood = orderDetails.find(item => item.foodId === foodId);
			if (existingFood) {
				existingFood.quantity += quantity;
				existingFood.totalPrice = existingFood.quantity * price;
			} else {
				orderDetails.push({
					foodId,
					foodName,
					quantity,
					price,
					totalPrice: quantity * price
				});
			}

			updateOrderDetailsTable();
		}

		function updateOrderDetailsTable() {
			const tableBody = document.querySelector("#orderDetailsTable tbody");
			tableBody.innerHTML = "";

			let totalAmount = 0;
			orderDetails.forEach((item, index) => {
				const row = '<tr>' +
					'<td>' + item.foodName + '</td>' +
					'<td>' + item.quantity + '</td>' +
					'<td>' + item.price.toFixed(2) + '</td>' +
					'<td>' + item.totalPrice.toFixed(2) + '</td>' +
					'<td><button type="button" class="btn btn-danger" onclick="removeFood(' + index +
					')">Xóa</button></td>' +
					'</tr>';
				tableBody.innerHTML += row;
				totalAmount += item.totalPrice;
			});

			document.getElementById("totalAmount").value = totalAmount.toFixed(2);
		}

		function removeFood(index) {
			orderDetails.splice(index, 1);
			updateOrderDetailsTable();
		}

		function validateOrder() {
			if (orderDetails.length === 0) {
				alert("Vui lòng thêm ít nhất một món ăn!");
				return false;
			}

			let valueInputHidden = "";
			orderDetails.forEach((item, index) => {
				valueInputHidden += item.foodId + '-' + item.quantity;
				if (index !== orderDetails.length - 1) {
					valueInputHidden += ":";
				}
			});


			const form = document.getElementById("formInput");
			const hiddenInput = document.createElement("input");
			hiddenInput.type = "hidden";
			hiddenInput.name = "orderFood";
			hiddenInput.value = valueInputHidden;
			form.appendChild(hiddenInput);

			let totalAmount = 0;
			orderDetails.forEach((item) => {
				totalAmount += item.totalPrice;
			});

			const totalField = document.createElement("input");
			totalField.type = "hidden";
			totalField.name = "total";
			totalField.value = totalAmount;

			form.appendChild(totalField); // Add the total amount field to the form

			// Proceed to submit the form
			form.submit(); // Submit the form to the server
		}
	</script>