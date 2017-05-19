package com.acg_shop.enums;

/**
 * 返回结果类型
 * Created by mac_zly on 2017/5/19.
 */

public enum ResultEnum {
    QUERY_SUCCESS(200, "查询成功"),
    QUERY_FAILD(201, "查询失败"),
    ERROR(-1, "出错了");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
