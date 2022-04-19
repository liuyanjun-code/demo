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
 <%
//read cookies
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeVale="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVale=c.getValue();
            }
        }
    }
 %>
<form action="/login" method="post">
    Username:<input type="text" name="username" value="<%=username%>"><br/>
    Password:<input type="password" name="password" value="<%=password%>"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVale.equals("1") ?"checked":""%> />Remember  Me<br/>
    <input type="submit"  value="Login">
</form>
<%@include file="footer.jsp"%>
