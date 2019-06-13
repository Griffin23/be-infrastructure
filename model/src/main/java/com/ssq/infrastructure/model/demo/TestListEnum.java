package com.ssq.infrastructure.model.demo;

import lombok.Data;

import java.util.List;

/**
 * 用于测试swagger list enum
 *
 * @author Sun
 * @date 2019-6-13
 */
@Data
public class TestListEnum {
    private ColorEnum singleEnum;
    private List<ColorEnum> listEnum;

    private enum ColorEnum {
        red, blue
    }
}