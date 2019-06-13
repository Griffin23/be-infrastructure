package com.ssq.infrastructure.model.resultbean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回给前端的数据结构
 *
 * @author Sun
 * @date 2019-6-13
 */
@Data
public class ResultBean<T> {
    @ApiModelProperty("0表示成功")
    private int code;
    private Message msg;
    T result;
}