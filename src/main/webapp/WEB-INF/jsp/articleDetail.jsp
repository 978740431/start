<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="../../static/css/articleDetails.css"/>
    <link rel="stylesheet" href="../../static/css/wangEditor.min.css"/>
    <link rel="stylesheet" href="../../static/css/wangEditorCss.css"/>
    <title>${article.title}</title>
    <style>
        [contenteditable=true]:empty:before {
            content: attr(placeholder);
            color: #999;
        }
    </style>
</head>
<body style="margin: 0">
<%@ include file="/static/template/header.jsp"%>
<div class="article-title" style="margin-top: 50px">
    <span class="article-title-span">${article.title}</span>
</div>
<div style="font-size: 12px;padding-top: 20px;color: #999;text-align: center">作者 ${article.author} | 发布于 ${article.createTime} | 阅读次数 ${article.readTimes} | 文章字数 ${article.articleLength}
    <c:if test="${userArticle==true}">
        &nbsp&nbsp&nbsp&nbsp
        <a style="font-size: 20px;color: #999;" href="/goEditUserArticlePlug?id=${article.id}">
            <img src="../../static/img/edit.png" style="width: 20px"></img>编辑
        </a>
    </c:if>
</div>
<input type="hidden" name="articleId" id="articleId" value="${article.id}">

<blockquote class="article-content" style="margin-left: 21%;padding-left: 25px;margin-top: 100px;margin-right: 20%">
    ${article.articleGeneralize}
</blockquote>
<div class="article-content" style="margin-top: 100px">${article.content}</div>


<div style="margin-left: 20%;margin-right: 20%;margin-top: 100px;line-height: 1.2;">
    <c:forEach items="${articleComments}" var="var" varStatus="vs">
        <div style="border-top: 1px solid #DDDFE2;padding-top: 20px;margin-bottom: 10px">
                <div style="margin-left: 2%"><span style="color: #d32">${var.nickname}</span></div>
                <div style="margin-top: 10px;margin-left: 2%; color: #555555;"><span>${var.commentContent}</span></div>
        </div>
    </c:forEach>
    <div style="border-top: 1px solid #DDDFE2;"></div>
    <div style="margin-top: 30px;margin-left: 2%">
        <img src="http://static.duoshuo.com/images/noavatar_default.png" alt="">
        <div id="commentContent" contenteditable="true" name="title"  id="title" style="border: 1px solid #DFDFDF;font-size: 15px;outline:none;
        background: #FFFFFF;padding:2px;min-height:100px;float: right;width:90%;" placeholder="如果遇到问题,请在此添加内容,我们会通过短信通知作者尽快解决" ></div>
        <div style="float: right;width: 90.4%;background: #F6F8FA;margin-bottom: 300px;border: 1px solid #DFDFDF;">
            <input style="-webkit-appearance:button;float: right;margin-right: 2%;margin-bottom: 5px;margin-top: 5px;color: #60676d;font-size: 15px;height: 30px;width: 100px;" type="button" onclick="saveComment()" value="发布">
        </div>
    </div>
</div>
</body>
<script type="text/javascript">

    function saveComment(){
        var commentContent=$("#commentContent").html();
        commentContent = commentContent.replace("&nbsp;","");
        if(commentContent==""){
            alert("评论不能为空");
            return false;
        }
        $.ajax({
            type: "POST",
            url: "/article/addArticleComment",
            dataType: "json",
            data:{ 'commentContent':commentContent,"articleId":$("#articleId").val()},
            success: function(msg){
                if(0==msg.resultKey){
                    window.location='/article/queryArticleDetail?articleId='+$("#articleId").val();
                }else{
                    alert(msg.resultValue);
                }
            }
        });
    }
</script>
</html>
