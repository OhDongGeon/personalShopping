<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/product.css'/>">

<body>
    <div class="category-container">
        <div class="category-title">
            ${categoryProduct.mainCategory.categoryName}
        </div>
        <div class="category-links">
            <c:forEach items="${categoryProduct.subCategoryList}" var="subCategory">
                <a>${subCategory.categoryName}</a>
            </c:forEach>
        </div>
    </div>
    <div class="container">
        <div class="main-content">
            <c:choose>
                <c:when test="${empty productGrid}">
                    <div class="no-products-message">
                        현재 상품이 없습니다.
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="row clear-fix">
                    <c:forEach var="product" items="${productGrid}" varStatus="status">
                        <div class="product">
                            <a href="<c:url value='/products/${product.productId}/categories/${product.categoryId}'/>">
                                <img src="${product.imageUrl}" alt="${product.productId}">
                                <h3>${product.productId}</h3>
                                <p class="price">${product.price}</p>
                            </a>
                        </div>
<%--                        <c:if test="${status.index % 3 == 2}">--%>
<%--                            </div><div class="row clear-fix">--%>
<%--                        </c:if>--%>
                    </c:forEach>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>


    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <!-- 처음 페이지 -->
            <li class="page-item ${pageHandler.page > 1 ? '' : 'disabled'}">
                <a class="page-link" href="<c:url value='/products?main=${param.main}&sub=${param.sub}&page=1'/>" aria-label="First">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <!-- 이전 페이지 -->
            <li class="page-item ${pageHandler.page > 1 ? '' : 'disabled'}">
                <a class="page-link" href="<c:url value='/products?main=${param.main}&sub=${param.sub}&page=${pageHandler.page - 1}'/>" aria-label="Previous">
                    <span aria-hidden="true">&lsaquo;</span>
                </a>
            </li>
            <!-- 페이지 번호들 -->
            <c:forEach begin="${pageHandler.naviBegin}" end="${pageHandler.naviEnd}" var="pageNum">
                <li class="page-item ${pageNum == pageHandler.page ? 'active' : ''}">
                    <a class="page-link" href="<c:url value='/products?main=${param.main}&sub=${param.sub}&page=${pageNum}'/>">${pageNum}</a>
                </li>
            </c:forEach>
            <!-- 다음 페이지 -->
            <li class="page-item ${pageHandler.page < pageHandler.totalPageSize ? '' : 'disabled'}">
                <a class="page-link" href="<c:url value='/products?main=${param.main}&sub=${param.sub}&page=${pageHandler.page + 1}'/>" aria-label="Next">
                    <span aria-hidden="true">&rsaquo;</span>
                </a>
            </li>
            <!-- 마지막 페이지 -->
            <li class="page-item ${pageHandler.page < pageHandler.totalPageSize ? '' : 'disabled'}">
                <a class="page-link" href="<c:url value='/products?main=${param.main}&sub=${param.sub}&page=${pageHandler.totalPageSize}'/>" aria-label="Last">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</body>
