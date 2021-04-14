<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="general.FormReplacer"%>
<%@page import="org.apache.tomcat.jni.Local"%>
<%@page import="java.util.Currency"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="model.Menu"%>
<%@page import="model.MenuType"%>
<%@page import="ctrl.*"%>
<%@page import="controller.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
<link rel="stylesheet" href="/ideal/css/cardStyle.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>メニュー管理</title>

</head>
<body>
	<div style="min-height: 100vh; position: relative; width: 100%">

		<jsp:directive.include file="/adminHeader.jsp" />
		<jsp:include page="idealException.jsp" />




		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1 class="redBack">メニュー管理画面</h1>
				<div style="position: relative;">
					<div class="menuLeftInner" style="position: absolute; top: 0;">
						<input type="checkbox" id="menu2-btn-check" style="display: none;">
							<label for="menu2-btn-check"><span
								class="bgBlur greenBack m-btn-check"
								style="position: absolute; top: 2px; left: 5px; z-index: 400;"><img
									src="/ideal/img/rightArrow.svg" /></span></label> </input>
						<div class="bgBlur menuLeftInInner"
							style="position: absolute; top: 0;">

							<%
								ArrayList<MenuType> mType = (ArrayList<MenuType>) request
										.getAttribute("mType");
								if(mType==null){
									response.sendRedirect("/ideal/controller/MenuMaintenanceSvl");
									return;
								}

								int typeID = (Integer) request.getAttribute("typeID");
								NumberFormat nf = NumberFormat.getCurrencyInstance();

								ArrayList<Menu> menu = (ArrayList<Menu>) request
										.getAttribute("menu");
								if (mType != null) {
									for (MenuType m : mType) {
							%>

							<form action="<%=SvlUlrl.MenuMaintenanceSvl%>" method="post">
								<input type="hidden" name="typeID" value="<%=m.getTypeID()%>" />
								<input class="button "
									style="font-size: 16px; height: 2.2em;<%if (typeID == m.getTypeID()) {
						out.print("background:rgba(70,170,70,0.7)");
					}%>"
									type="submit" value="<%=FormReplacer.fmtNull(m.getTypeName())%>" />
							</form>

							<%
								}
								}
							%>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div style="display: flex; width: 100%">
			<div ><div class="menu-margin"></div></div>
			<div class="menuWidth">
				<div style="display: flex; justify-content: space-around; width: 100%">

					<div class="menuDiv" style="z-index: 1;width: 100%">
						<div
							style="display: flex; justify-content: space-around; flex-wrap: wrap;width: 100%">
							<%
								if (menu != null) {
									for (Menu m : menu) {
							%>
							<div class="bgBlur menuCard">
								<div class="menuCardInner">
									<h3><%=FormReplacer.fmtNull(m.getMenuName())%></h3>
									<h4><%=nf.format(m.getPrice())%></h4>
									<h4>
										<%
											if (m.getDetail() != null)
														out.print(m.getDetail());
										%>
									</h4>

									<div
										style="position: absolute; bottom: 0; right: 0; width: 40%; display: flex;">
										<form style="width: 50%" action="<%=SvlUlrl.MenuUpdateSvl%>"
											method="post">
											<input type="hidden" name="typeID" value="<%=m.getTypeId()%>" />
											<input type="hidden" name="menuID" value="<%=m.getMenuId()%>" />
											<input type="hidden" name="mode"
												value="<%=MenuOperationSvl.UPDATE%>" /> <input
												class="button" type="submit" value="変更" />
										</form>
										<form style="width: 50%;" action="<%=SvlUlrl.MenuDeleteSvl%>"
											method="post">
											<input type="hidden" name="typeID" value="<%=m.getTypeId()%>" />
											<input type="hidden" name="menuID" value="<%=m.getMenuId()%>" />
											<input type="hidden" name="mode"
												value="<%=MenuOperationSvl.DELETE%>" /> <input
												class="button" type="submit" value="削除" />
										</form>
									</div>
								</div>

							</div>
							<%
								}
								}
							%>
							<div class="bgBlur menuCard" style="min-width: 300px;">
								<form action="<%=SvlUlrl.MenuInsertSvl%>" method="post">
									<input type="hidden" name="typeID" value="<%=typeID%>" /> <input
										type="hidden" name="mode" value="<%=MenuOperationSvl.INSERT%>" />
									<input class="button enterButton" type="submit"
										value="新しいメニューの追加" />
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<jsp:include page="/footer.jsp" />
	</div>

</body>
</html>