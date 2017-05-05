<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/test.js"></script>

  </head>
  
  <body>
   <form action="" method="post" name="test" id="test" onsubmit="return check()">
  	<input type="checkbox" name="pre" value="吉泽明步">吉泽明步
  	<input type="checkbox" name="pre" value="苍井空">苍井空
  	<input type="checkbox" name="pre" value="泷泽萝拉">泷泽萝拉
  	<input type="checkbox" name="pre" value="波多野结衣">波多野结衣
  	<input type="checkbox" name="pre" value="啪啪啪">啪啪啪
  	<input type="checkbox" name="pre" value="狠狠撸">狠狠撸
  	<input type="submit" value="提交">
  </body>
</html>
