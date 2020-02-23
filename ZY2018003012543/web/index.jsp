<%--
  Created by IntelliJ IDEA.
  User: Zeen
  Date: 2019/12/17/0017
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IMBM - 登录页面</title>
    <link rel="shortcut icon" href="images/favicon.png">
    <style type="text/css">
        #id{
            width:40%;
            height:40px;
            font-size:20px;
            margin-top:10px;
            margin-bottom:10px;
            margin-left:30%;
            line-height:50px;
            border-radius:8px;
            border:2px solid rgb(139,137,137);
            outline:none;
        }
        #pwd{
            width:40%;
            height:40px;
            font-size:20px;
            margin-top:10px;
            margin-bottom:10px;
            margin-left:30%;
            line-height:50px;
            border-radius:8px;
            border:2px solid rgb(139,137,137);
            outline:none;
        }
        #btn {
            float:right;
            height:30px;
            margin-right:30%;
            border-radius:6px;
            outline:none;
            font-size:20px;
            padding:0 20px;
            background:#ab1f2a;
            color: white;
            font-family: 宋体;
        }
    </style>
</head>
<body>
    <%
        if (request.getAttribute("flag")!=null){
    %>
    <script>alert("用户名或密码错误")</script>
    <%
        }
    %>
    <div style="text-align: center;font-size: 30px;">
        <p style="font-family: 微软雅黑">IMBM - <span style="font-family: 楷体">少慢差贵 爱买不买</span></p>
    </div>
    <form action="user" method="post">
        <input type="hidden" name="oper" value="login">
        <input type="text" id="id" placeholder="账号：zeen" value="" name="user"><br/>
        <input type="password" id="pwd" placeholder="密码：001128" value="" name="pwd"><br/>
        <input type="submit" id="btn" value="登录">
    </form>
</body>
</html>
