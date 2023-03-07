package com.hhy.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hhy
 * @code 2023-03-06 8:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {
    //表示响应的结果是成功还是失败
    boolean result;
    //表示响应成功，且有数据
    Object data;
    //表示失败，且有失败消息
    String errorMsg;
    //表示成功，且有失败消息
    String successMsg;
}
