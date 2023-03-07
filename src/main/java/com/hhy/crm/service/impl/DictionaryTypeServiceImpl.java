package com.hhy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hhy.crm.beans.DictionaryType;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;
import com.hhy.crm.service.DictionaryTypeService;
import com.hhy.crm.mapper.DictionaryTypeMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
* @author 24729
* @description 针对表【tbl_dictionary_type(字典类型表)】的数据库操作Service实现
* @createDate 2023-03-06 13:45:21
*/
@Service
public class DictionaryTypeServiceImpl extends ServiceImpl<DictionaryTypeMapper, DictionaryType>
    implements DictionaryTypeService{

    private final QueryWrapper<DictionaryType> queryWrapper = new QueryWrapper<>();

    @Override
    public List<DictionaryType> getAll() throws MySqlException, MyTextException{
        List<DictionaryType> dictionaryTypes = null;
        try {
            dictionaryTypes = list();
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (dictionaryTypes == null) {
            throw new MyTextException("没有数据");
        }
        return dictionaryTypes;
    }

    @Override
    public DictionaryType getById(String id) throws MySqlException, MyTextException {
        queryWrapper.clear();
        queryWrapper.eq("id", id);
        DictionaryType dictionaryType = null;
        try {
            dictionaryType = getOne(queryWrapper);
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (dictionaryType == null) {
            throw new MyTextException("没有数据");
        }
        return dictionaryType;
    }

    @Override
    public void deleteByIds(String[] ids) throws MySqlException, MyTextException{
        boolean isSucceed = true;
        try {
            isSucceed = removeByIds(Arrays.asList(ids));
        } catch (DataIntegrityViolationException e) {
            throw new MySqlException("删除失败,删除字典类型存在值!");
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (!isSucceed) {
            throw new MyTextException("删除失败,字典类型不存在");
        }
    }

    @Override
    public void add(DictionaryType dictionaryType) throws MySqlException, MyTextException{
        dictionaryType.setId(UUID.randomUUID().toString());
        boolean isSucceed = true;
        try {
            isSucceed = save(dictionaryType);
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (!isSucceed) {
            throw new MyTextException("添加失败");
        }

    }

    @Override
    public void update(DictionaryType dictionaryType) throws MySqlException, MyTextException {
        boolean isSucceed = true;
        try {
            isSucceed = updateById(dictionaryType);
        } catch (DataIntegrityViolationException e) {
            throw new MySqlException("修改失败,修改字典类型存在值!");
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (!isSucceed) {
            throw new MyTextException("修改失败,字典类型不存在");
        }

    }
}




