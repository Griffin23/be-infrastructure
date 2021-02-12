package com.ssq.infrastructure.controller;

import com.ssq.infrastructure.model.resultbean.ResultBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * File
 *
 * @author Sun
 * @date 2021-02-12
 */
@RestController
@RequestMapping(value = "file")
public class FileController {

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResponseEntity<ResultBean<String>> uploadFile(@RequestParam(name = "my-file") MultipartFile file, HttpServletRequest request) {
        ResultBean resultBean = new ResultBean();

        if (file.isEmpty() || file.getSize() <= 0) {
            resultBean.setResult("上传文件不能为空");
        }

        String dirPath = System.getProperty("user.dir") + "/upload-files";
        File dir =  new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String newFileName = UUID.randomUUID().toString() + file.getOriginalFilename();
        File newFile = new File(dirPath + "/" + newFileName);
        try {
            file.transferTo(newFile);
            resultBean.setResult("上传成功");
        } catch (IOException e) {
            resultBean.setResult("上传失败");
        }
        return ResponseEntity.status(HttpStatus.OK).body(resultBean);
    }
}
