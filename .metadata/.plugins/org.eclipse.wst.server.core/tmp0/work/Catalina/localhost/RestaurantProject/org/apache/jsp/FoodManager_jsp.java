/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.27
 * Generated at: 2024-12-15 09:03:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import Model.BEAN.Food;
import java.util.List;
import Model.BEAN.User;

public final class FoodManager_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Manage Food List</title>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("	font-family: Arial, sans-serif;\r\n");
      out.write("	margin: 0;\r\n");
      out.write("	padding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h1, h2 {\r\n");
      out.write("	text-align: center;\r\n");
      out.write("	color: #0077b6;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a {\r\n");
      out.write("	text-decoration: none;\r\n");
      out.write("	color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:hover {\r\n");
      out.write("	background-color: #0056b3;\r\n");
      out.write("	border-radius: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button {\r\n");
      out.write("	cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar {\r\n");
      out.write("	background-color: #007BFF;\r\n");
      out.write("	display: flex;\r\n");
      out.write("	justify-content: space-between;\r\n");
      out.write("	padding: 10px 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar .links {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	gap: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar a {\r\n");
      out.write("	padding: 8px 16px;\r\n");
      out.write("	font-size: 16px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn, .btn-logout {\r\n");
      out.write("	background-color: #007BFF;\r\n");
      out.write("	color: white;\r\n");
      out.write("	padding: 10px 20px;\r\n");
      out.write("	border: none;\r\n");
      out.write("	border-radius: 5px;\r\n");
      out.write("	font-size: 18px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn:hover, .btn-logout:hover {\r\n");
      out.write("	background-color: #0056b3;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn-logout:focus {\r\n");
      out.write("	outline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".content {\r\n");
      out.write("	margin: 20px auto;\r\n");
      out.write("	width: 80%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-container {\r\n");
      out.write("	background-color: #fff;\r\n");
      out.write("	padding: 30px;\r\n");
      out.write("	box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);\r\n");
      out.write("	border-radius: 12px;\r\n");
      out.write("	width: 400px;\r\n");
      out.write("	margin: 20px auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("label {\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("	display: block;\r\n");
      out.write("	margin-bottom: 8px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".input-field, select {\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	padding: 12px;\r\n");
      out.write("	margin: 8px 0 16px;\r\n");
      out.write("	border: 1px solid #ddd;\r\n");
      out.write("	border-radius: 8px;\r\n");
      out.write("	font-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".input-field:focus, select:focus {\r\n");
      out.write("	border-color: #0077b6;\r\n");
      out.write("	box-shadow: 0 0 5px rgba(0, 119, 182, 0.5);\r\n");
      out.write("	outline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-buttons {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	justify-content: space-between;\r\n");
      out.write("	margin-top: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Table */\r\n");
      out.write(".table-container {\r\n");
      out.write("	margin: 40px auto;\r\n");
      out.write("	width: 80%;\r\n");
      out.write("	border-collapse: collapse;\r\n");
      out.write("	text-align: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".table-container th, .table-container td {\r\n");
      out.write("	border: 1px solid #ccc;\r\n");
      out.write("	padding: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".table-container th {\r\n");
      out.write("	background-color: #007BFF;\r\n");
      out.write("	color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".action-icons {\r\n");
      out.write("	font-size: 18px;\r\n");
      out.write("	margin: 0 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".action-icons.edit {\r\n");
      out.write("	color: #4CAF50;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".action-icons.delete {\r\n");
      out.write("	color: #FF5733;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".action-icons:hover {\r\n");
      out.write("	opacity: 0.7;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Responsive Design */\r\n");
      out.write("@media ( max-width : 768px) {\r\n");
      out.write("	.form-container, .content {\r\n");
      out.write("		width: 90%;\r\n");
      out.write("		padding: 20px;\r\n");
      out.write("	}\r\n");
      out.write("	.btn {\r\n");
      out.write("		font-size: 14px;\r\n");
      out.write("		padding: 10px;\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn-back {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	align-items: center;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("	margin-bottom: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".icon-action {\r\n");
      out.write("	display: flex;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".welcome-user {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	gap: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".welcome-user span {\r\n");
      out.write("	color: white;\r\n");
      out.write("	margin-top: 7px;\r\n");
      out.write("	font-size: 20px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	");

	User user = (User) session.getAttribute("user");
	if (user == null || user.getRole() == null) {
	
      out.write("\r\n");
      out.write("	<div class=\"navbar\">\r\n");
      out.write("		<div class=\"links\">\r\n");
      out.write("			<a href=\"WelcomeUser.jsp\">Home Page</a> <a href=\"WelcomeAdmin.jsp\">Admin\r\n");
      out.write("				Page</a>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"group-btn\">\r\n");
      out.write("			<a href=\"Login.jsp\">Đăng nhập</a> <a href=\"Register.jsp\">Đăng ký</a>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"content\">\r\n");
      out.write("		<h1>Bạn cần đăng nhập để thực hiện chức năng này</h1>\r\n");
      out.write("	</div>\r\n");
      out.write("	");

	} else {
	
      out.write("\r\n");
      out.write("	<div class=\"navbar\">\r\n");
      out.write("		<div class=\"links\">\r\n");
      out.write("			<a href=\"WelcomeUser.jsp\">Home Page</a> <a href=\"WelcomeAdmin.jsp\">Admin\r\n");
      out.write("				Page</a>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<form action=\"AuthController\" method=\"post\">\r\n");
      out.write("			<div class=\"welcome-user\">\r\n");
      out.write("				<span>Xin chào, ");
      out.print(user.getFullName());
      out.write("</span>\r\n");
      out.write("				<button class=\"btn-logout\" type=\"submit\">Đăng xuất</button>\r\n");
      out.write("				<input type=\"hidden\" value=\"logout\" name=\"action\">\r\n");
      out.write("			</div>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"content\">\r\n");
      out.write("		<h1>Manage Food List</h1>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"form-container\">\r\n");
      out.write("		<h2>Add New Food</h2>\r\n");
      out.write("		<form id=\"foodForm\" action=\"FoodController\" method=\"POST\">\r\n");
      out.write("			<label for=\"foodName\">Food Name:</label> <input type=\"text\"\r\n");
      out.write("				name=\"food\" id=\"foodName\" class=\"input-field\" required> <label\r\n");
      out.write("				for=\"description\">Food Desciption:</label> <input type=\"text\"\r\n");
      out.write("				name=\"description\" id=\"description\" class=\"input-field\" required>\r\n");
      out.write("\r\n");
      out.write("			<label for=\"price\">Price:</label> <input type=\"number\" name=\"price\"\r\n");
      out.write("				id=\"price\" class=\"input-field\" required> <label for=\"status\">Status:</label>\r\n");
      out.write("			<select name=\"statusId\" id=\"status\" class=\"input-field\" required>\r\n");
      out.write("				<option value=\"4\">On Sale</option>\r\n");
      out.write("				<option value=\"3\">Sold Out</option>\r\n");
      out.write("			</select>\r\n");
      out.write("\r\n");
      out.write("			<!-- Hidden -->\r\n");
      out.write("			<input type=\"hidden\" name=\"id\" id=\"foodId\" value=\"0\"\r\n");
      out.write("				class=\"input-field\">\r\n");
      out.write("\r\n");
      out.write("			<div class=\"form-buttons\">\r\n");
      out.write("				<!-- Nút \"Add New Food\" -->\r\n");
      out.write("				<button type=\"button\" class=\"btn\" onclick=\"setAction('create')\">Add\r\n");
      out.write("					New Food</button>\r\n");
      out.write("\r\n");
      out.write("				<!-- Nút \"Edit\" -->\r\n");
      out.write("				<button type=\"button\" class=\"btn\" onclick=\"setAction('edit')\">Edit</button>\r\n");
      out.write("\r\n");
      out.write("				<button type=\"reset\" class=\"btn\">Reset</button>\r\n");
      out.write("			</div>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<h2>Food List</h2>\r\n");
      out.write("	<table class=\"table-container\">\r\n");
      out.write("		<thead>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>ID</th>\r\n");
      out.write("				<th>Food Name</th>\r\n");
      out.write("				<th>Food Description</th>\r\n");
      out.write("				<th>Price</th>\r\n");
      out.write("				<th>Status</th>\r\n");
      out.write("				<th>Action</th>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</thead>\r\n");
      out.write("		<tbody>\r\n");
      out.write("			");

			List<Food> foodList = (List<Food>) request.getAttribute("foodList");
			if (foodList != null) {
				for (Food food : foodList) {
			
      out.write("\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td>");
      out.print(food.getId());
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print(food.getFood());
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print(food.getDescription());
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print(food.getPrice());
      out.write(" đ</td>\r\n");
      out.write("				<td>");
      out.print(food.getStatus().getName());
      out.write("</td>\r\n");
      out.write("				<td>\r\n");
      out.write("					<div class=\"icon-action\">\r\n");
      out.write("						<button class=\"action-icons edit\"\r\n");
      out.write("							onclick=\"fillFoodInfo('");
      out.print(food.getId());
      out.write("', '");
      out.print(food.getFood());
      out.write("', '");
      out.print(food.getDescription());
      out.write("', '");
      out.print(food.getPrice());
      out.write("', '");
      out.print(food.getStatusId());
      out.write("')\">\r\n");
      out.write("							<i class=\"fas fa-pencil-alt\"></i>\r\n");
      out.write("						</button>\r\n");
      out.write("						<form action=\"FoodController?action=delete&id=");
      out.print(food.getId());
      out.write("\"\r\n");
      out.write("							method=\"post\">\r\n");
      out.write("							<button type=\"submit\" class=\"action-icons delete\">\r\n");
      out.write("								<i class=\"fas fa-trash-alt\"></i>\r\n");
      out.write("							</button>\r\n");
      out.write("						</form>\r\n");
      out.write("					</div>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			");

			}
			} else {
			
      out.write("\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td colspan=\"5\">No data available</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			");

			}
			
      out.write("\r\n");
      out.write("		</tbody>\r\n");
      out.write("	</table>\r\n");
      out.write("	<div class=\"btn-back\">\r\n");
      out.write("		<a href=\"WelcomeAdmin.jsp\"><button class=\"btn\">Return</button></a>\r\n");
      out.write("	</div>\r\n");
      out.write("	");

	}
	
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	function fillFoodInfo(id, food, description, price, statusId) {\r\n");
      out.write("		document.querySelector('input[name=\"id\"]').value = id;\r\n");
      out.write("		document.querySelector('input[name=\"food\"]').value = food;\r\n");
      out.write("		document.querySelector('input[name=\"description\"]').value = description;\r\n");
      out.write("		document.querySelector('input[name=\"price\"]').value = price;\r\n");
      out.write("\r\n");
      out.write("		// Cập nhật giá trị cho dropdown statusId\r\n");
      out.write("		var statusSelect = document.querySelector('select[name=\"statusId\"]');\r\n");
      out.write("\r\n");
      out.write("		// Chọn giá trị statusId tương ứng\r\n");
      out.write("		statusSelect.value = statusId;\r\n");
      out.write("\r\n");
      out.write("		// Kiểm tra giá trị statusId và chọn option tương ứng\r\n");
      out.write("		if (statusId == 4) {\r\n");
      out.write("			statusSelect.selectedIndex = 0; // Chọn option đầu tiên (On Sale)\r\n");
      out.write("		} else if (statusId == 3) {\r\n");
      out.write("			statusSelect.selectedIndex = 1; // Chọn option thứ hai (Sold Out)\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	//action for form\r\n");
      out.write("\r\n");
      out.write("	function setAction(action) {\r\n");
      out.write("		// Cập nhật action của form khi nhấn nút\r\n");
      out.write("		var form = document.getElementById(\"foodForm\");\r\n");
      out.write("		var foodId = document.getElementById(\"foodId\").value; // Lấy giá trị từ input type=\"hidden\"\r\n");
      out.write("\r\n");
      out.write("		// Thay đổi action tùy theo button được nhấn\r\n");
      out.write("		if (action === 'create') {\r\n");
      out.write("			form.action = \"FoodController?action=create\";\r\n");
      out.write("		} else if (action === 'edit' && foodId) {\r\n");
      out.write("			form.action = \"FoodController?action=edit&id=\" + foodId;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		// Submit form sau khi cập nhật action\r\n");
      out.write("		form.submit();\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
