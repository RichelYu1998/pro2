<%--
  Created by IntelliJ IDEA.
  User: 余浩
  Date: 2020/6/13
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<h3> 1 c:set标签 往域中添加属性</h3>
<c:set var="name" value="真布" scope="request"/>
<%--    往域中添加属性,xxx.setAttrinute("name","真布"); 默认pageContext scope修改域--%>

${ name }

<c:set var="name" value="镜华" scope="request"/>

${ name }


<h3> 1 c:if标签  可以模拟简单的if else分支结构</h3>

<c:set var="score" value="78" scope="request"/>

<c:if test="${ score >= 80 && score <= 100}">优</c:if>
<c:if test="${ score >= 60 && score < 80}">良</c:if>
<c:if test="${ score >= 0 && score < 60}">差</c:if>
<c:if test="${ score < 0 || score > 100}">数据错误</c:if>

<h3> 1 c:forEach标签</h3>
<h5>1 遍历域中数组或集合中的元素</h5>
<%
String[] name={"王海涛","刘培霞","陈子姝","齐磊"};
request.setAttribute("names",name);
%>
<%-- items：指定要遍历的数组或集合，如果数组或集合来自域中，可以使用nel获取
    var:指定一个变量，用于接收数组或集合中的元素
    varstatus:表示的是一个对象,该对象表示循环遍历的状态信息，属性有：
    frist:boolean，如果是第一次则true，反之false
    last:boolean，如果是最后一次则true，反之false
    count:用于统计当前是第几回遍历
    besgin：起始
    end：终止
    step:自增的值(默认是1)
 --%>
<c:forEach items="${names}" var="name" varStatus="vs">
    ${vs.first},${vs.last},${name}<br/>
</c:forEach>
<h5>2 遍历域中的map集合中的元素</h5>
<h5>3 遍历1-100之间所有的整数,将是3的倍数的数值输出</h5>

</body>
<head>
    <title>Title</title>
</head>
</html>