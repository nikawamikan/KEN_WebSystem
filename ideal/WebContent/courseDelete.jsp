<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.HashMap"%>
<%@page import="general.FormReplacer"%>
<%@page import="ctrl.SvlUlrl"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="controller.*"%>
<%@ page import="model.*"%>
<%@page import="java.text.NumberFormat"%>



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
<title>コース情報削除画面</title>

</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		NumberFormat nf = NumberFormat.getCurrencyInstance();
	%>
	<%
		Course oneCourse = (Course) request.getAttribute("oneCourse");

		if(oneCourse==null){
			response.sendRedirect("/ideal/controller/MenuMaintenanceSvl");
			return;
		}

		HashMap<Integer, String> mTypeMap = (HashMap<Integer, String>) MenuType
				.getAllTypeMap();
	%>
	<%
		int typeID = 100;
	%>
	<div style="min-height: 100vh; position: relative;">
		<jsp:directive.include file="/header.jsp" />


		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1 class="greenBack">コースの削除</h1>
			</div>
		</div>


		<jsp:include page="idealException.jsp" />
		<center>
			<div class="tableDiv bgBlur">
				<div class="flex-container">
					<div class="formDiv">
						<h2>
							コース削除ボタンを押すと<br />削除が確定されます。
						</h2>
					</div>
					<div class="flex-item">
						<h2>コース名</h2>
						<h3><%=FormReplacer.fmtNull(oneCourse.getCourseName())%>
						</h3>
						<h2>価格</h2>
						<h3><%=nf.format(oneCourse.getPrice())%></h3>
						<h2>オーダーの可否</h2>
						<h3>
							<%
								if (oneCourse.getOrderFlg() == 0) {
									out.print("不可");
								} else {
									out.print("可");
								}
							%>
						</h3>
					</div>

					<div class="flex-item">
						<%
							for (int i = 0; i < oneCourse.getMenuListSize(); i++) {
						%>
						<h2><%=mTypeMap.get(oneCourse.getMenuListOne(i).getTypeId())%></h2>
						<h3><%=oneCourse.getMenuListOne(i).getMenuName()%></h3>
						<%
							}
						%>
						<h2>コメント</h2>
						<h3><%=FormReplacer.fmtNull(oneCourse.getDetail())%></h3>
					</div>

				</div>
				<div
					style="display: flex; flex-wrap: wrap; justify-content: space-around;">
					<div>
						<form action="<%=SvlUlrl.CourseOperationSvl%>">
							<input type="hidden" name="mode"
								value="<%=CourseOperationSvl.DELETE%>" /> <input type="hidden"
								name="typeID" value="<%=oneCourse.getTypeId()%>" /> <input
								type="hidden" name="courseID"
								value="<%=oneCourse.getCourseId()%>" /> <input
								class="button enterButton" type="submit" value="コース削除" />
						</form>
					</div>
				</div>
			</div>
			<div style="height: 50px">
				<br />
			</div>

			<div style="margin-top: 3em; display: flex; justify-content: center;">
				<a class="button enterButton" href="<%=SvlUlrl.MenuMaintenanceSvl%>">メニューメンテナンスに戻る</a>
			</div>
			<div style="height: 50px">
				<br />
			</div>


		</center>
		<jsp:include page="/footer.jsp" />
	</div>
</body>
</html>