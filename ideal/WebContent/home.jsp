<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="controller.AdminLoginSvl"%>
<%@page import="controller.UserLoginSvl"%>
<%@page import="controller.ShowMenuSvl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="/ideal/css/bgBlur.css" />
<link rel="stylesheet" href="/ideal/css/form.css" />
<link rel="stylesheet" href="/ideal/css/header.css" />
<link rel="stylesheet" href="/ideal/css/bg.css" />
<link rel="stylesheet" href="/ideal/css/footer.css" />
<link rel="stylesheet" href="/ideal/css/title.css" />
<link rel="stylesheet" href="/ideal/css/home.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>ホームページ</title>
</head>
<body class="home">

	<div style="min-height: 100vh; position: relative;">
		<jsp:directive.include file="/header.jsp" />
		<jsp:include page="idealException.jsp" />
		<div>
			<div
				style="position: absolute; z-index: -2; width: 100%; height: 100vh; top: -50px">
				<h2
					style="position: absolute; left: 50%; top: 60%; transform: translate(-50%, -50%); width: 100%; text-align: center;">あなたの最高のひとときの為に。</h2>
			</div>
			<div style="position: sticky; z-index: -2; height: 50vh;"></div>

		</div>
		<div
			style="position: sticky; z-index: -2; width: 100%; height: 100vh; top: -50px">
			<img
				style="position: absolute; width: 30%; top: 60%; left: 50%; transform: translate(-50%, -50%);"
				src="/ideal/img/logo3.svg" />
		</div>
		<div style="position: sticky; z-index: -2; height: 50vh;"></div>

		<div
			style="position: sticky; z-index: -4; width: 100%; height: 50vh; top: 0">
			<img
				style="position: absolute; height: 100vh; width: 100%; object-fit: cover;"
				src="/ideal/img/bg2.jpg" />
		</div>
		<div style="position: sticky; z-index: -2; height: 50vh;"></div>



		<center>

			<div class="tableDiv bgBlur">
				<div class="flex-container">
					<div class="flex-item">
						<h2>Ristorante IDEALLEのコンセプト</h2>
						<h4>本物のイタリア料理と大人がくつろげる空間、これこそが私たちの目指すコンセプトです。
							北の大地で育んだ気鋭の神代シェフが、Ristorante IDEALLEの味を演出します。
							北海道の食材を吟味し、その素材の美点を余りなく引き出した料理は、特別な時間に花を添えてくれることでしょう。</h4>
					</div>

					<div class="flex-item">
						<img style="width: 100%; max-width: 600px;"
							src="/ideal/img/home1.jpg" />
					</div>
				</div>
			</div>
		</center>
		<div style="height: 50px">
			<br />
		</div>

		<center>

			<div class="tableDiv bgBlur">
				<div class="flex-container">
					<div class="flex-item">
						<h2>special～おすすめ料理～</h2>
						<div class="specialContainer">
							<div class="special">
								<table>
									<tr>
										<td valign="top" align="center"><h3>和牛のサーロインステーキ</h3></td>
									</tr>

									<tr>
										<td align="right">￥4,800</td>
									</tr>

									<tr>
										<td valign="top"><div class="min-hi">分厚さに関わらず驚くほど「すーっ」とナイフがお肉に入って行くことに皆様驚かれることでしょう。柔らかく肉の味が濃いブランド牛を、一番お肉を楽しむことができるステーキでぜひご賞味ください。</div></td>
									</tr>

									<tr>
										<td align="center"><img
											src="/ideal/img/sirloin Steak.jpg" class="imgs" /></td>
									</tr>
								</table>
							</div>
							<div class="special">
								<table>
									<tr>
										<td valign="top" align="center"><h3>フォアグラのロースト</h3></td>
									</tr>

									<tr>
										<td align="right">￥3,000</td>
									</tr>

									<tr>
										<td valign="top"><div class="min-hi">世界最高峰と言われるフランスはペリゴール産のフォアグラを厚切りにローストした、とても贅沢なそして幸せな一皿となります。</div></td>
									</tr>

									<tr>
										<td align="center"><img src="/ideal/img/foie gras.jpg"
											class="imgs" /></td>
									</tr>
								</table>
							</div>
							<div class="special">
								<table>
									<tr>
										<td valign="top" align="center"><h3>オマールエビのサラダ</h3></td>
									</tr>

									<tr>
										<td align="right">￥1,800</td>
									</tr>

									<tr>
										<td valign="top"><div class="min-hi">オマール海老を生きたまま茹でて、身はもちろん、殻とミソから作ったソースを地元の新鮮なお野菜とともにいただく当店看板メニューのひとつです。</div></td>

									</tr>

									<tr>
										<td align="center"><img src="/ideal/img/shrimp2.jpg"
											class="imgs" /></td>
									</tr>
								</table>
							</div>
						</div>

					</div>
				</div>
			</div>

		</center>

		<div style="height: 50px">
			<br />
		</div>

		<center>

			<div class="tableDiv bgBlur">
				<div class="flex-container">
					<div class="flex-item">
						<h2>お知らせ</h2>
						<hr></hr>
						<h4>2021.2.1 新メニュー「ミートボールナポリ風トマトソース」を追加しました。</h4>
						<hr></hr>
						<h4>2021.1.15 Aコース(牛肉料理)をリニューアルしました。</h4>
						<hr></hr>
						<h4>2021.1.1 Restaurant IDEALLE 公式サイトオープン</h4>
						<hr></hr>
					</div>
				</div>
			</div>
		</center>

		<div style="height: 50px">
			<br />
		</div>

		<center>

			<div class="tableDiv bgBlur">
				<div class="flex-container">
					<div class="flex-item">
						<h2>感染症対策</h2>
						<font color="white">
							<table width="100%">
								<tr>
									<td width="40%" rowspan="6" valign="top" align="center"><h3>お客様への取り組み</h3></td>
									<td width="60%">[入店時]</td>
								</tr>
								<tr>
									<td>体調不良の方への自粛呼びかけあり</td>
								</tr>
								<tr>
									<td>[客席へのご案内]</td>
								</tr>
								<tr>
									<td>席毎に一定間隔あり、他グループとの相席禁止</td>
								</tr>
								<tr>
									<td>[会計処理]</td>
								</tr>
								<tr>
									<td>現金等受け渡し時の手渡しなし</td>
								</tr>

								<tr>
									<td align="center"><h3>従業員の安全衛生管理</h3></td>
									<td>勤務時の検温、マスク着用、頻繁な手洗い</td>
								</tr>

								<tr>
									<td align="center" valign="top"><h3>店舗の衛生管理</h3></td>
									<td>換気設備の設置と換気、多数の人が触れる箇所の消毒、
										備品/卓上設置物の消毒、トイレのハンドドライヤーの使用中止</td>
								</tr>
							</table>
						</font>

					</div>
				</div>
			</div>
		</center>

		<div style="height: 50px">
			<br />
		</div>

		<center>

			<div class="tableDiv bgBlur">
				<h2>SNS</h2>

				<!-- twitter表示 -->
				<a class="twitter-timeline" data-width="80%" data-height="550"
					data-theme="light"
					href="https://twitter.com/kenschool?ref_src=twsrc%5Etfw">Tweets
					by kenschool</a>
				<script async src="https://platform.twitter.com/widgets.js"
					charset="utf-8"></script>

			</div>
		</center>


		<jsp:include page="/footer.jsp" />
	</div>

	<script type="text/javascript" src="/ideal/js/adminLoginCheck.js"></script>
</body>
</html>