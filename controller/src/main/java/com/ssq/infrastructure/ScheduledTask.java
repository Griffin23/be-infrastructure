package com.ssq.infrastructure;

import com.ssq.infrastructure.core.log.LoggerBase;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sunsiquan
 * @date 2019-12-25
 */
@Component
public class ScheduledTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("现在时间是" + dateFormat.format(new Date()));
        LoggerBase.info("fooabr");
    }
}
