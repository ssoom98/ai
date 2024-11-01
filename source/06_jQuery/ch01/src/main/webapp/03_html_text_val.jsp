<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	$(document).ready(function(){
		//p태그와 input태그에 내용을 넣기
		$('p#msg').html('<b>중복된아이디입니다</b>');
		//$("p#msg").html('<b>사용가능한 아이디입니다</b>');
		$('input[name=msg]').val('Hello,jQuery');
		// button 클릭시 : p태그내용과 input태그의 value를 가져와서 alert창에 출력
		$('button').click(function(){
			var pMsgTag = $('p#msg').html();//<b>중복된 아이디입니다</b>
			var pMsgtext = $('p#msg').text().trim();// 중복된 아이디 입니다
			var inputMsg = $('input[name=msg]').val();//value값
			alert(pMsgTag + '\n' +pMsgsext+ '\n' + inputMsg);
		});
		
	});
</script>
</head>
<body>
	<p id="msg"></p>
	<p>정보 :<input type="text" name="msg"></p>
	<button>msg 내용 alert</button>
</body>
</html>