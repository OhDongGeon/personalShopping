<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<header class="header">
    <div>
        <nav>
            <ul>
                <c:forEach items="${list}" var="category">
                    <c:if test="${category.parentCategoryId == null}">
                        <li><a href="">${category.categoryName}</a>
                            <ul class="dropdown">
                                <c:forEach items="${list}" var="subcategory">
                                    <c:if test="${subcategory.parentCategoryId == category.categoryId}">
                                        <li>
                                            <a href="http://localhost:8080/${subcategory.categoryId}">${subcategory.categoryName}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </nav>
    </div>
</header>
</body>
</html>