<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="ctrl.SvlUlrl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1"/>
<title>管理者ログイン画面</title>
<link rel="stylesheet" href="/ideal/css/button.css" />
<link rel="stylesheet" href="/ideal/css/bgBlur.css" />
<link rel="stylesheet" href="/ideal/css/form.css" />
<link rel="stylesheet" href="/ideal/css/header.css" />
<link rel="stylesheet" href="/ideal/css/bg.css" />
<link rel="stylesheet" href="/ideal/css/footer.css" />
<link rel="stylesheet" href="/ideal/css/title.css" />

</head>
<body>
<div style="min-height: 100vh; position: relative;">
		<jsp:directive.include file="/header.jsp" />

		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1 class="redBack">管理者ログイン</h1>
			</div>
		</div>
		<jsp:include page="idealException.jsp" />

		<center>
			<div class="tableDiv bgBlur">

			<form id="frm" name="frm" action="<%= SvlUlrl.AdminLoginSvl %>" method="post" onsubmit="return adminLoginCheck(this)" >
					<input type="hidden" name="mode"
						value="<%=request.getAttribute("mode")%>" />


					<div class="formDiv">
					<h2>ここは管理者ログインページです。<br/>
					お客様がログインされる場合はログインボタンからログインしてください</h2>
					</div>
					<div class="formDiv">
						<div class="formDivInner">
							<div class="titleDiv">
								<div class="tableDef">ユーザー名</div>
								<div class="messageDiv"></div>
							</div>
							<div>
								<input class="inputDef" type="text" name="admName" />
							</div>
						</div>
					</div>
								<div class="messageDiv"></div>
					<div class="formDiv">
						<div class="formDivInner">
							<div class="titleDiv">
								<div class="tableDef">パスワード</div>
								<div class="messageDiv"></div>
							</div>
							<div>
								<input class="inputDef" type="password" name="password" />
							</div>
						</div>
					</div>
					<div style="display: flex; justify-content: center;">
						<input class="button enterButton" type="submit" value="管理者としてログイン" />
					</div>
				</form>
			</div>
		</center>

		
		<jsp:include page="/footer.jsp" />
	</div>

<script type="text/javascript" src="/ideal/js/adminLoginCheck.js" ></script>
</body>
</html>