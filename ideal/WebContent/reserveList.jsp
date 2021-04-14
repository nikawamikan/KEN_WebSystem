<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="general.FormReplacer"%>
<%@page import="general.ReserveDate"%>
<%@page import="java.time.LocalDate"%>
<%@page import="ctrl.ReserveVar"%>
<%@page import="ctrl.SvlUlrl"%>
<%@page import="ctrl.SvlName"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Reserve"%>
<%@page import="model.User"%>
<%@page import="ctrl.LoginVar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>予約情報一覧画面</title>
</head>
<body>
	<div style="min-height: 100vh; position: relative;">
		<jsp:directive.include file="/header.jsp" />
		<%
			ArrayList<Reserve> reList = (ArrayList<Reserve>) request
					.getAttribute(ReserveVar.reserveList);

		if (reList == null) {
			response.sendRedirect("/ideal/home.jsp");
			return;
		}

			ArrayList<Integer> today = ReserveDate.getDateIntArray(ReserveDate
					.getToday());
		%>
		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1 class="greenBack"><%=FormReplacer.fmtNull(us.getUsrName())%>様のご予約情報
				</h1>
			</div>
		</div>
		<!-- メッセージがあれば表示 -->
		<jsp:include page="idealException.jsp" />
		<center>
			<%
				if (reList != null) {
					if (!reList.isEmpty()) {
						for (Reserve re : reList) {
			%>
			<div class="tableDiv bgBlur">
				<div class="flex-container">
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

				</div>

				<%
					String add = "";

								if (re.getRsvYy() == today.get(0)
										&& re.getRsvMm() == today.get(1)
										&& re.getRsvDd() == today.get(2)) {
									add = "disabled=\"disabled\"";
								}
				%>

				<div
					style="display: flex; flex-wrap: wrap; justify-content: space-around;">
					<div>
						<form action="<%=SvlUlrl.ReserveUpdateSvl%>">
							<input type="hidden" name="<%=ReserveVar.rsvId%>"
								value="<%=re.getRsvId()%>" /> <input class="button enterButton"
								type="submit" value="予約の変更" <%=add%> />
						</form>
					</div>
					<div>
						<form action="<%=SvlUlrl.ReserveDeleteSvl%>">
							<input type="hidden" name="<%=ReserveVar.rsvId%>"
								value="<%=re.getRsvId()%>" /> <input class="button enterButton"
								type="submit" value="ご予約のキャンセル" <%=add%> />
						</form>
					</div>
				</div>
			</div>
			<div style="height: 50px">
				<br />
			</div>


			<%
				}
					} else {
			%>

			<div class="tableDiv bgBlur">
				<div class="flex-container">
					<h2 style="width: 100%">まだ、予約はありません。</h2>
				</div>
			</div>
			<div style="height: 50px">
				<br />
			</div>
			<%
				}
				}
			%>
			<div class="tableDiv bgBlur">
				<div class="flex-container">
					<h2 style="width: 100%">新しく予約を取りますか？</h2>
					<form action="<%=SvlUlrl.ReserveInsertSvl%>" method="post">
						<input class="button enterButton" type="submit" value="予約する" />
					</form>
				</div>
			</div>
			<div style="height: 50px">
				<br />
			</div>

		</center>
		<jsp:include page="/footer.jsp" />
	</div>



</body>
</html>