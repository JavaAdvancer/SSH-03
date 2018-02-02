<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>我有物品出手</title>
    <link href="css/jquery-ui.css" rel="stylesheet" type="text/css">
    <link href="css/theme.css" rel="stylesheet" type="text/css">
    <link href="css/sellProduct.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="img/icon.png" type="image/x-icon" >
    <script src="js/jquery-2.1.1.js" type="text/javascript"></script>
    <script src="js/jquery-ui.js" type="text/javascript"></script>
    <script src="js/sellProduct.js" type="text/javascript"></script>
</head>
<body>
	<div class="background">
        <div class="mainBoard">
            <form action="uploadProductInfoAction" method="post" enctype="multipart/form-data">
                名称：<input class="formStyle name" type="text" name="name">
                <br/>
                标题：<input class="formStyle title" type="text" name="title">
                <br/>
                详细信息：<textarea class="formStyle detail" name="detail" ></textarea>
                <br/>
                购买时间：<input class="formStyle budgetTime" type="date" name="budgetTime">
                <br/>
                购买价格：<input class="formStyle price" type="text" name="budgetprice">
                <br/>
                物品分类：
                <select name="category" class="formStyle category">
                    <option name="book" value="book">书籍资料</option>
                    <option name="gym" value="gym">健身器材</option>
                    <option name="shampoo" value="shampoo">洗化用品</option>
                    <option name="digital" value="digital">电子数码</option>
                    <option name="computer" value="computer">电脑配件</option>
                    <option name="clothes" value="clothes">上衣外套</option>
                    <option name="trousers" value="trousers">裤装鞋类</option>
                </select>
                <br/>
                图片：<input class="formStyle picture" type="file" name="picture">
                <br/>
                <input class="formStyle submit" type="submit" name="submit" value="提交">
                <input class="formStyle reset" type="reset" name="reset" value="清空">
            </form>
    </div>
</body>
</html>