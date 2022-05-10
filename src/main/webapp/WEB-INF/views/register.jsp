<%--
  Created by IntelliJ IDEA.
  User: yitongleiying
  Date: 2022/3/7
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/header.jsp"%>

<div class="Login">
    <form action="${pageContext.request.contextPath}/register" align="center" name="form1" method="post" onsubmit="return on_submit()"><!--within do post() in servlet-->
        <h2>New User Registration!</h2><br>
        <div class="Login_Box">
            <input type="text"  name="Username"id="A" placeholder="Username" >
            <input type="password" name="password" id="B" placeholder="password" >
            <input type="text" name="Email" id="C" placeholder=Email ><br>
            <input type="date" name="Birthdate" placeholder="Birthday" ><br>
        </div>
        <div class="Login_Box2">
            <strong>Gender</strong> <input type="radio" name="gender" value="male">Male
            <input type="radio" name="gender" value="female">Female<br>
        </div>
        <br><br><br>
        <input type="submit" class="Login_Box3" value="register" >
    </form>
</div>
<%@include file="/footer.jsp"%>