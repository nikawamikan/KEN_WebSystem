<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="general.FormReplacer"%>
<%@page import="general.ReserveDate"%>
<%@page import="java.time.LocalDate"%>
<%@page import="ctrl.SvlUlrl"%>
<%@page import="ctrl.ReserveVar"%>
<%@page import="ctrl.SvlName"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.ReserveOperationSvl"%>
<%@page import="controller.ReserveListSvl"%>
<%@page import="static controller.ReserveOperationSvl.*"%>
<%@page import="model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link rel="stylesheet" href="/ideal/css/button.css" />
<link rel="stylesheet" href="/ideal/css/bgBlur.css" />
<link rel="stylesheet" href="/ideal/css/form.css" />
<link rel="stylesheet" href="/ideal/css/header.css" />
<link rel="stylesheet" href="/ideal/css/bg.css" />
<link rel="stylesheet" href="/ideal/css/footer.css" />
<link rel="stylesheet" href="/ideal/css/title.css" />
<link rel="stylesheet" href="/ideal/css/table.css" />
<link rel="stylesheet" href="/ideal/css/access.css" />

<title>新規予約画面</title>


<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />


<style type="text/css">
@media screen and (max-width:400px) {
	.swiper-button-prev {
		display: none;
	}
	.swiper-button-next {
		display: none;
	}
}

/* 左右のボタンの位置の微調整用 */
.swiper-button-next {
	margin-top: 10px;
}

.swiper-button-prev {
	margin-top: 10px;
}

:root { -
	-swiper-navigation-color: #ffffff; -
	-swiper-pagination-color: #ffffff;
}
</style>
</head>
<body>
	<%
		ArrayList<Course> courseList = (ArrayList<Course>)request.getAttribute(reserveVar.courseList);
	if (courseList == null) {
		response.sendRedirect("/ideal/home.jsp");
		return;
	}
	%>
	<div style="min-height: 100vh; position: relative;">

		<jsp:directive.include file="/header.jsp" />
		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1 class="greenBack"><%=FormReplacer.fmtNull(us.getUsrName())%>様 ご予約
				</h1>
			</div>
		</div>
		<center>
			<div class="tableDiv bgBlur" style="position: relative;">
				<div style="width: 100%">
					<h2 class="yellowBack">ご予約される日付</h2>
				</div>
				<div class="swiper-button-prev"></div>
				<div class="swiper-container">
					<!-- Additional required wrapper -->
					<div class="swiper-wrapper">
						<%!static final String[] YOUBI = { "日", "月", "火", "水", "木", "金", "土" };%>
						<%
		int counter = 1;
		LocalDate date = LocalDate.now();
		for (int i = 0; i < 13; i++) {
			if (i == 0 && date.getDayOfMonth() == date.lengthOfMonth()) {
				continue;
			}

			int youbiInt = date.plusMonths(i).withDayOfMonth(1)
					.getDayOfWeek().getValue();
			if (youbiInt == 7) {
				youbiInt = 0;
			}
	%>
						<div class="swiper-slide" style="height: 350px">
							<h3>
								<%= date.plusMonths(i).getMonthValue()+"月"%></h3>
							<table class="tableRadius">
								<tr>
									<%

				for (String youbi : YOUBI) {
			%>
									<th style="color: #ffffff;"><%=youbi%></th>
									<%
				}
			%>
								</tr>
								<tr>
									<%
				if (youbiInt != 7) {
						for (int j = youbiInt; j > 0; j--) {
							out.print("<td></td>");
						}
					}
					for (int j = 1; j <= date.plusMonths(i).lengthOfMonth(); j++) {
						if (youbiInt++ == 7) {
							youbiInt = 1;
			%>
								</tr>
								<tr>
									<%
				}
			%>
									<%
				if ((i == 0 && date.getDayOfMonth() >= j)
								|| (i == 12 && date.plusMonths(i).getDayOfMonth() < j)) {
			%>
									<td style="text-align: center;">
										<div class="graytile"><%=j%></div>
									</td>
									<%
				} else {
			%><td>
										<form action="#" onsubmit="return getReserveList(this)">
											<input name="calNum" type="hidden" value="<%=counter%>" /> <input
												class="greentile" type="submit" value="<%=j%>" />
											<%
						counter++;
					%>
										</form>
									</td>
									<%
				}
					}
			%>
								</tr>
							</table>
						</div>
						<%
		}
	%>

					</div>

					<div class="swiper-pagination"></div>


				</div>
				<div class="swiper-button-next"></div>
			</div>
		</center>
		<center>
			<jsp:include page="idealException.jsp" />

			<div style="height: 100px">
				<br />
			</div>

			<div class="tableDiv bgBlur">
				<!-- ajaxで予約時間の要素取得します。 -->
				<div id="ajaxReserveListTime"></div>
				<div id="ajaxReserveList" style="overflow-x: auto;"></div>
			</div>

			<div style="height: 100px">
				<br />
			</div>
			<div class="tableDiv bgBlur">
				<div style="width: 100%">
					<h2 id="lastForm" class="yellowBack">ご予約の内容</h2>
				</div>
				<div style="min-width: 300; color: #ffffff;">
					<div
						style="display: flex; flex-wrap: wrap; justify-content: center;">
						<h3 style="width: 100%;">ご予約の日時</h3>
						<h3 id="dispYear" style="margin: 1em;"></h3>
						<h3 id="dispMonthDate" style="margin: 1em;"></h3>
						<h3 id="dispHourMin" style="margin: 1em;"></h3>
					</div>
					<div
						style="display: flex; flex-wrap: wrap; justify-content: center;">
						<h3 style="width: 100%;">ご予約のテーブル名</h3>
						<h3 id="tableName" style="margin: 1em;"></h3>
					</div>

				</div>
				<div style="display: flex; justify-content: center">
					<div>
						<form action="<%=SvlUlrl.ReserveOperationSvl%>" method="post">
							<input type="hidden" id="mode" name="mode"
								value="<%=ReserveOperationSvl.INSERT%>" /> <input type="hidden"
								id="rsvYy" name="rsvYy" value="" /> <input type="hidden"
								id="rsvMm" name="rsvMm" value="" /> <input type="hidden"
								id="rsvDd" name="rsvDd" value="" /> <input type="hidden"
								id="rsvHh" name="rsvHh" value="" /> <input type="hidden"
								id="rsvMi" name="rsvMi" value="" /> <input type="hidden"
								id="tableId" name="tableId" value="" />
							<div class="messageDiv"></div>
							<div class="formDiv">
								<div class="formDivInner">
									<div class="titleDiv">
										<div class="tableDef">ご予約される人数</div>
										<div class="messageDiv"></div>
									</div>
									<div>
										<select class="inputDef" id="person" name="person">
										</select>
									</div>
								</div>
							</div>
							<div class="messageDiv"></div>
							<div class="formDiv">
								<div class="formDivInner">
									<div class="titleDiv">
										<div class="tableDef">ご予約されるコース</div>
										<div class="messageDiv" ></div>
									</div>
									<div>
										<select class="inputDef" id="courseId" name="courseId"
											onchange="coursePrint()">

											<%
								for(Course oneCourse:courseList){
								%>
											<option value="<%=oneCourse.getCourseId()%>"><%=FormReplacer.fmtNull(oneCourse.getCourseName())%></option>

											<%
							}
							%>
										</select>
									</div>
								</div>
							</div>
							<div class="formDiv">
								<div class="flex-container">
									<div id="coursePrint" class="flex-item">

									</div>

									<div id="coursePrint2" class="flex-item">

									</div>

								</div>
							</div>

							<div class="messageDiv"></div>
							<div class="formDiv">
								<input id="send" class="button enterButton" type="submit"
									disabled="disabled" value="予約する" />
							</div>
						</form>
					</div>
				</div>
			</div>
			<div style="height: 50px">
				<br />
			</div>

			<div style="display: flex; justify-content: center">
				<div>
					<form action="<%=SvlUlrl.ReserveListSvl%>" method="post">
						<input class="button enterButton" type="submit" value="予約一覧に戻る" />
					</form>
				</div>
			</div>
			<div style="height: 50px">
				<br />
			</div>

			<input type="hidden" id="today" name="today"
				value="<%=ReserveDate.getToday()%>" /> <input type="hidden"
				id="afterDate" name="afterDate" value="1" />
		</center>


		<jsp:include page="/footer.jsp" />
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		type="text/javascript"></script>
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	<script src="/ideal/js/reserveInsertTableCreater.js"
		type="text/javascript"></script>
	<script>
		var Swiper = new Swiper('.swiper-container', {
			slidesPerView : 1,
			pagination : {
				el : '.swiper-pagination',
				type : 'bullets',
				clickable : true
			},
			navigation : {
				nextEl : '.swiper-button-next',
				prevEl : '.swiper-button-prev',
			},

			breakpoints : {
				// 画面幅が 640px 以上の場合（window width >= 640px）
				640 : {
					slidesPerView : 2,
				},
				// 画面幅が 980px 以上の場合（window width >= 980px）
				980 : {
					slidesPerView : 3,
				}
			},
		})
	</script>

</body>
</html>