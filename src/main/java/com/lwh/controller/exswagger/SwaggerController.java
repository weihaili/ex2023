package com.lwh.controller.exswagger;

import com.lwh.vo.exswagger.SwaggerReqVO;
import com.lwh.vo.exswagger.SwaggerResVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swagger")
@Api(value = "userInterface", tags = "userInterface")
public class SwaggerController {

    @ApiOperation("saveUserInformation")
    @PostMapping("/save")
    public String save(@RequestBody SwaggerReqVO vo) {
        return "success";
    }

    @ApiOperation("queryUserById")
    @PostMapping("/query")
    public SwaggerResVO getById(@RequestBody SwaggerReqVO vo) {
        return new SwaggerResVO();
    }
}
