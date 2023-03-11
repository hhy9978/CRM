package com.hhy.crm.controller;

import com.hhy.crm.beans.User;
import com.hhy.crm.dto.ResultDTO;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;
import com.hhy.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hhy
 * @code 2023-03-09 13:10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("getAll.action")
    public ResultDTO getAll() throws MySqlException, MyTextException {
        List<User> userList = userService.getAll();
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setData(userList);
        return resultDTO;
    }

    @RequestMapping("get.action")
    public ResultDTO get(String id) throws MySqlException, MyTextException {
        User user = userService.get(id);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setData(user);
        return resultDTO;
    }
    @RequestMapping("add.action")
    public ResultDTO add(User user) throws MySqlException, MyTextException {
        userService.add(user);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setSuccessMsg("添加成功!");
        return resultDTO;
    }
    @RequestMapping("del.action")
    public ResultDTO del(@RequestBody String... ids) throws MySqlException, MyTextException {
        userService.del(ids);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setSuccessMsg("添加成功!");
        return resultDTO;
    }

    @RequestMapping("edit.action")
    public ResultDTO edit(User user) throws MySqlException, MyTextException {
        userService.edit(user);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setSuccessMsg("添加成功!");
        return resultDTO;
    }

}
