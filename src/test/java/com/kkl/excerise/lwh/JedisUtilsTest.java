package com.kkl.excerise.lwh;

import com.kkl.excerise.ExceriseApplication;
import com.lwh.util.JedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ExceriseApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JedisUtilsTest {

    @Resource
    private JedisUtils jedisUtils;

    @Test
    public void testSet() {
        String res = jedisUtils.set("124", "123");
        Assert.notNull(res);
    }

}
