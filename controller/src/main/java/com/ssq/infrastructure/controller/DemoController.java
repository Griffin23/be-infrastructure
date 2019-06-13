package com.ssq.infrastructure.controller;

import com.ssq.infrastructure.model.demo.TestListEnum;
import com.ssq.infrastructure.model.resultbean.Message;
import com.ssq.infrastructure.model.resultbean.ResultBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo
 *
 * @author Sun
 * @date 2019-6-13
 */
@RestController
@RequestMapping(value = "demo")
public class DemoController {

    @RequestMapping(value = "foo", method = RequestMethod.GET)
    public ResponseEntity<ResultBean<TestListEnum>> foo() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        // TODO 空数组应该返回[]，空字符串返回"" ...
        resultBean.setResult(new TestListEnum());
        Message msg = new Message();
        msg.setEn("English prompt info");
        msg.setZh("中文提示信息");
        resultBean.setMsg(msg);
        return ResponseEntity.status(HttpStatus.OK).body(resultBean);
    }
}
