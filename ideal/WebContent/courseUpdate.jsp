<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ page import="controller.*"%>
<%@ page import="ctrl.*"%>
<%@ page import="general.*"%>
<%@ page import="java.util.*"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>コース変更画面</title>

<script type="text/javascript">
	function check() {
		if (document.courseInsert.courseName.value == "") {
			window.alert("メニュー名が未入力です。");
			return false;
		} else if (document.courseInsert.price.value == "") {
			window.alert("価格が未入力です。");
			return false;
		} else if (priceRegexCheck(document.courseInsert.price.value)) {
			window.alert("価格は数字で入力してください。");
			return false;
		}
		return true;
	}

	function priceRegexCheck(pass) {
		const
		regex = new RegExp('^[0-9]+$');
		return !regex.test(pass);
	}
</script>
</head>
<body>
	<%
		int typeID;
		try {
			typeID = Integer.parseInt(request.getParameter("typeID"));
		} catch (NumberFormatException e) {
			typeID = 100;
		}
	%>
	<!-- requestscopeからArrayListに格納されたMenuクラス型の"typeMenuList"を取得 -->
	<%
		ArrayList<ArrayList<Menu>> typeMenuList = (ArrayList<ArrayList<Menu>>) request
				.getAttribute("typeMenuList");

	if(typeMenuList==null){
		response.sendRedirect("/ideal/controller/MenuMaintenanceSvl");
		return;
	}
	%>

	<!-- requestscopeからArrayListに格納されたMenuクラス型の"menu"を取得 -->
	<%
		ArrayList<Menu> menu = (ArrayList<Menu>) request
				.getAttribute("menu");
	%>
	<%
		Course oneCourse = (Course) request.getAttribute(MenuVar.oneCourse);
	%>

	<div style="min-height: 100vh; position: relative;">
		<jsp:directive.include file="/adminHeader.jsp" />

		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1 class="greenBack">コースの変更</h1>
			</div>
		</div>
		<jsp:include page="idealException.jsp" />

		<center>
			<div class="tableDiv bgBlur">

				<form id="courseInsert" name="courseInsert"
					action="<%=SvlUlrl.CourseOperationSvl%>" method="post"
					onsubmit="return check();">
					<div class="formDiv">
						<div class="formDivInner">
							<div class="titleDiv">
								<div class="tableDef">コース名</div>
								<div class="messageDiv"></div>
							</div>
							<div>
								<input class="inputDef" id="courseName" type="text"
									name="courseName" value="<%=FormReplacer.fmtNull(oneCourse.getCourseName()) %>" />
							</div>
						</div>
					</div>
					<div class="messageDiv"></div>
					<div class="formDiv">
						<div class="formDivInner">
							<div class="titleDiv">
								<div class="tableDef">価格</div>
								<div class="messageDiv"></div>
							</div>
							<div>
								<input class="inputDef" id="price" type="text" name="price"
									value="<%=oneCourse.getPrice() %>" />
							</div>
						</div>
					</div>
					<div class="messageDiv"></div>
					<div class="formDiv">
						<div class="formDivInner">
							<div class="titleDiv">
								<div class="tableDef">オーダー可</div>
								<div class="messageDiv"></div>
							</div>
							<div
								style="width: 26em; display: flex; justify-content: space-around; color: white;">
								<div>
									<input type="radio" name="orderFlg" value="1" <%=FormReplacer.checkeder(oneCourse.getOrderFlg(), 1)%>/>可
								</div>
								<div>
									<input type="radio" name="orderFlg" value="0" <%=FormReplacer.checkeder(oneCourse.getOrderFlg(), 0)%>/>不可
								</div>
							</div>
						</div>
					</div>
					<div class="messageDiv"></div>
					<%!String[] typeName = { "前菜", "スープ", "パスタ", "肉料理", "魚料理", "デザート" };%>
					<%!String[] selectName = { "appetizerID", "soupID", "pastaID", "meatID",
			"fishID", "dessertID" };%>
					<%
						for (int i = 0; i < typeName.length; i++) {
					%>
					<div class="formDiv">
						<div class="formDivInner">
							<div class="titleDiv">
								<div class="tableDef"><%=typeName[i]%></div>
								<div class="messageDiv"></div>
							</div>

							<div>
								<select class="inputDef" id="<%=selectName[i]%>"
									name="<%=selectName[i]%>">
									<option value="0"><%=typeName[i] + "の追加はしない"%></option>
									<%
										for (Menu m : typeMenuList.get(i)) {
											String selected = "";
											MenuBase mb = oneCourse.getOneCourseMenu(m.getTypeId());
											if (mb == null) {
											} else if (oneCourse.getOneCourseMenu(m.getTypeId())
													.getMenuId() == m.getMenuId()) {
												selected = "selected";
											} else {
												selected = "";
											}
									%>
									<option value="<%=m.getMenuId()%>" <%=selected %>><%=FormReplacer.fmtNull(m.getMenuName())%></option>
									<%
										}
									%>
								</select>
							</div>
						</div>
					</div>
					<div class="messageDiv"></div>
					<%
						}
					%>


					<div class="formDiv">
						<div class="formDivInner">
							<div class="titleDiv">
								<div class="tableDef">コメント</div>
								<div class="messageDiv"></div>
							</div>
							<div>
								<textarea class="inputDef" style="height: 200px; resize: none;"
									name="detail"><%=FormReplacer.fmtNull(oneCourse.getDetail()) %></textarea>
							</div>
						</div>
					</div>
					<div style="display: flex; justify-content: center;">
						<input class="button enterButton" type="submit" value="登録" />
					</div>
					<input type="hidden" name="mode"
						value="<%=CourseOperationSvl.UPDATE%>" />
						<input
								type="hidden" name="courseID"
								value="<%=oneCourse.getCourseId()%>" />
				</form>
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