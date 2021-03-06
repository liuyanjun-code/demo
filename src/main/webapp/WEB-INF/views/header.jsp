<% Object basePath = null; %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | E-Shopper</title>
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/prettyPhoto.css" rel="stylesheet">
    <link href="<%=basePath%>css/price-range.css" rel="stylesheet">
    <link href="<%=basePath%>css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>css/main.css" rel="stylesheet">
    <link href="<%=basePath%>css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="<%=basePath%>js/html5shiv.js"></script>
    <script src="<%=basePath%>js/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="<%=basePath%>images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=basePath%>images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=basePath%>images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=basePath%>images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>images/ico/apple-touch-icon-57-precomposed.png">
    <title>My Online Shop</title>
    <script language="JavaScript">
        function on_submit()
        {
            let username=document.getElementById("A").value;
            if (username==null||username===''){
                alert("username can not be null!")
                return false;
            }
            let password=document.getElementById("B").value;
            if (password==null||password===''){
                alert("password can not be null!")
                return false;
            }
            if (password.length<8){
                alert("lengh must be at least 8 characters!");
                return false;
            }
            let Email=document.getElementById("C").value;
            const reg=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
            if (!reg.test(Email)){
                alert("invalid Email")
                return false;
            }
        }
    </script>
    <style type="text/css">


        .Login{
            background:#ccffff;
            /*???????????? ??????????????????????????????*/
            display: flex;
            /*???????????????????????????  ??????????????????????????????????????????
            ???????????????????????????  ??????????????????????????????????????????*/
            flex-direction: column;
            /*?????????????????????????????????????????????  ??????????????????????????????
            ???????????????????????????????????? ???????????????????????????*/
            align-items: center;
            width: 350px;
            heigth:100px;
            padding: 40px;
            position:absolute;
            left:35%;
            top:200px;
        }

        .Login h2{
            color: #fff;
            margin-bottom: 30px;
        }
        .Login .Login_Box {
            /*????????????*/
            position: relative;
            width: 100%;
        }
        .Login .Login_Box input{
            /*??????input???????????????????????????*/
            outline: none;
            border: none;
            width: 50%;
            padding: 2px 0;
            margin-bottom: 30px;

            font-size: 16px;
            border-bottom: 1px solid #fff;
            /*????????????????????????*/
            background-color: transparent;
        }

        .Login .Login_Box input:focus,
        .Login .Login_Box input:valid{
            top: -20px;
            color: #9999ff;
            font-size: 12px;
        }

        .Login .Login_Box3{
            outline: none;
            border: none;
            position: relative;
            padding: 10px 30px;
            background: transparent;
            color:#cc99ff;
        }



    </style>
</head>
<body style="margin:0px;padding:0px;font-family:helvetica;">
<table width="100%" cellpadding="0" cellspacing="0" class="table">
    <tr>
        <td height="78" style="background-color:#788dad;
                            border-width:2px;
                            border-style:solid;
                            border-color:black;
                            padding:0px;
                            margin:0px;" valign="bottom">

            <img src="logo.jpg" align="left">
        </td>
    </tr>
    <tr>
        <td height="15" style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black;" align="center">
            <a style="color:white;" href="home">Home</a><!--request come to controller-homeservlet-->
            - <a style="color:white;" href="login">Login</a><!--request come to controller-loginservlet-->
            - <a style="color:white;" href="productList">Product</a>
            - <a style="color:white;" href="#">FAQ</a>
            - <a style="color:white;" href="#">About</a>

        </td>
    </tr>
    <tr height="25"><td align="right"><font size="18" color="blue">
        Welcome,
        <%
            User user=(User) session.getAttribute("user");
            if(user!=null){
                out.println(user.getUsername())
            }else{
        %>
        <%}//end of else%>
        <font size="18" color="red"> Guest</font>
    </font></td> </tr>
    <tr height="20"><td align="right">
        <br> <a href="#">Logout</a>
        <%if(session.getAttribute("user")!=null){%>
        <br> <a href="logout">logout</a>
        <%}//end of if%>
        <br><a href="#">My Cart</a><br/>
        <a href="register.jsp">Register Here</a>
    </td></tr>
</table>