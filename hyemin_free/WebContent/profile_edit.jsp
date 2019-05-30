<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dog.club.domain.*, java.util.List"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로필 수정</title>
<link rel="stylesheet" href="resources/css/join.css" type="text/css"></link>
</head>
<body>
<l><mytag:SubLogo/></l>
<div>
<br>
	<div>
		<form name=form1 method="post" action="http://localhost:8080/hyemin_free/ProfileService?key=edit">
			<table>
				<tr>
					<td colspan="2">
						<header>내 정보 수정</header>
					</td>
				</tr>
				<%
					DogVO loginclient = (DogVO)session.getAttribute("loginclient");
				%>
				<tr>
					<td>이름</td>
					<td><input type=text size=20 name=username value=<%= loginclient.getUsername() %>></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type=text size=20 name=id value=<%= loginclient.getId() %>></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type=text size=20 name=password value=<%= loginclient.getPassword() %>></td>
				</tr>
				<tr>
					<td>반려견 이름</td>
					<td><input type=text size=20 name=dogname value=<%= loginclient.getDogname() %>></td>
				</tr>
				<tr>
					<td>반려견 나이</td>
					<td><input type="number" name="dogage" min="1" max="50" value=<%= loginclient.getDogage() %>></td>
				</tr>
				<tr>
					<td>반려견 성별</td>
					<td>
					<% String sex=loginclient.getDogsex(); 
								if(sex.equals("남")){%>
						<select name=dogsex>
								
								<option selected>남</option>
								<option>여</option>
						</select>
					<%} %>
					<% if(sex.equals("여")){%>
						<select name=dogsex>
								<option>남</option>
								<option selected>여</option>
						</select>
					<%} %>
					</td>
				</tr>
				<tr>
					<td>견종</td>
					<td>
					<% String type=loginclient.getDogtype(); 
						if(type.equals("말티즈")){%>
						<select name="dogtype">
								<option value="말티즈"selected>말티즈</option>
								<option value="요크셔테리어">요크셔테리어</option>
								<option value="치와와">치와와</option>
								<option value="시추">시추</option>
								<option value="푸들">푸들</option>
							</select>
							<%} %>
					<% if(type.equals("요크셔테리어")){%>
							<select name="dogtype">
								<option value="말티즈">말티즈</option>
								<option value="요크셔테리어"selected>요크셔테리어</option>
								<option value="치와와">치와와</option>
								<option value="시추">시추</option>
								<option value="푸들">푸들</option>
							</select>
					<%} %>
					<% if(type.equals("치와와")){%>
							<select name="dogtype">
								<option value="말티즈">말티즈</option>
								<option value="요크셔테리어">요크셔테리어</option>
								<option value="치와와"selected>치와와</option>
								<option value="시추">시추</option>
								<option value="푸들">푸들</option>
							</select>
					<%} %>
					<% if(type.equals("시추")){%>
							<select name="dogtype">
								<option value="말티즈">말티즈</option>
								<option value="요크셔테리어">요크셔테리어</option>
								<option value="치와와">치와와</option>
								<option value="시추"selected>시추</option>
								<option value="푸들">푸들</option>
							</select>
					<%} %>
					<% if(type.equals("푸들")){%>
							<select name="dogtype">
								<option value="말티즈">말티즈</option>
								<option value="요크셔테리어">요크셔테리어</option>
								<option value="치와와">치와와</option>
								<option value="시추">시추</option>
								<option value="푸들"selected>푸들</option>
							</select>
					<%} %>
					</td>
				</tr>
				<tr>
					<td colspan=2 align=center>
							<input type=submit value="확인">
							<input type=reset value="취소">
						</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>