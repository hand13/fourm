<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hd110
  Date: 2017/10/31
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>writeTopic</title>
    <link href="<c:url value="/fly/css/layui.css" />" rel="stylesheet">
    <script src="<c:url value="/fly/layui.js"/>"></script>
    <script src="https://unpkg.com/vue"></script>
    <script src="<c:url value="/js/fourm-index.js"/> "></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <style>
        .cs{
            width : 900px;
            margin-top: 20px;
            margin-bottom:20px;
            margin-left: 40px;
            border: solid #009f95 2px;
        }
        .title {
            width : 400px;
            height: 50px;
        }
    </style>
</head>
<body>
    <div>
        <jsp:include page="nav.jsp"/>
    </div>
    <div class="cs">
        <form class="layui-form" action="${pageContext.request.contextPath}/forum/addTopic/${boardId}" method="post">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">标题</label>
                <div class="layui-input-block title">
                    <textarea name="topicTitle" placeholder="请输入内容" class="layui-textarea" required></textarea>
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">摘要</label>
                <div class="layui-input-block">
                    <textarea name="digest" placeholder="请输入内容" class="layui-textarea" required></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
    <script>
        layui.use('form',function () {
            var form = layui.form;
        })
    </script>
</body>
</html>
