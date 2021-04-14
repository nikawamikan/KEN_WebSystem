<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="general.FormReplacer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
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
<title>会員登録完了画面</title>
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
				<h1 class="greenBack">会員登録が完了しました</h1>
			</div>
		</div>
		<jsp:include page="idealException.jsp" />

		<center>
			<div class="tableDiv bgBlur">
				<div class="formDiv">
					<h2>お客様の情報は以下の通りに登録されました。</h2>
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
					style="margin-top: 3em; display: flex; justify-content: center;">
				<a class="button enterButton" href="/ideal/userIndex.jsp">会員ページに移動</a>
				</div>
		</center>

		<jsp:include page="/footer.jsp" />
	</div>

</body>
</html>