<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dog.club.domain.*, dog.club.persistence.*"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="resources/css/board.css" type="text/css"></link>
</head>
<body>
<% 
	DogVO client = new DogVO();
	
	NoticeDAO noticeDAO = new NoticeDAO();
	Notice checkcon = new Notice();
	String cid="";
	String contno="";
	
	contno=(String)request.getAttribute("contno");

	checkcon = noticeDAO.checkContent(contno);
	
	int status=0;
	if(session.getAttribute("loginclient")!=null) {
		client=(DogVO)session.getAttribute("loginclient");
		cid = client.getId();
		if(cid.equals(checkcon.getId())){
			status=1;
		}
	}
	
%>
<l><mytag:SubLogo/></l>
<div><button type="button" onclick="location.href='http://localhost:8080/hyemin_free/DogServlet?key=notice' ">목록으로 이동</button></div>
<br>
<div>
<% if(status==1){ %>
	<div style="width: 100%;">
		<div style="float:right;"><button style="float:right;" type="button" onclick="#' ">수정</button><button style="float:right;" type="button" onclick="location.href='#' ">삭제</button></div>
	</div>
<%} %>
<table align="center" border="1">
<tr>
    <td class="td_color">No.<%= checkcon.getNo() %></td>
    <td class="td_color">제목:<%=checkcon.getTitle() %></td>
</tr>
<tr>
	<td><%=checkcon.getId() %></td>
	<td><%=checkcon.getDate() %></td>
</tr>
<tr>
    <td colspan="2" style="height:100px"><%=checkcon.getContent() %></td>
</tr>
</table>
</div>
</body>
</html>