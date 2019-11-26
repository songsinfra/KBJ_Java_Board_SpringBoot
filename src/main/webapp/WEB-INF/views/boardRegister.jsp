<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board Register Page</title>
</head>
<body>
 
<h2> 게시글 작성 </h2>
 
<div class="container">
    <form action="/boards/register" method="post">
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text" class="form-control" name="title" placeholder="제목" value="Default Title">
      </div>
      <div class="form-group">
        <label for="writer">작성자</label>
        <input type="text" class="form-control" name="writer" placeholder="작성자" value="Default Writer">
      </div>
      <div class="form-group">
        <label for=content">내용</label>
        <textarea class="form-control" id="content" name="content" rows="3">Default Content 입니다. Default Content 입니다. Default Content 입니다.</textarea>
      </div>
      <button type="submit" class="btn btn-primary">글 작성</button>
    </form>
</div>
<%@ include file="./partials/bootstrap.jsp" %>
</body>
</html>


