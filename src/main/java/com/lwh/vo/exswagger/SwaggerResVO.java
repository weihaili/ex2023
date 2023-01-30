package com.lwh.vo.exswagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("create swagger response result")
public class SwaggerResVO {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("name")
    private String name;

    @ApiModelProperty("gender")
    private Integer gender;

    @ApiModelProperty("what")
    private String what;
}
