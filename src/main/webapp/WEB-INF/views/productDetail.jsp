<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>
<section class="product-details spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="product__details__pic">
                    <div class="product__details__pic__left product__thumb nice-scroll" tabindex="1" style="overflow-y: hidden; outline: none;">
                        <c:forEach items="${productDetail.productImages}" var="productImage" varStatus="status">
                            <a class="pt ${status.index == 0 ? 'active' : ''}" href="#product-${status.index + 1}">
                                <img src="${productImage.imageUrl}" alt="Product image ${status.index + 1}">
                            </a>
                        </c:forEach>
                    </div>
                    <div class="product__details__slider__content">
                        <div class="product__details__pic__slider owl-carousel owl-loaded">
                            <div class="owl-stage-outer">
                                <div class="owl-stage" style="transform: translate3d(0px, 0px, 0px); transition: all 0s ease 0s; width: 1652px;">
                                    <c:forEach items="${productDetail.productImages}" var="productImage" varStatus="status">
                                        <div class="owl-item ${status.first ? 'active' : ''}" style="width: 412.896px;">
                                            <img data-hash="product-${status.index + 1}" class="product__big__img" src="${productImage.imageUrl}" alt="">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>

                            <div class="owl-nav">
                                <button type="button" role="presentation" class="owl-prev disabled">
                                    <i class="arrow_carrot-left"></i>
                                </button>
                                <button type="button" role="presentation" class="owl-next">
                                    <i class="arrow_carrot-right"></i>
                                </button>
                            </div>
                            <div class="owl-dots disabled"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="product__details__text">
                    <h3>${productDetail.product.productName}</h3>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <span>( 138 reviews )</span>
                    </div>
                    <div class="product__details__price">${productDetail.product.price} 원<%--<span>$ 83.0</span>--%></div>

                    <div class="product__details__button">
                        <div class="quantity">
                            <span>Quantity:</span>
                            <div class="pro-qty"><span class="dec qtybtn">-</span>
                                <input type="text" value="1">
                                <span class="inc qtybtn">+</span></div>
                        </div>
                        <a href="#" class="cart-btn"><span class="icon_bag_alt"></span> Add to cart</a>
                        <ul>
                            <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                            <li><a href="#"><span class="icon_adjust-horiz"></span></a></li>
                        </ul>
                    </div>
                    <div class="product__details__widget">
                        <ul>
                            <li>
                                <span>color:</span>
                                <div class="color__checkbox">
                                    <c:forEach items="${productDetail.productColors}" var="productColor" varStatus="status">
                                        <label for="${productColor.optionColor}">
                                            <input type="radio" name="color__radio" id="${productColor.optionColor}" ${status.first ? 'checked' : ''}>
                                            <span class="checkmark" style="background-color: ${productColor.rgbValue};"></span>
                                        </label>
                                    </c:forEach>
                                </div>
                            </li>
                            <li>
                                <span>size:</span>
                                <div class="size__btn">
                                    <c:forEach items="${productDetail.productSizes}" var="productSize">


                                    </c:forEach>

                                    <c:forEach items="${productDetail.productSizes}" var="productSize" varStatus="status">
                                        <label for="${productSize.optionSize}-btn" class="${status.first ? 'active' : ''}">
                                            <input type="radio" id="${productSize.optionSize}-btn" name="size__radio" ${status.first ? 'checked' : ''}>
                                                ${productSize.optionSize}
                                        </label>
                                    </c:forEach>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="product__details__tab">
                    <ul class="nav nav-tabs" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">상품 설명</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab">상품 후기 ( 2 )</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="tabs-1" role="tabpanel">
                            <c:forEach items="${productDetail.productDescriptions}" var="productDescription">
                                <c:choose>
                                    <c:when test="${productDescription.contentsType == 'text'}">
                                        <p>${productDescription.contentsValue}</p>
                                    </c:when>
                                    <c:when test="${productDescription.contentsType == 'image'}">
                                        <img src="${productDescription.contentsValue}" alt="Product Image" style="max-width:100%;height:auto;"/>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </div>
                        <div class="tab-pane" id="tabs-3" role="tabpanel">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
