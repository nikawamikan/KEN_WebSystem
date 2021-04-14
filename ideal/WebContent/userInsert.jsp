<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="controller.UserOperationSvl"%>
<%@page import="static controller.UserOperationSvl.*"%>
<%@ page import="static ctrl.LoginVar.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1"/>
<title>お客様情報登録</title>
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

s		<div>
			<div class="titleSticky">
				<div class="titleInnerDiv">
					<h1 class="greenBack">お客様情報登録</h1>
				</div>
			</div>
			<jsp:include page="idealException.jsp" />
			<center>
				<div class="tableDiv bgBlur">

					<form name="insert" action="/ideal/controller/UserOperationSvl"
						method="post" onsubmit="return userInsertCheck(this);">

						<div class="formDiv">
							<div class="formDivInner">
								<div class="titleDiv">
									<div class="tableDef">[必須]お名前</div>
									<div class="messageDiv"></div>
								</div>
								<div>
									<input class="inputDef" type="text" name="usrName" />
								</div>
							</div>
						</div>
						<div class="formDiv">
							<div class="formDivInner">
								<div class="titleDiv">
									<div class="messageDiv"></div>
									<div class="tableDef">郵便番号</div>
								</div>
								<div>
									<div class="messageDiv" id="status"></div>
									<input class="inputDef" id="zipcode" type="text" name="zipcode"  />
									<div>
										<input class="button formButton" id="searchBtn" type="button"
											value="検索" />
									</div>
								</div>
							</div>
						</div>
						<div class="formDiv">
							<div class="formDivInner">
								<div class="titleDiv">
									<div class="tableDef">住所</div>
									<div class="messageDiv"></div>
								</div>
								<div>
									<input id="address" class="inputDef" type="text" name="address" />
								</div>
							</div>
						</div>
						<div class="messageDiv"></div>
						<div class="formDiv">
							<div class="formDivInner">
								<div class="titleDiv">
									<div class="tableDef">電話番号</div>
									<div class="messageDiv"></div>
								</div>
								<div>
									<input class="inputDef" type="text" name="phone" />
								</div>
							</div>
						</div>
						<div class="formDiv">
							<div class="formDivInner">
								<div class="titleDiv">
									<div class="messageDiv"></div>
									<div class="tableDef">[必須]e-mail</div>
								</div>
								<div>
									<div class="messageDiv" id="mailMessage"></div>
									<input class="inputDef" id="mailadd" type="text" name="mail" />
									<div>
										<input class="button formButton" id="mailid" type="button"
											value="使用可能かチェック" />
									</div>
								</div>
							</div>
						</div>
						<div class="formDiv">
							<div class="formDivInner">
								<div class="titleDiv">
									<div class="tableDef">[必須]パスワード</div>
									<div class="messageDiv"></div>
								</div>
								<div>
									<input class="inputDef" type="password" name="password" />
								</div>
							</div>
						</div>
						<div style="display: flex; justify-content: center;">
							<input class="button enterButton" type="submit" value="登録" />
						</div>


						<input type="hidden" name="mode"
							value="<%=UserOperationSvl.INSERT%>" />

					</form>
				</div>
				<div
					style="margin-top: 3em; display: flex; justify-content: center;">
					<a class="button enterButton" href="/ideal/home.jsp">ホームページに戻る</a>
				</div>
				<div style="height: 50px">
					<br />
				</div>

			</center>
		</div>


		<jsp:include page="/footer.jsp" />
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	type="text/javascript"></script>
<script src="/ideal/js/userInsertCheck.js" type="text/javascript"></script>
</body>
</html>