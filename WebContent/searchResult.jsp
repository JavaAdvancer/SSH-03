<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索结果</title>
	<link href="css/jquery-ui.css" rel="stylesheet" type="text/css">
    <link href="css/theme.css" rel="stylesheet" type="text/css">
    <link href="css/searchResult.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="img/icon.png" type="image/x-icon" >
    <script src="js/jquery-2.1.1.js" type="text/javascript"></script>
    <script src="js/jquery-ui.js" type="text/javascript"></script>
    <script src="js/searchResult.js" type="text/javascript"></script>
</head>
<body>
	<%
	String keyWord = request.getParameter("keyWord");
	String category = request.getParameter("category");
	ResultSet resultSet = null;
	Statement statement = null;
	Connection connection = null;
	String url = "jdbc:mysql://localhost:3306/exchange";
	String username = "root";
	String password = "root";
	String sql = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url, username, password);
		statement = connection.createStatement();
		if(keyWord!=null){
			sql = "select * from product p where p.title like '%"+keyWord+"%'";
		}else{
			sql = "select * from product p where p.category like '%"+category+"%'";
		}
		resultSet = statement.executeQuery(sql);
		if(resultSet==null){
			out.print("查询无记录！！！");
		}
		while (resultSet.next()) {
			Integer id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String title = resultSet.getString(3);
			String detail = resultSet.getString(4);
			String budgetTime = resultSet.getString(5);
			String budgetPrice = resultSet.getString(6);
			String picture = resultSet.getString(8);
			Integer uId = resultSet.getInt(9);
			String pictureUrl = "upload/images/"+picture.substring(picture.lastIndexOf("\\")+1);
			out.print("<div class='product'>");
			out.print("<img src="+pictureUrl+" width='200px' height='200px'>");
			out.print("<p><b class='title'>"+title+"</b></p>");
			out.print("<p><b class='detail'>"+detail+"</b></p>");
			out.print("<p>购买时间：<b class='budgetTime'>"+budgetTime+"</b></p>");
			out.print("<p>购买价格：<b class='budgetPrice'>"+budgetPrice+"</b></p>");
			out.print("<a href="+uId+" class='sellerInfo'>卖家信息</a>");
			out.print("</div>");   
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}finally{
		connection.close();
	}
	%>
	<div class="sellerInfoDia">
        <p>昵称：<strong class="sellerName"></strong></p>
        <p>性别：<strong class="gender"></strong></p>
        <p>年纪：<strong class="age"></strong></p>
        <p>学校：<strong class="schoolName"></strong></p>
        <p>邮箱：<strong class="emailName"></strong></p>
    </div>
</body>
</html>