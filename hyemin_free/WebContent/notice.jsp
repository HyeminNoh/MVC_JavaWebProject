<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dog.club.domain.*, java.util.List, dog.club.persistence.*"%>
    <%@taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="resources/css/chat.css" type="text/css"></link>
</head>
<body>
<l><mytag:SubLogo/></l>
<div><button type="button" onclick="location.href='http://localhost:8080/hyemin_free/DogServlet?key=main' ">메인페이지로 이동</button></div>
<br>
		<table>
		<tr>
			<td>
				<header>공지사항</header>
			</td>
		</tr>
		</table>
		
	<div>
	<br>
	<table>
	<tr>
	<td class="td_color">No.</td>
	<td class="td_color">제목</td>
	<td class="td_color">작성자</td>
	<td class="td_color">날짜</td>
	</tr>
	<%
			NoticeDAO noticeDAO=new NoticeDAO();
			List<Notice> contentList=noticeDAO.getContentList();
			for(Notice cont : contentList){
	%>
	<tr>
	<td><%=cont.getNo() %></td>
	<td><a href="http://localhost:8080/hyemin_free/DogServlet?key=notice_view&contno=<%=cont.getNo()%>"><%=cont.getTitle() %></a></td>
	<td><%=cont.getId() %></td>
	<td><%=cont.getDate() %></td>
	</tr>
	<%} %>
	</table>
	</div>
</body>
</html>