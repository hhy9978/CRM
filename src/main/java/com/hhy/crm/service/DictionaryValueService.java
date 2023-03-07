package com.hhy.crm.service;

import com.hhy.crm.beans.DictionaryValue;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;

import java.util.List;

/**
* @author 24729
* @description 针对表【tbl_dictionary_value(字典值表)】的数据库操作Service
* @createDate 2023-03-06 13:45:42
*/
public interface DictionaryValueService extends IService<DictionaryValue> {

    void add(DictionaryValue dictionaryValue) throws MySqlException, MyTextException;

    DictionaryValue getById(String id) throws MySqlException, MyTextException;

    void deleteByIds(String[] ids) throws MySqlException, MyTextException;

    List<DictionaryValue> getAll() throws MySqlException, MyTextException;

    void update(DictionaryValue dictionaryValue) throws MySqlException, MyTextException;
}
