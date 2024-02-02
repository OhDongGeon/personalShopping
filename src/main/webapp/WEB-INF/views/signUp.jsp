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



    <script src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>
    <script>

        // 아이디 형식 체크
        function checkEmailForm(email) {

            const emailRegx = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
            return emailRegx.test(email);
        }

        // 아이디 중복확인 및 서버쪽 valid 아이디 형식 체크
        function checkEmailDuplication() {

            const email = document.getElementById('email').value;
            const emailError = document.getElementById('emailError');

            if (!email) {
                emailError.innerText = '이메일을 입력하세요.';
                return;
            }

            if (!checkEmailForm(email)) {
                emailError.innerText = '이메일을 올바르게 입력해주세요.';
                return;
            }

            $.ajax({
                url: '/sign/up/check-duplication',
                type: 'POST',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify({email: email}),

                success: function () {
                    emailError.innerText = '';
                },
                error: function (xhr) {
                    if (xhr.status === 409) {
                      emailError.innerText = "사용할 수 없는 아이디입니다. 다른 아이디를 입력해 주세요.";
                    } else {
                        emailError.innerText = JSON.parse(xhr.responseText).email;
                    }
                }
            });
        }

        // 비밀번호 형식 체크
        function checkPasswordForm() {

            const password = document.getElementById('password').value;
            const passwordError = document.getElementById('passwordError');

            if (!password) {
                passwordError.innerText = '비밀번호를 입력하세요.';
                return;
            }

            const passwordRegx = /(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\W)(?=\S+$).{10,}/;
            if (!passwordRegx.test(password)) {
                passwordError.innerText = '비밀번호는 10자 이상, 영문 대 소문자, 숫자, 특수문자를 사용하세요.';
                return;
            }
            passwordError.innerText = '';
        }

        // 이름 공백 확인
        function checkNameEmpty() {

            const name = document.getElementById('name').value;
            const nameError = document.getElementById('nameError');

            if (!name) {
                nameError.innerText = '이름을 입력하세요.';
                return;
            }
            nameError.innerText = '';
        }

        // 전화번호 형식 및 공백 확인
        function checkPhoneNumberForm() {

            const phoneNumber = document.getElementById('phoneNumber').value;
            const phoneNumberError = document.getElementById('phoneNumberError');

            if (!phoneNumber) {
                phoneNumberError.innerText = '핸드폰번호를 입력하세요.';
                return;
            }

            const phoneNumberRegx = /^[0-9]{11,12}$/;
            if (!phoneNumberRegx.test(phoneNumber)) {
                phoneNumberError.innerText = '핸드폰번호를 확인하세요.';
                return;
            }

            phoneNumberError.innerText = '';
        }
    </script>
</body>
