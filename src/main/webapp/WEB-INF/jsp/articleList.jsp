<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="/static/css/question.css"/>
    <title>文章区</title>
</head>
<body>
<%@ include file="/static/template/header.jsp"%>
<c:forEach items="${articleList}" var="var" varStatus="vs">
    <div class="content-body">
        <a href="queryArticleDetail?articleId=${var.id}" target="_Blank" id="title" class="question">${var.title}</a>
        <div class="article-footer">${var.author} ${var.createTime}</div>
    </div>
</c:forEach>

</body>
<script type="text/javascript" src="/static/js/iscroll.js"></script>

<script type="text/javascript">


</script>
</html>
