<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/articleDetails.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/wangEditor.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/wangEditorCss.css"/>
    <title>问题区</title>
</head>
<body style="margin: 0">
<%@ include file="/static/template/header.jsp"%>
<div class="article-title">
    <span class="article-title-span">${article.title}</span>
    <c:if test="${userArticle==true}">
        <a href=<c:url value="/goEditUserArticlePlug?id=${article.id}" />>修改</a>
    </c:if>
</div>
<%--<div>${article.articleGeneralize}</div>--%>
<div class="article-content">${article.content}</div>
</body>
<script type="text/javascript">

</script>
</html>
