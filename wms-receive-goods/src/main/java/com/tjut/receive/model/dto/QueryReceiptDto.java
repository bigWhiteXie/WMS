package com.tjut.receive.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@ApiModel
@Data
public class QueryReceiptDto {
    /**
     * 入库单号
     */
    @ApiModelProperty(value = "入库单号")
    private String imNoticeId;
    /**
     * 预计到货时间
     */
    @ApiModelProperty(value = "预计到货时间")
    private String imData;
}
