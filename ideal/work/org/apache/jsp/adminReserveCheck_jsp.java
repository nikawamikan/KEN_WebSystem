/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2021-04-05 01:41:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import general.FormReplacer;
import general.ReserveDate;
import java.time.LocalDate;
import ctrl.ReserveVar;
import ctrl.SvlUlrl;
import ctrl.SvlName;
import java.util.ArrayList;
import model.Reserve;
import model.User;
import ctrl.LoginVar;
import model.Admin;
import model.User;
import ctrl.SvlUlrl;
import ctrl.*;

public final class adminReserveCheck_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

String[] menuName = { "メニューメンテ", "予約確認", "ログアウト" };
String[] menuLink = { SvlUlrl.MenuMaintenanceSvl, "/ideal/controller/AdminReserveListSvl",  "/ideal/controller/UserLogoffSvl" };
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/adminHeader.jsp", Long.valueOf(1617586891907L));
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
    _jspx_imports_classes.add("general.ReserveDate");
    _jspx_imports_classes.add("ctrl.SvlName");
    _jspx_imports_classes.add("ctrl.LoginVar");
    _jspx_imports_classes.add("model.Reserve");
    _jspx_imports_classes.add("java.time.LocalDate");
    _jspx_imports_classes.add("model.Admin");
    _jspx_imports_classes.add("model.User");
    _jspx_imports_classes.add("ctrl.ReserveVar");
    _jspx_imports_classes.add("general.FormReplacer");
    _jspx_imports_classes.add("ctrl.SvlUlrl");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/button.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/bgBlur.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/form.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/header.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/bg.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/footer.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/title.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/access.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/cardStyle.css\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\" />\r\n");
      out.write("<title>管理者予約管理画面</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div style=\"min-height: 100vh; position: relative;\">\r\n");
      out.write("\t\t");
      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<noscript>\r\n");
      out.write("\t<META http-equiv=\"Refresh\" content=\"0;/ideal/noScriptError.jsp\" />\r\n");
      out.write("</noscript>\r\n");

	Admin amd = (Admin) session.getAttribute(AdminVar.adminInfo);

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"header-left\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- ロゴをクリックすることでホームへ移動 -->\r\n");
      out.write("\t<img id=\"header-logo\" src=\"/ideal/img/logo3.svg\" alt=\"Homeへ戻る\" />\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- PS向けのメニュー -->\r\n");
      out.write("\t<div id=\"header-right\">\r\n");
      out.write("\t\t");

			for (int i = 0; i < menuName.length; i++) {
		
      out.write("\r\n");
      out.write("\t\t<a class=\"header-button\" style=\"width:25%\" href=\"");
      out.print(menuLink[i]);
      out.write('"');
      out.write('>');
      out.print(menuName[i]);
      out.write("</a>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"burgerKing bgBlur\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- ロゴをクリックすることでホームへ移動 -->\r\n");
      out.write("\t<img id=\"header-logo\" src=\"/ideal/img/logo3.svg\" alt=\"Homeへ戻る\" />\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<input type=\"checkbox\" id=\"menu-btn-check\"> <label\r\n");
      out.write("\tfor=\"menu-btn-check\" class=\"menu-btn\"><span class=\"menu-btn\"></span></label>\r\n");
      out.write("\t<div class=\"menu-content\">\r\n");
      out.write("\t\t<!-- スマホ向けのメニュー -->\r\n");
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
      out.write("\t</div>\r\n");
      out.write("</input>");
      out.write("\r\n");
      out.write("\t\t");

			ArrayList<Reserve> reList = (ArrayList<Reserve>) request
					.getAttribute(ReserveVar.reserveList);

		if(reList==null){
			response.sendRedirect("/ideal/controller/AdminReserveListSvl");
		}

			ArrayList<Integer> today = ReserveDate.getDateIntArray(ReserveDate
					.getToday());
		
      out.write("\r\n");
      out.write("\t\t<div class=\"titleSticky\">\r\n");
      out.write("\t\t\t<div class=\"titleInnerDiv\">\r\n");
      out.write("\t\t\t\t<h1 class=\"redBack\">お客様のご予約情報</h1>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- メッセージがあれば表示 -->\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "idealException.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t\t<div style=\"display: flex; flex-wrap: wrap;  justify-content:space-around;\">\r\n");
      out.write("\t\t\t\t");

				if (reList != null) {
					if (!reList.isEmpty()) {
						for (Reserve re : reList) {
			
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"tableDiv bgBlur cardStyle\" >\r\n");
      out.write("\t\t\t\t\t<h2>");
      out.print(FormReplacer.fmtNull(re.getUsrName()) );
      out.write("様のご予約</h2>\r\n");
      out.write("\t\t\t\t\t<h2>ご予約日時</h2>\r\n");
      out.write("\t\t\t\t\t<h3>");
      out.print(re.getRsvYy());
      out.write("年\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(re.getRsvMm());
      out.write("月\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(re.getRsvDd());
      out.write("日<br />");
      out.print(re.getRsvHh());
      out.write("時\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(re.getRsvMi());
      out.write("分\r\n");
      out.write("\t\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div style=\"height: 1em\">\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<h2>人数</h2>\r\n");
      out.write("\t\t\t\t\t<h3>");
      out.print(re.getPerson());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t名様\r\n");
      out.write("\t\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t\t<div style=\"height: 1em\">\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<h2>ご注文のコース</h2>\r\n");
      out.write("\t\t\t\t\t<h3>");
      out.print(FormReplacer.fmtNull(re.getCourseName()));
      out.write("</h3>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");

				}
					} else {
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"tableDiv bgBlur\">\r\n");
      out.write("\t\t\t\t\t<div class=\"flex-container\">\r\n");
      out.write("\t\t\t\t\t\t<h2 style=\"width: 100%\">まだ、予約はありません。</h2>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"height: 50px\">\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");

					}
						} else
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
