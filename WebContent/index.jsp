<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大学生二手交易平台</title>
	<link href="css/jquery-ui.css" rel="stylesheet" type="text/css">
    <link href="css/theme.css" rel="stylesheet" type="text/css">
    <link href="css/index.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="img/icon.png" type="image/x-icon" >
    <script src="js/jquery-2.1.1.js" type="text/javascript"></script>
    <script src="js/jquery-ui.js" type="text/javascript"></script>
    <script src="js/index.js" type="text/javascript"></script>
</head>
<body>
	<div class="topBar">
        <div class="topBarText welcome">欢迎进入二手交易平台！</div>
        <%
        	if(session.getAttribute("userEmail")==null){
        		out.print("<div class=\"topBarText topBarTextHover login\">登录</div>");
        	}else{
        		out.print("<div class=\"topBarText2 topBarTextHover2 login2\">"+ session.getAttribute("userEmail").toString()+"</div>");
        	}
        %>
        <div class="topBarText topBarTextHover register">注册</div>
        <div class="topBarText topBarTextHover logout">注销退出</div>
    </div>
    <div class="loginDialog">
        用户名:<input class="loginEmail" type="text" placeholder="请输入你的邮箱账号">
        <br>
        密码:<input class="loginPassword" type="password" placeholder="请输入你的密码">
    </div>
    <div class="hint"></div>
    <div class="registerDialog">
        邮箱:<input class="email" type="text" placeholder="请输入你的邮箱账号">
        <span>
            <img style="display:none" class="email-true-icon" width="20" height="20" src="img/true-check.png">
            <img style="display:none" class="email-error-icon" width="20" height="20" src="img/error-check.png">
        </span>
        <br>
        输入密码:<input class="password" type="password" placeholder="请输入你的密码">
        <br>
        确认密码:<input class="repassword" type="password" placeholder="请确认你的密码">
        <span>
            <img style="display:none" class="password-true-icon" width="20" height="20" src="img/true-check.png">
            <img style="display:none" class="password-error-icon" width="20" height="20" src="img/error-check.png">
        </span>
    </div>
    <div class="logoutDialog"></div>
    <div class="searchBar">
        <div class="searchBarPosition logo"><img src="img/icon.png" width="100px" height="100px"></div>
        <div class="searchBarPosition logoText">大学生二手交易平台</div>
        <div class="searchBarPosition searchInput"><input id="keyWord" type="text" name="keyWord"></div>
        <div class="searchBarPosition searchButton"><input id="search" type="button" value="搜索"></div>
    </div>
    <ul class="topMenu">
        <div class="menuTitle">
            全部商品分类
        </div>
        <li><a class="category">书籍资料</a>
            <span></span><div class="leftMenu"></div>
        </li>
        <li><a class="category">健身器材</a>
            <span></span><div class="leftMenu"></div>
        </li>
        <li><a class="category">洗化用品</a>
            <span></span><div class="leftMenu"></div>
        </li>
        <li><a class="category">电子数码</a>
            <span></span><div class="leftMenu"></div>
        </li>
        <li><a class="category">电脑配件</a>
            <span></span><div class="leftMenu"></div>
        </li>
        <li><a class="category">服装服饰</a>
            <span></span><div class="leftMenu"></div>
        </li>
        <li><a class="category">裤装鞋类</a>
            <span></span><div class="leftMenu"></div>
        </li>
    </ul>
    <div class="barMenu">
        <ul>
            <li><a class="index">首页</a></li>
            <li><a class="notice">最新公告</a></li>
            <li><a class="personalCenter">个人中心</a></li>
            <li><a class="sell">我有物品</a></li>
            <li><a class="need">我要物品</a></li>
        </ul>
    </div>
    <div class="container">
        <ul>
            <li><a href="forum.jsp"><img src="img/1.png"></a></li>
            <li><a href="products.jsp"><img src="img/2.png"></a></li>
            <li><a href="#"><img src="img/3.png"></a></li>
            <li><a href="#"><img src="img/4.png"></a></li>
        </ul>
    </div>
    <div id="accordion">
        <h3><a href="#">书籍资料</a></h3>
        <div></div>
        <h3><a href="#">健身器材</a></h3>
        <div></div>
        <h3><a href="#">洗化用品</a></h3>
        <div></div>
        <h3><a href="#">电子数码</a></h3>
        <div></div>
        <h3><a href="#">电脑配件</a></h3>
        <div></div>
        <h3><a href="#">上衣外套</a></h3>
        <div></div>
        <h3><a href="#">裤装鞋类</a></h3>
        <div></div>
    </div>
</body>
</html>