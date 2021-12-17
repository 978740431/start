<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="zuliup - 六篇 - 我们相信,每一份知识都有其对应的价值" />
    <meta name="keywords" content="zuliup - 六篇 - 我们相信,每一份知识都有其对应的价值" />
    <link rel="stylesheet" href="../../static/css/articleDetails.css"/>
    <title>六篇</title>
</head>
<%--<script src="https://s95.cnzz.com/z_stat.php?id=1260990957&web_id=1260990957" language="JavaScript"></script>--%>
<body style="margin: 0px">
<%@ include file="/static/template/header.jsp"%>
<div style="margin-left: 20%;margin-right: 20%;margin-top: 100px;line-height: 1.2">
    <c:forEach items="${articleList}" var="var" varStatus="vs">
        <div class="content-body">
            <div style="margin-bottom: 10px">
                <a href="/article/queryArticleDetail?articleId=${var.id}" target="_Blank" id="title" class="question">${var.title}</a>
            </div>
            <div class="article-footer">作者 ${var.author} | 发布于 ${var.createTime} | 阅读次数 ${var.readTimes} | 文章字数 ${var.articleLength}</div>
            <div style="margin-top: 40px;line-height: 35px">${var.articleGeneralize}</div>
        </div>
    </c:forEach>
</div>
</body>
<script type="text/javascript" src="../../static/js/iscroll.js"></script>

</html>
