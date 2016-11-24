<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <link rel="stylesheet" href="../../static/css/login.css"/>
  <title>登陆</title>
</head>
<body>
<div>
    <div class="login-div-username">账号: <input type="text" name="username" id="username"></div>
    <div class="login-div-password">密码: <input type="password" name="password" id="password"></div>
    <div class="login-div-login"><input type="submit" value="登陆" onclick="login()"/></div>
</div>

</body>
<script type="text/javascript" src="../../static/js/jquery-1.10.2.min.js"></script>


<script type="text/javascript">

  function login(){
    if($("#username").val()==null || $("#username").val()==""){
      alert("账号不能为空");
      return false;
    }
    if($("#password").val()==null || $("#password").val()==""){
      alert("密码不能为空");
      return false;
    }
    //登陆
    $.ajax({
      type: "POST",
      url: "/user/login",
      dataType: "json",
      data:{ 'username':$("#username").val(),'password':$("#password").val()},
      success: function(msg){
        if(msg=="true"){
          window.location.href='/article/queryArticleList';
        }else{
          alert("账号或密码错误");
        }
      }
    });
  }



</script>
</html>
