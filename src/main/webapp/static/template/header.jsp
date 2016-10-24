<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="head-fix">
    <div class="page-head">
        <li class="head-text"><a href="<%=request.getContextPath()%>/article/queryArticleList">文章</a></li>
    </div>
    <div class="page-head-right" id="notLogin">
    </div>
    <div class="page-head-right" id="hasLogin">
    </div>

    <hr class="clear-float"/>
</div>

<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-1.10.2.min.js"></script>

<script type="text/javascript">

    $(function(){
        $.ajax({
            type: "GET",
            url: "<%=request.getContextPath()%>/user/queryUserIsLogin",
            dataType: "json",
            success: function(msg){
                console.log(msg);
                if(msg==true){
                    $("#hasLogin").html(" <li class='head-text'><a href=<c:url value="/goEditPage" />>写文章</a></li>" +
                            "<li class='head-text'><a href='<%=request.getContextPath()%>/user_article/queryUserArticleList'>我的</a></li>"+
                    "<li class='head-text'><a href='<%=request.getContextPath()%>/user/login_out'>退出</a></li>");
                }else{
                    $("#notLogin").html(" <li class='head-text'><a href='<%=request.getContextPath()%>/user/goLogin'>登陆</a></li>"+
                    "<li class='head-text'><a href='<%=request.getContextPath()%>/user/goRegister'>注册</a></li>");
                }
            }
        });
    });



</script>
