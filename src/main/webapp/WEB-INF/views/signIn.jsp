<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>
    <%--@elvariable id="signIn" type="java"--%>
    <form:form modelAttribute="signIn" action="/sign/in" method="post">
        <div>
            <form:input path="email" id="email" placeholder="이메일" onblur="checkEmailEmpty()"/><br>
            <span id="emailError" class="error"><form:errors path="email" cssClass="text-danger"/></span><br>
        </div>
        <div>
            <form:input path="password" id="password" type="password" placeholder="비밀번호" onblur="checkPasswordEmpty()"/><br>
            <span id="passwordError" class="error"><form:errors path="password" cssClass="text-danger"/></span>
        </div>

        <c:if test="${not empty error}">
            <div class="text-danger">${error}</div>
        </c:if>

        <input type="submit" value="로그인"/>
    </form:form>


    <script src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>
    <script>
        // 이메일 공백 확인
        function checkEmailEmpty() {

            const email = document.getElementById('email').value;
            const emailError = document.getElementById('emailError');
            //
            // if (!email) {
            //     emailError.innerText = '이메일을 입력하세요.';
            //     return;
            // }
            //
            // emailError.innerText = '';
        }

        // 비밀번호 공백 확인
        function checkPasswordEmpty() {

            const password = document.getElementById('password').value;
            const passwordError = document.getElementById('passwordError');
            //
            // if (!password) {
            //
            //   passwordError.innerText = '비밀번호를 입력하세요.';
            //   return;
            // }
            //
            // passwordError.innerText = '';
        }
    </script>

</body>


