<%--
  Created by IntelliJ IDEA.
  User: Zeen
  Date: 2019/12/17/0017
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="sdu.zeen.pojo.*" language="java" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>IMBM - 少慢差贵 爱买不买</title>
    <link rel="shortcut icon" href="images/favicon.png">
    <link rel="stylesheet" href="css/main.css" type="text/css">
</head>
<body>
<span>你好，<%=((User) session.getAttribute("user")).getUser()%></span>
<form action="user" method="post">
    <input type="hidden" name="oper" value="logout">
    <input type="submit" value="退出">
    <input type="button" id="cartButton" value="查看购物车" onclick="showCart()">
    <a href="user?oper=order" >查看订单</a>
    <input type="button" value="下单" onclick="addOrder()">
</form>
<script>
    function showCart() {
        var status = document.getElementById("cartButton").value;
        if ("查看购物车" == status) {
            document.getElementById("cartButton").value = "关闭购物车";
            var ajax = new XMLHttpRequest();
            ajax.onreadystatechange = function () {
                if (ajax.readyState == 4) {
                    var result = ajax.responseText;
                    eval("var cart=" + result);
                    var total = <%=((ArrayList<Product>)application.getAttribute("products")).get(0).getPrice()%>*cart.num1 + <%=((ArrayList<Product>)application.getAttribute("products")).get(1).getPrice()%>*cart.num2 + <%=((ArrayList<Product>)application.getAttribute("products")).get(2).getPrice()%>*cart.num3 + <%=((ArrayList<Product>)application.getAttribute("products")).get(3).getPrice()%>*cart.num4;
                    document.getElementById("cart").innerHTML = "<i>购物车</i><br/><span>总金额:"+total+"</span><br/>";
                    if (cart.num1!=0){
                        var li1 = document.createElement("li");
                        li1.innerHTML = "<b>商品：</b>景天 Ganten 饮用 纯净水 560ml*24瓶/箱 纯净 生活<br/><b>数量：</b>" + cart.num1+"<br/><input type='button' value='删除' onclick='deleteProduct(<%=((ArrayList<Product>)application.getAttribute("products")).get(0).getID()%>)'>";
                        document.getElementById("cart").appendChild(li1);
                    }

                    if (cart.num2!=0){
                        var li2 = document.createElement("li");
                        li2.innerHTML = "<b>商品：</b>包邮 吉米多维奇 概率论与数理统计习题精选精解<br/><b>数量：</b>" + cart.num2+"<br/><input type='button' value='删除' onclick='deleteProduct(<%=((ArrayList<Product>)application.getAttribute("products")).get(1).getID()%>)'>";
                        document.getElementById("cart").appendChild(li2);
                    }

                    if (cart.num3!=0){
                        var li3 = document.createElement("li");
                        li3.innerHTML = "<b>商品：</b>old spice 欧仕派男士沐浴露持久留香全身沐浴乳液 宝洁官方<br/><b>数量：</b>" + cart.num3+"<br/><input type='button' value='删除' onclick='deleteProduct(<%=((ArrayList<Product>)application.getAttribute("products")).get(2).getID()%>)'>";
                        document.getElementById("cart").appendChild(li3);
                    }

                    if (cart.num4!=0){
                        var li4 = document.createElement("li");
                        li4.innerHTML = "<b>商品：</b>2018新款Apple/苹果 iPad Pro 11英寸 全面屏平板电脑三代<br/><b>数量：</b>" + cart.num4+"<br/><input type='button' value='删除' onclick='deleteProduct(<%=((ArrayList<Product>)application.getAttribute("products")).get(3).getID()%>)'>";
                        document.getElementById("cart").appendChild(li4);
                    }
                }
            }
            ajax.open("post", "/ZY2018003012543/user");
            ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            ajax.send("oper=cart&type=check");
        } else {
            document.getElementById("cartButton").value = "查看购物车";
            document.getElementById("cart").innerHTML = "";
        }
    }

    function addProduct(productID) {

            var status = document.getElementById("cartButton").value;
            var ajax = new XMLHttpRequest();
            ajax.onreadystatechange = function () {
                if (ajax.readyState == 4) {
                    if (ajax.status == 200) {
                        if (status == "关闭购物车") {
                            showCart();
                            showCart();
                        }
                        alert("添加成功");
                    }
                }
            }
            ajax.open("post", "/ZY2018003012543/user");
            ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            ajax.send("oper=cart&type=add&ID=" + productID);

    }

    function deleteProduct(productID) {
        var ajax = new XMLHttpRequest();
        ajax.onreadystatechange = function () {
            if (ajax.readyState == 4) {
                if (ajax.status==200){
                    showCart();
                    showCart();
                    alert("删除成功");
                }
            }
        }
        ajax.open("post", "/ZY2018003012543/user");
        ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        ajax.send("oper=cart&type=delete&ID="+productID);
    }

    function addOrder() {
            var ajax = new XMLHttpRequest();
            ajax.onreadystatechange = function () {
                if (ajax.readyState == 4) {
                    if (ajax.status == 200) {
                        alert("下单成功");
                        showCart();
                        showCart();
                    }
                }
            }
            ajax.open("post", "/ZY2018003012543/user");
            ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            ajax.send("oper=addorder");

    }
</script>
<br/>
<ul>
    <li class="selected">
        <span><img height="200px"
                   src="images/<%=((ArrayList<Product>)application.getAttribute("products")).get(0).getPic()%>"/></span>
        <h4><a href="#"><%=((ArrayList<Product>) application.getAttribute("products")).get(0).getName()%>
        </a></h4>
        <p>￥<%=((ArrayList<Product>) application.getAttribute("products")).get(0).getPrice()%>
        </p>
        <form><input type="button" value="加入购物车"
                     onclick="addProduct(<%=((ArrayList<Product>)application.getAttribute("products")).get(0).getID()%>)">
        </form>
    </li>

    <li>
        <span><img height="200px"
                   src="images/<%=((ArrayList<Product>)application.getAttribute("products")).get(1).getPic()%>"/></span>
        <h4><a href="#"><%=((ArrayList<Product>) application.getAttribute("products")).get(1).getName()%>
        </a></h4>
        <p>￥<%=((ArrayList<Product>) application.getAttribute("products")).get(1).getPrice()%>
        </p>
        <form><input type="button" value="加入购物车"
                     onclick="addProduct(<%=((ArrayList<Product>)application.getAttribute("products")).get(1).getID()%>)">
        </form>
    </li>

    <li>
        <span><img height="200px"
                   src="images/<%=((ArrayList<Product>)application.getAttribute("products")).get(2).getPic()%>"/></span>
        <h4><a href="#"><%=((ArrayList<Product>) application.getAttribute("products")).get(2).getName()%>
        </a></h4>
        <p>￥<%=((ArrayList<Product>) application.getAttribute("products")).get(2).getPrice()%>
        </p>
        <form><input type="button" value="加入购物车"
                     onclick="addProduct(<%=((ArrayList<Product>)application.getAttribute("products")).get(2).getID()%>)">
        </form>
    </li>

    <li>
        <span><img height="200px"
                   src="images/<%=((ArrayList<Product>)application.getAttribute("products")).get(3).getPic()%>"/></span>
        <h4><a href="#"><%=((ArrayList<Product>) application.getAttribute("products")).get(3).getName()%>
        </a></h4>
        <p>￥<%=((ArrayList<Product>) application.getAttribute("products")).get(3).getPrice()%>
        </p>
        <form><input type="button" value="加入购物车"
                     onclick="addProduct(<%=((ArrayList<Product>)application.getAttribute("products")).get(3).getID()%>)">
        </form>
    </li>
</ul>
<div id="cart">
</div>
</body>
</html>
