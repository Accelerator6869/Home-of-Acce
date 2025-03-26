package com.zyf.sb_zyf.exception;

public class BusinessException extends RuntimeException {
    private final String message; // 错误描述

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    // Getter 方法
    @Override
    public String getMessage() {
        return message;
    }
}
