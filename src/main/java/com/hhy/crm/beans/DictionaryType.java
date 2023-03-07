package com.hhy.crm.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import javax.validation.constraints.*;

/**
 * 字典类型表
 * @author hhy
 * @TableName tbl_dictionary_type
 */
@TableName(value ="tbl_dictionary_type")
@Data
public class DictionaryType implements Serializable {
    /**
     * 例如：sex、orgType
     */
    @TableId
    private String id;

    /**
     * 例如：性别、机构类型
     */
    @NotNull(message = "字典类型名称不能为空")
    @NotEmpty(message = "字典类型名称不能为空")
    @NotBlank(message = "字典类型名称不能为空")
    @Size(min = 1, max = 10, message = "字典类型名称长度只能是1-10")
    private String name;

    /**
     * 对该字典类型的一个描述
     */
    @NotNull(message = "字典类型描述不能为空")
    @NotEmpty(message = "字典类型描述不能为空")
    @NotBlank(message = "字典类型描述不能为空")
    @Size(min = 1, max = 10, message = "字典类型描述长度只能是1-10")
    private String description;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}