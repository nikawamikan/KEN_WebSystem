/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2021-04-04 23:55:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controller.AdminLoginSvl;
import controller.UserLoginSvl;
import controller.ShowMenuSvl;
import model.User;
import ctrl.SvlUlrl;
import ctrl.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

String twitter = "#";
	String twitterImg = "";
	String insta = "#";
	String instaImg = "";
String sns = "<ul class='snsbtniti'><li><a href='"
			+ twitter
			+ "' class='flowbtn7 fl_tw7'><i><img src='/ideal/img/white.svg' alt='twitter'  style='width:100%;' /></i></a></li><li><a href='"
			+ insta + "' class='flowbtn7 insta_btn7'><i></i></a></li></ul>";
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header.jsp", Long.valueOf(1617580414117L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("ctrl");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("controller.AdminLoginSvl");
    _jspx_imports_classes.add("model.User");
    _jspx_imports_classes.add("controller.ShowMenuSvl");
    _jspx_imports_classes.add("controller.UserLoginSvl");
    _jspx_imports_classes.add("ctrl.SvlUlrl");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/bgBlur.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/form.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/header.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/bg.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/footer.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/title.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/home.css\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\" />\r\n");
      out.write("<title>??????????????????</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"home\">\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"min-height: 100vh; position: relative;\">\r\n");
      out.write("\t\t");
      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<noscript>\r\n");
      out.write("\t<META http-equiv=\"Refresh\" content=\"0;/ideal/noScriptError.jsp\" />\r\n");
      out.write("</noscript>\r\n");
      out.write("<!--  ???????????????????????????????????????(?????????5????????????????????????) -->\r\n");

	User us = (User) session.getAttribute(LoginVar.userInfo);

      out.write('\r');
      out.write('\n');

	String[] menuName = { "?????????", "????????????", "?????????", "????????????", "????????????" };

      out.write("\r\n");
      out.write("\r\n");

	String[] menuLink = { "/ideal/home.jsp", SvlUlrl.ShowMenuSvl,
			SvlUlrl.ReserveInsertSvl, "/ideal/access.jsp",
			"/ideal/userLogin.jsp" };

      out.write('\r');
      out.write('\n');

	if (us != null) {
		menuName[4] = "??????????????????";
		menuLink[4] = "/ideal/userIndex.jsp";
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- SNS????????????????????????????????????????????? -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- ?????????????????????????????????????????????????????????????????????????????? -->\r\n");
      out.write("\r\n");
      out.write("<div id=\"header-left\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- ?????????????????????????????????????????????????????? -->\r\n");
      out.write("\t<img id=\"header-logo\" src=\"/ideal/img/logo3.svg\" alt=\"Home?????????\" />\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- PS????????????????????? -->\r\n");
      out.write("\t<div id=\"header-right\">\r\n");
      out.write("\t\t");

			for (int i = 0; i < menuName.length; i++) {
		
      out.write("\r\n");
      out.write("\t\t<a class=\"header-button\" href=\"");
      out.print(menuLink[i]);
      out.write('"');
      out.write('>');
      out.print(menuName[i]);
      out.write("</a>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- PC?????????SNS???????????? -->\r\n");
      out.write("\t<div id=\"pc-sns-btn\">\r\n");
      out.write("\t\t");
      out.print(sns);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- ?????????????????????????????? -->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"burgerKing bgBlur\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- ?????????????????????????????????????????????????????? -->\r\n");
      out.write("\t<img id=\"header-logo\" src=\"/ideal/img/logo3.svg\" alt=\"Home?????????\" />\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<input type=\"checkbox\" id=\"menu-btn-check\"> <label\r\n");
      out.write("\tfor=\"menu-btn-check\" class=\"menu-btn\"><span class=\"menu-btn\"></span></label>\r\n");
      out.write("\t<div class=\"menu-content\">\r\n");
      out.write("\t\t<!-- ?????????????????????????????? -->\r\n");
      out.write("\t\t<ul class=\"menu-content-ul\">\r\n");
      out.write("\t\t\t");

				for (int i = 0; i < menuName.length; i++) {
			
      out.write("\r\n");
      out.write("\t\t\t<li class=\"menu-content-ul-li\"><a href=\"");
      out.print(menuLink[i]);
      out.write('"');
      out.write('>');
      out.print(menuName[i]);
      out.write("</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- ??????????????????SNS???????????? -->\r\n");
      out.write("\t\t<div id=\"phone-sns-btn\">\r\n");
      out.write("\t\t\t");
      out.print(sns);
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div> </input>");
      out.write("\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "idealException.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<div\r\n");
      out.write("\t\t\t\tstyle=\"position: absolute; z-index: -2; width: 100%; height: 100vh; top: -50px\">\r\n");
      out.write("\t\t\t\t<h2\r\n");
      out.write("\t\t\t\t\tstyle=\"position: absolute; left: 50%; top: 60%; transform: translate(-50%, -50%); width: 100%; text-align: center;\">?????????????????????????????????????????????</h2>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"position: sticky; z-index: -2; height: 50vh;\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div\r\n");
      out.write("\t\t\tstyle=\"position: sticky; z-index: -2; width: 100%; height: 100vh; top: -50px\">\r\n");
      out.write("\t\t\t<img\r\n");
      out.write("\t\t\t\tstyle=\"position: absolute; width: 30%; top: 60%; left: 50%; transform: translate(-50%, -50%);\"\r\n");
      out.write("\t\t\t\tsrc=\"/ideal/img/logo3.svg\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"position: sticky; z-index: -2; height: 50vh;\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div\r\n");
      out.write("\t\t\tstyle=\"position: sticky; z-index: -4; width: 100%; height: 50vh; top: 0\">\r\n");
      out.write("\t\t\t<img\r\n");
      out.write("\t\t\t\tstyle=\"position: absolute; height: 100vh; width: 100%; object-fit: cover;\"\r\n");
      out.write("\t\t\t\tsrc=\"/ideal/img/bg2.jpg\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"position: sticky; z-index: -2; height: 50vh;\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"tableDiv bgBlur\">\r\n");
      out.write("\t\t\t\t<div class=\"flex-container\">\r\n");
      out.write("\t\t\t\t\t<div class=\"flex-item\">\r\n");
      out.write("\t\t\t\t\t\t<h2>Ristorante IDEALLE??????????????????</h2>\r\n");
      out.write("\t\t\t\t\t\t<h4>???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????\r\n");
      out.write("\t\t\t\t\t\t\t??????????????????????????????????????????????????????Ristorante IDEALLE???????????????????????????\r\n");
      out.write("\t\t\t\t\t\t\t???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????</h4>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"flex-item\">\r\n");
      out.write("\t\t\t\t\t\t<img style=\"width: 100%; max-width: 600px;\"\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"/ideal/img/home1.jpg\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\t\t<div style=\"height: 50px\">\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"tableDiv bgBlur\">\r\n");
      out.write("\t\t\t\t<div class=\"flex-container\">\r\n");
      out.write("\t\t\t\t\t<div class=\"flex-item\">\r\n");
      out.write("\t\t\t\t\t\t<h2>special????????????????????????</h2>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"specialContainer\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"special\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td valign=\"top\" align=\"center\"><h3>????????????????????????????????????</h3></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"right\">???4,800</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td valign=\"top\"><div class=\"min-hi\">????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????</div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"center\"><img\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tsrc=\"/ideal/img/sirloin Steak.jpg\" class=\"imgs\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"special\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td valign=\"top\" align=\"center\"><h3>??????????????????????????????</h3></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"right\">???3,000</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td valign=\"top\"><div class=\"min-hi\">?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????</div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"center\"><img src=\"/ideal/img/foie gras.jpg\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"imgs\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"special\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td valign=\"top\" align=\"center\"><h3>??????????????????????????????</h3></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"right\">???1,800</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td valign=\"top\"><div class=\"min-hi\">????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????</div></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"center\"><img src=\"/ideal/img/shrimp2.jpg\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"imgs\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\r\n");
      out.write("\t\t<div style=\"height: 50px\">\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"tableDiv bgBlur\">\r\n");
      out.write("\t\t\t\t<div class=\"flex-container\">\r\n");
      out.write("\t\t\t\t\t<div class=\"flex-item\">\r\n");
      out.write("\t\t\t\t\t\t<h2>????????????</h2>\r\n");
      out.write("\t\t\t\t\t\t<hr></hr>\r\n");
      out.write("\t\t\t\t\t\t<h4>2021.2.1 ?????????????????????????????????????????????????????????????????????????????????????????????</h4>\r\n");
      out.write("\t\t\t\t\t\t<hr></hr>\r\n");
      out.write("\t\t\t\t\t\t<h4>2021.1.15 A?????????(????????????)????????????????????????????????????</h4>\r\n");
      out.write("\t\t\t\t\t\t<hr></hr>\r\n");
      out.write("\t\t\t\t\t\t<h4>2021.1.1 Restaurant IDEALLE ???????????????????????????</h4>\r\n");
      out.write("\t\t\t\t\t\t<hr></hr>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\r\n");
      out.write("\t\t<div style=\"height: 50px\">\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"tableDiv bgBlur\">\r\n");
      out.write("\t\t\t\t<div class=\"flex-container\">\r\n");
      out.write("\t\t\t\t\t<div class=\"flex-item\">\r\n");
      out.write("\t\t\t\t\t\t<h2>???????????????</h2>\r\n");
      out.write("\t\t\t\t\t\t<font color=\"white\">\r\n");
      out.write("\t\t\t\t\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"40%\" rowspan=\"6\" valign=\"top\" align=\"center\"><h3>???????????????????????????</h3></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"60%\">[?????????]</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>????????????????????????????????????????????????</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>[?????????????????????]</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>???????????????????????????????????????????????????????????????</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>[????????????]</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>??????????????????????????????????????????</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td align=\"center\"><h3>??????????????????????????????</h3></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>?????????????????????????????????????????????????????????</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td align=\"center\" valign=\"top\"><h3>?????????????????????</h3></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>???????????????????????????????????????????????????????????????????????????\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t??????/??????????????????????????????????????????????????????????????????????????????</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\r\n");
      out.write("\t\t<div style=\"height: 50px\">\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"tableDiv bgBlur\">\r\n");
      out.write("\t\t\t\t<h2>SNS</h2>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- twitter?????? -->\r\n");
      out.write("\t\t\t\t<a class=\"twitter-timeline\" data-width=\"80%\" data-height=\"550\"\r\n");
      out.write("\t\t\t\t\tdata-theme=\"light\"\r\n");
      out.write("\t\t\t\t\thref=\"https://twitter.com/kenschool?ref_src=twsrc%5Etfw\">Tweets\r\n");
      out.write("\t\t\t\t\tby kenschool</a>\r\n");
      out.write("\t\t\t\t<script async src=\"https://platform.twitter.com/widgets.js\"\r\n");
      out.write("\t\t\t\t\tcharset=\"utf-8\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/ideal/js/adminLoginCheck.js\"></script>\r\n");
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
