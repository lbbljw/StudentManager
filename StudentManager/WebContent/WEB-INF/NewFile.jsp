<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
	<div style="height: 320px;">
		<table align="center" border="1">
			<thead>
				<tr>
					<td>ID</td>
					<td>姓名</td>
					<td>出生年月</td>
					<td>年龄</td>
					<td>成績</td>
					<td>授業ID</td>

				</tr>
			</thead>
			<c:forEach items="${students}" var="student">
				<tr>
					<td id="${student.id }">${student.id }</td>
					<td id="${student.name }">${student.name }</td>
					<td id="${student.birthday }">${student.birthday }</td>
					<td id="${student.age }">${student.age }</td>
					<td id="${student.score }">${student.score }</td>
					<td id="${student.classid }">${student.classid }</td>

				</tr>
			</c:forEach>
		</table>
	</div>
	<div style="width: 100%; height: 30px">
		<style type="text/css">
.list {
	list-style: none;
}

.item {
	float: left;
	margin-right: 10px;
	width: 50px;
}
</style>
		<ul style="" class="list">
			<c:forEach begin="0" end="${pageCounts}" step="1" var="pagenum">
				<li class="item" style="float: left;margin-left: 222px;"><a
					href="http://localhost:8080/StudentManager/pageall?strBPoint=${pagenum}">第${pagenum+1}页</a></li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>