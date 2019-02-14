<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head lang="en">

    <meta charset="UTF-8">

    <title>登录界面</title>

    <script src="js/jquery-1.11.1.js"></script>

    <script src="js/login.js"></script>

    <link href="css/style.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" >
 $(function(){

	   $(".loginform_submit").click(function(){

	       if(checkInput()) {

	           $("form").action("/loginServlet");

	       }else{

	           return false;

	       }

	   });

	   $(".validationCode_img").click(function(){

	       $(".validationCode_img").attr("src","/UserLogin/Sample1/validationCode?"+Math.random());

	   });

	    function checkInput(){

	        //判断用户名

	        if($("input[name=username]").val() == null || $("input[name=username]").val() == ""){

	            alert("用户名不能为空");

	            $("input[name=username]").focus();

	            return false;

	        }

	        //判断密码

	        if($("input[name=password]").val() == null || $("input[name=password]").val() == ""){

	            alert("密码不能为空");

	            $("input[name=password]").focus();

	            return false;

	        }

	        //判断验证码

	        if($("input[name=validationCode]").val() == null || $("input[name=validationCode]").val() == ""){

	            alert("验证码不能为空");

	            $("input[name=validationCode]").focus();

	            return false;

	        }

	        return true;

	    }

	});
 </script  >
</head>

<body>

    <div id="loginpanelwrap">

        <div class="loginheader">

            <div class="logintitle">登录</div>

        </div>

        <form action = "/UserLogin/Sample1/loginServlet">

            <div class="loginform">

                <div class="loginform_row">

                    <label>用户名:</label>

                    <input type="text" class="loginform_input" name="username" />

                </div>

                <div class="loginform_row">

                    <label>密码:</label>

                    <input type="password" class="loginform_input" name="password" />

                </div>

                <div class = "loginform_row">

                    <label>验证码:</label>

                    <input type = "text" class="loginform_input_validationCode" name = "validationCode"/>

                    <img class = "validationCode_img" src="/UserLogin/Sample1/validationCode">

                </div>

                <div class="loginform_row">

                    <span class = "returnInfo"></span>

                    <input type="submit" class="loginform_submit" value="登录" />

                </div>

                <div class="clear"></div>

            </div>

        </form>

    </div>

</body>

</html>