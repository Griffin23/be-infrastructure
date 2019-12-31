package com.ssq.infrastructure.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 简易获取日志接口
 *
 * @author sunsiquan
 * @date 2019-12-31
 */
@RestController
@RequestMapping(value = "log")
public class LogController {

    /***
     * 获取日志文件 by 日期
     * @param dateStr 日期 yyyy-MM-dd
     * @param part
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "date/{date}", method = RequestMethod.GET)
    public void viewLogByDate(@PathVariable("date") String dateStr, @RequestParam(value = "part", required = false) String part,
                              @RequestParam("key") String key, HttpServletResponse response) throws Exception {
        if (!checkKey(key)) {
            responseText(response, "key error");
            return;
        }
        part = (StringUtils.isEmpty(part)) ? "0" : part;
        String path = String.format("/var/logs/be-inf-log/%s.%s.log", dateStr, part);
        // path是指欲下载的文件的路径。
        File file = new File(path);
        if (!file.exists()) {
            responseText(response, "file not exists");
            return;
        }
        // 取得文件名。
        String filename = file.getName();
        // 以流的形式下载文件。
        InputStream fis = new BufferedInputStream(new FileInputStream(path));
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        // 清空response
        response.reset();
        // 设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
        response.addHeader("Content-Length", "" + file.length());
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
    }

    private Boolean checkKey(String key) {
        String str = "";
        // custom code algorithm here
        return str.equals(key);
    }

    private void responseText(HttpServletResponse response, String text) throws Exception {
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(text);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
