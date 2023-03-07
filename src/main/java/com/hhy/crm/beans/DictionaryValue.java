package com.hhy.crm.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import javax.validation.constraints.*;

/**
 * 字典值表
 * @author hhy
 * @TableName tbl_dictionary_value
 */
@TableName(value ="tbl_dictionary_value")
@Data
public class DictionaryValue implements Serializable {

    @TableId
    private String id;

    @NotNull(message = "字典数值名称不能为空")
    @NotEmpty(message = "字典数值名称不能为空")
    @NotBlank(message = "字典数值名称不能为空")
    @Size(min = 1, max = 10, message = "字典数值名称长度只能1-10")
    private String value;

    @NotNull(message = "字典数值描述不能为空")
    @NotEmpty(message = "字典数值描述不能为空")
    @NotBlank(message = "字典数值描述不能为空")
    @Size(min = 1, max = 10, message = "字典数值描述长度只能1-10")
    private String text;

    @NotNull(message = "字典数值描述不能为空")
    @NotEmpty(message = "字典数值描述不能为空")
    @Min(value = 1,message = "排序范围是1-1000")
    @Max(value = 1000,message = "排序范围是1-1000")
    private Long orderNo;

    @NotNull(message = "字典类型不能为空")
    @NotEmpty(message = "字典类型不能为空")
    @NotBlank(message = "字典类型不能为空")
    private String typeid;

    private DictionaryType dictionaryType;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}