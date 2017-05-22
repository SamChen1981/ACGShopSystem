package com.acg_shop.dto;

import com.acg_shop.enums.ResultEnum;

/**
 * 基本结果返回
 * Created by mac_zly on 2017/5/19.
 */

public class ResultDto<T> {

    private Integer code;
    private String message;
    private Boolean success;
    private T result;

    public ResultDto(Integer code, String message) {
        this(code, message, false, null);
    }

    public ResultDto(Integer code, String message, Boolean success, T result) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.result = result;
    }

    public ResultDto(ResultEnum resultEnum, Boolean success) {
        this(resultEnum.getCode(), resultEnum.getMessage(), success, null);
    }

    public ResultDto(ResultEnum resultEnum, Boolean success, T result) {
        this(resultEnum.getCode(), resultEnum.getMessage(), success, result);
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

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", success=" + success +
                ", result=" + result +
                '}';
    }
}
