/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2021-04-02 01:14:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import general.FormReplacer;
import java.util.*;
import model.*;
import controller.*;
import ctrl.*;
import static general.NullErase.*;
import java.text.NumberFormat;
import model.User;
import ctrl.SvlUlrl;
import ctrl.*;

public final class menuDelete_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_dependants.put("/header.jsp", Long.valueOf(1617320362381L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("controller");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("ctrl");
    _jspx_imports_packages.add("model");
    _jspx_imports_packages.add("static general.NullErase");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.User");
    _jspx_imports_classes.add("general.FormReplacer");
    _jspx_imports_classes.add("java.text.NumberFormat");
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\" />\r\n");
      out.write("<title>Delete Menu</title>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("<!--\r\n");
      out.write("table {\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("caption {\r\n");
      out.write("\tcolor: #990000;\r\n");
      out.write("\tfont-size: 18pt;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\tbackground: #990000;\r\n");
      out.write("\tcolor: #FFD7D7;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td {\r\n");
      out.write("\tbackground: #FFD7D7;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th#bottom {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("p {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		request.setCharacterEncoding("UTF-8");
		NumberFormat nf = NumberFormat.getCurrencyInstance();
	
      out.write('\r');
      out.write('\n');
      out.write('	');

		Menu oneMenu = (Menu) request.getAttribute("oneMenu");
	
      out.write('\r');
      out.write('\n');
      out.write('	');

		int typeID = oneMenu.getTypeId();
	
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
      out.write("\t<META http-equiv=\"Refresh\" content=\"0;noScriptError.jsp\" />\r\n");
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
      out.write("\t<img id=\"header-logo\" src=\"/ideal/img/logo.svg\" alt=\"Homeへ戻る\" />\r\n");
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
      out.write("\t<img id=\"header-logo\" src=\"/ideal/img/logo.svg\" alt=\"Homeへ戻る\" />\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"titleSticky\">\r\n");
      out.write("\t\t\t<div class=\"titleInnerDiv\">\r\n");
      out.write("\t\t\t\t<h1 class=\"greenBack\">お客様脱会手続き</h1>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "idealException.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t\t<div class=\"tableDiv bgBlur\">\r\n");
      out.write("\t\t\t\t<div class=\"flex-container\">\r\n");
      out.write("\t\t\t\t\t<div class=\"formDiv\">\r\n");
      out.write("\t\t\t\t\t\t<h2>\r\n");
      out.write("\t\t\t\t\t\t\tメニュー削除ボタンを押すと<br />削除が確定されます。\r\n");
      out.write("\t\t\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"flex-item\">\r\n");
      out.write("\t\t\t\t\t\t<h2>メニュー名</h2>\r\n");
      out.write("\t\t\t\t\t\t<h3>");
      out.print(FormReplacer.fmtNull(oneMenu.getMenuName()));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t\t\t<h2>価格</h2>\r\n");
      out.write("\t\t\t\t\t\t<h3>");
      out.print(nf.format(oneMenu.getPrice()) );
      out.write("</h3>\r\n");
      out.write("\t\t\t\t\t\t<h2>オーダーの可否</h2>\r\n");
      out.write("\t\t\t\t\t\t<h3>");
if(oneMenu.getOrderFlg()==0){
							out.print("不可");
						}else{
							out.print("可");
						}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"flex-item\">\r\n");
      out.write("\t\t\t\t\t\t<h2>分類</h2>\r\n");
      out.write("\t\t\t\t\t\t<h3>");
      out.print(FormReplacer.fmtNull(oneMenu.getTypeName()));
      out.write("</h3>\r\n");
      out.write("\t\t\t\t\t\t<h2>コメント</h2>\r\n");
      out.write("\t\t\t\t\t\t<h3>");
      out.print(fmtNull(oneMenu.getDetail()));
      out.write("</h3>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\tstyle=\"display: flex; flex-wrap: wrap; justify-content: space-around;\">\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<form action=\"");
      out.print(SvlUlrl.MenuOperationSvl);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"mode\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"");
      out.print(MenuOperationSvl.DELETE);
      out.write("\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"typeID\" value=\"");
      out.print(oneMenu.getTypeId());
      out.write("\" /> <input\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"hidden\" name=\"menuID\" value=\"");
      out.print(oneMenu.getMenuId());
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"button enterButton\" type=\"submit\" value=\"メニュー削除\" />\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"height: 50px\">\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div style=\"margin-top: 3em; display: flex; justify-content: center;\">\r\n");
      out.write("\t\t\t\t<a class=\"button enterButton\" href=\"");
      out.print(SvlUlrl.MenuMaintenanceSvl);
      out.write("\">メニューメンテナンスに戻る</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"height: 50px\">\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
