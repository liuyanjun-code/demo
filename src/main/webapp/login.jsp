<%--
  Created by IntelliJ IDEA.
  User: yitongleiying
  Date: 2022/3/29
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(!(request.getAttribute("message")==null)){
        out.println(request.getAttribute("message"));
    }
%>
<form action="/login" method="post">
    <input type="text" placeholder="Username">
    <input type="password"placeholder="Password">
    <input type="submit"  value="Login">
</form>
<%@include file="footer.jsp"%>
