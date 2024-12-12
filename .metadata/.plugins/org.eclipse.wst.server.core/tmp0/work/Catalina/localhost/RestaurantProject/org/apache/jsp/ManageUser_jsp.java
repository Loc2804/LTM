/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.27
 * Generated at: 2024-12-12 08:16:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import Model.BEAN.Role;
import java.util.List;
import Model.BEAN.User;

public final class ManageUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("Model.BEAN.Role");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("Model.BEAN.User");
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
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Manage User</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("    font-family: Arial, sans-serif;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h1, h2 {\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    color: #0077b6;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a {\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:hover {\r\n");
      out.write("    background-color: #0056b3;\r\n");
      out.write("    border-radius: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button {\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar {\r\n");
      out.write("    background-color: #007BFF;\r\n");
      out.write("    display: flex;\r\n");
      out.write("    justify-content: space-between;\r\n");
      out.write("    padding: 10px 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar .links {\r\n");
      out.write("    display: flex;\r\n");
      out.write("    gap: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar a {\r\n");
      out.write("    padding: 8px 16px;\r\n");
      out.write("    font-size: 16px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn, .btn-logout {\r\n");
      out.write("    background-color: #007BFF;\r\n");
      out.write("    color: white;\r\n");
      out.write("    padding: 10px 20px;\r\n");
      out.write("    border: none;\r\n");
      out.write("    border-radius: 5px;\r\n");
      out.write("    font-size: 18px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn:hover, .btn-logout:hover {\r\n");
      out.write("    background-color: #0056b3;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn-logout:focus {\r\n");
      out.write("    outline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".content {\r\n");
      out.write("    margin: 20px auto;\r\n");
      out.write("    width: 80%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-container {\r\n");
      out.write("    background-color: #fff;\r\n");
      out.write("    padding: 30px;\r\n");
      out.write("    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);\r\n");
      out.write("    border-radius: 12px;\r\n");
      out.write("    width: 400px;\r\n");
      out.write("    margin: 20px auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("label {\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    display: block;\r\n");
      out.write("    margin-bottom: 8px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".input-field, select {\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    padding: 12px;\r\n");
      out.write("    margin: 8px 0 16px;\r\n");
      out.write("    border: 1px solid #ddd;\r\n");
      out.write("    border-radius: 8px;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".input-field:focus, select:focus {\r\n");
      out.write("    border-color: #0077b6;\r\n");
      out.write("    box-shadow: 0 0 5px rgba(0, 119, 182, 0.5);\r\n");
      out.write("    outline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-buttons {\r\n");
      out.write("    display: flex;\r\n");
      out.write("    justify-content: space-between;\r\n");
      out.write("    margin-top: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Table */\r\n");
      out.write(".table-container {\r\n");
      out.write("    margin: 40px auto;\r\n");
      out.write("    width: 80%;\r\n");
      out.write("    border-collapse: collapse;\r\n");
      out.write("    text-align: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".table-container th, .table-container td {\r\n");
      out.write("    border: 1px solid #ccc;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".table-container th {\r\n");
      out.write("    background-color:  #007BFF;\r\n");
      out.write("    color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".action-icons {\r\n");
      out.write("    font-size: 18px;\r\n");
      out.write("    margin: 0 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".action-icons.edit {\r\n");
      out.write("    color: #4CAF50;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".action-icons.delete {\r\n");
      out.write("    color: #FF5733;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".action-icons:hover {\r\n");
      out.write("    opacity: 0.7;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Responsive Design */\r\n");
      out.write("@media (max-width: 768px) {\r\n");
      out.write("    .form-container, .content {\r\n");
      out.write("        width: 90%;\r\n");
      out.write("        padding: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .btn {\r\n");
      out.write("        font-size: 14px;\r\n");
      out.write("        padding: 10px;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".welcome-user span{\r\n");
      out.write("	color: white;\r\n");
      out.write("	font-size: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn-back{\r\n");
      out.write("	display:flex;\r\n");
      out.write("	align-items: center;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("	margin-bottom: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".icon-action{\r\n");
      out.write("	display: flex;\r\n");
      out.write("	\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("		");

        	User user = (User) session.getAttribute("user");
			List<Role> roles = (List<Role>) session.getAttribute("listRole");
        	if(user == null || user.getRole() == null){
        
      out.write("\r\n");
      out.write("      <div class=\"navbar\">\r\n");
      out.write("       <div class=\"links\">\r\n");
      out.write("           <a href=\"WelcomeUser.jsp\">Home Page</a>\r\n");
      out.write("           <a href=\"WelcomeAdmin.jsp\">Admin Page</a>\r\n");
      out.write("       </div>\r\n");
      out.write("        <div class=\"group-btn\">\r\n");
      out.write("            <a href=\"Login.jsp\">Đăng nhập</a>\r\n");
      out.write("            <a href=\"Register.jsp\">Đăng ký</a>\r\n");
      out.write("        </div>\r\n");
      out.write("     </div>\r\n");
      out.write("     <div class=\"content\">\r\n");
      out.write("       	<h1>Bạn cần đăng nhập để thực hiện chức năng này</h1>\r\n");
      out.write("   	</div>\r\n");
      out.write("        ");
 }
        	else{
        
      out.write("\r\n");
      out.write("        <div class=\"navbar\">\r\n");
      out.write("	       <div class=\"links\">\r\n");
      out.write("	           <a href=\"WelcomeUser.jsp\">Home Page</a>\r\n");
      out.write("	           <a href=\"WelcomeAdmin.jsp\">Admin Page</a>\r\n");
      out.write("	       </div>\r\n");
      out.write("	        <form action=\"AuthController\" method=\"post\">\r\n");
      out.write("	        	<div class=\"welcome-user\">\r\n");
      out.write("	        		<span>Xin chào, ");
      out.print(user.getFullName() );
      out.write("</span>\r\n");
      out.write("	            	<button class=\"btn-logout\" type=\"submit\">Đăng xuất</button>\r\n");
      out.write("	            	<input  type=\"hidden\" value=\"logout\" name=\"action\">\r\n");
      out.write("	        	</div>\r\n");
      out.write("	        </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("       		<h1>Manage User</h1>\r\n");
      out.write("   		</div>\r\n");
      out.write("   		<div class=\"form-container\">\r\n");
      out.write("          <form action=\"UserController\" method=\"POST\">\r\n");
      out.write("            <label for=\"username\">Username:</label>\r\n");
      out.write("            <input type=\"text\" id=\"username\" name=\"username\" class=\"input-field\" placeholder=\"Enter your username\" required onblur=\"checkUsername()\">\r\n");
      out.write("			<input type=\"hidden\" name=\"id_up\"> \r\n");
      out.write("            <label for=\"password\">Password:</label>\r\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\" class=\"input-field\" placeholder=\"Enter your password\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"fullname\">Full Name:</label>\r\n");
      out.write("            <input type=\"text\" id=\"fullname\" name=\"fullName\" class=\"input-field\" placeholder=\"Enter your full name\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"phone\">Phone Number:</label>\r\n");
      out.write("            <input type=\"tel\" id=\"phone\" name=\"phonenumber\" class=\"input-field\" placeholder=\"Enter your phone number\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"address\">Address:</label>\r\n");
      out.write("            <input type=\"text\" id=\"address\" name=\"address\" class=\"input-field\" placeholder=\"Enter your address\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"age\">Age:</label>\r\n");
      out.write("            <input type=\"number\" id=\"age\" name=\"age\" class=\"input-field\" min=\"1\" max=\"120\" required>\r\n");
      out.write("            \r\n");
      out.write("            <label for=\"gender\">Gender:</label>\r\n");
      out.write("            <select name=\"gender\" id=\"gender\">\r\n");
      out.write("            	<option value=\"\" selected=\"selected\" hidden></option>\r\n");
      out.write("            	<option value=\"female\">Female</option>\r\n");
      out.write("            	<option value=\"male\">Male</option>\r\n");
      out.write("            </select>\r\n");
      out.write("\r\n");
      out.write("			<label for=\"role\">Role:</label>\r\n");
      out.write("            <select name=\"role\" id=\"role\">\r\n");
      out.write("            	<option value=\"\" selected=\"selected\" hidden></option>\r\n");
      out.write("            	");

            		if(roles != null){
            			for(Role role: roles){
            	
      out.write("\r\n");
      out.write("            				<option value=\"");
      out.print(role.getId() );
      out.write('"');
      out.write('>');
      out.print(role.getName() );
      out.write("</option>\r\n");
      out.write("            	");

            			}
            		}
            		else{
            	
      out.write("\r\n");
      out.write("            		<option value=\"1\">Admin</option>\r\n");
      out.write("            		<option value=\"2\">User</option> \r\n");
      out.write("            	");

            		}
            	
      out.write("\r\n");
      out.write("            	\r\n");
      out.write("            </select>\r\n");
      out.write("			<button type=\"submit\" class=\"btn btn-add\" name=\"action\" value=\"add\">Thêm Mới</button>\r\n");
      out.write("\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-update\" name=\"action\" value=\"update\">Cập Nhật</button>\r\n");
      out.write("            <button type=\"reset\" class=\"btn btn-reset\" onclick=\"resetForm()\">Reset</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");

	    List<User> list = (List<User>) session.getAttribute("listUser");
	    StringBuilder str = new StringBuilder();
	    str.append("[");
	    for (int i = 0; i < list.size(); i++) {
	        str.append("\"").append(list.get(i).getUsername()).append("\"");
	        if (i < list.size() - 1) {
	            str.append(", ");
	        }
	    }
	    str.append("]");
    
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    	console.log(");
      out.print( str.toString() );
      out.write(");\r\n");
      out.write("	    var existingUsername = ");
      out.print( str.toString() );
      out.write(";\r\n");
      out.write("	    function checkUsername() {\r\n");
      out.write("	    	\r\n");
      out.write("	        var idnv = document.getElementById('username').value;\r\n");
      out.write("	\r\n");
      out.write("	        if (existingUsername.includes(idnv)) {\r\n");
      out.write("	            alert(\"Username existed !\");\r\n");
      out.write("	\r\n");
      out.write("	            document.getElementById('username').value = \"\";\r\n");
      out.write("	            return false;  \r\n");
      out.write("	        }\r\n");
      out.write("	        return true; \r\n");
      out.write("	    }\r\n");
      out.write("	</script>\r\n");
      out.write("   	<h2>List user</h2>\r\n");
      out.write("    <table class=\"table-container\">\r\n");
      out.write("        <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>ID</th>\r\n");
      out.write("                <th>Username</th>\r\n");
      out.write("                <th>Full name</th>\r\n");
      out.write("                <th>Gender</th>\r\n");
      out.write("                <th>Age</th>\r\n");
      out.write("                <th>Phone number</th>\r\n");
      out.write("                <th>Address</th>\r\n");
      out.write("                <th>Role</th>\r\n");
      out.write("                <th>Action</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("            ");
 
                // Lấy danh sách nhân viên từ session
                if (list != null) {
                    for (User u : list) {
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.print( u.getId() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( u.getUsername() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( u.getFullName() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( u.getGender() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( u.getAge() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( u.getPhonenumber() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( u.getAddress() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( u.getRole().getName() );
      out.write("</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                	<div class=\"icon-action\">\r\n");
      out.write("                		<button class=\"action-icons edit\"  \r\n");
      out.write("                			onclick=\"fillInfo('");
      out.print( u.getId() );
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(u.getUsername() );
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(u.getPassword() );
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(u.getFullName() );
      out.write("',\r\n");
      out.write("                			'");
      out.print(u.getPhonenumber() );
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(u.getAddress() );
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(u.getAge() );
      out.write("',\r\n");
      out.write("                			'");
      out.print(u.getGender() );
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(u.getRole().getId() );
      out.write("')\"\r\n");
      out.write("                		>\r\n");
      out.write("                			<i class=\"fas fa-pencil-alt\"></i>\r\n");
      out.write("                		</button>\r\n");
      out.write("                		<form action=\"UserController\" method=\"post\">\r\n");
      out.write("                	    	<input type=\"hidden\" name=\"deleteId\" value=\"");
      out.print( u.getId() );
      out.write("\"> \r\n");
      out.write("                			<button type=\"submit\" value=\"delete\" name=\"action\" class=\"action-icons delete\" onclick=\"setId('");
      out.print( u.getId() );
      out.write("')\"><i class=\"fas fa-trash-alt\"></i></button>\r\n");
      out.write("                		</form>\r\n");
      out.write("                	</div>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
 
                    }
                } else {
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"9\">Empty data</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("    <div class=\"btn-back\">\r\n");
      out.write("    	<a href=\"WelcomeAdmin.jsp\"><button class=\"btn\" >Return</button></a>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		function fillInfo(id,username, password, fullName, phone, add, age,gender,role) {\r\n");
      out.write("			document.querySelector('input[name=\"id_up\"]').value = id;\r\n");
      out.write("		 	document.querySelector('input[name=\"username\"]').value = username;\r\n");
      out.write("		    document.querySelector('input[name=\"password\"]').value = password;\r\n");
      out.write("		    document.querySelector('input[name=\"fullName\"]').value = fullName;\r\n");
      out.write("		    document.querySelector('input[name=\"address\"]').value = add;\r\n");
      out.write("		    document.querySelector('input[name=\"age\"]').value = age;\r\n");
      out.write("		    document.querySelector('input[name=\"phonenumber\"]').value = phone;\r\n");
      out.write("		    if(gender === 'Nam'){\r\n");
      out.write("		    	gender = 'male';\r\n");
      out.write("		    }\r\n");
      out.write("		    else gender = 'female';\r\n");
      out.write("		    console.log(gender);\r\n");
      out.write("		    document.querySelector('select[name=\"gender\"]').value = gender;\r\n");
      out.write("		    document.querySelector('select[name=\"role\"]').value = role;\r\n");
      out.write("		    document.querySelector('input[name=\"username\"]').readOnly = true;\r\n");
      out.write("		    document.querySelector('input[name=\"password\"]').readOnly = true;\r\n");
      out.write("		}\r\n");
      out.write("		function resetForm() {\r\n");
      out.write("		    document.querySelector('input[name=\"username\"]').readOnly = false;\r\n");
      out.write("		    document.querySelector('input[name=\"password\"]').readOnly = false;\r\n");
      out.write("		}\r\n");
      out.write("		function setId(id){\r\n");
      out.write("			document.querySelector('input[name=\"deleteId\"]').value = id;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("\r\n");
      out.write("	</script>\r\n");
      out.write("        ");

        	}
        
      out.write("\r\n");
      out.write("</body>\r\n");
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