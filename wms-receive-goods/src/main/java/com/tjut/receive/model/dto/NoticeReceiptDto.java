package com.tjut.receive.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 入库通知单dto
 */
@Data
public class NoticeReceiptDto {

    /**
     * 入库单号
     */
    private String imNoticeId;
    private String goodsCode;
    private String goodsCount;
    private LocalDateTime goodsPrdData;
    private String goodsBatch;
    private String binPre;
    private String goodsFvol;
    private String goodsWeight;
    private String goodsUnit;
    private String goodsQmCount;
    private String baseUnit;
    private String baseGoodscount;
    private String baseQmcount;
    private String goodsName;
    private String imBeizhu;
    private String shpGuiGe;
    private String chpShuXing;
    private String areaCode;
    private String storeCode;
}
