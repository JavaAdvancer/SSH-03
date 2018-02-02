<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
	<link href="css/jquery-ui.css" rel="stylesheet" type="text/css">
    <link href="css/theme.css" rel="stylesheet" type="text/css">
    <link href="css/personInfo.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="img/icon.png" type="image/x-icon" >
    <script src="js/jquery-2.1.1.js" type="text/javascript"></script>
    <script src="js/jquery-ui.js" type="text/javascript"></script>
    <script src="js/personInfo.js" type="text/javascript"></script>
</head>
<body>
	<div class="infoCenter">
        <div class="captionStyle logo"><img width="100px" height="100px" src="img/icon.png"></div>
        <div class="captionStyle logoText">大学生二手物品交易平台</div>
        <div class="captionStyle separateLine"></div>
        <div class="captionStyle title">个人中心</div>
        <div class="infoContainer">
            <div id="tabs">
                <ul>
                    <li><a href="#tab1">个人资料</a></li>
                    <li><a href="#tab2">修改密码</a></li>
                    <li><a href="#tab3">我发布的商品</a></li>
                    <li><a href="#tab4">我发布的帖子</a></li>
                    <li><a href="#tab5">上传头像</a></li>
                </ul>
                <div id="tab1">
                <img class="picture" src="" width="150px" height="150px">
                    昵称：<input class="tab1InputStyle name" type="text" disabled="disabled">
                    <br>
                    年龄：<input class="tab1InputStyle age" type="number" min="0" max="100" disabled="disabled">
                    <br>
                    性别：<input class="gender" disabled="disabled" value="male" type="radio" name="gender">男
           <input class="gender" disabled="disabled" value="female" type="radio" name="gender">女
                    <br>
                    学校：<input class="tab1InputStyle school" type="text" disabled="disabled">
                    <br>
                    邮箱：<input class="tab1InputStyle email" type="email" disabled="disabled">
                    <br>
                    地址：<input class="tab1InputStyle address" type="text" disabled="disabled">
                    <br>
                    <input class="infoUpdate" type="button" value="提交">
                    <input class="isUpdate" type="button" value="修改">
                    <input class="infoClear" type="button" value="清空">
                    <div class="infohint"></div>
                </div>
                <div id="tab2">
                    原始密码：<input class="originalPass" type="password" placeholder="请输入原始密码"><span class="hint warnning1"></span>
                    <br>
                    修改密码：<input class="newPass" type="password" placeholder="请输入修改密码"><span class="hint warnning2"></span>
                    <br>
                    确认密码：<input class="confirmNewPass" type="password" placeholder="请确认修改密码"><span class="hint warnning3"></span>
                    <br>
                    <input class="passwordUpdate" type="button" value="修改">
                    <input class="passwordUpdate"type="button" value="清空">
                    <div class="hintDialog"></div>
                </div>
                <div id="tab3">
					<table border="1px solid gray">
                        <tr>
                            <th width="50px">名称</th>
                            <th width="50px">标题</th>
                            <th width="400px">详细内容</th>
                            <th>购买时间</th>
                            <th>购买价格</th>
                            <th>种类</th>
                            <th>删除</th>
                            <th>编辑</th>
                        </tr>
                    </table>
				</div>
                <div id="tab4">
					<table border="1px solid gray">
                        <tr>
                            <th width="100px">标题</th>
                            <th width="620px">内容</th>
                            <th>删除</th>
                            <th>编辑</th>
                        </tr>
                    </table>
                    <div class="postEditDialog" style="display:none">
                    	标题：<input class="postTitle" type="text">
                    	<br>
                    	内容：<input class="postContent" type="text">
                    </div>
				</div>
                <div id="tab5">
                    <form action="updateUserPicAction" method="post" enctype="multipart/form-data">
                        <input class="pic" type="file" name="picture">
                        <br>
                        <input class="picSubmit" type="submit" value="上传">
                    </form>
                    <div class="tab5Hint"></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>