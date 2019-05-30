<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dog.club.domain.*, java.util.List, dog.club.persistence.*"%>
     <%@taglib tagdir="/WEB-INF/tags" prefix="mytag" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내.댕.소</title>
<link rel="stylesheet" href="resources/css/board.css" type="text/css"></link>
</head>
<body>
<% 
	int status=0;
	if(session.getAttribute("loginclient")!=null) {
		status=1;
	}
%>
<l><mytag:SubLogo/></l>
<div><button type="button" onclick="location.href='http://localhost:8080/hyemin_free/DogServlet?key=main' ">메인페이지로 이동</button></div>
<br>
		<table>
		<tr>
			<td>
				<header>내 댕댕이를 소개합니다.</header>
			</td>
		</tr>
		</table>
		
	<div>
	<br>
	<% if(status==1){ %>
	<div style="width: 100%;">
		<div style="float:right;"><button style="float:right;" type="button" onclick="location.href='http://localhost:8080/hyemin_free/BoardService?key=add_board' ">게시글 등록</button></div>
	</div>
	<%} %>
	<table>
	<%
			BoardConDAO boardDAO=new BoardConDAO();
			List<BoardContent> contentList = boardDAO.getContentList();
			for(BoardContent cont : contentList){
	%>
	<tr><td class="td_color"><a href="http://localhost:8080/hyemin_free/BoardService?key=view_board&contno=<%=cont.getNo()%>"><%=cont.getNo()%>. <%=cont.getTitle() %></a></td></tr>
	<tr><td><a href="http://localhost:8080/hyemin_free/BoardService?key=view_board&contno=<%=cont.getNo()%>"><img src="<%=cont.getImagefile() %>" style="width:50%"></a></td></tr>
	<%} %>
	</table>
	</div>
</body>
</html>