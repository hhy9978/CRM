package com.hhy.crm.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tbl_user
 */
@TableName(value ="tbl_user")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 
     */
    private String deptId;

    /**
     * 
     */
    private String loginAct;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String loginPwd;

    /**
     * 
     */
    private String email;

    /**
     * 失效时间为空表示永不失效
     */
    private String expireTime;

    /**
     * 0表示锁定1表示启用
     */
    private String lockStatus;

    /**
     * 为空时表示不限制IP，多个IP地址之间使用半角逗号隔开
     */
    private String allowIps;

    /**
     * 
     */
    private String createBy;

    /**
     * 
     */
    private String createTime;

    /**
     * 
     */
    private String editBy;

    /**
     * 
     */
    private String editTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}