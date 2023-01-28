package leetcdoe.ex20230128.testAnnotation.sdaopredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import redis.clients.jedis.Jedis;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;
import java.util.Objects;

@Component
public class RedisLock {

    private static final Long RELEASE_SUCCESS = 1L;
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "EX";

    private static final String RELEASE_LOCK_SRIPPT = "if redis.call('get', KEYS[1]) == ARGV[1] " +
            "then return redis.call('del', KEYS[1]) else return 0 end";

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean tryLock(String key, String clientId, long second) {
        return redisTemplate.execute((RedisCallback<Boolean>) redisConnection ->{
            Jedis jedis = this.getJedis(redisConnection);
            String res = jedis.set(key, clientId, new SetParams().nx().px(second));
            if (LOCK_SUCCESS.equals(res)) {
                return true;
            }
            return false;
        });
    }

    public boolean releaseLock(String key, String clientId) {
        return redisTemplate.execute((RedisCallback<Boolean>) redisConnection ->{
            Jedis jedis = this.getJedis(redisConnection);
            Object res = jedis.eval(RELEASE_LOCK_SRIPPT, Collections.singletonList(key), Collections.singletonList(clientId));
            if (Objects.equals(RELEASE_SUCCESS, res)) {
                return true;
            }
            return false;
        });
    }


    private Jedis getJedis(RedisConnection connection) {
        return (Jedis) connection.getNativeConnection();
    }
}
