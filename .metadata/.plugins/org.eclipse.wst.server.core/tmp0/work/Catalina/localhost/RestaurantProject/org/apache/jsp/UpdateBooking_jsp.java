/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.27
 * Generated at: 2024-12-12 09:59:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.List;
import Model.BEAN.Booking;

public final class UpdateBooking_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("Model.BEAN.Booking");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Update Booking</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: Arial, sans-serif;\r\n");
      out.write("            background-color: #f9f9f9;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        h1 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            color: #333;\r\n");
      out.write("        }\r\n");
      out.write("        .form-container {\r\n");
      out.write("            width: 80%;\r\n");
      out.write("            margin: 20px auto;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            background-color: #fff;\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);\r\n");
      out.write("        }\r\n");
      out.write("        .form-container label, .form-container input {\r\n");
      out.write("            display: block;\r\n");
      out.write("            margin-bottom: 10px;\r\n");
      out.write("        }\r\n");
      out.write("        .form-container input {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 8px;\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("        }\r\n");
      out.write("        .form-container button {\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            background-color: #007BFF;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("        }\r\n");
      out.write("        .form-container button:hover {\r\n");
      out.write("            background-color: #0056b3;\r\n");
      out.write("        }\r\n");
      out.write("        table {\r\n");
      out.write("            width: 80%;\r\n");
      out.write("            margin: 20px auto;\r\n");
      out.write("            border-collapse: collapse;\r\n");
      out.write("        }\r\n");
      out.write("        table, th, td {\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("        }\r\n");
      out.write("        th, td {\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <h1>Update Booking</h1>\r\n");
      out.write("    <div class=\"form-container\">\r\n");
      out.write("        <form action=\"BookingController?action=update\" method=\"post\">\r\n");
      out.write("            <label for=\"id\">Booking ID:</label>\r\n");
      out.write("            <input type=\"text\" id=\"id\" name=\"id\" readonly>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"user_id\">User ID:</label>\r\n");
      out.write("            <input type=\"text\" id=\"user_id\" name=\"user_id\">\r\n");
      out.write("\r\n");
      out.write("            <label for=\"table_id\">ID Bàn:</label>\r\n");
      out.write("			<select id=\"table_id\" name=\"table_id\" required>\r\n");
      out.write("			    <option value=\"\">Chọn ID bàn</option>\r\n");
      out.write("			    ");

			    List<Long> tableIds = (List<Long>) request.getAttribute("tablesList");
			        if (tableIds != null) {
			            for (long tableId : tableIds) {
			    
      out.write("\r\n");
      out.write("			    <option value=\"");
      out.print( tableId );
      out.write('"');
      out.write('>');
      out.print( tableId );
      out.write("</option>\r\n");
      out.write("			    ");

			            }
			        }
			    
      out.write("\r\n");
      out.write("			</select>\r\n");
      out.write("            <label for=\"date\">Date:</label>\r\n");
      out.write("            <input type=\"text\" id=\"date\" name=\"date\">\r\n");
      out.write("\r\n");
      out.write("            <label for=\"status_id\">Status:</label>\r\n");
      out.write("			<select id=\"status_id\" name=\"status_id\">\r\n");
      out.write("			    <option value=\"5\">Waiting</option>\r\n");
      out.write("			    <option value=\"6\">Confirm</option>\r\n");
      out.write("			    <option value=\"7\">Canceled</option>\r\n");
      out.write("			</select>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <button type=\"submit\">Update</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <table>\r\n");
      out.write("        <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>ID</th>\r\n");
      out.write("                <th>User ID</th>\r\n");
      out.write("                <th>Table ID</th>\r\n");
      out.write("                <th>Date</th>\r\n");
      out.write("                <th>Status ID</th>\r\n");
      out.write("                <th>Action</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("            ");

                List<Booking> bookings = (List<Booking>) request.getAttribute("bookingsList");
                if (bookings != null) {
                    for (Booking booking : bookings) {
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.print( booking.getId() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( booking.getUser_id() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( booking.getTable_id() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( booking.getDate() );
      out.write("</td>\r\n");
      out.write("                <td>\r\n");
      out.write("				    ");
 
				        long statusId = booking.getStatus_id();
				        String status = "";
				        if (statusId == 5) {
				            status = "Waiting";
				        } else if (statusId == 6) {
				            status = "Confirm";
				        } else if (statusId == 7) {
				            status = "Canceled";
				        }
				    
      out.write("\r\n");
      out.write("				    ");
      out.print( status );
      out.write("\r\n");
      out.write("				</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <button onclick=\"fillForm('");
      out.print( booking.getId() );
      out.write("', '");
      out.print( booking.getUser_id() );
      out.write("', '");
      out.print( booking.getTable_id() );
      out.write("', '");
      out.print( booking.getDate() );
      out.write("', '");
      out.print( booking.getStatus_id() );
      out.write("')\">Edit</button>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

                    }
                } else {
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"6\">No bookings found</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

                }
            
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        function fillForm(id, userId, tableId, date, statusId) {\r\n");
      out.write("            document.getElementById(\"id\").value = id;\r\n");
      out.write("            document.getElementById(\"user_id\").value = userId;\r\n");
      out.write("            document.getElementById(\"table_id\").value = tableId;\r\n");
      out.write("            document.getElementById(\"date\").value = date;\r\n");
      out.write("            document.getElementById(\"status_id\").value = statusId;\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
