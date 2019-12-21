package com.ssq.infrastructure.service;

import com.ssq.infrastructure.model.demo.TestListEnum;
import com.ssq.infrastructure.model.resultbean.Message;
import com.ssq.infrastructure.model.resultbean.ResultBean;
import org.springframework.stereotype.Service;

/**
 * demo
 *
 * @author sunsiquan
 * @date 2019-12-21
 */
@Service
public class DemoService {

    public ResultBean<TestListEnum> getFoo() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setResult(new TestListEnum());
        Message msg = new Message();
        msg.setEn("English prompt info.");
        msg.setZh("中文提示信息。");
        resultBean.setMsg(msg);
        return resultBean;
    }
}
