<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: hd110
  Date: 2017/10/30
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Topics</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fly/css/layui.css">
    <script src="${pageContext.request.contextPath}/fly/layui.js"></script>
    <script src="https://unpkg.com/vue"></script>
    <script src="<c:url value="/js/fourm-index.js"/> "></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <style>
        a:hover{
            cursor: pointer;
            color: #a9302a;
        }
        .no {
            display: none;
        }
    </style>
</head>
<body>
    <div>
        <jsp:include page="nav.jsp"/>
    </div>
    <div>
        <div>
            <a href="${pageContext.request.contextPath}/forum/addTopic/${board.boardId}" class="layui-btn <shiro:guest>layui-btn-disabled</shiro:guest>">创建主题</a>
        </div>
        <div>
            <table lay-filter="test">
                <thead>
                <tr>
                    <th lay-data="{width:530,field:'desc'}">简介</th>
                    <th lay-data="{width:100,field:'author'}">作者</th>
                    <th lay-data="{width:100,field:'date'}">发表日期</th>
                    <th lay-data="{width:100,field:'visitors'}">查看</th>
                    <th lay-data="{width:100,field:'back'}">回复</th>
                    <th lay-data="{width:150,field:'last'}">最近回复</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="topic" items="${topics}">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/forum/topic/${topic.topicId}/1">${topic.topicTitle}</a></td>
                    <td><h2>${topic.username}</h2></td>
                    <td><h2>${topic.createTime}</h2></td>
                    <td><h2>${topic.topicViews}</h2></td>
                    <td><h2>${topic.topicReplics}</h2></td>
                    <td><h2>${topic.lastPost}</h2></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <c:if test="${num > 1}">
            <a class="layui-btn" href="${pageContext.request.contextPath}/forum/topic/${board.boardName}/${num - 1}">${num -1 }</a>
            </c:if>
            <a class="layui-btn layui-btn-disabled">${num}</a>
            <a class="layui-btn" href="${pageContext.request.contextPath}/forum/board/${board.boardName}/${num +1}">${num + 1}</a>
        </div>
    </div>
    <jsp:include page="lg.jsp"/>
    <script>
        layui.use('table',function () {
            var table = layui.table;
            table.init('test',{height:315});
        });
        $("#login").on("click",function () {
            layui.use('layer',function () {
                layer.open({type:1,content:$('#loginPage'),title:"登陆"}) ;
            });
        });
    </script>
</body>
</html>
