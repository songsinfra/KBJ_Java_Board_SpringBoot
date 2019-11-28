<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
<br><br>

<c:choose>
	<c:when test="${loginUser == null}">
		<h3>admin / admin 으로 로그인 가능합니다 ^_^</h3>
		<form action="/login" method="post" >
			<div class="form-group" style="display:inline-block;">
				<label for="title">Username: </label> 
				<div style="display:inline-block;" >
					<input required type="text" class="form-control" name="username" placeholder="Username" >
				</div>
			</div>
			<div class="form-group" style="display:inline-block;">
				<label for="writer">Password: </label>
				<div style="display:inline-block;" > 
					<input required style="display:inline-block;" type="password" class="form-control" name="password" placeholder="Password">
				</div>
			</div>
			<button type="submit" class="btn btn-primary"> Login </button>
			<button onclick="location.href='/join'" type="button" class="btn btn-primary"> Join ?</button>
		</form>
	</c:when>
	<c:when test="${loginUser != null}">
		<div class="form-group" style="display:inline-block;">
			<label><h2> 로그인 By ${loginUser} </h2></label>
			<button class="btn btn-primary" onclick="location.href='/logout'">Logout ?</button>
		</div>
	</c:when>
</c:choose>

 </div>
 <br><br>
 
 <%@ include file="./bootstrap.jsp" %>