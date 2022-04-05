<%--
  Created by IntelliJ IDEA.
  User: yitongleiying
  Date: 2022/3/7
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
<h2>Welcome come to My Online Shop Home page<h2>
<form method="get" target="_blank" action="search">
    <input type="text" name="text" size=30/>
    <select>
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="search"/>
</form>

<h1>Welcome come to my home page</h1>
<br/>
<a href="HelloREsoure">Hello servlet-week1</a>
<br/>
<a href="HelloWorldServlet">Sthdent Info Servlet-week2</a>
<br/>
<a herf="RegisterServlet">Register-getParmeter-week3</a>
<br/>
<a href="ConfigDemoServlet">config parameter-week4</a>
<br/>
<a href="register.jsp">Register JDBC -week4</a>
<br/>
<a href="index.jsp">include-week5</a>
<br/>
<a href="login.jsp">Login-week5</a>
<%@include file="footer.jsp"%>
