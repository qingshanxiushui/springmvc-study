<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName()
    +":"+request.getServerPort()+request.getContextPath()+"/";

    //http://localhost:8080/ch07_path/
%>
<html>
<head>
    <title></title>
    <base href="<%=basePath%>">
</head>
<body>
    <p>测试路径</p>
    <!-- a href="${pageContext.request.contextPath}/test/some.do">发起请求test/some.do</a -->
    <!--a href="test/some.do">发起请求test/some.do</a-->

    <p>有/开头的地址</p>
    <a href="${pageContext.request.contextPath}/test/some.do">/test/some.do</a>

    <br/>
    <a href="http://www.baidu.com">有协议开头的地址</a>
</body>
</html>
