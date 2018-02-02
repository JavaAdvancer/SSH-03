<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>最新公告</title>
	<link href="css/jquery-ui.css" rel="stylesheet" type="text/css">
    <link href="css/theme.css" rel="stylesheet" type="text/css">
    <link href="css/notice.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="img/icon.png" type="image/x-icon" >
    <script src="js/jquery-2.1.1.js" type="text/javascript"></script>
    <script src="js/jquery-ui.js" type="text/javascript"></script>
    <script src="js/notice.js" type="text/javascript"></script>
</head>
<body>
	<table>
        <caption><h3>高校二手物品交易网站公告栏</h3></caption>
        <thead>
            <tr>
                <th>序号</th>
                <th>标题</th>
            </tr>
        </thead>
        <tbody>
            <%
            	ResultSet resultSet = null;
            	Statement statement = null;
            	Connection connection = null;
            	String url = "jdbc:mysql://localhost:3306/exchange";
            	String username = "root";
            	String password = "root";
            	String sql = "select * from notice";
            	try {
            		Class.forName("com.mysql.jdbc.Driver");
            		connection = DriverManager.getConnection(url, username, password);
            		statement = connection.createStatement();
            		resultSet = statement.executeQuery(sql);
            		while (resultSet.next()) {
            			Integer id = resultSet.getInt(1);
            			String title = resultSet.getString(2);
            			
            			out.print("<tr>");
            			out.print("<td>" + id + "</td>");
            			out.print("<td><a href=" + id + ">" + title + "</a></td>");
            			out.print("</tr>");
            		}
            	} catch (ClassNotFoundException e) {
            		e.printStackTrace();
            	}finally{
            		connection.close();
            	}
            %>
        </tbody>
        <p></p>
    </table>
	
</body>
</html>