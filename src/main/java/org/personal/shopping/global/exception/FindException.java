package org.personal.shopping.global.exception;

import lombok.Getter;

@Getter
public class FindException extends RuntimeException {

    private final ErrorCode errorCode;

    public FindException(ErrorCode errorCode) {
        super(errorCode.getMESSAGE());
        this.errorCode = errorCode;
    }
}
