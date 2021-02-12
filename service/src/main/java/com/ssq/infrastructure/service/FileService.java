package com.ssq.infrastructure.service;

import com.ssq.infrastructure.model.resultbean.ResultBean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    public ResultBean<String> uploadFile(MultipartFile file) {
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
        return resultBean;
    }
}
