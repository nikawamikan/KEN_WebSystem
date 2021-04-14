<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="/ideal/css/bgBlur.css" />
<link rel="stylesheet" href="/ideal/css/form.css" />
<link rel="stylesheet" href="/ideal/css/header.css" />
<link rel="stylesheet" href="/ideal/css/bg.css" />
<link rel="stylesheet" href="/ideal/css/footer.css" />
<link rel="stylesheet" href="/ideal/css/title.css" />
<link rel="stylesheet" href="/ideal/css/access.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1"/>
<title>Access</title>
</head>
<body>

	<div style="min-height: 100vh; position: relative;">
		<jsp:directive.include file="/header.jsp" />

		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1 class="greenBack">アクセス</h1>
			</div>
		</div>
		<!-- メッセージがあれば表示 -->
		<jsp:include page="idealException.jsp" />
<center>
		<div class="tableDiv bgBlur">
			<div class="flex-container">
				<div class="flex-item">
					<h2>住所</h2>
					<h4>〒060-0005 北海道札幌市中央区北５条西2−５ JRタワーオフィスプラザさっぽろ19F</h4>
					<h4>TEL 011-000-0000</h4>
					<h2>営業時間</h2>
					<h4>17:00～24:00 ご入店ストップ21:30</h4>
					<h2>ご予約について</h2>
					<h4>翌日から一年先までのご予約を受け付けております。</h4>
					<h4>当日のご予約はできません。</h4>
					<h4>予約状況によりお受けできない場合もございますので、お早目のご予約をお願いいたします。</h4>

				</div>

				<div class="flex-item">
					<h2>地図</h2>
					<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d11658.887202851385!2d141.3519154!3d43.0683183!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x2fd7ce4f4c00cf1c!2z44OR44K944Kz44Oz5pWZ5a6kIEtFTuOCueOCr-ODvOODqyDmnK3luYzmoKE!5e0!3m2!1sja!2sjp!4v1616981334571!5m2!1sja!2sjp"  style="border:0;width:100%;height: 420px;" allowfullscreen="" loading="lazy"></iframe>
				</div>

			</div>
		</div>
</center>
		<jsp:include page="/footer.jsp" />
	</div>




</body>
</html>