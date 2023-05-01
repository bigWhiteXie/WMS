package com.tjut.receive.model.entity;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WmIn {

  /**
   * 入库单号
   */
  private String id;
  private String createName;
  private String createBy;
  private LocalDateTime createDate;
  private String updateName;
  private String updateBy;
  private LocalDateTime updateDate;
  private String sysOrgCode;
  private String sysCompanyCode;
  private LocalDateTime imData;
  private String imCarDri;
  private String imCarMobile;
  private String imCarNo;
  private String orderTypeCode;
  private String platformCode;
  private String imBeizhu;
  private String imSta;
  /**
   * 入库通知单号
   */
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
