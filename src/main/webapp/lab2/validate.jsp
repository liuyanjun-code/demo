<%--
  Created by IntelliJ IDEA.
  User: yitongleiying
  Date: 2022/5/25
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.liuyanjun.model.User" %>
<%@ page import="com.lab2.Login" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
<jsp:useBean id="user" class="com.lab2.Login" scope="request"/>
<%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>
<jsp:setProperty name="user" property="username" value="Liuyanjun-2020211001001325"/>
<jsp:setProperty name="user" property="password" value="123456"/>
<%
    //todo 3: use if check username is admin and password is admin
    if ((user.getUsername()).equals(request.getParameter("username")) && (user.getPassword()).equals(request.getParameter("password"))){
        session.setAttribute("user", user);
%>

<%--todo 4: use jsp:forward to welcome.jsp page--%>
<jsp:forward page="welcome.jsp"/>
<%--todo 5: else part{ --%>
<%
}else {
// todo 6: print username or password error message
    out.println("Username Password Error");
%>
<%--todo 7: use jsp:include login.jsp page --%>
<jsp:include page="login.jsp"/>
<%--todo 8: close else --%>
<%
    }
%>

</body>
</html>