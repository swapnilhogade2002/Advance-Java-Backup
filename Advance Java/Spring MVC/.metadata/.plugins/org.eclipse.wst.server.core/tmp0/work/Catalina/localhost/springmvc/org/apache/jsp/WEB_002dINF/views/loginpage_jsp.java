/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.92
 * Generated at: 2023-11-27 11:54:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<!-- Required meta tags -->\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("	content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap CSS -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\"\r\n");
      out.write("	integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<title>Login</title>\r\n");
      out.write("<style>\r\n");
      out.write(".gradient-custom-2 {\r\n");
      out.write("	/* fallback for old browsers */\r\n");
      out.write("	background: #fccb90;\r\n");
      out.write("	/* Chrome 10-25, Safari 5.1-6 */\r\n");
      out.write("	background: -webkit-linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);\r\n");
      out.write("	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\r\n");
      out.write("	background: linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media ( min-width : 768px) {\r\n");
      out.write("	.gradient-form {\r\n");
      out.write("		height: 100vh !important;\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media ( min-width : 769px) {\r\n");
      out.write("	.gradient-custom-2 {\r\n");
      out.write("		border-top-right-radius: .3rem;\r\n");
      out.write("		border-bottom-right-radius: .3rem;\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<section class=\"h-100 gradient-form\" style=\"background-color: #eee;\">\r\n");
      out.write("		<div class=\"container py-5 h-100\">\r\n");
      out.write("			<div\r\n");
      out.write("				class=\"row d-flex justify-content-center align-items-center h-100\">\r\n");
      out.write("				<div class=\"col-xl-10\">\r\n");
      out.write("					<div class=\"card rounded-3 text-black\">\r\n");
      out.write("						<div class=\"row g-0\">\r\n");
      out.write("							<div class=\"col-lg-6\">\r\n");
      out.write("								<div class=\"card-body p-md-5 mx-md-4\">\r\n");
      out.write("\r\n");
      out.write("									<div class=\"text-center\">\r\n");
      out.write("										<img\r\n");
      out.write("											src=\"https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/lotus.webp\"\r\n");
      out.write("											style=\"width: 185px;\" alt=\"logo\">\r\n");
      out.write("										<h4 class=\"mt-1 mb-5 pb-1\">Product Management System</h4>\r\n");
      out.write("									</div>\r\n");
      out.write("\r\n");
      out.write("									<form action=\"userlogin\" method=\"post\">\r\n");
      out.write("										<p>Please login to your account</p>\r\n");
      out.write("\r\n");
      out.write("										<div class=\"form-outline mb-4\">\r\n");
      out.write("											<label class=\"form-label\" for=\"form2Example11\">Email\r\n");
      out.write("												Address</label> <input type=\"email\" id=\"form2Example11\"\r\n");
      out.write("												class=\"form-control\" placeholder=\"Enter your email address\"\r\n");
      out.write("												name=\"email\" />\r\n");
      out.write("\r\n");
      out.write("										</div>\r\n");
      out.write("\r\n");
      out.write("										<div class=\"form-outline mb-4\">\r\n");
      out.write("											<input type=\"password\" id=\"form2Example22\"\r\n");
      out.write("												class=\"form-control\" name=\"password\" /> <label\r\n");
      out.write("												class=\"form-label\" for=\"form2Example22\"\r\n");
      out.write("												placeholder=\"Enter your password\">Password</label>\r\n");
      out.write("										</div>\r\n");
      out.write("\r\n");
      out.write("										<div class=\"text-center pt-1 mb-5 pb-1\">\r\n");
      out.write("											<button\r\n");
      out.write("												class=\"btn btn-primary btn-block fa-lg gradient-custom-2 mb-3\"\r\n");
      out.write("												type=\"submit\">Log in</button>\r\n");
      out.write("\r\n");
      out.write("										</div>\r\n");
      out.write("\r\n");
      out.write("										<div\r\n");
      out.write("											class=\"d-flex align-items-center justify-content-center pb-4\">\r\n");
      out.write("											<p class=\"mb-0 me-2\">Don't have an account?</p>\r\n");
      out.write("											<a href=\"register\"> Create new\r\n");
      out.write("												</button>\r\n");
      out.write("											</a>\r\n");
      out.write("\r\n");
      out.write("										</div>\r\n");
      out.write("\r\n");
      out.write("									</form>\r\n");
      out.write("\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"col-lg-6 d-flex align-items-center gradient-custom-2\">\r\n");
      out.write("								<div class=\"text-white px-3 py-4 p-md-5 mx-md-4\">\r\n");
      out.write("									<h4 class=\"mb-4\">We are more than just a company</h4>\r\n");
      out.write("									<p class=\"small mb-0\">Lorem ipsum dolor sit amet,\r\n");
      out.write("										consectetur adipisicing elit, sed do eiusmod tempor incididunt\r\n");
      out.write("										ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\n");
      out.write("										quis nostrud exercitation ullamco laboris nisi ut aliquip ex\r\n");
      out.write("										ea commodo consequat.</p>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</section>\r\n");
      out.write("\r\n");
      out.write("	<!-- Optional JavaScript -->\r\n");
      out.write("	<!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"\r\n");
      out.write("		integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\"\r\n");
      out.write("		integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\"\r\n");
      out.write("		integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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