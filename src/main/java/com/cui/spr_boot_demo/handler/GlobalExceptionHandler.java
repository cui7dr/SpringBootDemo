package com.cui.spr_boot_demo.handler;

import com.cui.spr_boot_demo.entity.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * @author cui7dr
 * @date 2021/9/28
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResultDto globalException(HttpServletResponse response, Exception ex) {
        log.info("ExceptionHandler...");
        log.info("错误代码：" + response.getStatus());
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(0);
        resultDto.setMsg(ex.getMessage());
        resultDto.setData(null);
        return resultDto;
    }
}
