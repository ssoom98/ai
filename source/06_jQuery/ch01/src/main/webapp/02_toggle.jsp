<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
	div#toggle{
		width:200px; height:100px; line-height:100px;
		text-align :center;
		background-color:red;
	}
</style>
<script>
	$(document).ready(function(){
		//$('선택자').함수();
		$('h1.goShow').click(function(){
			$('#toggle').show();
		});
		$('h1.goHide').click(function(){
			$('#toggle').hide();
		});
		$('button').click(function(){
			$('#toggle').toggle();
		});
	});
</script>
</head>
<body>
	<button> 토글링</button>
	<h1 class="goShow">보이게</h1>
	<h1 class="goHide">사라지게</h1>
	<div id="toggle"><b>토글되는부분</b></div>
</body>
</html>