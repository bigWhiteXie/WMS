package com.tjut.receive.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 入库单
 */
@Data
public class ReceiptDto {

    /**
     * 预计到货时间
     */
    private String imData;
    private String imCarDri;
    private String imCarMobile;
    private String imCarNo;
    private String orderTypeCode;
    private String platformCode;
    private String imBeizhu;
    private String imSta;
    /**
     * 入库单号
     */
    private String imNoticeId;
    private String fuJian;
    private String supCode;
    private String supName;
    private String goodsCode;
    private String goodsCount;
    private String goodsPrdData;
    private String goodsFvol;
    private String goodsWeight;
    private String goodsUnit;
    private String goodsQmCount;
    private String baseUnit;
    private String baseGoodscount;
    private String baseQmcount;
    private String goodsName;
}
