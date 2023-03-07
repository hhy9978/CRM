package com.hhy.crm.mapper;

import com.hhy.crm.beans.DictionaryValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author hhy
* @description 针对表【tbl_dictionary_value(字典值表)】的数据库操作Mapper
* @createDate 2023-03-06 13:45:42
* @Entity com.hhy.crm.beans.DictionaryValue
*/
public interface DictionaryValueMapper extends BaseMapper<DictionaryValue> {

    List<DictionaryValue> getAll();

    DictionaryValue get(String id);

}




