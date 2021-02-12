package com.ssq.infrastructure.controller;

import com.ssq.infrastructure.model.resultbean.ResultBean;
import com.ssq.infrastructure.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * File
 *
 * @author Sun
 * @date 2021-02-12
 */
@RestController
@RequestMapping(value = "file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResponseEntity<ResultBean<String>> uploadFile(@RequestParam(name = "my-file") MultipartFile file) {
        ResultBean resultBean = fileService.uploadFile(file);
        return ResponseEntity.status(HttpStatus.OK).body(resultBean);
    }
}
