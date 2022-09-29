<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show</title>
</head>
<body>
    /other.jsp ,显示requset作用域中的数据 <br/>
    <h3>myname数据： ${param.myname}</h3>
    <h3>myage数据： ${param.myage}</h3>
    <h3>获取get请求中的参数：<%=request.getParameter("myname")%></h3>
</body>
</html>
