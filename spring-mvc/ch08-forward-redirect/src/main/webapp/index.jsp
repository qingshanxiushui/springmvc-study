<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求方式</title>
</head>
<body>
    <a href="doForward.do">发起doForward.do</a>
    <br/>
    <br/>
    <p>重定向redirect</p>
    <form action="doRedirect.do" method="post">
        姓名<input type="text" name="name"><br/>
        年龄<input type="text" name="age"><br/>
        操作<input type="submit" value="提交"><br/>

    </form>

</body>
</html>
