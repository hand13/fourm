<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: hd110
  Date: 2017/10/30
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>posts</title>
    <link href="<c:url value="/fly/css/layui.css" />" rel="stylesheet">
    <script src="<c:url value="/fly/layui.js"/>"></script>
    <script src="https://unpkg.com/vue"></script>
    <script src="<c:url value="/js/fourm-index.js"/> "></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <style>
        .content {
            margin-top: 20px;
        }
        td{
            padding: 5px;
        }
        .no {
            display: none;
        }
        a:hover{
            cursor: pointer;
        }
    </style>
</head>
<body>
<div>
    <jsp:include page="nav.jsp"/>
</div>
<div class="layui-container content layui-col-md-offset1">
    <div style="margin-bottom: 7px;">
        <h1>帖子</h1>
    </div>
    <div>
        <c:if test="${!empty mainPost}">
            <h1>main</h1>
        <table style="width: 900px; background-color: #d4d4d4">
            <tr style="height: 100px; border-bottom: solid #2E2D3C 1px">
                <td style="width: 100px; border-right: solid #9F9F9F 1px">${mainPost.username}</td>
                <td style="width: 500px;">
                    <div style="height: 40px">
                        发表时间:${mainPost.createTime}
                        <h1>${mainPost.postTitle}</h1>
                    </div>
                    <div style="height: 80px">${mainPost.postContext}</div>
                </td>
            </tr>
        </table>
        </c:if>
        <c:forEach var="post" items="${posts}">
            <table style="width: 900px; background-color: #d4d4d4">
                <tr style="height: 100px; border-bottom: solid #2E2D3C 1px">
                    <td style="width: 100px; border-right: solid #9F9F9F 1px"><strong>${post.username}</strong></td>
                    <td style="width: 500px;">
                        <div style="height: 40px">
                            <p>发表时间:${post.createTime}</p>
                            <h1>${post.postTitle}</h1>
                        </div>
                        <div style="height: 80px"><p>${post.postContext}</p></div>
                    </td>
                </tr>
            </table>
        </c:forEach>
    </div>
    <div>
        <c:if test="${num > 1}">
            <a class="layui-btn" href="${pageContext.request.contextPath}/forum/topic/${topic.topicId}/${num - 1}">${num -1 }</a>
        </c:if>
        <a class="layui-btn layui-btn-disabled">${num}</a>
        <a class="layui-btn" href="${pageContext.request.contextPath}/forum/board/${topic.topicId}/${num +1}">${num + 1}</a>
    </div>
</div>
<div style="height: 10px;border-bottom: solid #FF5722 1px;border-top: solid #3F3F3F 1px"></div>
<div>
    <form class="layui-form" action="${pageContext.request.contextPath}/forum/addPost/${topic.topicId}" method="post">
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-block" style="width: 200px; height: 50px;">
                <textarea name="postTitle" placeholder="请输入内容" class="layui-textarea" required></textarea>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">内容</label>
            <div class="layui-input-block">
                <textarea name="postContext" placeholder="请输入内容" class="layui-textarea" required></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn <shiro:guest>layui-btn-disabled</shiro:guest>" lay-submit lay-filter="formDemo">发帖</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<div>
    <jsp:include page="lg.jsp"/>
</div>
<script>
    layui.use('form',function () {
        var form = layui.form;
    });
    $("#login").on("click",function () {
        layui.use('layer',function () {
            layer.open({type:1,content:$('#loginPage'),title:"登陆"}) ;
        });
    });
</script>
</body>
</html>
