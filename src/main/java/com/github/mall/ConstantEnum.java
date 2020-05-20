package com.github.mall;

public enum ConstantEnum {
    USER_NOT_FOUND(10001, "用户不存在"),
    USER_HAS_BEEN(10002, "用户已经注册");

    private Integer code;

    private String message;


    ConstantEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
