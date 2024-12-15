/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.27
 * Generated at: 2024-12-15 09:04:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.List;
import Model.BEAN.Food;
import Model.BEAN.User;
import Model.BEAN.Tables;
import Model.BEAN.OrderFood;

public final class OrderCreate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("Model.BEAN.User");
    _jspx_imports_classes.add("Model.BEAN.OrderFood");
    _jspx_imports_classes.add("Model.BEAN.Tables");
    _jspx_imports_classes.add("Model.BEAN.Food");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"vi\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("	<title>Đặt Món Ăn</title>\r\n");
      out.write("	<!-- Link Bootstrap CSS -->\r\n");
      out.write("	<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("	<style>\r\n");
      out.write("		/* General Style Improvements */\r\n");
      out.write("		body {\r\n");
      out.write("			font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\r\n");
      out.write("			margin: 0;\r\n");
      out.write("			padding: 0;\r\n");
      out.write("			background-color: #f7f7f7;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.navbar {\r\n");
      out.write("			background-color: #007BFF;\r\n");
      out.write("			display: flex;\r\n");
      out.write("			justify-content: space-between;\r\n");
      out.write("			padding: 10px 20px;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.navbar .links {\r\n");
      out.write("			display: flex;\r\n");
      out.write("			gap: 20px;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.navbar a {\r\n");
      out.write("			padding: 8px 16px;\r\n");
      out.write("			font-size: 16px;\r\n");
      out.write("			color: white;\r\n");
      out.write("			text-decoration: none;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.navbar a:hover {\r\n");
      out.write("			background-color: #0056b3;\r\n");
      out.write("			border-radius: 4px;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.navbar .group-btn {\r\n");
      out.write("			display: flex;\r\n");
      out.write("			gap: 10px;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.btn,\r\n");
      out.write("		.btn-logout {\r\n");
      out.write("			background-color: #007BFF;\r\n");
      out.write("			color: white;\r\n");
      out.write("			padding: 10px 20px;\r\n");
      out.write("			border: none;\r\n");
      out.write("			border-radius: 5px;\r\n");
      out.write("			font-size: 18px;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.btn:hover,\r\n");
      out.write("		.btn-logout:hover {\r\n");
      out.write("			background-color: #0056b3;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.btn-logout:focus {\r\n");
      out.write("			outline: none;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		h1,\r\n");
      out.write("		h2 {\r\n");
      out.write("			text-align: center;\r\n");
      out.write("			color: #0077b6;\r\n");
      out.write("			font-size: 28px;\r\n");
      out.write("			padding: 20px 0;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.content {\r\n");
      out.write("			margin: 20px auto;\r\n");
      out.write("			width: 90%;\r\n");
      out.write("			max-width: 1200px;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.table-container {\r\n");
      out.write("			margin: 40px auto;\r\n");
      out.write("			width: 100%;\r\n");
      out.write("			border-collapse: collapse;\r\n");
      out.write("			text-align: left;\r\n");
      out.write("			background-color: white;\r\n");
      out.write("			border-radius: 8px;\r\n");
      out.write("			overflow: hidden;\r\n");
      out.write("			box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.table-container th,\r\n");
      out.write("		.table-container td {\r\n");
      out.write("			padding: 12px 18px;\r\n");
      out.write("			border-bottom: 1px solid #ddd;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.table-container th {\r\n");
      out.write("			background-color: #007BFF;\r\n");
      out.write("			color: white;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.table-container tr:nth-child(even) {\r\n");
      out.write("			background-color: #f9f9f9;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.table-container tr:hover {\r\n");
      out.write("			background-color: #f1f1f1;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		/* Responsive Design */\r\n");
      out.write("		@media (max-width : 768px) {\r\n");
      out.write("			.navbar {\r\n");
      out.write("				flex-direction: column;\r\n");
      out.write("				align-items: center;\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			.navbar .links {\r\n");
      out.write("				flex-direction: column;\r\n");
      out.write("				gap: 10px;\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			.table-container {\r\n");
      out.write("				width: 100%;\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			.btn {\r\n");
      out.write("				font-size: 16px;\r\n");
      out.write("				padding: 10px 16px;\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			.form-group input,\r\n");
      out.write("			.form-group select {\r\n");
      out.write("				width: 100%;\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		/* Center align form elements */\r\n");
      out.write("		.form-group {\r\n");
      out.write("			margin-bottom: 1.5rem;\r\n");
      out.write("			display: flex;\r\n");
      out.write("			align-items: center;\r\n");
      out.write("			justify-content: space-between;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.form-group label {\r\n");
      out.write("			font-size: 16px;\r\n");
      out.write("			margin-bottom: 8px;\r\n");
      out.write("			text-align: left;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.form-group input,\r\n");
      out.write("		.form-group select {\r\n");
      out.write("			width: 80%;\r\n");
      out.write("			/* Adjust this value as needed */\r\n");
      out.write("			max-width: 400px;\r\n");
      out.write("			padding: 8px;\r\n");
      out.write("			font-size: 16px;\r\n");
      out.write("			border: 1px solid #ddd;\r\n");
      out.write("			border-radius: 5px;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.form-actions {\r\n");
      out.write("			text-align: center;\r\n");
      out.write("			margin-top: 20px;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.welcome-user {\r\n");
      out.write("			display: flex;\r\n");
      out.write("			align-items: center;\r\n");
      out.write("			justify-content: center;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.welcome-user span {\r\n");
      out.write("			color: white;\r\n");
      out.write("			margin-right: 10px;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		/* Add Custom Styling for Table Rows */\r\n");
      out.write("		tbody tr:hover {\r\n");
      out.write("			background-color: #e9ecef;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.form-actions button {\r\n");
      out.write("			margin: 5px;\r\n");
      out.write("		}\r\n");
      out.write("	</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"navbar\">\r\n");
      out.write("		<div class=\"links\">\r\n");
      out.write("			<a href=\"FoodController?action=index\">Menu</a> <a href=\"OrderController?action=create\">Order Food</a>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<!-- User Login Section -->\r\n");
      out.write("		");

		User user = (User) session.getAttribute("user");
		if (user != null) {
		
      out.write("\r\n");
      out.write("		<form action=\"AuthController\" method=\"post\">\r\n");
      out.write("			<div class=\"welcome-user\">\r\n");
      out.write("				<span>XIn chào, ");
      out.print(user.getFullName());
      out.write("</span>\r\n");
      out.write("				<button class=\"btn-logout\" type=\"submit\">Đăng xuất</button>\r\n");
      out.write("				<input type=\"hidden\" value=\"logout\" name=\"action\">\r\n");
      out.write("			</div>\r\n");
      out.write("		</form>\r\n");
      out.write("		");

		}
		
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"content\">\r\n");
      out.write("		<h2>Đặt Món Ăn</h2>\r\n");
      out.write("\r\n");
      out.write("		<form action=\"OrderController?action=create\" id=\"formInput\" method=\"post\" onsubmit=\"return validateOrder()\">\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"customerName\">Tên Khách Hàng:</label> <input type=\"text\" id=\"customerName\"\r\n");
      out.write("					name=\"customerName\" value=\"Khách hàng đang ăn tại quán\" required>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"table\">Chọn bàn:</label> <select id=\"tableSelect\" name=\"tableId\" required>\r\n");
      out.write("					<option value=\"\">-- Chọn Bàn --</option>\r\n");
      out.write("					");

					// Lấy danh sách bàn từ request attribute
					List<Tables> tableList = (List<Tables>) request.getAttribute("tableList");
					if (tableList != null) {
						// Lặp qua danh sách các bàn
						for (Tables table : tableList) {
							// Chỉ hiển thị các bàn có trạng thái là "empty"
							if ("empty".equals(table.getStatus().getName())) {
					
      out.write("\r\n");
      out.write("					<option value=\"");
      out.print(table.getId());
      out.write('"');
      out.write('>');
      out.print(table.getNumber());
      out.write("</option>\r\n");
      out.write("					");

					}
					}
					}
					
      out.write("\r\n");
      out.write("				</select>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"foodSelect\">Chọn Món Ăn:</label> <select id=\"foodSelect\">\r\n");
      out.write("					<option value=\"\">-- Chọn Món Ăn --</option>\r\n");
      out.write("					");

					List<Food> foodList = (List<Food>) request.getAttribute("foodList");
					if (foodList != null) {
						for (Food food : foodList) {
					
      out.write("\r\n");
      out.write("					<option value=\"");
      out.print(food.getId());
      out.write("\" data-name=\"");
      out.print(food.getFood());
      out.write("\" data-price=\"");
      out.print(food.getPrice());
      out.write("\">\r\n");
      out.write("						");
      out.print(food.getFood());
      out.write(" (Giá:\r\n");
      out.write("						");
      out.print(food.getPrice());
      out.write(")\r\n");
      out.write("					</option>\r\n");
      out.write("					");

					}
					}
					
      out.write("\r\n");
      out.write("				</select>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"quantity\">Số Lượng:</label> <input type=\"number\" id=\"quantity\" min=\"1\" value=\"1\">\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"form-actions\">\r\n");
      out.write("				<button type=\"button\" class=\"btn btn-primary\" onclick=\"addFood()\">Thêm\r\n");
      out.write("					Món</button>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<h3>Danh Sách Món Ăn</h3>\r\n");
      out.write("			<table id=\"orderDetailsTable\" class=\"table-container\">\r\n");
      out.write("				<thead>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th>Tên Món Ăn</th>\r\n");
      out.write("						<th>Số Lượng</th>\r\n");
      out.write("						<th>Giá</th>\r\n");
      out.write("						<th>Thành Tiền</th>\r\n");
      out.write("						<th>Hành Động</th>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</thead>\r\n");
      out.write("				<tbody></tbody>\r\n");
      out.write("			</table>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"totalAmount\">Tổng Tiền:</label> <input type=\"text\" id=\"totalAmount\" name=\"totalAmount\"\r\n");
      out.write("					readonly value=\"0\">\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"payment\">Phương thức thanh toán:</label> <select id=\"payment\" name=\"payment\" required>\r\n");
      out.write("					<option value=\"\">-- Chọn phương thức --</option>\r\n");
      out.write("					<option value=\"cash\">Tiền mặt</option>\r\n");
      out.write("					<option value=\"transfer\">Chuyển khoản</option>\r\n");
      out.write("				</select>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"form-actions\">\r\n");
      out.write("				<button type=\"submit\" class=\"btn btn-success\">Lưu Order</button>\r\n");
      out.write("				<button type=\"reset\" class=\"btn btn-danger\">Làm Lại</button>\r\n");
      out.write("			</div>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("	<script>\r\n");
      out.write("		let orderDetails = [];\r\n");
      out.write("		let tableIdGl;\r\n");
      out.write("\r\n");
      out.write("		function addFood() {\r\n");
      out.write("			const foodSelect = document.getElementById(\"foodSelect\");\r\n");
      out.write("			const tableSelect = document.getElementById(\"tableSelect\");\r\n");
      out.write("			const quantityInput = document.getElementById(\"quantity\");\r\n");
      out.write("			const selectedOption = foodSelect.options[foodSelect.selectedIndex];\r\n");
      out.write("\r\n");
      out.write("			if (!foodSelect.value) {\r\n");
      out.write("				alert(\"Vui lòng chọn món ăn!\");\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			if (!tableSelect.value) {\r\n");
      out.write("				alert(\"Vui lòng chọn bàn ăn!\");\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			const foodId = selectedOption.value;\r\n");
      out.write("			const foodName = selectedOption.getAttribute(\"data-name\");\r\n");
      out.write("			const price = parseFloat(selectedOption.getAttribute(\"data-price\"));\r\n");
      out.write("			const quantity = parseInt(quantityInput.value);\r\n");
      out.write("			const tableId = tableSelect.value;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			if (tableId != tableIdGl) {\r\n");
      out.write("				orderDetails = [];\r\n");
      out.write("				tableIdGl = tableId;\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			const existingFood = orderDetails.find(item => item.foodId === foodId);\r\n");
      out.write("			if (existingFood) {\r\n");
      out.write("				existingFood.quantity += quantity;\r\n");
      out.write("				existingFood.totalPrice = existingFood.quantity * price;\r\n");
      out.write("			} else {\r\n");
      out.write("				orderDetails.push({\r\n");
      out.write("					foodId,\r\n");
      out.write("					foodName,\r\n");
      out.write("					quantity,\r\n");
      out.write("					price,\r\n");
      out.write("					totalPrice: quantity * price\r\n");
      out.write("				});\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			updateOrderDetailsTable();\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		function updateOrderDetailsTable() {\r\n");
      out.write("			const tableBody = document.querySelector(\"#orderDetailsTable tbody\");\r\n");
      out.write("			tableBody.innerHTML = \"\";\r\n");
      out.write("\r\n");
      out.write("			let totalAmount = 0;\r\n");
      out.write("			orderDetails.forEach((item, index) => {\r\n");
      out.write("				const row = '<tr>' +\r\n");
      out.write("					'<td>' + item.foodName + '</td>' +\r\n");
      out.write("					'<td>' + item.quantity + '</td>' +\r\n");
      out.write("					'<td>' + item.price.toFixed(2) + '</td>' +\r\n");
      out.write("					'<td>' + item.totalPrice.toFixed(2) + '</td>' +\r\n");
      out.write("					'<td><button type=\"button\" class=\"btn btn-danger\" onclick=\"removeFood(' + index +\r\n");
      out.write("					')\">Xóa</button></td>' +\r\n");
      out.write("					'</tr>';\r\n");
      out.write("				tableBody.innerHTML += row;\r\n");
      out.write("				totalAmount += item.totalPrice;\r\n");
      out.write("			});\r\n");
      out.write("\r\n");
      out.write("			document.getElementById(\"totalAmount\").value = totalAmount.toFixed(2);\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		function removeFood(index) {\r\n");
      out.write("			orderDetails.splice(index, 1);\r\n");
      out.write("			updateOrderDetailsTable();\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		function validateOrder() {\r\n");
      out.write("			if (orderDetails.length === 0) {\r\n");
      out.write("				alert(\"Vui lòng thêm ít nhất một món ăn!\");\r\n");
      out.write("				return false;\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			let valueInputHidden = \"\";\r\n");
      out.write("			orderDetails.forEach((item, index) => {\r\n");
      out.write("				valueInputHidden += item.foodId + '-' + item.quantity;\r\n");
      out.write("				if (index !== orderDetails.length - 1) {\r\n");
      out.write("					valueInputHidden += \":\";\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			const form = document.getElementById(\"formInput\");\r\n");
      out.write("			const hiddenInput = document.createElement(\"input\");\r\n");
      out.write("			hiddenInput.type = \"hidden\";\r\n");
      out.write("			hiddenInput.name = \"orderFood\";\r\n");
      out.write("			hiddenInput.value = valueInputHidden;\r\n");
      out.write("			form.appendChild(hiddenInput);\r\n");
      out.write("\r\n");
      out.write("			let totalAmount = 0;\r\n");
      out.write("			orderDetails.forEach((item) => {\r\n");
      out.write("				totalAmount += item.totalPrice;\r\n");
      out.write("			});\r\n");
      out.write("\r\n");
      out.write("			const totalField = document.createElement(\"input\");\r\n");
      out.write("			totalField.type = \"hidden\";\r\n");
      out.write("			totalField.name = \"total\";\r\n");
      out.write("			totalField.value = totalAmount;\r\n");
      out.write("\r\n");
      out.write("			form.appendChild(totalField); // Add the total amount field to the form\r\n");
      out.write("\r\n");
      out.write("			// Proceed to submit the form\r\n");
      out.write("			form.submit(); // Submit the form to the server\r\n");
      out.write("		}\r\n");
      out.write("	</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
