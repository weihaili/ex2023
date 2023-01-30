package com.lwh.controller.exswagger;

import com.lwh.util.JedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "CacheController", tags = "CacheController")
@RequestMapping("/cache")
@RestController
@Slf4j
public class CacheController {

    @Resource
    private JedisUtils jedisUtils;

    @PostMapping("/add")
    @ApiOperation("addNewCache")
    public String set(@ApiParam(name = "key") String key, @ApiParam(name = "value") String value) {
        log.info("set key:{}, value:{}", key, value);
        return jedisUtils.set(key, value);
    }

    @PostMapping("/del")
    @ApiOperation("delCache")
    public long set(@ApiParam(name = "key") String key) {
        return jedisUtils.del(key);
    }
}
