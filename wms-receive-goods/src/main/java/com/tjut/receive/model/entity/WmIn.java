package com.tjut.receive.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("wm_in")
public class WmIn {

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
   * 入库单号
   */
  private String imNoticeId;
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
