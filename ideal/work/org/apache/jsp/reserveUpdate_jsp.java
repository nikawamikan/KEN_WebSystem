/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2021-04-05 06:01:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import general.FormReplacer;
import java.time.temporal.ChronoUnit;
import general.ReserveDate;
import java.time.LocalDate;
import ctrl.SvlUlrl;
import ctrl.ReserveVar;
import ctrl.SvlName;
import java.time.LocalDateTime;
import java.util.ArrayList;
import controller.ReserveOperationSvl;
import controller.ReserveListSvl;
import static controller.ReserveOperationSvl.*;
import model.*;
import model.User;
import ctrl.SvlUlrl;
import ctrl.*;

public final class reserveUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
static final String[] YOUBI = { "日", "月", "火", "水", "木", "金", "土" };
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
    _jspx_imports_packages.add("static controller.ReserveOperationSvl");
    _jspx_imports_packages.add("model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("controller.ReserveOperationSvl");
    _jspx_imports_classes.add("java.time.temporal.ChronoUnit");
    _jspx_imports_classes.add("general.ReserveDate");
    _jspx_imports_classes.add("ctrl.SvlName");
    _jspx_imports_classes.add("java.time.LocalDate");
    _jspx_imports_classes.add("java.time.LocalDateTime");
    _jspx_imports_classes.add("model.User");
    _jspx_imports_classes.add("ctrl.ReserveVar");
    _jspx_imports_classes.add("controller.ReserveListSvl");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/button.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/bgBlur.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/form.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/header.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/bg.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/footer.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/title.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/table.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ideal/css/access.css\" />\r\n");
      out.write("\r\n");
      out.write("<title>予約変更画面</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://unpkg.com/swiper/swiper-bundle.min.css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("@media screen and (max-width:400px) {\r\n");
      out.write("\t.swiper-button-prev {\r\n");
      out.write("\t\tdisplay: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t.swiper-button-next {\r\n");
      out.write("\t\tdisplay: none;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* 左右のボタンの位置の微調整用 */\r\n");
      out.write(".swiper-button-next {\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".swiper-button-prev {\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(":root { -\r\n");
      out.write("\t-swiper-navigation-color: #ffffff; -\r\n");
      out.write("\t-swiper-pagination-color: #ffffff;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		ArrayList<Course> courseList = (ArrayList<Course>)request.getAttribute(reserveVar.courseList);
		if (courseList == null) {
			response.sendRedirect("/ideal/home.jsp");
			return;
		}
		Reserve res = (Reserve)request.getAttribute(reserveVar.reserve);

		LocalDate appLd=LocalDate.now();
		LocalDate rsvLd=LocalDate.of(res.getRsvYy(), res.getRsvMm(), res.getRsvDd());
		long afterDate= ChronoUnit.DAYS.between(appLd, rsvLd);
	
      out.write("\r\n");
      out.write("\t<div style=\"min-height: 100vh; position: relative;\">\r\n");
      out.write("\r\n");
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
      out.write("<!--  メニューの要素をここで指定(今回は5つを想定している) -->\r\n");

	User us = (User) session.getAttribute(LoginVar.userInfo);

      out.write('\r');
      out.write('\n');

	String[] menuName = { "ホーム", "メニュー", "ご予約", "アクセス", "ログイン" };

      out.write("\r\n");
      out.write("\r\n");

	String[] menuLink = { "/ideal/home.jsp", SvlUlrl.ShowMenuSvl,
			SvlUlrl.ReserveInsertSvl, "/ideal/access.jsp",
			"/ideal/userLogin.jsp" };

      out.write('\r');
      out.write('\n');

	if (us != null) {
		menuName[4] = "お客様ページ";
		menuLink[4] = "/ideal/userIndex.jsp";
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- SNSアカウントと画像イメージの指定 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- クラス名などが個別なのでループ処理めんどくなったもの -->\r\n");
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
      out.write("\t<!-- PC向けのSNSメニュー -->\r\n");
      out.write("\t<div id=\"pc-sns-btn\">\r\n");
      out.write("\t\t");
      out.print(sns);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- ハンバーガーメニュー -->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("\t\t<!-- スマホ向けのSNSメニュー -->\r\n");
      out.write("\t\t<div id=\"phone-sns-btn\">\r\n");
      out.write("\t\t\t");
      out.print(sns);
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div> </input>");
      out.write("\r\n");
      out.write("\t\t<div class=\"titleSticky\">\r\n");
      out.write("\t\t\t<div class=\"titleInnerDiv\">\r\n");
      out.write("\t\t\t\t<h1 class=\"greenBack\">");
      out.print(FormReplacer.fmtNull(us.getUsrName()));
      out.write("様 ご予約の変更\r\n");
      out.write("\t\t\t\t</h1>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t\t<div class=\"tableDiv bgBlur\" style=\"position: relative;\">\r\n");
      out.write("\t\t\t\t<div style=\"width: 100%\">\r\n");
      out.write("\t\t\t\t\t<h2 class=\"yellowBack\">ご予約される日付</h2>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"swiper-button-prev\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"swiper-container\">\r\n");
      out.write("\t\t\t\t\t<!-- Additional required wrapper -->\r\n");
      out.write("\t\t\t\t\t<div class=\"swiper-wrapper\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");

		int counter = 1;
		LocalDate date = LocalDate.now();
		for (int i = 0; i < 13; i++) {
			if (i == 0 && date.getDayOfMonth() == date.lengthOfMonth()) {
				continue;
			}

			int youbiInt = date.plusMonths(i).withDayOfMonth(1)
					.getDayOfWeek().getValue();
			if (youbiInt == 7) {
				youbiInt = 0;
			}
	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"swiper-slide\" style=\"height: 350px\">\r\n");
      out.write("\t\t\t\t\t\t\t<h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print( date.plusMonths(i).getMonthValue()+"月");
      out.write("</h3>\r\n");
      out.write("\t\t\t\t\t\t\t<table class=\"tableRadius\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");


				for (String youbi : YOUBI) {
			
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th style=\"color: #ffffff;\">");
      out.print(youbi);
      out.write("</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

				if (youbiInt != 7) {
						for (int j = youbiInt; j > 0; j--) {
							out.print("<td></td>");
						}
					}
					for (int j = 1; j <= date.plusMonths(i).lengthOfMonth(); j++) {
						if (youbiInt++ == 7) {
							youbiInt = 1;
			
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

				if ((i == 0 && date.getDayOfMonth() >= j)
								|| (i == 12 && date.plusMonths(i).getDayOfMonth() < j)) {
			
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td style=\"text-align: center;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"graytile\">");
      out.print(j);
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

				} else {
			
      out.write("<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<form action=\"#\" onsubmit=\"return getReserveList(this)\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"calNum\" type=\"hidden\" value=\"");
      out.print(counter);
      out.write("\" /> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"greentile\" type=\"submit\" value=\"");
      out.print(j);
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");

						counter++;
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

				}
					}
			
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t");

		}
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"swiper-pagination\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"swiper-button-next\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "idealException.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div style=\"height: 100px\">\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"tableDiv bgBlur\">\r\n");
      out.write("\t\t\t\t<!-- ajaxで予約時間の要素取得します。 -->\r\n");
      out.write("\t\t\t\t<div id=\"ajaxReserveListTime\"></div>\r\n");
      out.write("\t\t\t\t<div id=\"ajaxReserveList\" style=\"overflow-x: auto;\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div style=\"height: 100px\">\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"tableDiv bgBlur\">\r\n");
      out.write("\t\t\t\t<div style=\"width: 100%\">\r\n");
      out.write("\t\t\t\t\t<h2 id=\"lastForm\" class=\"yellowBack\">ご予約の内容</h2>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"min-width: 300; color: #ffffff;\">\r\n");
      out.write("\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\tstyle=\"display: flex; flex-wrap: wrap; justify-content: center;\">\r\n");
      out.write("\t\t\t\t\t\t<h3 style=\"width: 100%;\">ご予約の日時</h3>\r\n");
      out.write("\t\t\t\t\t\t<h3 id=\"dispYear\" style=\"margin: 1em;\"></h3>\r\n");
      out.write("\t\t\t\t\t\t<h3 id=\"dispMonthDate\" style=\"margin: 1em;\"></h3>\r\n");
      out.write("\t\t\t\t\t\t<h3 id=\"dispHourMin\" style=\"margin: 1em;\"></h3>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\tstyle=\"display: flex; flex-wrap: wrap; justify-content: center;\">\r\n");
      out.write("\t\t\t\t\t\t<h3 style=\"width: 100%;\">ご予約のテーブル名</h3>\r\n");
      out.write("\t\t\t\t\t\t<h3 id=\"tableName\" style=\"margin: 1em;\"></h3>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"display: flex; justify-content: center\">\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<form id=\"reserveForm\" action=\"");
      out.print(SvlUlrl.ReserveOperationSvl);
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\tmethod=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" id=\"mode\" name=\"mode\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"");
      out.print(ReserveOperationSvl.UPDATE);
      out.write("\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"rsvYy\" name=\"rsvYy\" value=\"\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"rsvMm\" name=\"rsvMm\" value=\"\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"rsvDd\" name=\"rsvDd\" value=\"\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"rsvHh\" name=\"rsvHh\" value=\"\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"rsvMi\" name=\"rsvMi\" value=\"\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"tableId\" name=\"tableId\" value=\"\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"");
      out.print(reserveVar.rsvId );
      out.write("\" name=\"");
      out.print(reserveVar.rsvId );
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"");
      out.print(res.getRsvId() );
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"messageDiv\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"formDiv\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"formDivInner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"titleDiv\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"tableDef\">ご予約される人数</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"messageDiv\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"inputDef\" id=\"person\" name=\"person\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"\"></option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"messageDiv\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"formDiv\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"formDivInner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"titleDiv\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"tableDef\">ご予約されるコース</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"messageDiv\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"inputDef\" id=\"courseId\" name=\"courseId\" onchange=\"coursePrint()\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");

								for(Course oneCourse:courseList){
											String select = "";
									if(oneCourse.getCourseId()==res.getCourseId()){
										select ="selected";
									}else{
										select ="";

									}
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(oneCourse.getCourseId());
      out.write('"');
      out.write(' ');
      out.print(select );
      out.write('>');
      out.print(FormReplacer.fmtNull(oneCourse.getCourseName()));
      out.write("</option>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");

							}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"formDiv\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"flex-container\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div id=\"coursePrint\" class=\"flex-item\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div id=\"coursePrint2\" class=\"flex-item\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"messageDiv\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"formDiv\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"send\" class=\"button enterButton\" type=\"submit\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdisabled=\"disabled\" value=\"予約する\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"height: 50px\">\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div style=\"display: flex; justify-content: center\">\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<form action=\"");
      out.print(SvlUlrl.ReserveListSvl);
      out.write("\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"button enterButton\" type=\"submit\" value=\"予約一覧に戻る\" />\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"height: 50px\">\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"today\" name=\"today\"\r\n");
      out.write("\t\t\t\tvalue=\"");
      out.print(ReserveDate.getToday());
      out.write("\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\tid=\"afterDate\" name=\"afterDate\" value=\"");
      out.print(afterDate);
      out.write("\" /> <input\r\n");
      out.write("\t\t\t\ttype=\"hidden\" id=\"rsvYyDef\" value=\"");
      out.print(res.getRsvYy() );
      out.write("\" /> <input\r\n");
      out.write("\t\t\t\ttype=\"hidden\" id=\"rsvMmDef\" value=\"");
      out.print(res.getRsvMm() );
      out.write("\" /> <input\r\n");
      out.write("\t\t\t\ttype=\"hidden\" id=\"rsvDdDef\" value=\"");
      out.print(res.getRsvDd() );
      out.write("\" /> <input\r\n");
      out.write("\t\t\t\ttype=\"hidden\" id=\"rsvHhDef\" value=\"");
      out.print(res.getRsvHh() );
      out.write("\" /> <input\r\n");
      out.write("\t\t\t\ttype=\"hidden\" id=\"rsvMiDef\" value=\"");
      out.print(res.getRsvMi() );
      out.write("\" /> <input\r\n");
      out.write("\t\t\t\ttype=\"hidden\" id=\"tableIdDef\" value=\"");
      out.print(res.getTableId() );
      out.write("\" /> <input\r\n");
      out.write("\t\t\t\ttype=\"hidden\" id=\"personDef\" value=\"");
      out.print(res.getPerson() );
      out.write("\" />\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"\r\n");
      out.write("\t\ttype=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"https://unpkg.com/swiper/swiper-bundle.min.js\"></script>\r\n");
      out.write("\t<script src=\"/ideal/js/reserveUpdateTableCreater.js\"\r\n");
      out.write("\t\ttype=\"text/javascript\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tvar Swiper = new Swiper('.swiper-container', {\r\n");
      out.write("\t\t\tslidesPerView : 1,\r\n");
      out.write("\t\t\tpagination : {\r\n");
      out.write("\t\t\t\tel : '.swiper-pagination',\r\n");
      out.write("\t\t\t\ttype : 'bullets',\r\n");
      out.write("\t\t\t\tclickable : true\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tnavigation : {\r\n");
      out.write("\t\t\t\tnextEl : '.swiper-button-next',\r\n");
      out.write("\t\t\t\tprevEl : '.swiper-button-prev',\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\r\n");
      out.write("\t\t\tbreakpoints : {\r\n");
      out.write("\t\t\t\t// 画面幅が 640px 以上の場合（window width >= 640px）\r\n");
      out.write("\t\t\t\t640 : {\r\n");
      out.write("\t\t\t\t\tslidesPerView : 2,\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t// 画面幅が 980px 以上の場合（window width >= 980px）\r\n");
      out.write("\t\t\t\t980 : {\r\n");
      out.write("\t\t\t\t\tslidesPerView : 3,\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t})\r\n");
      out.write("\t</script>\r\n");
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