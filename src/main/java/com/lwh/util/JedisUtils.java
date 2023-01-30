package com.lwh.util;

import com.kkl.excerise.JedisConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.*;

@Component
@Slf4j
public class JedisUtils {

    @Autowired
    private JedisConfig jedisConfig;

    private JedisPool jedisPool;

    private Jedis jedis = null;

    private Jedis getInstance() {
        jedis = jedisConfig.redisPoolFactory().getResource();
        jedis.select(1);
        return jedis;
    }

    public void takeBackJedis() {
        if (jedis != null && jedisPool != null) {
            jedis.close();
        }
    }

    public String get(String key) {
        return jedis.get(key);
    }

    public String set(String key, String value) {
        return this.getInstance().set(key, value);
    }

    public Long del(String ... keys) {
        return this.getInstance().del(keys);
    }

    public byte[] objectSerialize(Object obj) {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            return baos.toByteArray();
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                log.error("close stream error:{}", e.getMessage());
            }
        }
        return null;
    }

    public Object deObjectSerialize(byte[] bytes) {
        ObjectInputStream ois = null;
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (IOException e) {
            log.error("deObjectSerialize io exception reason:{}", e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error("deObjectSerialize class not found exception reason:{}", e.getMessage());
        }
        return null;
    }
}
