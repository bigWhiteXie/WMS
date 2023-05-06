package com.tjut.receive.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("分页参数")
public class PageParam {
    @ApiModelProperty("当前页码")
    int index;

    @ApiModelProperty("页大小")
    int size;
}
