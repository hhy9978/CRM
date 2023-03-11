package com.hhy.crm.service;

import com.hhy.crm.beans.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;

import java.util.List;

/**
* @author 24729
* @description 针对表【tbl_user】的数据库操作Service
* @createDate 2023-03-07 17:34:14
*/
public interface UserService extends IService<User> {


    List<User> getAll() throws MySqlException, MyTextException;

    User get(String id) throws MySqlException, MyTextException;

    void add(User user) throws MySqlException, MyTextException;

    void del(String... ids) throws MySqlException, MyTextException;

    void edit(User user) throws MySqlException, MyTextException;
}
