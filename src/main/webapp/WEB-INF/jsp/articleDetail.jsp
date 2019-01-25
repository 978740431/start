<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="${article.title}" />
    <meta name="description" content="${article.articleGeneralize}" />
    <link rel="stylesheet" href="../../static/css/articleDetails.css"/>
    <link rel="stylesheet" href="../../static/css/wangEditor.min.css"/>
    <link rel="stylesheet" href="../../static/css/wangEditorCss.css"/>
    <%-- 图片有预览效果--%>
    <link href="../../static/css/lightbox.css" rel="stylesheet">

    <title>${article.title} - zuliup - 六篇</title>
    <style>
        [contenteditable=true]:empty:before {
            content: attr(placeholder);
            color: #999;
        }
    </style>
</head>
<%--友盟统计--%>
<script src="https://s95.cnzz.com/z_stat.php?id=1260990957&web_id=1260990957" language="JavaScript"></script>

<body style="margin: 0">
<%--防止另存为--%>
<noscript>
    <iframe src="*.htm"></iframe>
</noscript>
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
        <img src="../../static/img/noavatar_default.png" alt="">
        <div id="commentContent" contenteditable="true" name="title"  id="title" style="border: 1px solid #DFDFDF;font-size: 15px;outline:none;
        background: #FFFFFF;padding:2px;min-height:100px;float: right;width:90%;" placeholder="如果遇到问题,请在此添加内容,我们会通过短信通知作者尽快解决" ></div>
        <div style="float: right;width: 90.4%;background: #F6F8FA;margin-bottom: 300px;border: 1px solid #DFDFDF;">
            <input style="-webkit-appearance:button;float: right;margin-right: 2%;margin-bottom: 5px;margin-top: 5px;color: #60676d;font-size: 15px;height: 30px;width: 100px;" type="button" onclick="saveComment()" value="发布">
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="../../static/js/lightbox.js"></script>
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

    window.onload = function () {
        var imgs = document.getElementsByTagName('img');
        for (var i = 0;i<imgs.length;i++){
            imgs[i].setAttribute("data-lightbox", "imgs-" + i);
            imgs[i].setAttribute("id", "imgs-" + i);
            $("#imgs-" + i).wrapAll("<a data-lightbox='"+ "imgs-" + i +"' href='"+ imgs[i].getAttribute('src') +"'></a>");
        }
    }
</script>

<%--百度站点推送--%>
<script>
    (function(){
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
</script>
</html>
