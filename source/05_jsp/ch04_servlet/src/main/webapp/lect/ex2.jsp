<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h2>오늘의 메뉴와 식당 선택</h2>
	<form action="<%=conPath %>/ex2" method="post">
		<p>
			메뉴
			<select name="menu" multiple="multiple" size="3">
				<option value="kimchi">김치찌개</option>
				<option>된장찌개</option>
				<option>자장면</option>
				<option>스파게티</option>
				<option>부대찌개</option>
			</select>
		</p>
		<p>
		식당
		<input type="checkbox" name="rest" value="신림">신림
		<input type="checkbox" name="rest" value="구리">구리
		<input type="checkbox" name="rest" value="신도림">신도림
		<input type="checkbox" name="rest" value="용인" checked="checked">용인
		</p>
		<p>
			성별
			<input type="radio" name="gender" value="m">남자
			<input type="radio" name="gender" value="f">여자
		</p>
		<p><input type="submit"></p>
		
	</form>
</body>
</html>