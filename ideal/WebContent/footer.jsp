<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="ctrl.AdminVar"%>
<%@page import="model.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<div style="height: 100px"></div>
<div id="footer" class="bgBlur">
	<div
		style="position: absolute; bottom: 0; left: 50%; transform: translate(-50%, 0)">©
		Ristorante ideal</div>
	<%
			String url = "/ideal/controller/MenuMaintenanceSvl";
		Admin admin2 = (Admin) session.getAttribute(AdminVar.adminInfo);
		if (admin2 == null) {
			url = "/ideal/adminLogin.jsp";
		}
	%>
	<a href="<%=url %>" style="float: right; height: 100%">
		<img src="/ideal/img/admin.svg"
		style="width: 30px; margin-top: 10px; margin-right: 15px;" alt="" />
	</a>
</div>