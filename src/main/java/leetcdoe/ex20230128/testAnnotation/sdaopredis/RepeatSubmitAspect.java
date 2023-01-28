package leetcdoe.ex20230128.testAnnotation.sdaopredis;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Aspect
@Component
@Slf4j
public class RepeatSubmitAspect {

    @Autowired
    private RedisLock redisLock;

    @Pointcut("@annotation(noRepeatSubmit)")
    public void pointCut(NoRepeatSubmit noRepeatSubmit) {
    }

    @Around("pointCut(noRepeatSubmit)")
    public Object around(ProceedingJoinPoint pjp, NoRepeatSubmit noRepeatSubmit) throws Throwable {
        int lockTime = noRepeatSubmit.lockTime();

        HttpServletRequest request = RequestUtil.getRequest();
        Assert.notNull(request, "request can not null");

        String tokenStr = request.getHeader("Authorization");
        String[] tokens = tokenStr.split(StringUtils.SPACE);
        String token = tokens[1];
        String path = RequestUtil.getServletPath();
        String lockKey = token + path;
        String clientId = UUID.randomUUID().toString();

        boolean lockFlag = redisLock.tryLock(lockKey, clientId, lockTime);
        log.info("try lock key:[{}], clientId:[{}]", lockKey, clientId);
        Object res = null;
        if (lockFlag) {
            res = pjp.proceed();
        }
        return res;
    }
}
