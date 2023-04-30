package com.tjut.receive.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReceiptDto {
    private String id;
    private LocalDateTime imData;
    private String imCarDri;
    private String imCarMobile;
    private String imCarNo;
    private String orderTypeCode;
    private String platformCode;
    private String imBeizhu;
    private String imSta;
    private String noticeId;
    private String fuJian;
    private String supCode;
    private String supName;
    private String goodsCode;
    private String goodsCount;
    private LocalDateTime goodsPrdData;
    private String goodsFvol;
    private String goodsWeight;
    private String goodsUnit;
    private String goodsQmCount;
    private String baseUnit;
    private String baseGoodscount;
    private String baseQmcount;
    private String goodsName;
}
