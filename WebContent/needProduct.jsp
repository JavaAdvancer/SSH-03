<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>我要物品</title>
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css">
    <link href="css/theme.css" rel="stylesheet" type="text/css">
    <link href="css/needProduct.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="img/icon.png" type="image/x-icon" >
    <script src="js/jquery-2.1.1.js" type="text/javascript"></script>
    <script src="js/jquery-ui.js" type="text/javascript"></script>
    <script src="js/needProduct.js" type="text/javascript"></script>
</head>
<body>
	<div class="background">
        <div class="mainBoard">
            <form>
                标题：<input class="formStyle title" name="title" type="text">
                <br>
                内容：<textarea class="formStyle content" name="content"></textarea>
                <br>
                <input type="button" class="submit" value="发布"/>
                <input type="button" class="reset" value="清空"/>
            </form>
        </div>
        <div class="hint"></div>
    </div>
</body>
</html>