<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/6/6
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%--要使用EL 一定要isELIgnored="false"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>hello</title>
</head>
<br/>
<table border="1">
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>phone</td>
        <td>address</td>
        <td>email</td>
        <td>c_id</td>
    </tr>
    <c:forEach items="${list}" var="a" varStatus="idx">
        <tr>
            <td>${a.id}</td>
            <td>${a.username}</td>
            <td>${a.password}</td>
            <td>${a.phone}</td>
            <td>${a.address}</td>
            <td>${a.email}</td>
            <td>${a.c_id}</td>
        </tr>
    </c:forEach>

</table>
<body>

</body>
</html>
