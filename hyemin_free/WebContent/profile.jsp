<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dog.club.domain.*, java.util.List"%>
    <%@taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로필</title>
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
			<td colspan="2">
				<header>내 정보</header>
			</td>
		</tr>
		<%
			DogVO loginclient = (DogVO)session.getAttribute("loginclient");
		%>
		<tr>
			<td class="td_color">이름</td>
			<td><%= loginclient.getUsername() %></td>
		</tr>
		<tr>
			<td class="td_color">아이디</td>
			<td><%= loginclient.getId() %></td>
		</tr>
		<tr>
			<td class="td_color">비밀번호</td>
			<td><%= loginclient.getPassword() %></td>
		</tr>
		<tr>
			<td class="td_color">반려견 이름</td>
			<td><%= loginclient.getDogname() %></td>
		</tr>
		<tr>
			<td class="td_color">반려견 나이</td>
			<td><%= loginclient.getDogage() %></td>
		</tr>
		<tr>
			<td class="td_color">반려견 성별</td>
			<td><%= loginclient.getDogsex() %></td>
		</tr>
		<tr>
			<td class="td_color">견종</td>
			<td><%= loginclient.getDogtype() %></td>
		</tr>
	</table>
	<br>
	<table>
		<tr>
			<td class="td_color"><a href="http://localhost:8080/hyemin_free/ProfileService?key=edit">프로필 수정</a></td>
			<td class="td_color"><a href="http://localhost:8080/hyemin_free/ProfileService?key=secession">회원 탈퇴</a></td>
		</tr>
	</table>
</div>
</div>
</body>
</html>