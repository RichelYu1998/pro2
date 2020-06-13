<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 余浩
  Date: 2020/6/12
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一个Jsp页面</title>
</head>
<body>
<%-- JSP表达式符号(可以写java代码，但是不可以写分号结束的语句) --%>
<%= new Date() %>
<%=100 + 123 %>
<%="helo"%>
<hr/>
<%-- 2.jsp脚本片段(可以书写在java中) --%>
<%
    for (int i = 0; i < 5; i++) {
        System.out.println("hello jsp");
    }
%>
<%
    for (int i = 0; i < 5; i++) {%>
    Hello Jsp<br/>
<%}%>
<%-- 3.Jsp注释 --%>
</body>
</html>
