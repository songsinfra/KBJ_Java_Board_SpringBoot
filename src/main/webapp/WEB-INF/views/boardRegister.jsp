<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board Register Page</title>
</head>
<body>
 
<jsp:include page="./partials/header.jsp"/> 
 
<div class="container">
	<h2> 게시글 작성 </h2>
	
    <form action="/boards/register" method="post" enctype="multipart/form-data">
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text" class="form-control" name="title" placeholder="제목" value="Default Title">
      </div>
      <div class="form-group">
        <label for="writer">작성자</label>
<c:choose>
	<c:when test="${loginUser == null}"> 
		<input type="text" class="form-control" name="writer" placeholder="작성자" value="Default Writer">
	</c:when>
	<c:when test="${loginUser != null}">
		<input type="text" class="form-control" name="writer" placeholder="작성자" value='${loginUser}' readonly>
	</c:when>
</c:choose>
        
        
      </div>
      <div class="form-group">
        <label for=content">내용</label>
        <textarea class="form-control" id="content" name="content" rows="3">Default Content 입니다. Default Content 입니다. Default Content 입니다.</textarea>
      </div>
      <div class="form-group">
        <label for="writer">첨부 파일 - 1Mb 이하 3개까지 다중 첨부 가능</label>
        <input type="file" class="form-control" name="files" id="files" multiple>
      </div>
      
      <button type="submit" class="btn btn-primary">글 작성</button>
      <a class="btn btn-primary" href="/">글 리스트</a>
    </form>
</div>

<script type="text/javascript">

	// 페이지 로딩 후 username input에 포커스 집중
	window.onload  = function() {
		
	}

	//input file 태그의 규칙 확인
	document.getElementById("files").onchange = function() {
	  var fileList = [...document.getElementById("files").files];
	
	  //파일 갯수 제한
	  if (fileList.length > 3) {
	    alert("파일은 3개까지만 선택 부탁 드립니다");
	    document.getElementById("files").value = "";
	    return;
	  }
	  // 파일 용량 제한
	  fileList.map(element => {
	    if (element.size > 1024 * 1024) {
	      alert("첨부 파일 사이즈는 개당 1 MB로 제한하겠습니다 ㅠ");
	      document.getElementById("files").value = "";
	      return;
	    }
	  });
	};
</script>

</body>
</html>


