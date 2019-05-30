<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dog.club.domain.*, dog.club.persistence.BoardConDAO"%>
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
	DogVO client = new DogVO();
	
	BoardConDAO boardconDAO = new BoardConDAO();
	BoardContent checkcon = new BoardContent();
	String cid="";
	String contno="";
	
	contno=(String)request.getAttribute("contno");

	checkcon = boardconDAO.checkboard(contno);
	
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
<div><button type="button" onclick="location.href='http://localhost:8080/hyemin_free/BoardService?key=dog_board' ">목록으로 이동</button></div>
<br>
<div>
<% if(status==1){ %>
	<div style="width: 100%;">
		<div style="float:right;"><button style="float:right;" type="button" onclick="location.href='http://localhost:8080/hyemin_free/BoardService?key=update_board&contno=<%=checkcon.getNo()%>' ">수정</button><button style="float:right;" type="button" onclick="location.href='http://localhost:8080/hyemin_free/BoardService?key=delete_board&contno=<%=checkcon.getNo()%>' ">삭제</button></div>
	</div>
<%} %>
<table align="center" border="1">
<tr>
    <td class="td_color">ID:<%= checkcon.getId() %></td>
    <td class="td_color">제목:<%=checkcon.getTitle() %></td>
</tr>
<tr>
	<td colspan="2"><img src="<%=checkcon.getImagefile() %>" style="width:70%"></td>
</tr>
<tr>
    <td class="td_color" colspan="2">내용</td>
</tr>
<tr>
    <td colspan="2" style="height:100px"><%=checkcon.getContent() %></td>
</tr>
</table>
</div>
</body>
</html>