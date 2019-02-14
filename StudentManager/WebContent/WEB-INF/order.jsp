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
	})
})
</script>
</head>
<body>
	<img alt="" src="./images/header.jpg">
	<form align="center" action="teaall" method="post">
			<input type="submit" value="進入訂単管理主页"  />
		</form>
	<h1 align="center">訂単情報管理</h1>
	<div id="all_comm" class="all">
		<h2 align="center">訂単信息一覧</h2>
	<table  border="4"  align="right">
			<thead>
				<tr align="center">
					<td>名称</td>
					<td>日付</td>
					<td>金額</td>
				</tr>
			</thead>
			<c:forEach items="${orders}" var="order">
				<tr align="center">
					<td id="${order.name}">${order.name}</td>
					<td id="${order.name}">${order.date}</td>
					<td id="${order.name}">${order.amount}</td>

				</tr>
			</c:forEach>
		</table>
	<div id="add_comm" class="all" align="center">
		<h2>訂単の検索</h2>
		<form action="queryorByName" method="post">
			<input type="text" placeholder="名称" name="name"> <input
				type="submit" value="訂単の検索">
		</form>
	</div>


</body>
</html>