<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="单词表"/>
    <meta name="description" content="单词表"/>
    <link rel="stylesheet" href="../../static/css/articleDetails.css"/>
    <link rel="stylesheet" href="../../static/css/wangEditor.min.css"/>
    <link rel="stylesheet" href="../../static/css/wangEditorCss.css"/>
    <script type="text/javascript" src="../../static/js/jquery-1.10.2.min.js"></script>
    <title>单词表 - zuliup - 六篇</title>
    <meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <style>
        [contenteditable=true]:empty:before {
            content: attr(placeholder);
            color: #999;
        }
    </style>
</head>
<%--友盟统计--%>
<%--<script src="https://s95.cnzz.com/z_stat.php?id=1260990957&web_id=1260990957" language="JavaScript"></script>--%>

<body style="margin: 0">
<%--防止另存为--%>
<noscript>
    <iframe src="*.htm"></iframe>
</noscript>
<%--<%@ include file="/static/template/header.jsp"%>--%>
<div class="article-title" style="margin-top: 50px">
    <span class="article-title-span">${article.title}</span>
</div>


<div style="margin-left: 7%;margin-right: 20%;margin-top: 10px;line-height: 1.2;">
    <div>
        <input type="text" style="height: 20px;width: 300px;font-size: 15px" placeholder="输入英文" id="english"
               name="english"><br>
        <input type="text" style="height: 20px;width: 300px;font-size: 15px;margin-top: 10px" placeholder="输入中文"
               id="chinese" name="chinese">
        <input type="button" value="添加" style="width: 100px;height: 20px;font-size: 15px;margin-top: 10px"
               onclick="addWord()">
    </div>
    <c:forEach items="${wordList}" var="var" varStatus="vs">
        <div style="border-top: 1px solid #DDDFE2;padding-top: 20px;margin-bottom: 10px">
            <div style=""><span style="color: #d32;font-size: 15px">${var.english}</span></div>
            <div style="margin-top: 10px; color: #555555;font-size: 15px"><span>${var.chinese}</span></div>
            <div style="margin-top: 10px; color: #555555;font-size: 15px"><span>${var.source}</span></div>
        </div>
    </c:forEach>
</div>
</body>
<script type="text/javascript">

    function saveComment() {
        var commentContent = $("#commentContent").html();
        commentContent = commentContent.replace("&nbsp;", "");
        if (commentContent == "") {
            alert("评论不能为空");
            return false;
        }
        $.ajax({
            type: "POST",
            url: "/article/addArticleComment",
            dataType: "json",
            data: {'commentContent': commentContent, "articleId": $("#articleId").val()},
            success: function (msg) {
                if (0 == msg.resultKey) {
                    window.location = '/article/queryArticleDetail?articleId=' + $("#articleId").val();
                } else {
                    alert(msg.resultValue);
                }
            }
        });
    }
</script>

<%--百度站点推送--%>
<script>
    (function () {
        var bp = document.createElement('script');
        var curProtocol = window.location.protocol.split(':')[0];
        if (curProtocol === 'https') {
            bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
        }
        else {
            bp.src = 'http://push.zhanzhang.baidu.com/push.js';
        }
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(bp, s);
    })();

    function addWord() {
        $.ajax({
            type: "POST",
            url: "/english_to_chinese/add_word",
            dataType: "json",
            data: {'english': $("#english").val(), "chinese": $("#chinese").val()},
            success: function (msg) {
                window.location.reload();
                /*if(0==msg.resultKey){
                 window.location='/article/queryArticleDetail?articleId='+$("#articleId").val();
                 }else{
                 alert(msg.resultValue);
                 }*/
            }
        });
    }
</script>
</html>
