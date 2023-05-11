package com.tjut.receive.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 入库单
 */
@ApiModel("创建入库单参数")
@Data
public class ReceiptDto {

    /**
     * 预计到货时间
     */
    @ApiModelProperty("预计到货时间")
    private String imData;
    @ApiModelProperty("司机姓名")
    private String imCarDri;
    @ApiModelProperty("司机电话号")
    private String imCarMobile;
    @ApiModelProperty("汽车编号")
    private String imCarNo;
    @ApiModelProperty("订单类型")
    private String orderTypeCode;
    @ApiModelProperty("月台编码")
    private String platformCode;
    @ApiModelProperty("备注")
    private String imBeizhu;
    @ApiModelProperty("入库单状态")
    private String imSta;
    /**
     * 入库单号
     */
    @ApiModelProperty("入库单号")
    private String imNoticeId;
    @ApiModelProperty("附件")
    private String fuJian;
    @ApiModelProperty("供应商编码")
    private String supCode;
    @ApiModelProperty("供应商名称")
    private String supName;
    @ApiModelProperty("商品编码")
    private String goodsCode;
    @ApiModelProperty("商品数量")
    private String goodsCount;
    @ApiModelProperty("生产日期")
    private String goodsPrdData;
    @ApiModelProperty("商品体积")
    private String goodsFvol;
    @ApiModelProperty("商品重量")
    private String goodsWeight;
    @ApiModelProperty("单位")
    private String goodsUnit;
    @ApiModelProperty("收货登记数量")
    private String goodsQmCount;
    @ApiModelProperty("基本单位")
    private String baseUnit;
    @ApiModelProperty("基本单位数量")
    private String baseGoodscount;
    @ApiModelProperty("基本单位收货数量")
    private String baseQmcount;
    @ApiModelProperty("商品名称")
    private String goodsName;
}
