package com.tjut.receive.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("入库单查询返回")
@Data
public class Response {

    @ApiModelProperty("入库单")
    private List<ReceiptDto> receiptList;

    private long total;
    private long size;
    private long current;
}
