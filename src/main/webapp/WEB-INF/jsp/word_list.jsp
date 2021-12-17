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
        <textarea style="height: 40px;width: 300px;font-size: 15px;margin-top: 10px" placeholder="输入中文" id="chinese" name="chinese"></textarea><br>
        <input type="text" style="height: 20px;width: 300px;font-size: 15px;margin-top: 10px" placeholder="音标"
               id="phonetic" name="phonetic"><br>
        <textarea style="height: 40px;width: 300px;font-size: 15px;margin-top: 10px" placeholder="例句" id="example" name="example"></textarea>

        <input type="button" value="添加" style="width: 100px;height: 20px;font-size: 15px;margin-top: 10px"
               onclick="addWord()">
    </div>
    <c:forEach items="${wordList}" var="var" varStatus="vs">
        <div style="border-top: 1px solid #DDDFE2;padding-top: 20px;margin-bottom: 10px">
            <div style=""><span style="color: #d32;font-size: 15px">${var.english}</span><span id="phoneticValue" style="color: #686868;font-size: 15px;margin-left: 3%">${var.phonetic}</span></div>
            <div style="margin-top: 10px; color: #555555;font-size: 15px"><span>${var.chinese}</span></div>
            <div style="margin-top: 10px; color: #555555;font-size: 15px"><span>${var.source}</span></div>
            <div style="margin-top: 10px; color: #555555;font-size: 15px"><span>${var.example}</span></div>
            <input type="button" onclick="uploadUpdateWordDialog('${var.id}','${var.english}','${var.chinese}','${var.source}','${var.phonetic}','${var.example}')" value='修改'>
        </div>
    </c:forEach>
</div>
</body>
<link rel="stylesheet" href="//staticssl.healthcare-inc.com/css/ui-dialog.css?version=V1">
<script src="//staticssl.healthcare-inc.com/js/dialog-plus-min.js?version=V1"></script>
<%--百度站点推送--%>
<script>
    /*(function () {
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
    })();*/

    function addWord() {
        $.ajax({
            type: "POST",
            url: "/english_to_chinese/add_word",
            dataType: "json",
            data: {'english': $("#english").val(), "chinese": $("#chinese").val(),"phonetic": $("#phonetic").val(),"example": $("#example").val()},
            success: function (msg) {
                window.location.reload();
            }
        });
    }

    function uploadUpdateWordDialog(wordId, english,chinese,source,phonetic,example) {
        commentDialog = dialog({
            title: "修改",
            content: commentTableEditHtmls,
            width: 300
        });

        $("[name=editEnglish]").val(english);
        $("[name=editChinese]").val(chinese);
        $("[name=editSource]").val(source);
        $("[name=editWordId]").val(wordId);
        $("[name=editPhonetic]").val(phonetic);
        $("[name=editExample]").val(example);

        commentDialog.showModal();
    }

    var commentTableEditHtmls ="" +
        "<input type='text' style='width: 250px;height: 30px;font-size: 20px;' id='editEnglish' name='editEnglish' placeholder='英文'> <br>" +
        "<input type='text' style='width: 250px;height: 30px;font-size: 20px;' id='editPhonetic' name='editPhonetic' placeholder='音标'> <br>" +
        "<input type='text' style='margin-top: 10px;width: 250px;height: 30px;font-size: 20px;' id='editChinese' name='editChinese' placeholder='中文'><br>" +
        "<input type='text' style='margin-top: 10px;width: 250px;height: 30px;font-size: 20px;' id='editSource' name='editSource' placeholder='来源'><br>" +
        "<input type='text' style='margin-top: 10px;width: 250px;height: 30px;font-size: 20px;' id='editExample' name='editExample' placeholder='例句'><br>" +
        "<input type='text' id='editWordId' name='editWordId' hidden>" +
        "<input type='button' onclick='updateWord()' style='height: 20px;margin-top: 10px;font-size: 15px' value='修改'>";

    function updateWord() {
        $.ajax({
            type: "POST",
            url: "/english_to_chinese/update_word",
            dataType: "json",
            data: {'english': $("#editEnglish").val(), "chinese": $("#editChinese").val(), "source": $("#editSource").val(),
                "id": $("#editWordId").val(), "phonetic": $("#editPhonetic").val(), "example": $("#editExample").val()},
            success: function (msg) {
                window.location.reload();
            }
        });
    }

</script>
</html>
