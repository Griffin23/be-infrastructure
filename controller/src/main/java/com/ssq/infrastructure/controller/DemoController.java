package com.ssq.infrastructure.controller;

import com.ssq.infrastructure.model.demo.TestListEnum;
import com.ssq.infrastructure.model.resultbean.ResultBean;
import com.ssq.infrastructure.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "foo", method = RequestMethod.GET)
    public ResponseEntity<ResultBean<TestListEnum>> foo() {
        ResultBean resultBean = demoService.getFoo();
        return ResponseEntity.status(HttpStatus.OK).body(resultBean);
    }
}
