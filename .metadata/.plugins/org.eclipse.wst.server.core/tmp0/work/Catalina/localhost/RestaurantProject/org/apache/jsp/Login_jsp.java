/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.27
 * Generated at: 2024-12-15 11:13:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Login Form</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("    font-family: Arial, sans-serif;\r\n");
      out.write("    background: linear-gradient(135deg, #89CFF0, #67B7D1); /* Màu xanh nước biển nhạt */\r\n");
      out.write("    display: flex;\r\n");
      out.write("    justify-content: center;\r\n");
      out.write("    align-items: center;\r\n");
      out.write("    height: 100vh;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    color: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login-container {\r\n");
      out.write("    background-color: #fff;\r\n");
      out.write("    padding: 25px;\r\n");
      out.write("    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);\r\n");
      out.write("    border-radius: 12px;\r\n");
      out.write("    width: 350px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    color: #333;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h2 {\r\n");
      out.write("    margin-bottom: 15px;\r\n");
      out.write("    color: #0077b6; /* Xanh nước biển đậm */\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("label {\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    display: block;\r\n");
      out.write("    margin-bottom: 8px;\r\n");
      out.write("    text-align: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".input-field {\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    padding: 12px;\r\n");
      out.write("    margin: 8px 0 16px 0;\r\n");
      out.write("    border: 1px solid #ddd;\r\n");
      out.write("    border-radius: 8px;\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    transition: all 0.3s ease;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".input-field:focus {\r\n");
      out.write("    border-color: #0077b6;\r\n");
      out.write("    outline: none;\r\n");
      out.write("    box-shadow: 0 0 5px rgba(0, 119, 182, 0.5);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-buttons {\r\n");
      out.write("    display: flex;\r\n");
      out.write("    justify-content: space-between;\r\n");
      out.write("    margin-top: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn {\r\n");
      out.write("    width: 48%;\r\n");
      out.write("    padding: 12px;\r\n");
      out.write("    background: linear-gradient(135deg, #89CFF0, #0077b6);\r\n");
      out.write("    color: white;\r\n");
      out.write("    border: none;\r\n");
      out.write("    border-radius: 8px;\r\n");
      out.write("    font-size: 16px;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    transition: all 0.3s ease;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn:hover {\r\n");
      out.write("    background: linear-gradient(135deg, #0077b6, #005f99);\r\n");
      out.write("    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);\r\n");
      out.write("    transform: translateY(-2px);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".error-message {\r\n");
      out.write("    color: #d9534f;\r\n");
      out.write("    background-color: #f8d7da;\r\n");
      out.write("    border: 1px solid #f5c6cb;\r\n");
      out.write("    border-radius: 8px;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    margin-top: 15px;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".success-message {\r\n");
      out.write("    color: #28a745;\r\n");
      out.write("    background-color: #d4edda;\r\n");
      out.write("    border: 1px solid #c3e6cb;\r\n");
      out.write("    border-radius: 8px;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    margin-top: 15px;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-container {\r\n");
      out.write("    margin-top: 15px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-container label {\r\n");
      out.write("    text-align: left;\r\n");
      out.write("    display: block;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    margin-bottom: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-container .input-field {\r\n");
      out.write("    margin-bottom: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("::placeholder {\r\n");
      out.write("    color: #999;\r\n");
      out.write("    font-style: italic;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"text\"]:focus, input[type=\"password\"]:focus {\r\n");
      out.write("    background-color: #f9f9f9;\r\n");
      out.write("    outline: none;\r\n");
      out.write("    border: 1px solid #0077b6;\r\n");
      out.write("    box-shadow: 0 0 3px rgba(0, 119, 182, 0.4);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media (max-width: 768px) {\r\n");
      out.write("    .login-container {\r\n");
      out.write("        width: 90%;\r\n");
      out.write("        padding: 15px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .btn {\r\n");
      out.write("        font-size: 14px;\r\n");
      out.write("        padding: 10px;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("}\r\n");
      out.write("    a {\r\n");
      out.write("    display: block;\r\n");
      out.write("    margin-top: 15px;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    color: #0077b6;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    transition: color 0.3s ease;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:hover {\r\n");
      out.write("    color: #005f99;\r\n");
      out.write("    text-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"login-container\">\r\n");
      out.write("        <h2>Login</h2>\r\n");
      out.write("		<form action=\"AuthController\" method=\"POST\">\r\n");
      out.write("            <label for=\"username\">Username:</label>\r\n");
      out.write("            <input type=\"text\" id=\"username\" name=\"username\" class=\"input-field\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"password\">Password:</label>\r\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\" class=\"input-field\" required>\r\n");
      out.write("\r\n");
      out.write("			<input type=\"hidden\" name=\"action\" value=\"login\" class=\"input-field\" required>\r\n");
      out.write("            <div class=\"form-buttons\">\r\n");
      out.write("			    <button type=\"submit\" class=\"btn\">Login</button>\r\n");
      out.write("			    <button type=\"reset\" class=\"btn\">Reset</button>\r\n");
      out.write("			</div>\r\n");
      out.write("        </form>\r\n");
      out.write("        ");
 
            String errorMessage = (String) request.getAttribute("errorMessage");

            if (errorMessage != null) {
        
      out.write("\r\n");
      out.write("            <div class=\"error-message\">");
      out.print( errorMessage );
      out.write("</div>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <a href=\"Register.jsp\">-----Sign up-----</a>\r\n");
      out.write("    </div>\r\n");
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
