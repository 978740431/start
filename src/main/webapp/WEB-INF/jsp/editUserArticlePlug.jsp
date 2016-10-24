<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>文章</title>
    <!--引入wangEditor.css-->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/wangEditor.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/article.css">

    <!--引入jquery和wangEditor.js-->   <!--注意：javascript必须放在body最后，否则可能会出现问题-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/wangEditor.min.js"></script>
</head>
    <div class="titleDiv">
        <textarea onkeyup="MaxMe(this)" name="title" id="title" cols="70" rows="1" title="文章标题" placeholder="文章标题" class="title">${article.title}</textarea>
    </div>
    <div class="wangEdit">
        <div id="div1" style="height:500px">${article.content}</div>
    </div>
    <input type="hidden" id="articleId" value="${article.id}">
    <input type="hidden" id="uid" value="${article.uid}">
    <input type="button" value="发布" onclick="test()" style="float:right"/>
</div>
</body>
<script type="text/javascript">
    var editor = new wangEditor('div1');
    editor.config.uploadImgUrl = '/image/update_image';
    editor.config.hideLinkImg = true;
    editor.config.uploadImgFileName ='studentPhoto';

    // 自定义菜单
    editor.config.menus = [
        'source',
        '|',
        'bold',
        'underline',
        'italic',
        'strikethrough',
        'eraser',
        'forecolor',
        'bgcolor',
        '|',
        'quote',
        'fontfamily',
        'fontsize',
        'head',
        'unorderlist',
        'orderlist',
        'alignleft',
        'aligncenter',
        'alignright',
        '|',
        'link',
        'unlink',
        'table',
        '|',
        'img',
        'insertcode',
        'fullscreen',
        '|'

    ];
    editor.create();

    function test(){
        $.ajax({
            type: "POST",
            url: "<%=request.getContextPath()%>/user_article/updateUserArticle",
            dataType: "json",
            data:{ 'content':editor.$txt.html(),'title':$("#title").val(),'id':$("#articleId").val(),'uid':$("#uid").val(),'price':0},
            success: function(msg){
                if("success"==msg){
                    window.location='<%=request.getContextPath()%>/article/queryArticleList';
                }else{
                    alert("保存错误");
                }
            }
        });
    }
    //改变areatext高度
    function MaxMe(o) {
        if (window.navigator.userAgent.indexOf("Firefox") > -1) {
            o.style.height = o.scrollTop + o.scrollHeight + "px";
        }
        else {
            if (o.scrollTop > 0) o.style.height = o.scrollTop + o.scrollHeight + "px";
        }
    }
</script>
</html>
