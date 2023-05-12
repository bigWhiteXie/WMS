package com.tjut.receive.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 入库通知单
 */
@Data
@TableName("wm_in_notice")
public class WmInNotice {

  private String createName;
  private String createBy;
  private LocalDateTime createDate;
  private String updateName;
  private String updateBy;
  private LocalDateTime updateDate;
  private String imNoticeId;
  private String noticeId;
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
