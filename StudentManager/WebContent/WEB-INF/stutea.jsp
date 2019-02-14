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
					<td>name</td>
					<td>birthday</td>
					<td>age</td>
					<td>classid</td>
					<td>teaid</td>
					<td>course</td>

				</tr>
			</thead>
			<c:forEach items="${stuteas}" var="stutea">
				<tr>
					<td id="${stutea.student.name }">${stutea.student.name }</td>
					<td id="${stutea.student.birthday }">${stutea.student.birthday }</td>
					<td id="${stutea.student.age }">${stutea.student.age }</td>
					<td id="${stutea.student.classid }">${stutea.student.classid }</td>
					<td id="${stutea.teacher.id }">${stutea.teacher.id}</td>
					<td id="${stutea.teacher.course }">${stutea.teacher.course }</td>

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

</body>
</html>