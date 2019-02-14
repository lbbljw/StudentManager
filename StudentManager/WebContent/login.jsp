<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script src="../js/jquery-1.11.3.js"></script>
<title>ユーザ登録画面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.7.2.min.js"></script>
<script type="text/javascript">

$(function(){
	$(":input[name='username']").change(function(){
		var val=$(this).val();
		val=$.trim(val);

		if(val!=""){
			var url="${pageContext.request.contextPath}/valiateUserName";
			var args={"userName":val,"time":new Date()};
			$.post(url,args,function(data){
				$("#message").html(data);
			});
		}
	});
})


	function dengluForm() {
		var form = document.getElementById('xxx');
		var input_ad = document.getElementById("inputid").value;
		var input_ps = document.getElementById("inputpsd").value;
		if (input_ad != "admin" || input_ps != "admin") {
			alert("账号或密码");
			return false;
		}
		form.submit();
		return true;
	}

</script>
</head>
<body>


	<form action="#" name="form1" align="center">
		<input type="text" name="field1" size="50">
	</form>

	<img alt="" src="./images/header.jpg">
	<div>
		<table id="table_id" align="center">
			<thead>
				<form id=xxx action="all" align="center">
					<tr>
						<td>ユーザ名 :</td>
						<td><input id="inputid" type="text" name="username" size="20">
						<div id="message"></div>
					</tr>
					<br><br>
			</thead>
			<tr>
				<td>パスワード:</td>
				<td><input id="inputpsd" type="password" name="password"
					size="20"></td>
			</tr>
			<br>
			<br>
			<td><input id="but" type="button" value="ログイン" onclick="dengluForm()"></td>
			<br>
			<br>
			</form>
		</table>
	</div>

	<!--
	1   获取页面所有a节点 并每个a节点 都添加 onclick响应函数 取消默认行为
	2 准备发送Ajax请求；url(a节点的href属性值)；args（时间戳）
	3 响应为一个JSON对象 包括：bookName，totalBookNumber,totalMoney
	4 把对应的属性添加到对应的位置
	 -->
	<div id="cartstatus">
		您已将 &nbsp;<span id="bookName"></span>&nbsp;添入购物车 &nbsp; &nbsp; 购买数量
		&nbsp; &nbsp;<span id="totalBookNumber"></span>&nbsp; &nbsp; 总价
		&nbsp;&nbsp;<span id="totalMoney"></span>&nbsp;<br> <br>
	</div>
	Java &nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/addToCart?id=Java&price=90">加入购物车</a>
	<br>
	<br> SQL &nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/addToCart?id=SQL&price=50">加入购物车</a>
	<br>
	<br> C &nbsp;&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/addToCart?id=C&price=100">加入购物车</a>
	<br>
	<br>
	<script type="text/javascript" stc="${pageContext.request.contextPath}/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">

	$(function(){
		var isHasCart="${sessionScope.sc==null}";
		//alert(isHasCart);
		if(isHasCart=="true"){
			$("#cartstatus").hide();
		}else{
			$("#cartstatus").show();
			$("#bookName").text("${sessionScope.sc.bookName}");
			$("#totalBookNumber").text("${sessionScope.sc.totalBookNumber}");
			$("#totalMoney").text("${sessionScope.sc.totalMoney}");
		}
		$("a").click(function(){
			$("#cartstatus").show();
			var url=this.href;
			var args={"time":new Date()};
			$.getJSON(url,args,function(data){
				$("#bookName").text(data.bookName);
				$("#totalBookNumber").text(data.totalBookNumber);
				$("#totalMoney").text(data.totalMoney);
			});
			return false;
		});
	})

	</script>

	<input id="myajaxbtn" type="button" href="javascript:void(0);" value="有惊喜"  >
	<script type="text/javascript">
		$(function() {
			$('#myajaxbtn').click(function(){
				var ajaxUrl = 'myajax';
				var username = $("#inputid").val();
				var param = {id:username};

				$.getJSON(ajaxUrl,param,function(result){
					if(!result.result){
						alert('接口失敗');
						return false;
					}else{
						//alert("接口成功");
					};
					var data = result.data;
					var html = "<table border='3' align='center'><tr><th>id</th> <th>名字</th> <th>出生</th> <th>年齡</th> <th>分数</th> <th>班级</th></tr>"
					for(var i=0;i<data.length;i++){
						html+="<tr align='center'><td>"+data[i].id+"</td>"
						html+="<td color='red'>"+data[i].name+"</td>"
						html+="<td>"+data[i].birthday+"</td>"
						html+="<td>"+data[i].age+"</td>"
						html+="<td>"+data[i].score+"</td>"
						html+="<td>"+data[i].classid+"</td>"
					}
					html+='</tr></table>'
					$("body").append(html);
					$("#inputid").hide();
					$("#inputpsd").hide();
					$("#but").hide();
					//$("body").css('background-color','green');
				});
			});
		});
	</script>
</body>
</html>
