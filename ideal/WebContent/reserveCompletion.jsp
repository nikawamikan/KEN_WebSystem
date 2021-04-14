<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="general.FormReplacer"%>
<%@page import="ctrl.SvlUlrl"%>
<%@page import="ctrl.SvlName"%>
<%@page import="ctrl.ReserveVar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@page import="controller.ReserveOperationSvl"%>
<%@page import="controller.ReserveListSvl"%>
<%@page import="static controller.ReserveOperationSvl.*"%>
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
<title>予約完了画面</title>
</head>
<body>
	<div style="min-height: 100vh; position: relative;">
		<jsp:directive.include file="/header.jsp" />
		<%
			Reserve re = (Reserve) request.getAttribute(ReserveVar.reserve);
			if (re == null) {
				response.sendRedirect("/ideal/home.jsp");
				return;
			}
		%>

		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1 class="greenBack">ご予約が完了しました</h1>
			</div>
		</div>



		<jsp:include page="idealException.jsp" />
		<center>
			<div class="tableDiv bgBlur">
				<div class="flex-container">
					<div class="formDiv">
						<h2><%=re.getUsrName()%>様のご予約が完了しました。
						</h2>
					</div>
					<div class="flex-item">
						<h2>ご予約日時</h2>
						<h3><%=re.getRsvYy()%>年
							<%=re.getRsvMm()%>月
							<%=re.getRsvDd()%>日<br /><%=re.getRsvHh()%>時
							<%=re.getRsvMi()%>分
						</h3>
						<h2>人数</h2>
						<h3><%=re.getPerson()%>
							名様
						</h3>
					</div>

					<div class="flex-item">
						<h2>テーブル</h2>
						<h3><%=FormReplacer.fmtNull(re.getTableName())%></h3>
						<h2>ご注文のコース</h2>
						<h3><%=FormReplacer.fmtNull(re.getCourseName())%></h3>
					</div>

					<div style="height: 50px">
						<br />
					</div>

				</div>



			</div>


			<div style="margin-top: 3em; width:100%; display: flex; justify-content: center;">
				<a class="button enterButton" href="<%=SvlName.ReserveListSvl%>">ご予約のリストへ戻る</a>
			</div>


			<div style="height: 50px">
				<br />
			</div>


		</center>
	</div>
</body>
</html>