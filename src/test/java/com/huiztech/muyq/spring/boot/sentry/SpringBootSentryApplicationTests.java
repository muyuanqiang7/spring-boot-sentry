package com.huiztech.muyq.spring.boot.sentry;

import com.google.common.collect.Maps;
import com.huiztech.muyq.spring.boot.sentry.cache.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
class SpringBootSentryApplicationTests {

    @Resource
    private RedisService redisService;

    @Test
    void contextLoads() {
        Map<String, Object> data = Maps.newHashMap();
        data.put("user", "entry");
        data.put("info", "came from lost city");
        redisService.set("sentry:mall", data);
    }

}
