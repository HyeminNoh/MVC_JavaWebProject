<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개꿀팁</title>
<link rel="stylesheet" href="resources/css/list.css" type="text/css"></link>
</head>
<body>
<center>
<div>
<l><mytag:SubLogo/></l>
<div><button type="button" onclick="location.href='http://localhost:8080/hyemin_free/main.jsp' ">메인페이지로 이동</button></div>
<p id="sect">강아지와 관련된 유용한 정보를 나눠요ʕ•ﻌ•ʔ</p>
<br>
<p>참고:<a href="https://terms.naver.com/list.nhn?cid=42883&categoryId=59597">네이버-다시 쓰는 개 사전</a></p>
<div>
<table>
	<c:forEach var="tipContent" items="${tipContents }" begin="0" varStatus="status" end="7">
	<tr>
	<td><img width="80%" src="${tipContent.image }"/></td>
	<td><p><a href="${tipContent.url }"> "${tipContent.content }"</a></p></td>
	</tr>
	</c:forEach>
</table>
</div>
</div>
</center>
</body>
</html>