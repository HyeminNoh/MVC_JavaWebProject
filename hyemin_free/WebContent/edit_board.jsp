<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.oreilly.servlet.MultipartRequest, 
 com.oreilly.servlet.multipart.DefaultFileRenamePolicy,java.util.*,java.io.*, dog.club.domain.*, dog.club.persistence.*"%>
 <%@taglib tagdir="/WEB-INF/tags" prefix="mytag" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댕세구: 게시글 수정</title>
<link rel="stylesheet" href="resources/css/board.css" type="text/css"></link>
</head>
<body>
<% 
	DogVO client = new DogVO();
	BoardConDAO boardconDAO = new BoardConDAO();
	BoardContent checkcon = new BoardContent();
	
	String cid="";
	String contno = (String)request.getAttribute("contno");
	checkcon = boardconDAO.checkboard(contno);
	
	int status=0;
	if(session.getAttribute("loginclient")!=null) {
		client=(DogVO)session.getAttribute("loginclient");
		cid = client.getId();
	}
%>
<l><mytag:SubLogo/></l>
<div><button type="button" onclick="location.href='http://localhost:8080/hyemin_free/BoardService?key=dog_board' ">목록으로 이동</button></div>
<br>
<div>
<form name="form1" action="http://localhost:8080/hyemin_free/BoardService?key=update_board&contno=<%=contno%>" method="post" enctype="multipart/form-data">
<table align="center" border="1">
<tr>
    <td colspan="2"><header>게시글 수정</header></td>
</tr>
<tr>
    <td class="td_color">ID:</td>
    <td><%=checkcon.getId()%></td>
</tr>
<tr>
    <td class="td_color">제목:</td>
    <td><input type="text" name="title" value=<%= checkcon.getTitle() %>></td>
</tr>
<tr>
    <td class="td_color">이미지 파일:</td>
    <td><input type="file" name="ImageFile"></td>
</tr>
<tr>
    <td class="td_color">내용:</td>
    <td><input type="text" name="content" value=<%= checkcon.getContent() %>></td>
</tr>
<tr>
    <td colspan="2" align=center><input type="submit" value="전송"><input type=reset value="취소"></td>
</tr>
</table>
</div>
</body>
</html>