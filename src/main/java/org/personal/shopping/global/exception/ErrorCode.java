package org.personal.shopping.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 회원
    NOT_EMAIL_PASSWORD("이메일 또는 비밀번호를 잘못 입력했습니다."),


    // 카테고리
    NOT_FIND_CATEGORY("카테고리를 확인하세요."),



    ;

    private final String MESSAGE;
}
