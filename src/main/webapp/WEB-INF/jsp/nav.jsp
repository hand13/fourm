<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: hd110
  Date: 2017/10/30
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <dd><a href="${pageContext.request.contextPath}/register.jsp">注册</a></dd>
                </dl>
            </li>
        </shiro:user>
        <shiro:guest>
            <li class="layui-nav-item">
                <a id="login">请登陆</a>
            </li>
            <li class="layui-nav-item">
                <a href="${pageContext.request.contextPath}/register.jsp">注册</a>
            </li>
        </shiro:guest>
    </ul>
</nav>
