package com.hhy.crm.controller;

import com.hhy.crm.beans.DictionaryType;
import com.hhy.crm.dto.ResultDTO;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;
import com.hhy.crm.service.DictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

/**
 * @author hhy
 * @code 2023-03-01 9:45
 */
@RestController
@RequestMapping("/dictionaryType")
public class DictionaryTypeController {

    @Autowired
    private DictionaryTypeService dictionaryTypeService;

    @RequestMapping("getAll.action")
    public ResultDTO getAll() throws MySqlException, MyTextException {
        List<DictionaryType> dictionaryTypeList = dictionaryTypeService.getAll();
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setData(dictionaryTypeList);
        return resultDTO;
    }

    @RequestMapping("get.action")
    public ResultDTO get(String id) throws MySqlException, MyTextException {
        DictionaryType dictionaryType = dictionaryTypeService.getById(id);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setData(dictionaryType);
        return resultDTO;
    }

    @RequestMapping("del.action")
    public ResultDTO del(@RequestBody String[] ids) throws MySqlException, MyTextException {
        dictionaryTypeService.deleteByIds(ids);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccessMsg("删除成功!");
        resultDTO.setResult(true);
        return resultDTO;
    }


    @RequestMapping("edit.action")
    public ResultDTO edit(@Valid DictionaryType dictionaryType, BindingResult bindingResult) throws MySqlException, MyTextException {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            throw new MyTextException(fieldError.getDefaultMessage());
        }
        dictionaryTypeService.update(dictionaryType);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccessMsg("修改成功!");
        resultDTO.setResult(true);
        return resultDTO;
    }

    @RequestMapping("add.action")
    public ResultDTO add(@Valid DictionaryType dictionaryType, BindingResult bindingResult) throws MySqlException, MyTextException {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            throw new MyTextException(fieldError.getDefaultMessage());
        }
        dictionaryTypeService.add(dictionaryType);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccessMsg("添加成功!");
        resultDTO.setResult(true);
        return resultDTO;
    }

}
