package com.tjut.shop.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("分页条件查询")
public class SupParam {

    @ApiModelProperty("中文全称")
    private String zhongWenQch;

    @ApiModelProperty("助记码")
    private String zhuJiMa;

    @ApiModelProperty("供应商简称")
    private String gysJianCheng;

    @ApiModelProperty("供应商编码")
    private String gysBianMa;
}
