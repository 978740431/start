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
<div class="article-title" style="margin-top: 50px">
    <span class="article-title-span">${article.title}</span>
</div>
<%--<div>${article.articleGeneralize}</div>--%>
<div style="font-size: 12px;padding-top: 20px;color: #999;text-align: center">作者 ${article.author} | 发布于 ${article.createTime} | 阅读次数 ${article.readTimes} | 文章字数 ${article.articleLength}
    <c:if test="${userArticle==true}">
        &nbsp&nbsp&nbsp&nbsp
        <a style="font-size: 20px;color: #999;" href=<c:url value="/goEditUserArticlePlug?id=${article.id}" />>
            <img src="<%=request.getContextPath()%>/static/img/edit.png" style="width: 20px"></img>编辑
        </a>
    </c:if>
</div>

<blockquote class="article-content" style="margin-left: 21%;padding-left: 25px;margin-top: 100px;margin-right: 20%">
    ${article.articleGeneralize}
</blockquote>
<div class="article-content" style="margin-top: 100px">${article.content}</div>


<div style="margin-left: 20%;margin-right: 20%;margin-top: 100px;line-height: 1.2">
    <c:forEach items="${articleComments}" var="var" varStatus="vs">
        <div class="content-body">
            <div>
                ${var.commentContent}
            </div>
        </div>
    </c:forEach>
</div>
</body>
<script type="text/javascript">

</script>
</html>
