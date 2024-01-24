<%--
  Created by IntelliJ IDEA.
  User: ODG
  Date: 2024-01-24
  Time: 오후 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- header -->
    <tiles:insertAttribute name="header"/>

    <!-- 계속 바뀌는 내용부 -->
    <tiles:insertAttribute name="body"/>

    <!-- foot -->
    <tiles:insertAttribute name="foot"/>
</body>
</html>
