
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>全部商品</title>
 <link href="css/jquery-ui.css" rel="stylesheet" type="text/css">
    <link href="css/theme.css" rel="stylesheet" type="text/css">
    <link href="css/products.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="img/icon.png" type="image/x-icon" >
    <script src="js/jquery-2.1.1.js" type="text/javascript"></script>
    <script src="js/jquery-ui.js" type="text/javascript"></script>
    <script src="js/products.js" type="text/javascript"></script>
</head>
<body>
	 <div class="background">
        
    </div>
    <div class="sellerInfoDia">
	            昵称：<input disabled class="tab1InputStyle sellerName" type="text">
	            <br>
	            年龄：<input disabled class="tab1InputStyle age" type="number" min="1" max="100">
	            <br>
	            <br>
	            性别：<select disabled>
	                <option value="male">男</option>
	                <option value="female">女</option>
	        </select>
	            <br>
	            学校：<input disabled class="tab1InputStyle school" type="text">
	            <br>
	            邮箱：<input disabled class="tab1InputStyle email" type="text">
    </div>
    <div class="productInfoDia">
    	    名称：<b class="formStyle productName"></b>
                <br/>
	                标题：<b  class="formStyle title"></b>
	            <br/>
	                详细信息：<b  class="formStyle detail"></b>
	            <br/>
	                购买时间：<b  class="formStyle budgetTime"></b>
	            <br/>
	                购买价格：<b  class="formStyle price"></b>
    </div>
</body>
</html>