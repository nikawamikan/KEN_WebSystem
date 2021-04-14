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
	checkA("AdminLoginSvl");
	checkA("AdminReserveListSvl");
	checkA("CourseOperationSvl");
	checkA("GetCourseAjaxSvl");
	checkA("MailadressCheckSvl");
	checkA("MenuDeleteSvl");
	checkA("MenuInsertSvl");
	checkA("MenuMaintenanceSvl");
	checkA('MenuOperationSvl');
	checkA('MenuUpdateSvl');
	checkA('ReserveDeleteSvl');
	checkA('ReserveInsertSvl');
	checkA('ReserveListSvl');
	checkA('ReserveListAjaxSvl');
	checkA('ReserveOperationSvl');
	checkA('ReserveUpdateSvl');
	checkA('SessionErrSvl');
	checkA('ShowMenuSvl');
	checkA('UserDeleteSvl');
	checkA('UserLoginSvl');
	checkA('UserLogoffSvl');
	checkA('UserOperationSvl');
	checkA('UserUpdateSvl');

});

function checkA(url){
	alert(url);
	window.open("/ideal/controller/"+url);
}
function check(url){
	alert(url);
	window.open("/ideal/"+url);
}

</script>
</body>
</html>