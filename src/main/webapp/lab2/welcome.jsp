<%--
  Created by IntelliJ IDEA.
  User: yitongleiying
  Date: 2022/5/25
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Welcome</title>
</head>
<body>
<h2>Welcome,
  <%--todo 9 : use jsp:useBean to access the same instance of login bean from request scope--%>
  <jsp:useBean id="user" type="com.lab2.Login" scope="request"/>
  <%--todo 10 : use jsp:getProperty to display username --%>
  <jsp:getProperty name="user" property="username"/>
</h2>
</body>
</html>
