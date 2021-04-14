
// 動的処理を担当するJS
$(function() {
	$('#searchBtn')
			.on(
					'click',
					function() {
						$
								.ajax(
										{
											url : "https://zipcloud.ibsnet.co.jp/api/search?zipcode="
													+ $('#zipcode').val(),
											dataType : 'jsonp',
										})
								.done(
										function(data) {
											if (data.status === 200) {
												$('#address')
														.val(
																data.results[0].address1
																		+ data.results[0].address2
																		+ data.results[0].address3);
												$('#status').html("");
											} else {
												$('#status').html(data.message);
												$('#zipcode').focus();

											}
										}).fail(function() {
									alert('通信失敗');
								});

					});

	$('#mailid').on('click', function() {
		mailUseCheck();

	});

});
function mailUseCheckCore() {
	return $.ajax({
		url : "/ideal/controller/MailadressCheckSvl",
		type : "GET",
		dataType : "JSON",
		data : {
			mail : $('#mailadd').val(),
			usrId: $('#usrId').val()
		}
	});
}
function mailUseCheck() {
	var test;
	mailUseCheckCore().done(function(result) {
		if (result.test) {
			$('#mailMessage').html('このアドレスは使用できます。');
		} else {
			$('#mailMessage').html(result.message);
			$('#mailadd').focus();
		}
	}).fail(function() {
		alert("通信に失敗しました");
	});
}

// メールアドレスが使用可能かの判定式を入れるのが無理に等しい
// (ajaxで非同期処理オフにすることで一応可能だが、その間ブラウザが止まる)
// サーバー側で登録時確認する。
function userInsertCheck(frm) {

	if (frm.usrName.value == "") {
		alert("名前を入力してください。");
		return false;
		frm.usrName.focus();
		return false;
	} else if (frm.mail.value == "") {
		alert("メールアドレスを入力してください。");
		return false;
	} else if (frm.zipcode.value!=""&&zipcodeCheck(frm.zipcode.value)) {
		alert("郵便番号が正しくありません");
		return false;
	} else if (frm.phone.value!=""&&phoneNumberCheck(frm.phone.value)) {
		alert("電話番号が正しく入力されませんでした");
		frm.password.focus();
		return false;
	} else if (frm.password.value == "") {
		alert("パスワードを入力してください。");
		frm.password.focus();
		return false;
	} else if (passwordRegexCheck(frm.password.value)) {
		alert("パスワードに使用されている文字列が正しくありません。\n半角英数字で入力し、8文字以上32文字以下のパスワードを設定してください。");
		frm.password.focus();
		return false;
	} else if (passwordRegexCheck(frm.newPassword.value)) {
	alert("パスワードに使用されている文字列が正しくありません。\n半角英数字で入力し、8文字以上32文字以下のパスワードを設定してください。");
	frm.password.focus();
	return false;
}
	return true;
}

/* import文の仕様がよくわからないので直接記載 */
function passwordRegexCheck(pass) {
	const
	regex = new RegExp('^[a-zA-Z0-9]{8,32}$');
	return !regex.test(pass);
}
function phoneNumberCheck(phoneNunber) {
	const
	regex = new RegExp(
			'^(0([0-9]-[0-9]{4}|[0-9]{2}-[0-9]{3}|[0-9]{3}-[0-9]{2}|[0-9]{4}-[0-9])-[0-9]{4}$)|(^[0-9]{1,12}$)');
	return !regex.test(phoneNunber);
}
function zipcodeCheck(zipcode){
	const
	regex = new RegExp(
			'^[0-9]{3}-?[0-9]{4}$'
	);
	return !regex.test(zipcode);
}