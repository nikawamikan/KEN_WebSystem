<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="controller.UserLoginSvl"%>
<%@page import="controller.UserOperationSvl"%>
<%@page import="static controller.UserOperationSvl.*"%>
<%@ page import="static ctrl.LoginVar.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1"/>
<title>顧客ログイン画面</title>
<link rel="stylesheet" href="/ideal/css/button.css" />
<link rel="stylesheet" href="/ideal/css/bgBlur.css" />
<link rel="stylesheet" href="/ideal/css/form.css" />
<link rel="stylesheet" href="/ideal/css/header.css" />
<link rel="stylesheet" href="/ideal/css/bg.css" />
<link rel="stylesheet" href="/ideal/css/footer.css" />
<link rel="stylesheet" href="/ideal/css/title.css" />
<script type="text/javascript">
	function check() {
		if (document.login.usrId.value == "") {
			window.alert("IDが未入力です。");
			return false;
		} else if (idRegexCheck(document.login.usrId.value)) {
			window.alert("IDは数字で入力してください。");
			return false;

		} else if (document.login.password.value == "") {
			window.alert("パスワードが未入力です。");
			return false;
		} else if (passwordRegexCheck(document.login.password.value)) {
			window.alert("パスワードは英数字で入力してください。");
			return false;
		}
		return true;
	}

	function idRegexCheck(pass) {
		const
		regex = new RegExp('^[0-9]+$');
		return !regex.test(pass);
	}

	function passwordRegexCheck(pass) {
		const
		regex = new RegExp('^[a-zA-Z0-9]+$');
		return !regex.test(pass);
	}
</script>
</head>
<body>
	<div style="min-height: 100vh; position: relative;">
		<jsp:directive.include file="/header.jsp" />

		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1 class="greenBack">ログイン</h1>
			</div>
		</div>
		<jsp:include page="idealException.jsp" />

		<center>
			<div class="tableDiv bgBlur">

				<form id="login" name="login"
					action="/ideal/controller/UserLoginSvl" method="post"
					onsubmit="return check();">
					<input type="hidden" name="mode"
						value="<%=request.getAttribute("mode")%>" />

					<div class="formDiv">
						<div class="formDivInner">
							<div class="titleDiv">
								<div class="tableDef">e-mail</div>
								<div class="messageDiv"></div>
							</div>
							<div>
								<input class="inputDef" id="mailadd" type="text" name="mail" />
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
						<input class="button enterButton" type="submit" value="ログイン" />
					</div>
				</form>
			</div>
			<div style="height: 50px">
				<br />
			</div>
			<div class="tableDiv bgBlur">
					<div class="formDiv">
						<div class="formDivInner">
							<div class="titleDiv">
							<h2>アカウントをお持ちでないですか？<br/><a href="/ideal/userInsert.jsp" style="color: #55ee44">こちら</a>で新しくアカウントを作成できます。</h2>
							</div>
						</div>
					</div>
			</div>
			<div style="margin-top: 3em; display: flex; justify-content: center;">
				<a class="button enterButton" href="/ideal/home.jsp">ホームページに戻る</a>
			</div>
			<div style="height: 50px">
				<br />
			</div>
		</center>


		<jsp:include page="/footer.jsp" />
	</div>
</body>
</html>