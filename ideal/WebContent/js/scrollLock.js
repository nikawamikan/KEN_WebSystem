$(function(){

	$('#menu-btn-check').change(function(){
		console.log($('#menu-btn-check').val());

		if(a){
			$('html').css('overflow','hidden');
			$('body').css('overflow','hidden');
		}else{
			$('html').css('overflow','');
			$('body').css('overflow','');
		}
		a=!a;

	});

});

var a=true;