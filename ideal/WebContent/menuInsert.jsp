<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@ page import="controller.*"%>
<%@ page import="ctrl.*"%>
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
<title>メニュー登録画面</title>

<script type="text/javascript">
	function check() {
		if (document.menuInsert.menuName.value == "") {
			window.alert("メニュー名が未入力です。");
			return false;
		} else if (document.menuInsert.price.value == "") {
			window.alert("価格が未入力です。");
			return false;
		} else if (priceRegexCheck(document.menuInsert.price.value)) {
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
	<%
		ArrayList<MenuType> mType = (ArrayList<MenuType>) request
				.getAttribute("mType");

	if(mType==null){
		response.sendRedirect("/ideal/controller/MenuMaintenanceSvl");
		return;
	}
	%>
	<%
		ArrayList<Menu> menu = (ArrayList<Menu>) request
				.getAttribute("menu");
	%>
	<div style="min-height: 100vh; position: relative;">
		<jsp:directive.include file="/adminHeader.jsp" />

		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1 class="greenBack">新規メニュー登録</h1>
			</div>
		</div>
		<jsp:include page="idealException.jsp" />

		<center>
			<div class="tableDiv bgBlur">

				<form id="menuInsert" name="menuInsert"
					action="/ideal/controller/MenuOperationSvl" method="post"
					onsubmit="return check();">
					<div class="formDiv">
						<div class="formDivInner">
							<div class="titleDiv">
								<div class="tableDef">メニュー名</div>
								<div class="messageDiv"></div>
							</div>
							<div>
								<input class="inputDef" id="menuName" type="text"
									name="menuName" />
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
									size="6" />
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
								style="width: 26em; display: flex; justify-content: space-around;color:white;">
								<div>
									<input type="radio" name="orderFlg" value="1" />可
								</div>
								<div>
									<input type="radio" name="orderFlg" value="0" checked="checked" />不可
								</div>
							</div>
						</div>
					</div>
					<div class="messageDiv"></div>
					<div class="formDiv">
						<div class="formDivInner">
							<div class="titleDiv">
								<div class="tableDef">メニューの分類</div>
								<div class="messageDiv"></div>
							</div>

							<div>
								<select class="inputDef" id="typeID" name="typeID">
									<%
										for (MenuType mt : mType) {
											if (mt.getTypeID() != 100) {
												String selected = "";
												if (typeID == mt.getTypeID()) {
													selected = "selected";
												} else {
													selected = "";
												}
									%>
									<option value="<%=((MenuType) mt).getTypeID()%>" <%=selected%>>
										<%=((MenuType) mt).getTypeName()%></option>
									<%
										}
										}
									%>
								</select>
							</div>
						</div>
					</div>
					<div class="messageDiv"></div>
					<div class="formDiv">
						<div class="formDivInner">
							<div class="titleDiv">
								<div class="tableDef">コメント</div>
								<div class="messageDiv"></div>
							</div>
							<div>
								<textarea class="inputDef" style="height: 200px; resize: none;"
									name="detail"></textarea>
							</div>
						</div>
					</div>
					<div style="display: flex; justify-content: center;">
						<input class="button enterButton" type="submit" value="登録" />
					</div>
					<input type="hidden" name="mode"
						value="<%=MenuOperationSvl.INSERT%>" />
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