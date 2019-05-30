<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.oreilly.servlet.MultipartRequest, 
 com.oreilly.servlet.multipart.DefaultFileRenamePolicy,java.util.*,java.io.*, dog.club.domain.BoardContent, dog.club.domain.DogVO"%>
 <%@taglib tagdir="/WEB-INF/tags" prefix="mytag" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댕세구: 게시글 등록 결과</title>
<link rel="stylesheet" href="resources/css/board.css" type="text/css"></link>
</head>
<%
DogVO client = new DogVO();
BoardContent addcon_result = new BoardContent();
String cid="";
int status=0;
if(session.getAttribute("loginclient")!=null) {
	client=(DogVO)session.getAttribute("loginclient");
	cid = client.getId();
	
	status=1;
}
addcon_result = (BoardContent)request.getAttribute("addCon");
%>
<body>
<l><mytag:SubLogo/></l>
<div><button type="button" onclick="location.href='http://localhost:8080/hyemin_free/BoardService?key=dog_board' ">목록으로 이동</button></div>
<br>
<div>
<table align="center" border="1">
<tr>
    <td colspan="2"><header>게시글 등록 완료</header></td>
</tr>
<tr>
    <td class="td_color">ID:</td>
    <td><%=addcon_result.getId() %></td>
</tr>
<tr>
    <td class="td_color">제목:</td>
    <td><%=addcon_result.getTitle() %></td>
</tr>
<tr>
    <td class="td_color">이미지 파일:</td>
    <td><img src="<%= addcon_result.getImagefile() %>" style="width:70%"></td>
</tr>
<tr>
    <td class="td_color">내용:</td>
    <td><%= addcon_result.getContent() %></td>
</tr>
</table>
</div>
</body>
</html>