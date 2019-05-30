<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dog.club.domain.DogVO"%>
     <%@taglib tagdir="/WEB-INF/tags" prefix="mytag" %> 
<!DOCTYPE html>

<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소등록 완료</title>
<link rel="stylesheet" href="resources/css/join.css" type="text/css"></link>
</head>
<body>
<l><mytag:SubLogo/></l>
<p id="sect">회원가입이 완료 되었습니다.</p>
<div>
<% DogVO vo=(DogVO)request.getAttribute("client"); %>
	<table>
		<tr>
			<th class="td_color">이름</th>
			<td><%=vo.getUsername()%></td>
		</tr>
		<tr>
			<th class="td_color">아이디</th>
			<td><%=vo.getId()%></td>
		</tr>
		<tr>
			<th class="td_color">비밀번호</th>
			<td><%=vo.getPassword() %></td>
		</tr>
		<tr>
			<th class="td_color">반려견 이름</th>
			<td><%=vo.getDogname() %></td>
		</tr>
		<tr>
			<th class="td_color">반려견 나이</th>
			<td><%=vo.getDogage() %></td>
		</tr>
		<tr>
			<th class="td_color">반려견 성별</th>
			<td><%=vo.getDogsex() %></td>
		</tr>
		<tr>
			<th class="td_color">견종</th>
			<td><%=vo.getDogtype() %></td>
		</tr>
	</table>
</div>
<br>
<% session.setAttribute("loginclient",vo); %>
<div><button type="button" onclick="location.href='http://localhost:8080/hyemin_free/DogServlet?key=main' ">커뮤니티로 입장</button></div>
</body>
</html>