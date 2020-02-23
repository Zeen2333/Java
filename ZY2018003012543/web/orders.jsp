<%@ page import="sdu.zeen.pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="sdu.zeen.pojo.Order" %>
<%@ page import="sdu.zeen.pojo.Product" %><%--
  Created by IntelliJ IDEA.
  User: Zeen
  Date: 2019/12/28/0028
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IMBM - 订单查看</title>
    <link rel="shortcut icon" href="images/favicon.png">
</head>
<body>
<span>你好，<%=((User) session.getAttribute("user")).getUser()%></span><a href="main.jsp">返回首页</a>
<%
    ArrayList<Order> ao=(ArrayList<Order>)session.getAttribute("orders");
    for (int i=0;i<ao.size();i++){
%>
<p style="color: blue">订单：<%=ao.get(i).getDate()%></p>
<%
    if (ao.get(i).getNum1()!=0){
%>
<p><%=((ArrayList<Product>) application.getAttribute("products")).get(0).getName()%> 数量：<%=ao.get(i).getNum1()%></p>
<%
    }
    if (ao.get(i).getNum2()!=0){
%>
<p><%=((ArrayList<Product>) application.getAttribute("products")).get(1).getName()%> 数量：<%=ao.get(i).getNum2()%></p>
<%
    }
    if (ao.get(i).getNum3()!=0){
%>
<p><%=((ArrayList<Product>) application.getAttribute("products")).get(2).getName()%> 数量：<%=ao.get(i).getNum3()%></p>
<%
    }
    if (ao.get(i).getNum4()!=0){
%>
<p><%=((ArrayList<Product>) application.getAttribute("products")).get(3).getName()%> 数量：<%=ao.get(i).getNum4()%></p>
<%
    }
    }
%>
</body>
</html>
