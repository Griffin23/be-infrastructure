package com.ssq.infrastructure.model.resultbean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回给前端的国际化信息
 *
 * @author Sun
 * @date 2019-6-13
 */
@Data
public class Message {
    @ApiModelProperty("中文信息")
    private String zh;
    @ApiModelProperty("英文信息")
    private String en;
}