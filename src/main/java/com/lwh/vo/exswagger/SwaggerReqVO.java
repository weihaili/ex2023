package com.lwh.vo.exswagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("create swagger request parameter")
public class SwaggerReqVO {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("name")
    private String name;

    @ApiModelProperty("gender")
    private Integer gender;
}
