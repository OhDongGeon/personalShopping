package org.personal.shopping.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    NOT_EMAIL_PASSWORD("이메일 또는 비밀번호를 잘못 입력했습니다."),

    ;

    private final String MESSAGE;
}
