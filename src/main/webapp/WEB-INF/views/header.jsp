<html>
<head>
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
            /*弹性布局 让子元素称为弹性项目*/
            display: flex;
            /*让弹性项目垂直排列  原理是改变弹性盒子的主轴方向
            父元素就是弹性盒子  现在改变后的主轴方向是向下了*/
            flex-direction: column;
            /*让弹性项目在交叉轴方向水平居中  现在主轴的方向是向下
            交叉轴的方向是与主轴垂直 交叉轴的方向是向右*/
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
            /*相对定位*/
            position: relative;
            width: 100%;
        }
        .Login .Login_Box input{
            /*清除input框自带的边框和轮廓*/
            outline: none;
            border: none;
            width: 50%;
            padding: 2px 0;
            margin-bottom: 30px;

            font-size: 16px;
            border-bottom: 1px solid #fff;
            /*背景颜色为透明色*/
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
        Welcome,<font size="18" color="red"> Guest</font>
    </font></td> </tr>
    <tr height="20"><td align="right">
        <br> <a href="#">Logout</a>
        <br><a href="#">My Cart</a><br/>
        <a href="register.jsp">Register Here</a>
    </td></tr>
</table>