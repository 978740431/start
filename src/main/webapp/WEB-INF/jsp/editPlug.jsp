<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>文章</title>
    <!--引入wangEditor.css-->
    <link rel="stylesheet" type="text/css" href="../../static/css/wangEditor.min.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/article.css">

    <!--引入jquery和wangEditor.js-->   <!--注意：javascript必须放在body最后，否则可能会出现问题-->
    <script type="text/javascript" src="../../static/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="../../static/js/wangEditor.min.js"></script>

    <style>
        .test[placeholder]:empty:before {
            content: attr(placeholder);
            color: #555;
        }
    </style>
</head>
<body>
<div>
    <div>
        <div class="test" contenteditable="true" name="title"  id="title" style="border: 1px solid #DFDFDF;font-size: 20px;
        background: #FFFFFF;padding:2px;min-height:25px;width:50%;margin-left: 25%;margin-top: 50px" placeholder="文章标题" ></div>
        <input type="button" value="发布" onclick="test()" />
    </div>
    <div>
        <div class="test" contenteditable="true" style="border: 1px solid #DFDFDF;font-size: 15px;width:50%;
        margin-left:25%;background: #FFFFFF;padding:2px;min-height:100px;margin-top: 50px" id="articleGeneralize" placeholder="文章介绍"></div>
    </div>
    <div class="wangEdit" style="margin-top: 50px">

        <div id="div1" style="height:1000px"></div>
    </div>
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
        if($("#title").html()==null || $("#title").html()==""){
            alert("标题不能为空");
            return false;
        }

        $.ajax({
            type: "POST",
            url: "article/insertArticle",
            dataType: "json",
            data:{ 'content':editor.$txt.html(),'title':$("#title").html(),'price':0,'articleGeneralize':$("#articleGeneralize").html()},
            success: function(msg){
                if("success"==msg){
                    window.location='article/queryArticleList';
                }else{
                    alert("保存错误");
                }
            }
        });
    }
</script>
</html>
