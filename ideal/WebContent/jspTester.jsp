<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

$(function(){
	console.log("allcheck");
	check('access');
	check('adminIndex');
	check('adminLogin');
	check('adminReserveCheck');
	check('courseDelete');
	check('courseInsert');
	check('courseUpdate');
	check('home');
	check('idealException');
	check('menuDelete');
	check('menuInsert');
	check('menuUpdate');
	check('menuMaintenance');
	check('noScriptError');
	check('reserveCompletion');
	check('reserveDelete');
	check('reserveInsert');
	check('reserveList');
	check('reserveUpdate');
	check('showMenu2');
	check('userDelete');
	check('userIndex');
	check('userInsert');
	check('userInsertCompletion');
	check('userLogin');
	check('userUpdate');

});

function checkA(url){
	alert(url);
	window.open("/ideal/controller/"+url);
}
function check(url){
	alert(url);
	window.open("/ideal/"+url+".jsp");
}

</script>
</body>
</html>