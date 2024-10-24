<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
	<script>
		window.onload=()=>{
			document.querySelector("input[name='memo']").onkeyup=function(){
				var span = document.querySelector('span');
				span.innerHTML = this.value.length +'/30';
			};
		}
	</script>
</head>
<body>
	<form action="ex2_memoPro.jsp" method="post">
		<table>
			<tr>
				<th>작성자</th>
				<th>한줄메모</th>
			</tr>
			<tr>
				<td><input type="text" name="writer" size="3"></td>
				<td>
					<input type="text" name="memo" maxlength="30" size="25">
					<span>0/30</span>
				</td>
			</tr>
			<tr><input type="submit" name="작성하기"></tr>
				
		</table>
	
	</form>
</body>
</html>