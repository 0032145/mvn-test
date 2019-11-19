<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<h3>유저리스트</h3>
		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">이름</th>
					<th scope="col">아이디</th>
					<th scope="col">생성일</th>
					<th scope="col">생성시간</th>
				</tr>
			</thead>
			<tbody id="tBody">
			<tr>
			<td colspan="5">내용없음</td>
			</tr>
			</tbody>
		</table>
		<div class="button">
			<button onclick="goPage('/user/userInsert')">유저추가</button>
		</div>
	</div>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/user/list');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var userList = JSON.parse(xhr.responseText);
				var html ='';
				for(var user of userList){
					html += '<tr onclick="goPage(\'/user/userView?uiNum=' + user.uiNum + '\')">';
					html += '<td>' + user.uiNum + '</td>';
					html += '<td>' + user.uiName + '</td>';
					html += '<td>' + user.uiId + '</td>';
					html += '<td>' + user.credat + '</td>';
					html += '<td>' + user.cretim + '</td>';
					html += '</tr>';
				}
				document.querySelector('#tBody').innerHTML = html;
			}
		}
	}
	xhr.send();
}
</script>
</body>
</html>