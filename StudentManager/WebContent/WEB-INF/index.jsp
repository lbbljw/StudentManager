<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/all.css" />

<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script type="text/javascript" src=jquery-3.3.1.js></script>
<title>STUDENT管理</title>
<script type="text/javascript" >
$(function(){
	$("#").click(function(){
		$("#").submit();
		$("#xxx").val();
	})
})

$(document).ready(function(){
	$("#addbutton").click(function(){
		var input_name=$("#addname").val();
		var input_birthday=$("#addbirthday").val();
		var input_age=$("#addage").val();
		var input_score=$("#addscore").val();
		var input_classid=$("#addclassid").val();
		if	(input_name == "" || input_name == null){
			alert("姓名不能為空！！！");
			return false;
		}else{
			var username = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
			if(!username.test($("#addname").val())){
			alert("名字只能是英語或日語");
			return false;
	       }else{
				if(input_birthday == "" || input_birthday == null){
					alert("出生年月不能爲空！！！");
					return false;
				}else{
					var userbirthday=/^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
					if(!userbirthday.test($("#addbirthday").val())){
						alert("日期格式不正确，正确格式为：xxxx-xx-xx");
						return false;
					}else{
						if(input_age == "" || input_age == null){
							alert("年齡不能為空！！！");
							return false;
						}else{
							var userage=/^[0-9]+$/;
							if(!userage.test($("#addage").val())){
								alert("年齡必須是數字");
								return false;
							}else{
								if(input_score == "" || input_score == null){
									alert("成績不能爲空！！！");
									return false;
								}else{
									var userscore=/^[0-9]+$/;
									if(!userscore.test($("#addscore").val())){
										alert("成績必須是數字");
										return false;
									}else{
										if(input_classid == "" || input_classid == null){
											alert("班級不能爲空！！！");
											return false;
										}else{
											var userclassid=/^[0-9]+$/;
											if(!userclassid.test($("#addclassid").val())){
												alert("班級必須是數字");
												return false;
											}else{
												alert("ok！");
												$("#addForm").submit();
											}
										}
									}
								}
							}
						}
					}
				}
	       }
		}
	});
});


$(document).ready(function(){
	$("#IDdel").click(function(){
		var input_Id=$("#delid").val();
		if	(input_Id == "" || input_Id == null){
			alert("輸入要刪除的id！！！");
			return false;
		}else{
			var username = /^[0-9]+$/;
		if(!username.test($("#delid").val())){
			alert("ID只能輸入半角數字");
			return false;
	       }else{
				alert("刪除成功！");
				$("#delForm").submit();
	       }
		}
	});
});


	$(document).ready(function(){
		$("#idquerysumit").click(function(){
			var input_Id=$("#queryid").val();
			if	(input_Id == "" || input_Id == null){
				alert("輸入要查詢的id！！！");
				return false;
			}else{
				var username = /^[0-9]+$/;
				console.log("IDForm Function!");
			console.log($("#queryid").val())
			if(!username.test($("#queryid").val())){
				alert("ID只能輸入數字");
				return false;
		}else{
					alert("ok！");
					$("#IDForm").submit();

		}
			}
		});
	});

$(function(){
	$("#getgood").click(function(){
		$("#goodform").submit();
	});
});
</script>
</head>
<body>
	<img alt="" src="./images/header.jpg">
	<form align="center" action="teaall" method="post">
			<input type="submit" value="進入先生管理主页"  />
		</form>
	<h1 align="center">学生情報管理</h1>
	<div id="all_comm" class="all">
		<h2 align="center">STUENT信息一覧</h2>
	<table  border="4"  align="right">
			<thead>
				<tr align="center">
					<td>ID</td>
					<td>姓名</td>
					<td>出生年月</td>
					<td>年龄</td>
					<td>成績</td>
					<td>授業ID</td>
				</tr>
			</thead>
			<c:forEach items="${students}" var="student">
				<tr align="center">
					<td id="${student.id }">${student.id}</td>
					<td id="${student.id }">${student.name}</td>
					<td id="${student.id}">${student.birthday}</td>
					<td id="${student.id }">${student.age}</td>
					<td id="${student.id}">${student.score}</td>
					<td id="${student.id}">${student.classid}</td>
				</tr>
			</c:forEach>
		</table>
	<div id="add_comm" class="all" align="center">
		<h2>学生の検索</h2>
		<form action="queryByName" method="post">
			<input type="text" placeholder="氏名" name="name">
			<input type="submit" value="学生の検索">
		</form>
	</div>


		<form id="goodform" action="goodscore" method="post">
			<button id="getgood" type="button">
			<p>表示</p>
			</button>
		</form>


<div id="edit_comm" class="all" align="center">
		<h2>Id查詢</h2>
		<form id="IDForm" action="queryById" method="post">
			<input id="queryid" type="text" placeholder="要查詢的id" name="id" />
			<button id="idquerysumit" type="button">
			<p>查詢</p>
			</button>
		</form>
	</div>


	<div id="add_comm" class="all" align="center">
		<h2 id="edit_title">学生の追加</h2>
		<form id="addForm" action="add" method="post" class="checkform">
			<input id="addname" type="text" placeholder="氏名" name="name" />
			<input id="addbirthday" type="text" placeholder="生年月日" name="birthday" />
			<input  id="addage" type="text" placeholder="年齢" name="age" class="number" />
			<span class="alertarea"></span>
			<input id="addscore" type="text" placeholder="成績" name="score" />
			<input id="addclassid" type="text" placeholder="コースコード" name="classid" />
			<button id="addbutton" type="button">
			<p>添加</p>
			</button>
		</form>
	</div>

	<div id="edit_comm" class="all" align="center">
		<h2>刪除學員</h2>
		<form id="delForm" action="deleteById" method="post">
			<input id="delid" type="text" placeholder="刪除學員的id" name="id" />
			<button id="IDdel" type="button">
			<p>刪除</p>
			</button>
		</form>
	</div>

	<div id="edit_comm" class="all" align="center">
		<h2 id="edit_title">学生編集</h2>
		<form id="editForm" action="update" method="post">
			<input id="editid" type="text" placeholder="要修改的id" id="edit_id" name="id" /><br>
				 <input id="editname"	type="text" placeholder="氏名" name="name" />
				 <input id="editbirthday" type="text" placeholder="生年月日" name="birthday" />
			     <input id="editage" type="text" placeholder="年齢" name="age" />
			     <input id="editscore" type="text" placeholder="成績" name="score" />
			     <input id="editscore" type="text" placeholder="コースid" name="classid" />
			     <input	type="submit" value="修正の確認"  />
		</form>
	</div>
</body>
</html>