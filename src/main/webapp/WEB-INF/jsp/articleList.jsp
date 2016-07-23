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
<%@ include file="/static/template/header.html"%>
<c:forEach items="${articleList}" var="var" varStatus="vs">
    <div class="content-body">
        <a href="queryArticleDetail?articleId=${var.id}" target="_Blank" id="title" class="question">${var.title}</a>
        <div class="article-footer">${var.author} ${var.createTime}</div>
    </div>
</c:forEach>


<%--
url:指点击页数后，程序将执行的方法。
items:指记录总数，该组件根本这个数计算出要分多少页。
maxPageItems:每页最多显示多少条数据。
maxIndexPages:最多显示多少页。例如：10，则首页12345678910下一页尾页
export:需要暴露的变量。一般默认即可。
<pg:param name="xxx">这个标签可以增加需要传入后台的参数
    <pg:first>像first prev这些标签，和字面意思相同，即表示第一页前一页。
        另，下面有一些常用的pager属性：
        pageUrl:分页的链接，后面自动带有参数。
        pageNumber:页号。
        pager.offset:pageUrl后面带的参数，表示该页的第一个元素的索引。对数据库分页有用。
--%>


<%--        <pg:pager url="/clinic/usermanage" items="${requestScope.total}" maxPageItems="10" maxIndexPages="10">
            <pg:index>
                <pg:first><a href="${pageUrl}">首页</a></pg:first>
                <pg:prev><a href="${pageUrl}">上一页</a></pg:prev>
                <pg:pages><a href="${pageUrl}">${pageNumber}</a></pg:pages>
                <pg:next><a href="${pageUrl}">下一页</a></pg:next>
                <pg:last><a href="${pageUrl}">尾页</a></pg:last>
            </pg:index>
        </pg:pager>--%>

        <%--<input type="button" onclick="test()" />--%>
</body>
<script type="text/javascript" src="/static/js/iscroll.js"></script>

<script type="text/javascript">
    function test(){

        /*$.ajax({
            type: "GET",
            url: "http://192.168.100.129:8080/pay/app/paylog/refund/doRefund?batch_num=1&detail_data=2016061221001004350298700510^1^11111",
            dataType: "html",
            success: function(msg){
                console.log(11);
                console.log(msg);
                $("#one").html(msg);
            }
        });*/
    }

    var     myScroll,
            pullDownEl, pullDownOffset,
            pullUpEl, pullUpOffset,
            generatedCount = 0;

    /**
     * 下拉刷新 （自定义实现此方法）
     * myScroll.refresh(); 数据加载完成后，调用界面更新方法
     */
    function pullDownAction () {
        setTimeout(function () {
            var el, li, i;
            el = document.getElementById('thelist');

            for (i=0; i<3; i++) {
                li = document.createElement('li');
                li.innerText = 'Generated row ' + (++generatedCount);
                el.insertBefore(li, el.childNodes[0]);
            }

            myScroll.refresh();     //数据加载完成后，调用界面更新方法
        }, 1000);
    }

    /**
     * 滚动翻页 （自定义实现此方法）
     * myScroll.refresh();      // 数据加载完成后，调用界面更新方法
     */
    function pullUpAction () {
        setTimeout(function () {    // <-- Simulate network congestion, remove setTimeout from production!
            var el, li, i;
            el = document.getElementById('thelist');

            for (i=0; i<3; i++) {
                li = document.createElement('li');
                li.innerText = 'Generated row ' + (++generatedCount);
                el.appendChild(li, el.childNodes[0]);
            }

            myScroll.refresh();     //数据加载完成后，调用界面更新方法
        }, 1000);
    }

    /**
     * 初始化iScroll控件
     */
    function loaded() {
        pullDownEl = document.getElementById('pullDown');
        pullDownOffset = pullDownEl.offsetHeight;
        pullUpEl = document.getElementById('pullUp');
        pullUpOffset = pullUpEl.offsetHeight;

        myScroll = new iScroll('wrapper', {
            scrollbarClass: 'myScrollbar',
            useTransition: false,
            topOffset: pullDownOffset,
            onRefresh: function () {
                if (pullDownEl.className.match('loading')) {
                    pullDownEl.className = '';
                    pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';
                } else if (pullUpEl.className.match('loading')) {
                    pullUpEl.className = '';
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
                }
            },
            onScrollMove: function () {
                if (this.y > 5 && !pullDownEl.className.match('flip')) {
                    pullDownEl.className = 'flip';
                    pullDownEl.querySelector('.pullDownLabel').innerHTML = '松手开始更新...';
                    this.minScrollY = 0;
                } else if (this.y < 5 && pullDownEl.className.match('flip')) {
                    pullDownEl.className = '';
                    pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';
                    this.minScrollY = -pullDownOffset;
                } else if (this.y < (this.maxScrollY - 5) && !pullUpEl.className.match('flip')) {
                    pullUpEl.className = 'flip';
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '松手开始更新...';
                    this.maxScrollY = this.maxScrollY;
                } else if (this.y > (this.maxScrollY + 5) && pullUpEl.className.match('flip')) {
                    pullUpEl.className = '';
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
                    this.maxScrollY = pullUpOffset;
                }
            },
            onScrollEnd: function () {
                if (pullDownEl.className.match('flip')) {
                    pullDownEl.className = 'loading';
                    pullDownEl.querySelector('.pullDownLabel').innerHTML = '加载中...';
                    pullDownAction();   // ajax call
                } else if (pullUpEl.className.match('flip')) {
                    pullUpEl.className = 'loading';
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '加载中...';
                    pullUpAction(); // ajax call
                }
            }
        });

        setTimeout(function () { document.getElementById('wrapper').style.left = '0'; }, 800);
    }

    //初始化绑定iScroll控件
    document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
    document.addEventListener('DOMContentLoaded', loaded, false);


</script>
</html>
