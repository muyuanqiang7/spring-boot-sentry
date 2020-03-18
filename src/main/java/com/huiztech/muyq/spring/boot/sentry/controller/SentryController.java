package com.huiztech.muyq.spring.boot.sentry.controller;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author [muyuanqiang]
 * @version [1.0.0]
 * @date: [2020/3/12 10:59]
 * @description []
 */
@RestController
@RequestMapping(value = "/sentry")
@Slf4j
public class SentryController {

    @GetMapping
    public Map<String, Object> createSentryEvent() {
        Map<String, Object> data = Maps.newHashMap();
        try {
            throw new RuntimeException("sentry catch and report runtime error");
        } catch (RuntimeException e) {
            log.error("sentry event error测试信息", e);
        }
        data.put("code", "10001");
        data.put("data", "debug");
        data.put("status", false);
        return data;
    }

    @GetMapping(value = "greeting")
    public Map<String, Object> greeting() {
        Map<String, Object> data = Maps.newHashMap();
        log.info("greeting from: 127.0.0.1");
        data.put("code", "10001");
        data.put("data", "debug");
        data.put("status", false);
        return data;
    }
}
