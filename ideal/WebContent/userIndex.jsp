<?xml version="1.0" encoding="UTF-8" ?>
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
<title>お客様情報</title>
</head>
<body>

	<div style="min-height: 100vh; position: relative;">

		<jsp:directive.include file="/header.jsp" />
		<%
			if (us == null) {
				response.sendRedirect("/ideal/controller/SessionErrSvl");
				return;
			}
		%>

		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1 class="greenBack">会員様メニュー</h1>
			</div>
		</div>
		<jsp:include page="idealException.jsp" />

		<center>
			<div class="tableDiv bgBlur">
				<div class="flex-container">
					<div style="width: 100%">
						<h2><%=us.getUsrName() %>様のページ</h2>
					</div>
					<div>
						<a class="button enterButton" href="<%=SvlUlrl.ReserveListSvl%>">ご予約の確認</a>
						<br/>
						<a class="button enterButton" href="<%=SvlUlrl.UserUpdateSvl%>">お客様情報変更</a>

					</div>
					<div>
						<a class="button enterButton" href="<%=SvlUlrl.UserDeleteSvl%>">お客様脱会手続き</a>
						<br/>
						<a class="button enterButton" href="<%=SvlUlrl.UserLogoffSvl%>">ログアウト</a>
					</div>
				</div>

			</div>
		</center>

		<jsp:include page="/footer.jsp" />
	</div>

</body>
</html>