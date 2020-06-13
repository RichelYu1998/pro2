<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 余浩
  Date: 2020/6/13
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<h3>EL用法1:获取常量、表达式、变量的值(变量得先存在域中)</h3>
${"Hello EL"}
Hello EL
${23*34>700?"YES":"NO"}
<hr/>
<%
    String name="Jack";
    request.setAttribute("name1",name);
    request.setAttribute("age1",30);
%>
${name1}
${age1}
<%--
    在EL中书写变量，底层会根据变量的名字，到四个作用域中寻找同名的属性，
    如果可以找到，就会输出这个属性对应的value值，如果找不到，就什么都不输出,也不报错
    在寻找时，会按照如下作用域的顺序去寻找，找到就返回
    pageContext、request、session、application
--%>

<h3>EL用法2:获取作用域中数组或集合中的元素</h3>
<%
//声明一个数组，并将数组存入域中
    String[] names={"孙尚香","黄忠","马可波罗","成吉思汗"};
    request.setAttribute("names",names);
    List list = new ArrayList<>();
    list.add("安琪拉");
    list.add("王昭君");
    list.add("小乔");
    list.add("墨子");
    request.setAttribute("list",list);
%>
${names[0]}
${names[1]}
${names[2]}
${names[3]}
<hr/>
${list[0]}
${list[1]}
${list[2]}
${list[3]}
<h3>EL用法3:获取作用域中map集合中的元素</h3>
<%
//声明一个map集合并将map集合存入域中
    Map map = new HashMap<>();
    map.put("name","尼古拉斯.赵四");
    map.put("age",35);
    map.put("addr","中国");
    request.setAttribute("map1",map);
%>
${map1.name}
${map1.age}
${map1.addr}
<hr/>
<h3>EL用法4:获取作用域中JavaBean对象的属性值</h3>
</body>
</html>
