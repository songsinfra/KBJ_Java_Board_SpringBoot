<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>

<div class="container">
<br><br>
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

 </div>
 <br><br>