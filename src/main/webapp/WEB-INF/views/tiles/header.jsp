<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xl-3 col-lg-2">
                <div class="header__logo">
                    <a href="./index.html"><img src="<c:url value='/resources/image/SmallLogo.png'/>" alt="작은 로고"></a>
                </div>
            </div>
            <div class="col-xl-6 col-lg-7">
                <nav class="header__menu">
                    <ul>
                        <li>
                            <a href="<c:url value='/'/>">홈</a>
                        </li>
                        <c:forEach items="${categoryList}" var="category">
                            <c:if test="${category.parentCategoryId == null}">
                                <li><a href="">${category.categoryName}</a>
                                    <ul class="dropdown">
                                        <c:forEach items="${categoryList}" var="subcategory">
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
            <div class="col-lg-3">
                <div class="header__right">
                    <div class="header__right__auth">
                        <a href="<c:url value='/sign/in'/>">로그인</a>
                        <a href="<c:url value='/sign/in'/>">회원가입</a>
                    </div>
                    <ul class="header__right__widget">
                        <li><span class="icon_search search-switch"></span></li>
                        <li><a href="#"><span class="icon_heart_alt"></span>
                            <div class="tip">0</div>
                        </a></li>
                        <li><a href="#"><span class="icon_bag_alt"></span>
                            <div class="tip">0</div>
                        </a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="canvas__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
</header>
