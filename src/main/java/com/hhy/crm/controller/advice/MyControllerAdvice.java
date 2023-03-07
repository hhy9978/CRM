package com.hhy.crm.controller.advice;

import com.hhy.crm.dto.ResultDTO;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hhy
 * @code 2023-03-06 8:41
 */
@RestControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(MySqlException.class)
    public ResultDTO mySql(MySqlException e) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(false);
        resultDTO.setErrorMsg(e.getMessage());
        return resultDTO;
    }

    @ExceptionHandler(MyTextException.class)
    public ResultDTO text(MyTextException e) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(false);
        resultDTO.setErrorMsg(e.getMessage());
        return resultDTO;
    }

}
