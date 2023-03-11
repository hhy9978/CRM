package com.hhy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hhy.crm.beans.User;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;
import com.hhy.crm.service.UserService;
import com.hhy.crm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
* @author 24729
* @description 针对表【tbl_user】的数据库操作Service实现
* @createDate 2023-03-07 17:34:14
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public List<User> getAll() throws MySqlException, MyTextException {
        List<User> userList = null;
        try {
            userList = list();
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (userList == null) {
            throw new MyTextException("没有数据");
        }
        return userList;
    }

    @Override
    public User get(String id) throws MySqlException, MyTextException {
        User user = null;
        try {
            user = getById(id);
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (user == null) {
            throw new MyTextException("没有数据");
        }
        return user;
    }

    @Override
    public void add(User user) throws MySqlException, MyTextException {
        try {
            save(user);
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
    }

    @Override
    public void del(String... ids) throws MySqlException, MyTextException {
        boolean rows = true;
        try {
            rows = removeByIds(Arrays.asList(ids));
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (!rows) {
            throw new MyTextException("删除失败,用户不存在");
        }
    }
    @Override
    public void edit(User user) throws MySqlException, MyTextException {
        boolean rows = true;
        try {
            rows = updateById(user);
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (!rows) {
            throw new MyTextException("修改用户不存在!");
        }
    }

}




