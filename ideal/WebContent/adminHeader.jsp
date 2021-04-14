<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="model.Admin"%>
<%@page import="model.User"%>
<%@page import="ctrl.SvlUlrl"%>
<%@ page import="ctrl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<noscript>
	<META http-equiv="Refresh" content="0;/ideal/noScriptError.jsp" />
</noscript>
<%
	Admin amd = (Admin) session.getAttribute(AdminVar.adminInfo);
%>
<%!String[] menuName = { "メニューメンテ", "予約確認", "ログアウト" };%>

<%!String[] menuLink = { SvlUlrl.MenuMaintenanceSvl, "/ideal/controller/AdminReserveListSvl",  "/ideal/controller/UserLogoffSvl" };%>

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
		<a class="header-button" style="width:25%" href="<%=menuLink[i]%>"><%=menuName[i]%></a>
		<%
			}
		%>
	</div>
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
	</div>
</input>