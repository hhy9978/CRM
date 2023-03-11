package com.hhy.crm.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

/**
 * 市场活动表
 * @TableName tbl_marketing_activities
 */
@TableName(value ="tbl_marketing_activities")
@Data
public class MarketingActivities implements Serializable {
    /**
     * 主键采用uuid自动生成策略，要求32位长度，全部小写
     */
    @TableId
    private String id;

    /**
     * 市场活动所有者可以是当前登录的用户，不过当前登录的用户也可以指派其它用户为该市场活动的所有者
     */
    private String owner;


    @TableField(exist = false)
    private User ownerUser;


    /**
     * 
     */
    private String name;

    /**
     * 日期格式：2010-10-09
     */
    private String startDate;

    /**
     * 日期格式：2010-10-09
     */
    private String endDate;

    /**
     * 成本
     */
    private Long cost;

    /**
     * 对当前市场活动的描述
     */
    private String description;

    /**
     * 保存市场活动的时候，将当前登录的用户作为市场活动创建者
     */
    private String createBy;

    @TableField(exist = false)
    private User createByUser;


    /**
     * 19个长度，精确到时分秒，例如：2010-10-10 10:10:10
     */
    private String createTime;

    /**
     * 修改市场活动的时候，将当前登录的用户作为该市场活动的修改者
     */
    private String editBy;

    @TableField(exist = false)
    private User editByUser;

    /**
     * 19个长度，精确到时分秒，例如：2010-10-10 10:10:10
     */
    private String editTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


    public MarketingActivities() {
        System.out.println("111111");
    }
}