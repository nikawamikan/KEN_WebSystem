<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="general.FormReplacer"%>
<%@page import="model.MenuBase"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.Course"%>
<%@page import="model.Menu"%>
<%@page import="java.util.ArrayList"%>
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
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>メニュー紹介画面</title>
</head>
<body>

	<%
		ArrayList<Course> courseList = (ArrayList<Course>) request
			.getAttribute("courseList");

				if (courseList == null) {
				response.sendRedirect("/ideal/home.jsp");
				return;
			}

			ArrayList<ArrayList<Menu>> menuList = (ArrayList<ArrayList<Menu>>) request
			.getAttribute("menuList");
			HashMap<Integer, String> typeName = (HashMap<Integer, String>) request
			.getAttribute("typeName");
			NumberFormat nf = NumberFormat.getCurrencyInstance();
	%>
	<%
		//---------------------とりあえずコースな場所----------------------
			//■スライダーの設定 配列にsliderに必要な写真をセット
			String[][] sliderImages = {
			{"foie gras.jpg", "onionsoup2.jpeg", "sirloin Steak.jpg",
			"gateau Chocolat.jpg"},
			{"shrimp2.jpg", "clam chowder.jpg", "duck meat.jpg", "pear.jpg"},
			{"shrimp2.jpg", "clam chowder.jpg", "pescatore2.jpg",
			"lobster2.jpg", "matcha3.jpg"},
			{"","","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","","",""},};
	%>
	<div style="min-height: 100vh; position: relative;">
		<jsp:directive.include file="/header.jsp" />

		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1 class="green">コース</h1>
			</div>
		</div>
		<jsp:include page="idealException.jsp" />

		<%
			int index = 0;
									for (Course c : courseList) {
		%>
		<center>
			<div class="tableDiv bgBlur">
				<div class="flex-container">
					<div class="flex-item">
						<h2><%=FormReplacer.fmtNull(c.getCourseName())%></h2>
						<h4 style="text-indent: 1em;"><%=nf.format(c.getPrice())%></h4>
						<%
							for (MenuBase mb : c.getMenuList()) {
						%>

						<h4><%=typeName.get(mb.getTypeId())%><br />
							<div style="text-indent: 1em;"><%=FormReplacer.fmtNull(mb.getMenuName())%></div>
						</h4>

						<%
							}
						%>

					</div>

					<div class="flex-item">
						<h4 style="text-indent: 1em;"><%=FormReplacer.fmtNull(c.getDetail())%></h4>
						<div class="swiper-container">
							<!-- 全スライドをまとめるラッパー -->
							<div class="swiper-wrapper">
								<%
									for (int i = 0; i < sliderImages[index].length; i++) {
								%>
								<div class="swiper-slide">
									<div style="width: 100%">
										<img style="width: 100%; height: 400px; object-fit: cover;"
											src="/ideal/img/<%=sliderImages[index][i]%>" />
									</div>
								</div>
								<%
									}
								%>
							</div>
							<!-- ページネーションを表示する場合 -->
							<div class="swiper-pagination"></div>

							<!-- 前後スライドへのナビゲーションボタン(矢印)を表示する場合 -->
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>

						</div>

					</div>
				</div>

			</div>
		</center>
		<div style="height: 50px">
			<br />
		</div>
		<%
			index++;
										}
		%>

		<%
			//---------------単品メニューたち---------------
			//2次元配列 タイプ名("前菜", "スープ", "パスタ", "肉料理", "魚料理", "デザート")6種ごとに写真を用意
			//タイプID(200, 210, 220, 300, 310, 400)+連番で画像を保存
			String[][] menuImgNames = {
				{ "foie gras.jpg", "shrimp2.jpg", "prosciutto2.jpg", "mozzarella.jpg","","","","","","","","","",""},
				{ "corn soup.jpg", "onionsoup2.jpeg", "clam chowder.jpg", "Consome2.jpg","","","","","","","","","",""},
				{ "prince Ming pasta2.jpg", "pescatore2.jpg", "genoapasta2.jpg", "meatballs2.jpg","","","","","","","","","",""},
				{ "duck meat.jpg", "sirloin Steak.jpg", "mutton.jpg", "roast beef.jpg","","","","","","","","","",""},
				{ "sea bream.jpg", "Inspiration Meuniere.jpg", "salmon Steak2.jfif", "lobster2.jpg","","","","","","","","","",""},
				{ "matcha3.jpg", "gateau Chocolat.jpg", "pear.jpg","","","","","","","","","",""},
				{"","","","","","","","","","","","","","","",""},
				{"","","","","","","","","","","","","","","",""},
				{"","","","","","","","","","","","","","","",""},
				{"","","","","","","","","","","","","","","",""},
				{"","","","","","","","","","","","","","","",""},
				{"","","","","","","","","","","","","","","",""},
				{"","","","","","","","","","","","","","","",""},

				};
		%>


		<%
			index = 0;
							for (ArrayList<Menu> al : menuList) {
								if (al.isEmpty())
									continue;
		%>
		<div class="titleSticky">
			<div class="titleInnerDiv">
				<h1
					class="<%if(index%3==0){
					out.print("yellow");
				}else if(index%3==1){
					out.print("red");
				}else{
					out.print("green");
				}%>"><%=FormReplacer.fmtNull(typeName.get(al.get(0).getTypeId()))%></h1>
			</div>
		</div>
		<center>
			<div
				style="display: flex; flex-wrap: wrap; max-width: 63em; justify-content: space-between">
				<%
					int index2=0;
											for(Menu m:al){
				%>


				<div class="tableDiv bgBlur flex-conteiner-inner">
					<div class="flex-container">
						<div class="flex-item">
							<h2><%=m.getMenuName()%></h2>
							<h4 style="text-indent: 1em;"><%=nf.format(m.getPrice())%></h4>

							<h4><%=FormReplacer.fmtNull(m.getDetail())%></h4>

						</div>

						<div class="flex-item">
							<img style="width: 100%; height: 250px; object-fit: cover;"
								src="/ideal/img/<%=menuImgNames[index][index2]%>" />
						</div>

					</div>
				</div>

				<%
					index2++;
																						}
				%>
			</div>
		</center>

		<%
			index++;
			}
		%>


		<jsp:include page="/footer.jsp" />
	</div>


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
			autoplay : {
				delay : 2000,
			},

			loop : true,

		})
	</script>
</body>
</html>