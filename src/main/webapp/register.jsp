<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hd110
  Date: 2017/10/30
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link href="<c:url value="/fly/css/layui.css" />" rel="stylesheet">
    <script src="<c:url value="/fly/layui.js"/>"></script>
    <script src="https://unpkg.com/vue"></script>
    <script src="<c:url value="/js/fourm-index.js"/> "></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <div>
        <jsp:include page="/WEB-INF/jsp/nav.jsp"/>
    </div>
    <div class="layui-row">
        <div class="layui-col-md5 layui-col-md-offset3">
            <h1>请注册</h1>
        </div>
        <div class="layui-col-md5 layui-col-md-offset3">
            <form class="layui-form" action="${pageContext.request.contextPath}/register" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="username" lay-verify ="required" placeholder="请输入用户名" autocomplete="false" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" lay-verify ="required" placeholder="请输入密码" autocomplete="false" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">注册</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
