<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div style="background: #f5f5f5;height: 100px">
    <div style="padding-top: 25px">
        <div class="page-head">
            <li class="head-text" style="margin-left: 350px"><a href="/article/queryArticleList" style="color: #555555">文章</a></li>
        </div>
        <div class="page-head-right"  id="notLogin">
        </div>
        <div class="page-head-right" id="hasLogin">
        </div>
    </div>
</div>

<script type="text/javascript" src="../../static/js/jquery-1.10.2.min.js"></script>

<script type="text/javascript">

    $(function(){
        $.ajax({
            type: "GET",
            url: "/user/queryUserIsLogin",
            dataType: "json",
            success: function(msg){
                console.log(msg);
                if(msg==true){
                    $("#hasLogin").html(" <li class='head-text'><a style='color: #555555' href='/goEditPage'>写文章</a></li>" +
                            "<li class='head-text'><a href='/user_article/queryUserArticleList' style='color: #555555'>我的</a></li>"+
                    "<li class='head-text'><a href='/user/login_out' style='color: #555555;margin-right:280px'>退出</a></li>");
                }else{
                    $("#notLogin").html(" <li class='head-text'><a href='/user/goLogin' style='color: #555555'>登陆</a></li>"+
                    "<li class='head-text'><a href='/user/goRegister' style='color: #555555;margin-right:280px'>注册</a></li>");
                }
            }
        });
    });



</script>
