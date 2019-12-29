package com.ssq.infrastructure.core.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sunsiquan
 * @date 2019-12-29
 */
public class LoggerBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerBase.class);

    public static void debug(Object msg) {
        if (msg != null && LOGGER.isDebugEnabled()) {
            LOGGER.debug(msg.toString());
        }
    }

    public static void info(Object msg) {
        if (msg != null && LOGGER.isInfoEnabled()) {
            LOGGER.info(msg.toString());
        }
    }

    public static void warn(Object msg) {
        if (msg != null) {
            LOGGER.warn(msg.toString());
        }
    }

    public static void error(Object msg) {
        if (msg != null) {
            LOGGER.error(msg.toString());
        }
    }
}
