/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2021-04-05 01:41:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import general.FormReplacer;
import org.apache.tomcat.jni.Local;
import java.util.Currency;
import java.text.NumberFormat;
import model.Menu;
import model.MenuType;
import ctrl.*;
import controller.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import model.Admin;
import model.User;
import ctrl.SvlUlrl;
import ctrl.*;

public final class menuMaintenance_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("controller");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("ctrl");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("model.Admin");
    _jspx_imports_classes.add("model.User");
    _jspx_imports_classes.add("org.apache.tomcat.jni.Local");
    _jspx_imports_classes.add("java.util.Currency");
    _jspx_imports_classes.add("general.FormReplacer");
    _jspx_imports_classes.add("java.text.NumberFormat");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("ctrl.SvlUlrl");
    _jspx_imports_classes.add("model.Menu");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.Statement");
    _jspx_imports_classes.add("model.MenuType");
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
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/cardStyle.css\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\" />\r\n");
      out.write("<title>メニュー管理</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div style=\"min-height: 100vh; position: relative; width: 100%\">\r\n");
      out.write("\r\n");
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "idealException.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"titleSticky\">\r\n");
      out.write("\t\t\t<div class=\"titleInnerDiv\">\r\n");
      out.write("\t\t\t\t<h1 class=\"redBack\">メニュー管理画面</h1>\r\n");
      out.write("\t\t\t\t<div style=\"position: relative;\">\r\n");
      out.write("\t\t\t\t\t<div class=\"menuLeftInner\" style=\"position: absolute; top: 0;\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" id=\"menu2-btn-check\" style=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"menu2-btn-check\"><span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"bgBlur greenBack m-btn-check\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"position: absolute; top: 2px; left: 5px; z-index: 400;\"><img\r\n");
      out.write("\t\t\t\t\t\t\t\t\tsrc=\"/ideal/img/rightArrow.svg\" /></span></label> </input>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"bgBlur menuLeftInInner\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"position: absolute; top: 0;\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");

								ArrayList<MenuType> mType = (ArrayList<MenuType>) request
										.getAttribute("mType");
								if(mType==null){
									response.sendRedirect("/ideal/controller/MenuMaintenanceSvl");
									return;
								}

								int typeID = (Integer) request.getAttribute("typeID");
								NumberFormat nf = NumberFormat.getCurrencyInstance();

								ArrayList<Menu> menu = (ArrayList<Menu>) request
										.getAttribute("menu");
								if (mType != null) {
									for (MenuType m : mType) {
							
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<form action=\"");
      out.print(SvlUlrl.MenuMaintenanceSvl);
      out.write("\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"typeID\" value=\"");
      out.print(m.getTypeID());
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"button \"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"font-size: 16px; height: 2.2em;");
if (typeID == m.getTypeID()) {
						out.print("background:rgba(70,170,70,0.7)");
					}
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype=\"submit\" value=\"");
      out.print(FormReplacer.fmtNull(m.getTypeName()));
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
								}
							
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"display: flex; width: 100%\">\r\n");
      out.write("\t\t\t<div ><div class=\"menu-margin\"></div></div>\r\n");
      out.write("\t\t\t<div class=\"menuWidth\">\r\n");
      out.write("\t\t\t\t<div style=\"display: flex; justify-content: space-around; width: 100%\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"menuDiv\" style=\"z-index: 1;width: 100%\">\r\n");
      out.write("\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"display: flex; justify-content: space-around; flex-wrap: wrap;width: 100%\">\r\n");
      out.write("\t\t\t\t\t\t\t");

								if (menu != null) {
									for (Menu m : menu) {
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"bgBlur menuCard\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"menuCardInner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h3>");
      out.print(FormReplacer.fmtNull(m.getMenuName()));
      out.write("</h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h4>");
      out.print(nf.format(m.getPrice()));
      out.write("</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");

											if (m.getDetail() != null)
														out.print(m.getDetail());
										
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</h4>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tstyle=\"position: absolute; bottom: 0; right: 0; width: 40%; display: flex;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<form style=\"width: 50%\" action=\"");
      out.print(SvlUlrl.MenuUpdateSvl);
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmethod=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"typeID\" value=\"");
      out.print(m.getTypeId());
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"menuID\" value=\"");
      out.print(m.getMenuId());
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"mode\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
      out.print(MenuOperationSvl.UPDATE);
      out.write("\" /> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"button\" type=\"submit\" value=\"変更\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<form style=\"width: 50%;\" action=\"");
      out.print(SvlUlrl.MenuDeleteSvl);
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmethod=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"typeID\" value=\"");
      out.print(m.getTypeId());
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"menuID\" value=\"");
      out.print(m.getMenuId());
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"mode\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
      out.print(MenuOperationSvl.DELETE);
      out.write("\" /> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"button\" type=\"submit\" value=\"削除\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"bgBlur menuCard\" style=\"min-width: 300px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<form action=\"");
      out.print(SvlUlrl.MenuInsertSvl);
      out.write("\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"typeID\" value=\"");
      out.print(typeID);
      out.write("\" /> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttype=\"hidden\" name=\"mode\" value=\"");
      out.print(MenuOperationSvl.INSERT);
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"button enterButton\" type=\"submit\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvalue=\"新しいメニューの追加\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
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
