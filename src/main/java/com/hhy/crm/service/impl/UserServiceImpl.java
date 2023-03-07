package com.hhy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hhy.crm.beans.User;
import com.hhy.crm.service.UserService;
import com.hhy.crm.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 24729
* @description 针对表【tbl_user】的数据库操作Service实现
* @createDate 2023-03-07 17:34:14
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{



}




