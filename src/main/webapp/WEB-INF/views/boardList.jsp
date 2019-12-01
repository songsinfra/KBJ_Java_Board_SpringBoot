<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board List Page</title>
</head>
<body>

	<jsp:include page="./partials/header.jsp" />

	<div class="container">
		<button class="btn btn-primary"
			onclick="location.href='/boards/register'">글쓰기</button>
		<table class="table table-hover">
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성 날짜</th>
			</tr>
			<c:forEach var="list" items="${boardList}">
				<tr onclick="location.href='/boards/${list.boardId}'"
					style="cursor: pointer">
					<td>${list.boardId}</td>
					<td>${list.boardWriter}</td>
					<td>${list.boardTitle}</td>
					<td>${list.boardWriteTime}</td>
				</tr>
			</c:forEach>
		</table>

		<div style="position: relative">
			<ul style="text-align: center;">
				<c:forEach var="i" begin="1" end="${pageCount}" step="1">
					<a href="/?pageNum=${i}" style="padding:5px;" id="pageNum${i}"><c:out value="${i}" /></a>
				</c:forEach>
			</ul>
		</div>
	</div>
	
	<div style="text-align:center;">
		<br /><br /><br />
		<h3>그냥 추가해 본, AWS S3에 이미지 파일 첨부하고 보여주기</h3>
		<form action="/files/aws/upload" method="post" enctype="multipart/form-data">
			<input required type="file" name="imgFile" id="imgFile" style="display:inline" />
			<input type="submit" value="Upload Image" /> 
		</form>
	</div>
	
	<c:forEach var="img" items="${imgList}">
		<img src="https://s3.ap-northeast-2.amazonaws.com/kbj.board.springboot/${img}" style="width:100px; height:100px;"/>
	</c:forEach>
	
	<script type="text/javascript">
		// 페이지 로딩 후, 현재 페이지 번호 스타일 변경 - 밑줄 + Bold
		window.onload = function(){
			var pageNum = window.location.search.substr(9); // 현제 페이지 번호
			if(pageNum == '')
				pageNum = 1; // 특별히 지정된 페이지 번호가 없으면 그냥 페이지 1이라고 간주
			
			document.getElementById('pageNum'+pageNum).style.textDecoration = 'underline'
			document.getElementById('pageNum'+pageNum).style.fontWeight = 'bold'
		}

		var imgFileTag = document.getElementById("imgFile"); 
		imgFileTag.onchange = function(e){
			// 선택된 파일 없으면 실행 X
			if(imgFileTag.value == '')
				return;

			// 첨부하려는 Image가 1 Mb 이상이라면 초기화
			if (imgFileTag.files[0].size > 1024 * 1024 * 1) {
			 imgFileTag.value = "";
			  alert("Image Size Needs to be Smaller than 1 Mb. ");
			  return;
			}

			 //선택된 파일이 Image가 아니라면 초기화
			 if (imgFileTag.files[0]["type"].split("/")[0] !== "image") {
			   imgFileTag.value = "";
			   alert("Only Image Allowed.");
			 }
		}
	</script>

</body>
</html>


