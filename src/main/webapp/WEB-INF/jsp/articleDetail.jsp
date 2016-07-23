<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="/static/css/question.css"/>
    <link rel="stylesheet" href="/static/css/wangEditor.min.css"/>
    <link rel="stylesheet" href="/static/css/wangEditorCss.css"/>
    <title>问题区</title>
</head>
<body>
<%@ include file="/static/template/header.html"%>
<div class="article-title"><span class="article-title-span">${article.title}</span></div>
<div class="article-content">${article.content}</div>
</body>
<script type="text/javascript">

</script>
</html>
