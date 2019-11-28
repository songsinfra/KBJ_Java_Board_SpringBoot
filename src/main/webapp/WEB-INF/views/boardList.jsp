<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board List Page</title>
</head>
<body>
 
<jsp:include page="./partials/header.jsp"/> 
 
<div class="container">
	<button class="btn btn-primary" onclick="location.href='/boards/register'">글쓰기</button>
    <table class="table table-hover">
        <tr>
            <th>No</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성 날짜</th>
        </tr>
          <c:forEach var="list" items="${boardList}">
              <tr onclick="location.href='/boards/${list.boardId}'" style="cursor: pointer">
                 <td>${list.boardId}</td>
                 <td>${list.boardWriter}</td>
                 <td>${list.boardTitle}</td>
                 <td>${list.boardWriteTime}</td>
              </tr>
          </c:forEach>
          
    </table>
</div>
 
</body>
</html>


