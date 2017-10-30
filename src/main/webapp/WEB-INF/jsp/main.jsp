<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: hd110
  Date: 2017/10/29
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/fly/css/layui.css" />" rel="stylesheet">
    <script src="<c:url value="/fly/layui.js"/>"></script>
    <script src="https://unpkg.com/vue"></script>
    <script src="<c:url value="/js/fourm-index.js"/> "></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <title>主页</title>
    <style>
        #content{
            margin-top: 20px;
            border-top: 2px solid #1b1b1b;
            width: 1000px;
        }
        .boards{
            height: 100px;
            border: 1px solid #00F7DE;
            margin-bottom: 10px;
        }
        a:hover{
            cursor: pointer;
        }
        body{
            font-size: 12px;
        }
        no {
            display: none;
        }
    </style>
</head>
<body>
<div>
    <nav>
        <ul class="layui-nav">
            <li class="layui-nav-item layui-this"><a href="">板块群</a></li>
            <li class="layui-nav-item"><a href="">社区</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <shiro:user>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    <shiro:principal/>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">我的帖子</a></dd>
                    <dd><a href="">安全设置</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/logout">登出</a></dd>
                </dl>
            </li>
            </shiro:user>
            <shiro:guest>
                <li class="layui-nav-item">
                    <a id="login">请登陆</a>
                </li>
            </shiro:guest>
        </ul>
    </nav>
</div>
<div class="layui-row">
    <div id="content" class="layui-col-md9 layui-col-md-offset1">
        <div style="margin-bottom: 10px">
            <h1>板块</h1>
        </div>
        <div class="layui-row layui-col-space20">
            <c:forEach var="board" varStatus="status" items="${requestScope.boards}">
                <div class="layui-col-md5 boards">
                    <h1><a href="${pageContext.request.contextPath}/forum/board/${board.boardName}/1">${board.boardName}</a></h1>
                    版主:
                    <c:forEach var="manager" items="${board.manages}">
                        <span>${manager.username}|</span>
                    </c:forEach>
                    <p>介绍:${board.boardDesc}</p>
                    <p>主题数:${board.topicNum}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
