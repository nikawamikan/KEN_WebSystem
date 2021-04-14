function adminLoginCheck(frm) {

		if (frm.admName.value == "") {
			alert("名前を入力してください。");
			frm.admName.focus();
			return false;
		} else if (frm.password.value == "") {
			alert("パスワードを入力してください。");
			frm.password.focus();
			return false;
		}else if (passwordRegexCheck(pass)){
			alert("パスワードに使用されている文字列が正しくありません。\n半角英数字で入力してください。");
			frm.password.focus();
			return false;
		}
		return true;
	}
/*import文の仕様がよくわからないので直接記載 */
function passwordRegexCheck(pass) {
	const regex = new RegExp('^[a-zA-Z0-9]+$');
	return !regex.test(pass);
}