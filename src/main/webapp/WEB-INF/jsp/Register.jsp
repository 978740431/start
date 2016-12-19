<%--
  Created by IntelliJ IDEA.
  User: zhangnan
  Date: 16/7/23
  Time: 下午3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <link rel="stylesheet" href="../../static/css/register.css"/>

  <title>注册</title>
</head>
<body>
<div style="margin-left: 40%;margin-top: 20%;">
  <div>
    <span style="display: inline-block;width: 80px;">账号:</span><input type="text" id="username" onchange="queryUserIsExist()"></div>
  <div style="margin-top: 10px">
    <span style="display: inline-block;width: 80px;">验证码:</span><input id="authCode" type="text" name="authCode">
    <input type="button" id="authCodeButton" onclick="queryAuthCodeByAccount()" class="btn btn-success" value="获取验证码">
  </div>
  <div style="margin-top: 10px"><span style="display: inline-block;width: 80px;">密码:</span><input type="password" id="password"></div>
  <div style="margin-top: 10px"><span style="display: inline-block;width: 80px;">确认密码:</span><input type="password" id="confirmPassword"></div>
  <div style="margin-top: 10px"><span style="display: inline-block;width: 80px;">昵称:</span><input type="text" id="nickName"></div>
  <div style="margin-top: 10px;margin-left: 17.5%"><input type="button" value="注册" onclick="register()"/></div>
</div>
</body>
<script type="text/javascript" src="../../static/js/jquery-1.10.2.min.js"></script>

<script type="text/javascript">

  //用户贩判断用户是否存在,初始化设置为用户不存在
  var userExist=false;
  var username=$("#username");
  var password=$("#password");
  var nickName=$("#nickName");
  var authCode=$("#authCode");
  function register(){
    //校验用户密码和确认密码是否一致

    if(username.val()==null || username.val()==""){
      alert("账号不能为空");
      return false;

    }
    if(password.val()==null || password.val()==""){
      alert("密码不能为空");
      return false;
    }

    if(password.val()!=$("#confirmPassword").val()){
      alert("密码不一致");
      return false;
    }
    if(nickName.val()==null || nickName.val()==""){
      alert("昵称不能为空");
      return false;
    }
    if(authCode.val()==null || authCode.val()==""){
      alert("验证码不能为空");
      return false;
    }

    //校验用户是否存在
    if(userExist){
      alert("用户已存在");
      return false;
    }
    //用户注册
    $.ajax({
      type: "POST",
      url: "/user/register",
      dataType: "json",
      data:{ 'username':username.val(),'password':password.val(),'nickName':nickName.val(),'authCode':authCode.val()},
      success: function(msg){
        if(msg.resultKey==0){
          window.location='/article/queryArticleList';
        }else{
          alert(msg.resultValue);
        }
      }
    });
  }

  //查询用户是否存在
  function queryUserIsExist(){
    $.ajax({
      type: "POST",
      url: "/user/queryUserIsExist",
      dataType: "json",
      data:{ 'username':username.val()},
      success: function(msg){
        if(msg){
          alert("用户已存在");
          userExist=true;
        }else{
          userExist=false;
        }
      }
    });
  }


  var authCodeButton=$("#authCodeButton");

  var timeIndex = 60;
  var times;

  function queryAuthCodeByAccount() {
    if(username.val()==null || username.val()==""){
      alert("手机号不能为空");
      return false;
    }
    if(username.val().length<11){
      alert("手机号不满11位");
      return false;
    }

    $.get("/sendSMSCode", {"mobile": username.val()}, function cbk(msg) {
      var obj = eval("("+msg+")");
      if(obj.alibaba_aliqin_fc_sms_num_send_response.result.err_code==0){
        //验证码发送成功,将按钮置灰+不可点击
        authCodeButton.val("已发送");
        authCodeButton.attr('disabled',true);
        setTime();
        times = setInterval(setTime, 1000);
      }else {
        alert("验证码发送失败,请检查手机号");
      }
    });

  }

  function setTime(){
    var seconds = parseInt(timeIndex);    // 计算秒
    seconds = seconds < 10 ? "0" + seconds : seconds;
    authCodeButton.val("("+seconds+"秒)已发送");
    timeIndex--;
    if(timeIndex<0){
      clearInterval(times);
      authCodeButton.val("获取验证码");
      authCodeButton.attr('disabled',false);
      timeIndex=60;
    }
  }

</script>
</html>
