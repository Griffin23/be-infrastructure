package com.ssq.infrastructure.core.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * JsonUtil
 *
 * @author sunsiquan
 * @date 2019-12-25
 */
public class JSONUtil {

    public static String toJSONString(Object o) {
        return JSONObject.toJSONString(o);
    }
}
