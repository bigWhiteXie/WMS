package com.tjut.shop.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("分页条件查询")
public class GoodParam {


    @ApiModelProperty("商品名称")
    private String shpMingCheng;


    @ApiModelProperty("商品编码")
    private String shpBianMa;


    @ApiModelProperty("产品属性")
    private String chpShuXing;






}
