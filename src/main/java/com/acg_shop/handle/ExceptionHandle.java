package com.acg_shop.handle;

import com.acg_shop.dto.ResultDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理
 * Created by mac_zly on 2017/5/19.
 */

@ControllerAdvice
public class ExceptionHandle {

    Logger logger = LogManager.getLogger(ExceptionHandle.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultDto handle(Exception e) {
        logger.error("发生了未知异常: {}", e);
        return new ResultDto(-1, e.getMessage(), false, null);
    }

}
