<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dog.club.domain.*, java.util.List"%>
     <%@taglib tagdir="/WEB-INF/tags" prefix="mytag" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 등록된 강아지</title>
<link rel="stylesheet" href="resources/css/join.css" type="text/css"></link>
</head>
<body>
<l><mytag:SubLogo/></l>
<div>
<div><button type="button" onclick="location.href='http://localhost:8080/hyemin_free/main.jsp' ">메인페이지로 이동</button></div>
<br>
<div>
	<table>
		<tr>
			<td colspan="4">
				<header>강아지 정보</header>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<p>현재 가입된 회원들의 강아지들 정보입니다</p>
			</td>
		</tr>
		<tr class="td_color"><td>이름</td><td>나이</td><td>성별</td><td>견종</td></tr>
		<%
			List<DogVO> clientList=(List<DogVO>)request.getAttribute("clientList");
			for(DogVO vo : clientList){
		%>
		<tr>
			<td><%=vo.getDogname()%></td>
			<td><%=vo.getDogage()%></td>
			<td><%=vo.getDogsex()%></td>
			<td><%=vo.getDogtype()%></td>
		</tr>
		<% }%>
	</table>
</div>
</div>
</body>
</html>