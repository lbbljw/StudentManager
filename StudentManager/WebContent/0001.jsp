<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head lang="en">

<meta charset="UTF-8">

<title>登录界面111111</title>

<script src="js/jquery-1.11.1.js"></script>

<script src="js/login.js"></script>

<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

</script>
<style>
        table{
        text-align: center;
        }
        /*td{*/
            /*text-align: center;*/
        /*}*/
    </style>
</head>

<body>

<!-- sdfsdfsdfsdfsdfsdf -->
賬號:&nbsp;<input type="text"  placeholder="請輸入賬號" size="10"  ><br>
<input type="button"  value="提交" ><br>
<input type="checkbox" >足球
<input type="checkbox" >籃球<br>
<input type="password">
<div>
<form action="">
<input type="radio" value name="people"> 男
<input type="radio" value="1" name="people"> 女
</form><br>
<form action="all">
<input type="submit" value="提交">

</form><br>
<select>
<option  value="0">
<option  value="1">遼寧
<option  value="2">吉林
<option  value="3">黑龍江
</select>
<table align="center"  VALIGN="top"  border="4" >
<tr>
<th>name</th>
<th>Chinese</th>
<th>English</th>
<th>Japanese</th>
</tr>
<tr>
<th>Rick</th>
<th>100</th>
<th>55</th>
<th>33</th>
</tr>
<tr>
<th>Lucy</th>
<th>80</th>
<th>88</th>
<th>87</th>
</tr>
</table>
</div>
<h1 align="center">hello</h1>
<h2>hello</h2>
<h3>hello</h3>

<table border="1" width="50%" weight="50%">
    <tr>  <th rowspan="5">上午</th>  <th>星期一</th> <th>星期二</th> <th>星期三</th> <th>星期四</th> <th>星期五</th></tr>
    <tr>  <td>语文</td> <td>英语</td> <td>物理</td> <td colspan="2">英语</td></tr>
    <tr>  <td>语文</td> <td>英语</td> <td>物理</td> <td>英语</td> <td>数学</td></tr>
    <tr>  <td>英语</td> <td colspan="2">数学</td> <td>数学</td> <td rowspan="2">地理</td></tr>
    <tr>  <td>英语</td> <td>数学</td> <td>数学</td> <td>数学</td> </tr>
    <tr>  <th rowspan="3">下午</th> <td>数学</td> <td>生物</td> <td>化学</td> <td>物理</td> <td>历史</td></tr>
    <tr>  <td>数学</td> <td>地理</td> <td colspan="2">物理</td> <td>化学</td></tr>
    <tr>  <td>体育</td> <td colspan="2">化学</td><td colspan="2">体育</td>
</table>

</body>
</html>