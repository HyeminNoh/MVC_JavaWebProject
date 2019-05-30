<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="dog.club.domain.DogVO"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html>

<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title>DangSaeGu_main</title>
<link rel="stylesheet" href="resources/css/identity.css" type="text/css"></link>
</head>
<body>
<% 
	DogVO client = new DogVO();
	String cname="";
	String dname="";
	String cid="";
	int status=0;
	if(session.getAttribute("loginclient")!=null) {
		client=(DogVO)session.getAttribute("loginclient");
		cname = client.getUsername();
		dname = client.getDogname();
		cid = client.getId();
		
		status=1;
	}
%>
	<div style="text-align:right;">
		<p>건전한 커뮤니티 문화를 지향합니다.</p>
	</div>
	<hr>
	<l><mytag:MainLogo/></l>
	<div>
		<nav>
			<ul>
				<li><a href="http://localhost:8080/hyemin_free/DogServlet?key=chat">방명록</a></li>
				<li><a href="http://localhost:8080/hyemin_free/BoardService?key=dog_board">내.댕.소</a></li>
				<li><a href="http://localhost:8080/hyemin_free/DogServlet?key=tip">개꿀팁</a></li>
				<li><a href="http://localhost:8080/hyemin_free/DogServlet?key=notice">공지사항</a></li>
			</ul>
		</nav>
	</div>
<hr>
<div class="container">
	<div class="inline-box" id="left-box">
		<img style="height:100%; width: 100%; object-fit: contain"src="resources/images/super-chihuahua.jpg"/>
	</div>
	<%if(status==0) {%>
	<div class="inline-box" id="right-box">
		<br><p>반갑습니다 (ღ˘⌣˘ღ)<br>
		<br>반려견을 사랑하는 애견인들을 위한<br>커뮤니티 공간입니다.<br></p>
		<div>
			<a href="http://localhost:8080/hyemin_free/LoginService?key=login"><p id="sect">로그인</p></a>	
		</div>
		<div>
			<a href="http://localhost:8080/hyemin_free/LoginService?key=join" target="_self"><p id="sect">회원가입</p></a>
		</div>
	</div>
	<%} %>
	<%if(status==1) {%>
	<div class="inline-box" id="right-box">
		<p><% out.println(cname); %>님<br>환영합니다.</p>
		<p>id: <% out.println(cid); %></p>
		<p>내 반려견은 <% out.println(dname); %>♡<br>
		<div>
			<a href="http://localhost:8080/hyemin_free/ProfileService?key=profile"><p id="sect">내 정보</p></a>	
		</div>
		<div>
			<a href="http://localhost:8080/hyemin_free/LoginService?key=logout"><p id="sect">로그아웃</p></a>	
		</div>
		<div>
			<a href="http://localhost:8080/hyemin_free/DogServlet?key=list"><p id="sect">가입한<br>강아지 보러가기</p></a>	
		</div>
	</div>
	<%} %>
</div>
</body>
</html>