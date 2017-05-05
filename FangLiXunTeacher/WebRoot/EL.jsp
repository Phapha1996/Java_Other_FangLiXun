<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'EL.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	<%--EL表达式String类型 --%>
   	
   	<%
   	String data = "abcd";
   	request.setAttribute("data", data);
   	 %>
 
   	${data }
   	
   	<%--EL表达式对象类型 --%>
   	
   	<%
   	Person p = new Person();
   	p.setName("fage");
   	request.setAttribute("person",p );
   	 %>
   	 
   	 ${person.name }
   	 
   	 <%-- --%>
   	 <%
   	 Person p1 = new Person();
   	 Address a = new Address("柳州");
   	 p1.setaddress(a);
   	 request.setAttribute("p1",p1);
   	  %>
   	  
   	  ${p1.address.city }
   	</body>
</html>
