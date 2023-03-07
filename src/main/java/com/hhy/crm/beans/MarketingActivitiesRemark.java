package com.hhy.crm.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 市场活动备注表
 * @TableName tbl_marketing_activities_remark
 */
@TableName(value ="tbl_marketing_activities_remark")
@Data
public class MarketingActivitiesRemark implements Serializable {
    /**
     * 主键采用uuid自动生成策略，要求32位长度，全部小写
     */
    @TableId
    private String id;

    /**
     * 第一次创建此备注信息的人被称为备注人
     */
    private String notePerson;

    /**
     * 备注的详细内容
     */
    private String noteContent;

    /**
     * 19个长度，精确到时分秒，例如：2010-10-10 10:10:10
     */
    private String noteTime;

    /**
     * 当修改标记为0时，修改人为null，当修改标记为1时，修改人有值，并且修改人是可变化的。只记录最后一次修改人。
     */
    private String editPerson;

    /**
     * 19个长度，精确到时分秒，例如：2010-10-10 10:10:10
     */
    private String editTime;

    /**
     * 0表示该备注没有被修改过，1表示该备注被修改过
     */
    private Integer editFlag;

    /**
     * 
     */
    private String marketingActivitiesId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}