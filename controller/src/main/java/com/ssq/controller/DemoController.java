package com.ssq.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = "foo")
    public ResponseEntity foo() {
        return ResponseEntity.status(HttpStatus.OK).body("bar");
    }
}
