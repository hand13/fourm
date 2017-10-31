<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hd110
  Date: 2017/10/24
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>welcome</title>
      <link href="<c:url value="/fly/css/layui.css" />" rel="stylesheet">
      <script src="<c:url value="/fly/layui.js"/>"></script>
      <script src="https://unpkg.com/vue"></script>
      <script src="<c:url value="/js/fourm-index.js"/> "></script>
      <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
      <style>
          .no {
              display: none;
          }
      </style>
  </head>
  <body>
    <div>
        <jsp:include page="WEB-INF/jsp/nav.jsp"/>
    </div>
    <div align="center">
        <div class="layui-row">
            <div class="layui-col-md-offset5">
                 <a class="layui-btn" href="${pageContext.request.contextPath}/forum/show">去论坛</a>
            </div>
        </div>
    </div>
  <div>
      <jsp:include page="WEB-INF/jsp/lg.jsp"/>
  </div>
  <script>
      $("#login").on("click",function () {
          layui.use('layer',function () {
              layer.open({type:1,content:$('#loginPage'),title:"登陆"}) ;
          });
      });
      layui.use('element',function () {
          var element = layui.element;
      });
      layui.use('layer',function () {
          var layer = layui.layer;
          layer.msg("欢迎来到本坛，右上角登陆");
      });

  </script>
  </body>
</html>
