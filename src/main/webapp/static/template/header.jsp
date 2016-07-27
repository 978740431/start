<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="head-fix">
    <div class="page-head">
        <%--<li class="head-text">问题</li>--%>
        <li class="head-text"><a href="/article/queryArticleList">文章</a></li>
        <!--<input type=button value=按扭 onclick="window.location.href='../html/editPlug.html'">-->
    </div>
    <div class="page-head">
        <input type="button" value="提笔写文章" onclick="window.location='/static/html/editPlug.jsp'" style="float:right"/>
    </div>
    <c:if test="${empty user}">
        <div class="page-head-right">
            <li class="head-text"><a href="/user/goLogin">登陆</a></li>
            <li class="head-text"><a href="/user/goRegister">注册</a></li>
        </div>
    </c:if>
    <c:if test="${user!=null}">
        <div class="page-head-right">
            <li class="head-text"><a href="/user_article/queryUserArticleList">我的</a></li>
            <li class="head-text"><a href="/user/login_out">退出</a></li>
        </div>
    </c:if>

    <hr class="clear-float"/>
</div>