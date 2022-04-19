<%@ page import="com.liuyanjun.model.User" %><%--
  Created by IntelliJ IDEA.
  User: yitongleiying
  Date: 2022/4/19
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User u=(User) session.getAttribute("user");
%>
<form action="${pageContext.request.contextPath}/updateUser" align="center" name="form1" method="post" onsubmit="return on_submit()"><!--within do post() in servlet-->
    <h2>New User Registration!</h2><br>
    <div class="Login_Box">
        <input type="hidden" name="id" value="<%=u.getID()%>">
        <input type="text"  name="Username"id="A" placeholder="Username" value="<%=u.getUsername()%>"/>
        <input type="password" name="password" id="B" placeholder="password" value="<%=u.getPassword()%>">
        <input type="text" name="Email" id="C" placeholder=Email value="<%=u.getEmail()%>"><br>
        <input type="date" name="Birthdate" placeholder="Birthday" value="<%=u.getBirthdate()%>"><br>
    </div>
    <div class="Login_Box2">
        <strong>Gender</strong> <input type="radio" name="gender" value="male" <%= "male".equals(u.getGender())?"checked":""%>>Male
        <input type="radio" name="gender" value="female" <%= "female".equals(u.getGender())?"checked":""%>>Female<br>
    </div>
    <br><br><br>
    <input type="submit" class="Login_Box3" value="Save Changes" />
</form>
<%@include file="footer.jsp"%>
