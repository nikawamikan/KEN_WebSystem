<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.text.Normalizer.Form"%>
<%@page import="general.FormReplacer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="controller.UserOperationSvl"%>
<%@page import="static controller.UserOperationSvl.*"%>
<%@page import="model.*"%>
<%@ page import="ctrl.*"%>
<%@ page import="controller.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="/ideal/css/button.css" />
<link rel="stylesheet" href="/ideal/css/bgBlur.css" />
<link rel="stylesheet" href="/ideal/css/form.css" />
<link rel="stylesheet" href="/ideal/css/header.css" />
<link rel="stylesheet" href="/ideal/css/bg.css" />
<link rel="stylesheet" href="/ideal/css/footer.css" />
<link rel="stylesheet" href="/ideal/css/title.css" />
<link rel="stylesheet" href="/ideal/css/access.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>お客様脱会手続き</title>
</head>
<body>
	<div style="min-height: 100vh; position: relative;">
		<jsp:directive.include file="/header.jsp" />
		<%
			User us2 = (User) request.getAttribute(LoginVar.userInfo);
			if (us2 == null) {
				response.sendRedirect("/ideal/home.jsp");
				return;
			}
		%>

		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1 class="greenBack">お客様脱会手続き</h1>
			</div>
		</div>


		<jsp:include page="idealException.jsp" />
		<center>
			<div class="tableDiv bgBlur">
				<div class="flex-container">
					<div class="formDiv">
						<h2>
							下部のお客様の脱会ボタンを押すと<br />脱会が確定されます。
						</h2>
					</div>
					<div class="flex-item">
						<h2>お客様のお名前</h2>
						<h3><%=FormReplacer.fmtNull(us2.getUsrName())%>
						</h3>
						<h2>住所</h2>
						<%
							if (us2.getZipcode().equals("") && us2.getZipcode().equals("")) {
						%>

						<h3>登録はありません。</h3>

						<%
							} else {
						%>
						<h3><%=FormReplacer.fmtNull(us2.getZipcode())%><br /><%=FormReplacer.fmtNull(us2.getAddress())%>
						</h3>
						<%
							}
						%>
					</div>

					<div class="flex-item">
						<h2>電話番号</h2>
						<%
							if (us2.getPhone().equals("")) {
						%>
						<h3>登録はありません。</h3>
						<%
							} else {
						%>
						<h3><%=FormReplacer.fmtNull(us2.getPhone())%></h3>
						<%
							}
						%>
						<h2>e-mail</h2>
						<h3><%=FormReplacer.fmtNull(us2.getMail())%></h3>
					</div>

				</div>
				<div
					style="display: flex; flex-wrap: wrap; justify-content: space-around;">
					<div>
						<form action="/ideal/controller/UserOperationSvl">
							<input type="hidden" name="mode"
								value="<%=UserOperationSvl.DELETE%>" /> <input type="hidden"
								name="usrId" value="<%=us.getUsrId()%>" /> <input
								class="button enterButton" type="submit" value="お客様の脱会" />
						</form>
					</div>
				</div>
			</div>
			<div style="height: 50px">
				<br />
			</div>

			<div style="margin-top: 3em; display: flex; justify-content: center;">
				<a class="button enterButton" href="<%=SvlUlrl.ReserveListSvl%>">お客様の管理メニューに戻る</a>
			</div>
			<div style="height: 50px">
				<br />
			</div>


		</center>
		<jsp:include page="/footer.jsp" />
	</div>
</body>
</html>
