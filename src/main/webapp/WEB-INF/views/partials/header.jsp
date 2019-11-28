<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
<br><br>

<c:choose>
	<c:when test="${loginUser == null}">
		<form action="/login" method="post" >
			<div class="form-group" style="display:inline-block;">
				<label for="title">Username: </label> 
				<div style="display:inline-block;" >
					<input  type="text" class="form-control" name="username" placeholder="Username" >
				</div>
			</div>
			<div class="form-group" style="display:inline-block;">
				<label for="writer">Password: </label>
				<div style="display:inline-block;" > 
					<input style="display:inline-block;" type="password" class="form-control" name="password" placeholder="Password">
				</div>
			</div>
			<button type="submit" class="btn btn-primary"> Login </button>
			<button onclick="location.href='/join'" type="button" class="btn btn-primary"> Join ?</button>
		</form>
	</c:when>
	<c:when test="${loginUser != null}">
		<h1>로그인 By ${loginUser} </h1>
	</c:when>
</c:choose>

 </div>
 <br><br>