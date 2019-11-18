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
		</tbody>
	</table>
	</div>
	
	<script>
		window.onload = function(){
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/user/uiList?cmd=uiList');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						var list = JSON.parse(xhr.responseText);
						var tBody = document.getElementById('tBody');
						var html = '';
						for (var i = 0; i < list.length; i++) {
							html += '<tr>';
							html += '<td>' + list[i].uiNum + '</td>';
							html += '<td>' + list[i].uiName + '</td>';
							html += '<td>' + list[i].uiId + '</td>';
							html += '<td>' + list[i].credat + '</td>';
							html += '<td>' + list[i].cretim + '</td>';
							html += '</tr>';
						}
						tBody.innerHTML = html;
					}
				}
			}
			xhr.send();
		}
	</script>
</body>
</html>