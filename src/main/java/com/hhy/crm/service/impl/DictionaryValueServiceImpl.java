package com.hhy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hhy.crm.beans.DictionaryValue;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;
import com.hhy.crm.service.DictionaryValueService;
import com.hhy.crm.mapper.DictionaryValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
* @author 24729
* @description 针对表【tbl_dictionary_value(字典值表)】的数据库操作Service实现
* @createDate 2023-03-06 13:45:42
*/
@Service
public class DictionaryValueServiceImpl extends ServiceImpl<DictionaryValueMapper, DictionaryValue>
    implements DictionaryValueService{

    @Autowired(required = false)
    private DictionaryValueMapper dictionaryValueMapper;

    private final QueryWrapper<DictionaryValue> queryWrapper = new QueryWrapper<>();

    @Override
    public List<DictionaryValue> getAll() throws MySqlException, MyTextException {
        List<DictionaryValue> dictionaryValueList = null;
        try {
            dictionaryValueList = dictionaryValueMapper.getAll();
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (dictionaryValueList == null) {
            throw new MyTextException("没有数据");
        }
        return dictionaryValueList;
    }

    @Override
    public DictionaryValue getById(String id) throws MySqlException, MyTextException {
        queryWrapper.clear();
        queryWrapper.eq("id", id);
        DictionaryValue dictionaryValue = null;
        try {
            dictionaryValue = dictionaryValueMapper.get(id);
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (dictionaryValue == null) {
            throw new MyTextException("没有数据");
        }
        return dictionaryValue;
    }

    @Override
    public void deleteByIds(String[] ids) throws MySqlException, MyTextException {
        boolean isSucceed = true;
        try {
            isSucceed = removeByIds(Arrays.asList(ids));
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (!isSucceed) {
            throw new MyTextException("删除失败,字典数值不存在");
        }
    }

    @Override
    public void add(DictionaryValue dictionaryValue) throws MySqlException, MyTextException {
        dictionaryValue.setId(UUID.randomUUID().toString());
        boolean isSucceed = true;
        try {
            isSucceed = save(dictionaryValue);
        } catch (DataIntegrityViolationException e){
            throw new MySqlException("添加失败,字典类型不存在!");
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }

    }

    @Override
    public void update(DictionaryValue dictionaryValue) throws MySqlException, MyTextException {
        boolean isSucceed = true;
        try {
            isSucceed = updateById(dictionaryValue);
        } catch (DataIntegrityViolationException e){
            throw new MySqlException("修改失败,字典类型不存在!");
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (!isSucceed) {
            throw new MyTextException("修改失败,字典数值不存在!");
        }
    }
}




