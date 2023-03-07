package com.hhy.crm.controller;

import com.hhy.crm.beans.DictionaryValue;
import com.hhy.crm.dto.ResultDTO;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;
import com.hhy.crm.service.DictionaryValueService;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * @author hhy
 * @code 2023-03-01 9:45
 */
@RestController
@RequestMapping("/dictionaryValue")
public class DictionaryValueController {

    @Autowired
    private DictionaryValueService dictionaryValueService;

    @RequestMapping("getAll.action")
    public ResultDTO getAll() throws MySqlException, MyTextException {
        List<DictionaryValue> dictionaryValueList = dictionaryValueService.getAll();
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setData(dictionaryValueList);
        return resultDTO;
    }

    @RequestMapping("get.action")
    public ResultDTO get(String id) throws MySqlException, MyTextException {
        DictionaryValue dictionaryValue = dictionaryValueService.getById(id);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setData(dictionaryValue);
        return resultDTO;
    }

    @RequestMapping("del.action")
    public ResultDTO del(@RequestBody String[] ids) throws MySqlException, MyTextException {
        dictionaryValueService.deleteByIds(ids);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setSuccessMsg("删除成功!");
        return resultDTO;
    }

    @RequestMapping("edit.action")
    public ResultDTO edit(@Valid DictionaryValue dictionaryValue, BindingResult bindingResult) throws MySqlException, MyTextException {
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            if ("orderNo".equals(fieldError.getField()) && Objects.equals(fieldError.getCode(), TypeMismatchException.ERROR_CODE)) {
                throw new MyTextException("排序只能是数字");
            }
            throw new MyTextException(fieldError.getDefaultMessage());
        }
        dictionaryValueService.update(dictionaryValue);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccessMsg("修改成功!");
        resultDTO.setResult(true);
        return resultDTO;
    }

    @RequestMapping("add.action")
    public ResultDTO add(@Valid DictionaryValue dictionaryValue, BindingResult bindingResult) throws MySqlException, MyTextException {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            if ("orderNo".equals(fieldError.getField()) && Objects.equals(fieldError.getCode(), TypeMismatchException.ERROR_CODE)) {
                throw new MyTextException("排序只能是数字");
            }
            throw new MyTextException(fieldError.getDefaultMessage());
        }
        dictionaryValueService.add(dictionaryValue);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccessMsg("添加成功!");
        resultDTO.setResult(true);
        return resultDTO;
    }
}
