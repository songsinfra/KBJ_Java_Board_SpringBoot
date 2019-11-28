<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Register Page</title>
</head>
<body>
 
<div class="container">
    <form action="/join" method="post" id="joinForm">
      <h1> User Register - 회원가입 페이지</h1>
      
      <h3 style="color:red" >${message}</h3>
      <div class="form-group">
        <label for="writer">Username</label>
        <input required type="text" class="form-control" name="username" id="username" placeholder="Username" onkeypress="return runByEnter(event)">
      </div>
      <div class="form-group">
        <label for="writer">Password</label>
        <input required type="password" class="form-control" name="password" id="password" placeholder="Password" onkeypress="return runByEnter(event)">
      </div>
      <div class="form-group">
        <label for="writer">Password Confirm</label>
        <input required type="password" class="form-control" name="passwordConfirm" id="passwordConfirm" placeholder="Password Confirm" onkeypress="return runByEnter(event)">
      </div>
      
      <button type="button" class="btn btn-primary" onclick="checkUserInfo()">Confirm Join</button>
      <a class="btn btn-primary" href="/">Back</a>
    </form>
</div>

<script type="text/javascript">

	// Enter Key 입력시 Form Submit
	function runByEnter(e) {
	    if (e.keyCode == 13) {
	    	checkUserInfo();
	        return false;
	    }
	}

	// 페이지 로딩 후 username input에 포커스 집중
	window.onload  = function() {
		document.getElementById('username').focus();
	}

	// 가입 전 유효값 확인
	function checkUserInfo() {
		if(document.getElementById('username').value.trim() == '' || document.getElementById('password').value.trim() == '' ||document.getElementById('passwordConfirm').value.trim() == ''){
			alert('Please Inser All User Information')
			return;
		}
		if(document.getElementById('password').value != document.getElementById('passwordConfirm').value){
			alert('Please Insert Same Passwords')
			return;
		}
		document.getElementById('joinForm').submit();
	}
</script>

<%@ include file="./partials/bootstrap.jsp" %>

</body>
</html>


