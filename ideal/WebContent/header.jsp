<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="model.User"%>
<%@page import="ctrl.SvlUlrl"%>
<%@ page import="ctrl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<noscript>
	<META http-equiv="Refresh" content="0;/ideal/noScriptError.jsp" />
</noscript>
<!--  メニューの要素をここで指定(今回は5つを想定している) -->
<%
	User us = (User) session.getAttribute(LoginVar.userInfo);
%>
<%
	String[] menuName = { "ホーム", "メニュー", "ご予約", "アクセス", "ログイン" };
%>

<%
	String[] menuLink = { "/ideal/home.jsp", SvlUlrl.ShowMenuSvl,
			SvlUlrl.ReserveInsertSvl, "/ideal/access.jsp",
			"/ideal/userLogin.jsp" };
%>
<%
	if (us != null) {
		menuName[4] = "お客様ページ";
		menuLink[4] = "/ideal/userIndex.jsp";
	}
%>

<!-- SNSアカウントと画像イメージの指定 -->
<%!String twitter = "#";
	String twitterImg = "";
	String insta = "#";
	String instaImg = "";%>

<!-- クラス名などが個別なのでループ処理めんどくなったもの -->
<%!String sns = "<ul class='snsbtniti'><li><a href='"
			+ twitter
			+ "' class='flowbtn7 fl_tw7'><i><img src='/ideal/img/white.svg' alt='twitter'  style='width:100%;' /></i></a></li><li><a href='"
			+ insta + "' class='flowbtn7 insta_btn7'><i></i></a></li></ul>";%>
<div id="header-left">

	<!-- ロゴをクリックすることでホームへ移動 -->
	<img id="header-logo" src="/ideal/img/logo3.svg" alt="Homeへ戻る" />

</div>

<div id="header">

	<!-- PS向けのメニュー -->
	<div id="header-right">
		<%
			for (int i = 0; i < menuName.length; i++) {
		%>
		<a class="header-button" href="<%=menuLink[i]%>"><%=menuName[i]%></a>
		<%
			}
		%>
	</div>

	<!-- PC向けのSNSメニュー -->
	<div id="pc-sns-btn">
		<%=sns%>
	</div>
	<!-- ハンバーガーメニュー -->
</div>

<div class="burgerKing bgBlur">

	<!-- ロゴをクリックすることでホームへ移動 -->
	<img id="header-logo" src="/ideal/img/logo3.svg" alt="Homeへ戻る" />

</div>
<input type="checkbox" id="menu-btn-check"> <label
	for="menu-btn-check" class="menu-btn"><span class="menu-btn"></span></label>
	<div class="menu-content">
		<!-- スマホ向けのメニュー -->
		<ul class="menu-content-ul">
			<%
				for (int i = 0; i < menuName.length; i++) {
			%>
			<li class="menu-content-ul-li"><a href="<%=menuLink[i]%>"><%=menuName[i]%></a>
			</li>
			<%
				}
			%>
		</ul>

		<!-- スマホ向けのSNSメニュー -->
		<div id="phone-sns-btn">
			<%=sns%>
		</div>

	</div> </input>