$(function(){

	var deferred = writeList($('#afterDate').val());

	deferred.done(function(){
		updateReserveForm();
		coursePrint();
	});
});

function updateReserveForm(){
	console.log("formIn2");

	var tableId = Number($('#tableIdDef').val());
	var hourOfTime = Number($('#rsvHhDef').val());
	var minuteOfTime = Number($('#rsvMiDef').val());
	var personNum = Number($('#personDef').val());
	console.log("ID"+tableId + "h"+hourOfTime+"m"+minuteOfTime);
	$('#tableId').val(tableId);
	$('#tableName').html(tableName[tableId]);
	$('#rsvHh').val(hourOfTime);
	$('#rsvMi').val(minuteOfTime);
	$('#dispHourMin').html(hourOfTime+'時'+minuteOfTime+'分');

	var person;
	var personString="";
	if(tableId>5){
		person=6;
	}else{
		person=4;
	}
	for(i=1;i<=person;i++){
		if(personNum==i){
		personString+='<option value="'+i+'" selected>'+i+'名様</option>';
		}else{
		personString+='<option value="'+i+'" >'+i+'名様</option>';
		}
	}

	$('#person').html(personString);
	$('#person').prop("disabled", false);
	$('#send').prop("disabled", false);

	 const position = $('#lastForm').offset().top -160;
      const speed = 200;
      $("html,body").animate({scrollTop:position},speed);



	return false;
}

const tableName = ['','ローマ','フィレンツェ','ミラノ','ヴェニス','ナポリ','ロードス','シチリア'];

// とりあえずHTMLのLoadが終わったら明日の予約時間の表を構築させる。

	// カレンダーの日付を押した際に呼ばれるメソッド。予約時間の表を構築メソッドを呼び出す。
	function getReserveList(formObject) {
		writeList(formObject.calNum.value,false);
		 const position = $('#ajaxReserveListTime').offset().top -160;
	      const speed = 200;
	      $("html,body").animate({scrollTop:position},speed);
		return false;
	}


	const back1 = 'back1';
	const back2 = 'back2';

	// 予約できる時間のListの時間の部分
	function getHead(){
		var head="";
		head+="<tr><th></th>";

		var background;
		for(i=0;i<4;i++){
			if(i%2==0){
				background=back1;
			}else{
				background=back2;
			}
			head+='<th class="'+background+'" colspan=4>'+(i+17)+"</th>";
		}
			head+='<th colspan=3 class="back1">21</th>';
		head+="</tr><tr><th></th>";
		for(i =0 ;i<19;i++){
			if(Math.floor(i/4)%2==0){
				background=back1;
			}else{
				background=back2;
			}
			head+='<th class="'+background+'">'+( '00' + ((i%4)*15) ).slice( -2 )+"</th>";
		}
		head+="</th>";
		return head;
	}

	// 予約できる時間のListoを作成するための部品。引数から予約日のボタンを生成
	function getButton(b,tableId,index){
		if(b){
			return '<form action="#" onsubmit="return getReserveForm(this)">'
			+'<input type="hidden" name="index" value="'+index+'"/>'
			+'<input type="hidden" name="tableId" value="'+tableId+'"/>'
			+'<input class="greentile" type="submit" value="〇"/>'
			+'</form>';
			;
		}
		return '<center><div class="graytile">×</div></center>';
	}


	// 予約できる時間を表示するシステム
	function writeList(afterDate) {

		var deferred = new $.Deferred();
		$.ajax({
			url : "/ideal/controller/ReserveListAjaxSvl",
			type : "GET",
			dataType : "json",
			data : {
				rsvId:$('#rsvId').val(),
				mode : $('#mode').val(),
				today : $('#today').val(),
				afterDate : afterDate
			}
		}).done(function(result){
			// console.log("done");

			var keys = Object.keys(result);
			keys.sort();


			var reserveList ="";
			var date =new Date();
			// console.log(date.getDate());
			date.setDate(date.getDate() +Number(afterDate));
			$('#rsvYy').val(date.getFullYear());
			$('#rsvMm').val(date.getMonth()+1);
			$('#rsvDd').val(date.getDate());
			$('#dispYear').text(date.getFullYear()+'年');
			$('#dispMonthDate').text((date.getMonth()+1)+'月 '+date.getDate()+'日');
			$('#dispHourMin').html('');
			$('#tableName').html('');

			$('#tableId').val("");
			$('#rsvHh').val("");
			$('#rsvMi').val("");

			$('#person').prop("disabled", true);
			$('#send').prop("disabled", true);

			reserveList='<h2 class="yellowBack">'+date.getFullYear()+"年 "+(date.getMonth()+1)+"月"+date.getDate()+"日の予約状況"+"</h2>";
			reserveList+='<h3>〇がつく場所はご予約可能です。<br/>6人まで予約できるのはロードス、シチリアのみです。</h3>';

			$('#ajaxReserveListTime').html(reserveList);
			reserveList='<table style="width:900px;" class="tableRadius">';
				reserveList+=getHead();
			for(key of keys){
			reserveList+='<tr><th>'+(tableName[key])+"</th>";
			var index=0;
				result[key].forEach(function(b){
					reserveList +="<th>"+getButton(b,key,index)+"</th>";
					index++;
				});

			reserveList+="</tr>";

			}
			reserveList+="</table>";
			// console.log(reserveList);
			$('#ajaxReserveList').html(reserveList);

		}).fail(function(){
// console.log("fail");
			alert("日付が変わったので一度予約リストのページに戻ります。");
			window.location.href = '/ideal/reserveList.jsp';
		}).always(function(){
			console.log('ajaxEnd');
			deferred.resolve();
		});
		return deferred;
	}
	// 時間のtileを押したときに呼ばれるJS
	function getReserveForm(formObject){
		console.log("formIn");

		var tableId = Number(formObject.tableId.value);
		var hourOfTime = Math.floor(Number(formObject.index.value)/4)+17;
		var minuteOfTime = Number(formObject.index.value)%4*15;
		console.log("ID"+tableId + "h"+hourOfTime+"m"+minuteOfTime);
		$('#tableId').val(tableId);
		$('#tableName').html(tableName[tableId]);
		$('#rsvHh').val(hourOfTime);
		$('#rsvMi').val(minuteOfTime);
		$('#dispHourMin').html(hourOfTime+'時'+minuteOfTime+'分');

		var person;
		var personString="";
		if(tableId>5){
			person=6;
		}else{
			person=4;
		}
		for(i=1;i<=person;i++){
			if(i==1){
			personString+='<option value="'+i+'" selected >'+i+'名様</option>';
			}else{
			personString+='<option value="'+i+'" >'+i+'名様</option>';
			}
		}

		$('#person').html(personString);
		$('#person').prop("disabled", false);
		$('#send').prop("disabled", false);

		 const position = $('#lastForm').offset().top -160;
	      const speed = 200;
	      $("html,body").animate({scrollTop:position},speed);

		return false;
	}

	function coursePrint(){
		var courseId = $('#courseId').val();
		const formatter = new Intl.NumberFormat('ja-JP', {
			  style: 'currency',
			  currency: 'JPY'
			});

		$.ajax({
			url : "/ideal/controller/GetCourseAjaxSvl",
			type : "GET",
			dataType : "json",
			data : {
				courseId : courseId
			}
		}).done(function(result){

			console.log(result);

			var html = '<h2>'+result.courseName+'</h2>';
			html +='<h3>'+formatter.format(result.price)+'</h3>';
			html +='<h3>'+result.detail+'</h3>';
			$('#coursePrint').html(html);
			html="";
			for(i =0;i<result.menu.length;i++){
				html +='<h4>'+result.type[i]+'</h4>';
				html +='<h3>'+result.menu[i]+'</h3>';
			};
			$('#coursePrint2').html(html);


		});

	}