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
<title>JavaScriptを有効にしてください</title>
</head>
<body>

	<div style="min-height: 100vh; position: relative;">

		<jsp:directive.include file="/header2.jsp" />

		<jsp:include page="idealException.jsp" />

		<center>
			<div class="tableDiv bgBlur">
				<div class="flex-container">
						<h2>本サイトではJavaScriptを利用しています。</h2>
						<h3>下記の手順を参考にJavaScriptを有効にしてください。</h3>
				</div>

			</div>

		<div style="height: 50px">
			<br />
		</div>		</center>

		<center>
			<div class="tableDiv bgBlur">
				<div class="flex-container">
						<h2>JavaScriptを有効にする方法</h2>
						<h3>Google Chromeの場合</h3>
						<h4>1.画面右上の[...]をクリックする。</h4>
						<img src="/ideal/img/chrome1.jpg" />
						<h4>2.メニュー下部の[設定]をクリックする。</h4>
						<img src="/ideal/img/chrome2.jpg" />
						<h4>3.「プライバシーとセキュリティ」にある[サイトの設定]をクリックする。</h4>
						<img src="/ideal/img/chrome3.jpg" />
						<h4>4.「コンテンツ」にある[JavaScript]をクリックする。</h4>
						<img src="/ideal/img/chrome4.jpg" />
						<h4>5.「JavaScript」にある[ブロック中]をオンにする。</h4>
						<img src="/ideal/img/chrome5.jpg" />
						<h4>6.完了。</h4>
				</div>
			</div>
		</center>
				<div style="height: 50px">
			<br />
		</div>

		<center>
			<div class="tableDiv bgBlur">
				<div class="flex-container">
						<h3>Edgeの場合</h3>
						<h4>1.画面右上の[...]をクリックする。</h4>
						<img src="/ideal/img/chrome1.jpg" />
						<h4>2.メニュー下部の[設定]をクリックする。</h4>
						<img src="/ideal/img/chrome2.jpg" />
						<h4>3.「設定」にある[Cookie とサイトのアクセス許可]をクリックする。</h4>
						<img src="/ideal/img/chrome3.jpg" />
						<h4>4.「サイトのアクセス許可」にある[JavaScript]をクリックする。</h4>
						<img src="/ideal/img/chrome4.jpg" />
						<h4>5.「サイトのアクセス許可/JavaScript」にある[許可 (推奨)]をオンにする。</h4>
						<img src="/ideal/img/chrome5.jpg" />
						<h4>6.完了。</h4>
				</div>
			</div>
		</center>
				<div style="height: 50px">
			<br />
		</div>

		<jsp:include page="/footer.jsp" />
	</div>

</body>
</html>