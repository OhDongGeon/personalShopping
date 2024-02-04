<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>
    <%--@elvariable id="signUp" type="java"--%>
    <form:form modelAttribute="signUp" action="/sign/up" method="post">
        <div class="signUp_group">
            <form:input path="email" id="email" placeholder="이메일" onblur="checkEmailDuplication()"/><br>
            <form:input path="password" id="password" type="password" placeholder="비밀번호" onblur="checkPasswordForm()"/><br>
        </div>

        <div class="signUp_error_message">
            <span id="emailError" class="error"><form:errors path="email" cssClass="text-danger"/></span><br>
            <span id="passwordError" class="error"><form:errors path="password" cssClass="text-danger"/></span>
        </div>
        <div>
            <form:input path="name" id="name" placeholder="이름" onblur="checkNameEmpty()"/><br>
            <form:input path="phoneNumber" id="phoneNumber" placeholder="핸드폰번호" onblur="checkPhoneNumberForm()"/><br>
        </div>
        <div class="signUp_error_message">
            <span id="nameError" class="error"><form:errors path="name" cssClass="text-danger"/></span><br>
            <span id="phoneNumberError" class="error"><form:errors path="phoneNumber" cssClass="text-danger"/></span>
        </div>

        <input type="submit" value="가입하기"/>
    </form:form>

    <script src="<c:url value='/resources/js/signUp.js'/>"></script>
</body>
