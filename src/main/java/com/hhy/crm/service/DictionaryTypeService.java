package com.hhy.crm.service;

import com.hhy.crm.beans.DictionaryType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;

import java.util.List;

/**
* @author 24729
* @description 针对表【tbl_dictionary_type(字典类型表)】的数据库操作Service
* @createDate 2023-03-06 13:45:21
*/
public interface DictionaryTypeService extends IService<DictionaryType> {


    void add(DictionaryType dictionaryType) throws MySqlException, MyTextException;

    DictionaryType getById(String id) throws MySqlException, MyTextException;

    void deleteByIds(String[] ids) throws MySqlException, MyTextException;

    List<DictionaryType> getAll() throws MySqlException, MyTextException;

    void update(DictionaryType dictionaryType) throws MySqlException, MyTextException;
}
