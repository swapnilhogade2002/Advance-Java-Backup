/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.92
 * Generated at: 2023-11-01 08:46:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
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

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"register.css\">\r\n");
      out.write("    <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\r\n");
      out.write("    <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("        .error {\r\n");
      out.write("            color: red;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container register\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-3 register-left\" style=\"margin-top: 200px;\">\r\n");
      out.write("                <h4><b>Registration form !!!</b></h4>\r\n");
      out.write("                <h5>Welcome</h5>\r\n");
      out.write("                <p>Welcome to Aress Software & Education Technologies</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-9 register-right\">\r\n");
      out.write("                <div class=\"tab-content\" id=\"myTabContent\">\r\n");
      out.write("                    <div class=\"tab-pane fade show active\" id=\"home\" role=\"tabpanel\" aria-labelledby=\"home-tab\">\r\n");
      out.write("                        <form action=\"Register\" method=\"post\" onsubmit=\"return validateForm()\">\r\n");
      out.write("                            <div class=\"row register-form\">\r\n");
      out.write("                                <div class=\"col-md-6\">\r\n");
      out.write("                                    <!-- first name -->\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" name=\"fname\" id=\"fname\" placeholder=\"First Name *\" pattern=\"[A-Za-z]+\" oninput=\"removeSpaces(this)\" autofocus />\r\n");
      out.write("                                        <span class=\"error\" id=\"fname-error\"></span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <!-- last name -->\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" name=\"lname\" id=\"lname\" placeholder=\"Last Name *\" oninput=\"removeSpaces(this)\" />\r\n");
      out.write("                                        <span class=\"error\" id=\"lname-error\"></span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <!-- password -->\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <input type=\"password\" class=\"form-control\" name=\"pass\" id=\"pass\" placeholder=\"Password *\" oninput=\"removeSpaces(this)\" />\r\n");
      out.write("                                        <span class=\"error\" id=\"password-error\"></span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <!-- email -->\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <input type=\"email\" class=\"form-control\" name=\"email\" id=\"email\" placeholder=\"Your Email *\" oninput=\"removeSpaces(this)\" />\r\n");
      out.write("                                        <span class=\"error\" id=\"email-error\"></span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <!-- phone -->\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <input type=\"number\" class=\"form-control\" name=\"phone\" id=\"phone\" placeholder=\"Your Phone *\" oninput=\"removeSpaces(this)\" />\r\n");
      out.write("                                        <span class=\"error\" id=\"phone-error\"></span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <!-- submit button -->\r\n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-primary\" value=\"submit\" />\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- script tag -->\r\n");
      out.write("    <script>\r\n");
      out.write("        function removeSpaces(input) {\r\n");
      out.write("            input.value = input.value.replace(/\\s/g, \"\");\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function validateForm() {\r\n");
      out.write("            var valid = true;\r\n");
      out.write("\r\n");
      out.write("            var firstName = document.getElementById(\"fname\").value;\r\n");
      out.write("            var lastName = document.getElementById(\"lname\").value;\r\n");
      out.write("            var password = document.getElementById(\"pass\").value;\r\n");
      out.write("            var email = document.getElementById(\"email\").value;\r\n");
      out.write("            var phone = document.getElementById(\"phone\").value;\r\n");
      out.write("\r\n");
      out.write("            var firstNameError = document.getElementById(\"fname-error\");\r\n");
      out.write("            var lastNameError = document.getElementById(\"lname-error\");\r\n");
      out.write("            var passwordError = document.getElementById(\"password-error\");\r\n");
      out.write("            var emailError = document.getElementById(\"email-error\");\r\n");
      out.write("            var phoneError = document.getElementById(\"phone-error\");\r\n");
      out.write("\r\n");
      out.write("            firstNameError.innerText = \"\";\r\n");
      out.write("            lastNameError.innerText = \"\";\r\n");
      out.write("            passwordError.innerText = \"\";\r\n");
      out.write("            emailError.innerText = \"\";\r\n");
      out.write("            phoneError.innerText = \"\";\r\n");
      out.write("      \r\n");
      out.write("            if (firstName.length < 3 || firstName.length > 25) {\r\n");
      out.write("                firstNameError.innerText = \"First Name must be between 3 and 25 characters.\";\r\n");
      out.write("                valid = false;\r\n");
      out.write("            } else if (/\\d/.test(firstName)) {\r\n");
      out.write("                firstNameError.innerText = \"First Name should not contain numbers.\";\r\n");
      out.write("                valid = false;\r\n");
      out.write("            } else if (!/^[a-zA-Z]+$/.test(firstName)) {\r\n");
      out.write("                firstNameError.innerText = \"First Name should only contain alphabetic characters.\";\r\n");
      out.write("                valid = false;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            if (lastName.length < 3 || lastName.length > 25) {\r\n");
      out.write("                lastNameError.innerText = \"Last Name must be between 3 and 25 characters.\";\r\n");
      out.write("                valid = false;\r\n");
      out.write("            }else if (/\\d/.test(firstName)) {\r\n");
      out.write("                firstNameError.innerText = \"Last Name should not contain numbers.\";\r\n");
      out.write("                valid = false;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            if (password.length < 4 || password.length > 25) {\r\n");
      out.write("                passwordError.innerText = \"Password must be between 4 and 25 characters.\";\r\n");
      out.write("                valid = false;\r\n");
      out.write("            } else if (!/(?=.*[A-Z])(?=.*[a-z])(?=.*\\W)/.test(password)) {\r\n");
      out.write("                passwordError.innerText = \"Password should contain at least one uppercase letter, one lowercase letter, and one special character.\";\r\n");
      out.write("                valid = false;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            if (!email.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}/)) {\r\n");
      out.write("                emailError.innerText = \"Invalid email address format.\";\r\n");
      out.write("                valid = false;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            if (!phone.match(/^\\d{10}$/)) {\r\n");
      out.write("                phoneError.innerText = \"Phone number must be a 10-digit number without spaces or special characters.\";\r\n");
      out.write("                valid = false;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("         /*    if (valid) {\r\n");
      out.write("                alert(\"Successfully registered...!\");\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            else{\r\n");
      out.write("            	alert(\"You have addes duplcate value\");\r\n");
      out.write("            }\r\n");
      out.write("         */\r\n");
      out.write("            return valid;\r\n");
      out.write("        }\r\n");
      out.write("     // Update the removeSpaces function to restrict entering numbers\r\n");
      out.write("        function removeSpaces(input) {\r\n");
      out.write("        	if (input.id === \"fname\" ) {\r\n");
      out.write("                input.value = input.value.replace(/\\s/g, \"\"); // Remove spaces\r\n");
      out.write("                input.value = input.value.replace(/\\d/g, \"\"); // Remove numbers\r\n");
      out.write("                input.value = input.value.replace(/[^a-zA-Z]/g, \"\"); // Remove numbers and special characters\r\n");
      out.write("               \r\n");
      out.write("            }\r\n");
      out.write("        	if (input.id === \"lname\" ) {\r\n");
      out.write("                input.value = input.value.replace(/\\s/g, \"\"); // Remove spaces\r\n");
      out.write("                input.value = input.value.replace(/\\d/g, \"\"); // Remove numbers\r\n");
      out.write("                input.value = input.value.replace(/[^a-zA-Z]/g, \"\"); // Remove numbers and special characters\r\n");
      out.write("            }\r\n");
      out.write("     \r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
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
