<%--
  Created by IntelliJ IDEA.
  User: hd110
  Date: 2017/10/30
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="loginPage" class="no">
    <form class="layui-form" action="${pageContext.request.contextPath}/login" method="post">
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
                <button class="layui-btn" lay-submit lay-filter="formDemo">登陆</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
