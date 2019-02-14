<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

<title>Teacher管理</title>
<script type="text/javascript">

$(document).ready(function(){
	  $("#addteachersumit").click(function(){
		  var input_teachername=$("#addteachername").val();
		  var input_course=$("#addcourse").val();
		  if (input_teachername == "" || input_teachername == null) {
				alert("请输入先生姓名！！！");
				return false;
			}else{
				if (input_course == "" || input_course == null){
					alert("请输入先生課程！！！");
					return false;
				}
				   var username = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
					console.log("addCheckForm Function!");
				    console.log($("#addteachername").val());
				    if(!username.test($("#addteachername").val())){
						alert("先生姓名只能输入日文和英文");
						return false;
				    }else{
							alert("添加成功！");
							$("#addForm").submit();
				}
			}
	  });
	});

$(document).ready(function(){
	$("#delteachersumit").click(function(){
		var input_teacherId=$("#delid").val();
		if	(input_teacherId == "" || input_teacherId == null){
			alert("輸入要刪除先生的id！！！");
			return false;
		}else{
			var username = /^[0-9]+$/;
			console.log("delCheckForm Function!");
		console.log($("#delid").val())
		if(!username.test($("#delid").val())){
			alert("ID只能輸入數字");
			return false;
	}else{
				alert("刪除成功！");
				$("#delForm").submit();
	}
		}
	});
});
$(document).ready(function(){
	$("#editteachersumit").click(function(){
		var input_teacherId=$("#editid").val();
		var input_teacherName=$("#editteachername").val();
		var input_teacherCourse=$("#editcourse").val();
		if	(input_teacherId == "" || input_teacherId == null){
			alert("輸入要編輯先生的id！！！");
			return false;
		}else{
			if (input_teacherName == "" || input_teacherName == null){
				alert("请輸入要編輯的名字！！！");
				return false;
			}else{
				if(input_teacherCourse == "" || input_teacherCourse == null){
					alert("请輸入要編輯的課程！！！");
					return false;
				}
			}
			var username = /^[0-9]+$/;
			var usernameone=/^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
			console.log("editCheckForm Function!");
		    console.log($("#editid").val())
		if(!username.test($("#editid").val())){
			alert("ID只能輸入數字！");
			return false;
				}else{
		     if(!usernameone.test($("#editteachername").val())){
		    		alert("先生姓名只能输入日文和英文！");
		     }else{
				alert("編輯成功！");
				$("#editForm").submit();
		     }
	}
		}
	});
});


</script>
</head>
<body>

	<img alt="" src="./images/header.jpg">
<form align="center" action="all" method="post">
			<input type="submit" value="進入學生管理主页"  />
		</form>
	<h1 align="center">Teacher情報管理</h1>
	<div id="all_comm" class="teaall">
		<h2 align="center">TEACHER信息一覧</h2>
		<table id="table_id" align="center" border="1">
			<thead>
				<tr>
					<td>Id</td>
					<td>姓名</td>
					<td>課程</td>
				</tr>
			</thead>
			<c:forEach items="${teachers}" var="teacher">
				<tr>
					<td id="${teacher.id }">${teacher.id}</td>
					<td id="${teacher.id }">${teacher.teachername}</td>
					<td id="${teacher.id}">${teacher.course}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<div id="add_comm" class="teaall" align="center">
	<h2>先生の検索</h2>
	<form action="queryteaByName" method="post">
		<input type="text" placeholder="氏名" name="teachername"> <input
			type="submit" value="先生の検索">
	</form>
	<div id="add_comm" class="addtea" align="center">
		<h2 id="edit_title">先生の追加</h2>
		<form id="addForm" action="addtea" method="post">
			<input id="addteachername" type="text" placeholder="氏名"
				name="teachername" /> <input id="addcourse" type="text"
				placeholder="course" name="course" />
			<button id="addteachersumit" type="button">
				<p>添の加</p>
			</button>
		</form>
	</div>
</div>
<div id="edit_comm" class="deleteteaById" align="center">
	<h2>刪除の先生</h2>
	<form id="delForm" action="deleteteaById" method="post">
		<input id="delid" type="text" placeholder="要刪除的id" name="id" />
		<button id="delteachersumit" type="button" >
			<p>刪除の先生</p>
		</button>
	</form>
</div>
<div id="edit_comm" class="teaupdate" align="center">
	<h2 id="edit_title">先生の編集</h2>
	<form id="editForm" action="teaupdate" method="post">
		<input id="editid" type="text" placeholder="要修改的id" name="id" /><br>
		<input id="editteachername" type="text" placeholder="氏名" name="teachername" />
	    <input id="editcourse" type="text" placeholder="course" name="course" />
			<button id="editteachersumit" type="button" >
			<p>編集</p>
		</button>
	</form>

</div>
</body>
</html>