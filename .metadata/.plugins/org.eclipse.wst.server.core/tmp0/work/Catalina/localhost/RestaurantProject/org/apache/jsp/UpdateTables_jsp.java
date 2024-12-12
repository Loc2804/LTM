/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.27
 * Generated at: 2024-12-12 08:44:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import Model.BEAN.Tables;
import java.util.ArrayList;

public final class UpdateTables_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("Model.BEAN.Tables");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("    <title>Update Table</title>\r\n");
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
      out.write("        .form-container label {\r\n");
      out.write("            display: block;\r\n");
      out.write("            margin-bottom: 8px;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            color: #333;\r\n");
      out.write("        }\r\n");
      out.write("        .form-container input[type=\"text\"],\r\n");
      out.write("        .form-container select {\r\n");
      out.write("            width: calc(100% - 20px);\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            margin-bottom: 15px;\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("        }\r\n");
      out.write("        .form-container input[type=\"submit\"],\r\n");
      out.write("        .form-container input[type=\"reset\"] {\r\n");
      out.write("            background-color: #007BFF;\r\n");
      out.write("            color: white;\r\n");
      out.write("            border: none;\r\n");
      out.write("            padding: 10px 15px;\r\n");
      out.write("            margin-right: 10px;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("        }\r\n");
      out.write("        .form-container input[type=\"submit\"]:hover,\r\n");
      out.write("        .form-container input[type=\"reset\"]:hover {\r\n");
      out.write("            background-color: #0056b3;\r\n");
      out.write("        }\r\n");
      out.write("        table {\r\n");
      out.write("            width: 80%;\r\n");
      out.write("            margin: 20px auto;\r\n");
      out.write("            border-collapse: collapse;\r\n");
      out.write("            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);\r\n");
      out.write("            background-color: #fff;\r\n");
      out.write("        }\r\n");
      out.write("        th, td {\r\n");
      out.write("            padding: 12px 15px;\r\n");
      out.write("            text-align: left;\r\n");
      out.write("        }\r\n");
      out.write("        th {\r\n");
      out.write("            background-color: #007BFF;\r\n");
      out.write("            color: white;\r\n");
      out.write("            text-transform: uppercase;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("        }\r\n");
      out.write("        tr:nth-child(even) {\r\n");
      out.write("            background-color: #f2f2f2;\r\n");
      out.write("        }\r\n");
      out.write("        tr:hover {\r\n");
      out.write("            background-color: #d1e7fd;\r\n");
      out.write("        }\r\n");
      out.write("        td {\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("            color: #333;\r\n");
      out.write("        }\r\n");
      out.write("        button{\r\n");
      out.write("            cursor:pointer;\r\n");
      out.write("        }\r\n");
      out.write("        a {\r\n");
      out.write("            display: block;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin: 20px auto;\r\n");
      out.write("            padding: 10px 20px;\r\n");
      out.write("            background-color: #007BFF;\r\n");
      out.write("            color: white;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            width: 150px;\r\n");
      out.write("        }\r\n");
      out.write("        a:hover {\r\n");
      out.write("            background-color: #0056b3;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <h1>Update Table</h1>\r\n");
      out.write("    <div class=\"form-container\">\r\n");
      out.write("        <form action=\"TablesController?action=update\" method=\"post\">\r\n");
      out.write("            <label for=\"id\">ID:</label>\r\n");
      out.write("            <input type=\"text\" id=\"id\" name=\"id\" readonly=\"readonly\">\r\n");
      out.write("\r\n");
      out.write("            <label for=\"number\">Number:</label>\r\n");
      out.write("            <input type=\"text\" id=\"number\" name=\"number\" placeholder=\"Enter table number\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"status_id\">Status ID:</label>\r\n");
      out.write("            <select id=\"status_id\" name=\"status_id\" required>\r\n");
      out.write("			    <option value=\"\" disabled selected>Chọn trạng thái</option>\r\n");
      out.write("			    <option value=\"1\">Còn Trống</option>\r\n");
      out.write("			    <option value=\"2\">Đã Được Đặt</option>\r\n");
      out.write("			</select>\r\n");
      out.write("\r\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Update\">\r\n");
      out.write("            <input type=\"reset\" value=\"Reset\">\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <table border=\"1\">\r\n");
      out.write("        <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>ID</th>\r\n");
      out.write("                <th>Number</th>\r\n");
      out.write("                <th>Status ID</th>\r\n");
      out.write("                <th>Update</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("        ");

            ArrayList<Tables> list = (ArrayList<Tables>) request.getAttribute("tablesList");
            if (list != null) {
                for (Tables table : list) {
        
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.print( table.getId() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( table.getNumber() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( table.getStatus_id()== 1 ? "Còn Trống" : "Đã hết" );
      out.write("</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <button onclick=\"handleUpdate('");
      out.print( table.getId() );
      out.write("', '");
      out.print( table.getNumber() );
      out.write("', '");
      out.print( table.getStatus_id() );
      out.write("')\">Update</button>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        ");

                }
            } else {
        
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"4\" style=\"text-align: center;\">No data available</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        ");

            }
        
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("    <a href=\"Index_Tables.jsp\">Back to Home</a>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        function handleUpdate(id, number, statusID) {\r\n");
      out.write("            document.getElementById(\"id\").value = id;\r\n");
      out.write("            document.getElementById(\"number\").value = number;\r\n");
      out.write("            document.getElementById(\"status_id\").value = statusID;\r\n");
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
