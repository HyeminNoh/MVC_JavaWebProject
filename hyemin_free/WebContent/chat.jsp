<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, dog.club.domain.DogVO, dog.club.domain.ChatContent, dog.club.persistence.ChatConDAO"%>
 <%@taglib tagdir="/WEB-INF/tags" prefix="mytag" %> 
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title>방명록</title>
<link rel="stylesheet" href="resources/css/chat.css" type="text/css"></link>
</head>
<body>
<% 
	DogVO client = new DogVO();
	String cid="";
	int status=0;
	if(session.getAttribute("loginclient")!=null) {
		client=(DogVO)session.getAttribute("loginclient");
		cid = client.getId();
		
		status=1;
	}
%>
<l><mytag:SubLogo/></l>
<div><button type="button" onclick="location.href='http://localhost:8080/hyemin_free/main.jsp' ">메인페이지로 이동</button></div>
<br>
<div>
	<table>
		<tr>
			<td colspan="5">
				<header>방명록</header>
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<p>인사말 한마디 남겨주세요 *^_^*</p>
			</td>
		</tr>
		<% if(status==1){ %>
		<form name=form1 method="post" action="http://localhost:8080/hyemin_free/DogServlet?key=chat">
		<tr>
		<td><%out.println(cid); %>: </td>
		<td><input type="text" name="content"/></td>
		<td><input type="submit" value="등록"/></td>
		</tr>
		</form>
		<%} %>
		<% if(status==0){ %>
		<tr>
		<td>방명록 등록은 <a href="http://localhost:8080/hyemin_free/login.html">로그인</a> 후 이용해주세요.</td>
		</tr>
		<%} %>
		</table>
		<table>
		<tr class="td_color"><td>작성자ID</td><td>내용</td></tr>
		<%
			ChatConDAO chatDAO=new ChatConDAO();
			List<ChatContent> contentList = chatDAO.getContentList();
			for(ChatContent cont : contentList){
		%>
		<br>
		<tr>
			<td><%=cont.getId() %></td>
			<td><%=cont.getDate()%>: <%=cont.getContent() %></td>
		</tr>
		<% }%>
	</table>
</div>
</body>
</html>