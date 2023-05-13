package com.tjut.storage.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("分页参数")
public class PageParam {
    @ApiModelProperty(value = "当前页码",required = true)
    int index;

    @ApiModelProperty(value = "页大小",required = true)
    int size;
}
