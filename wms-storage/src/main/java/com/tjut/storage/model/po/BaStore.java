package com.tjut.storage.model.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@TableName("ba_store")
public class BaStore implements Serializable{

  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @TableId(type = IdType.ASSIGN_ID)
  private String id;

  /**
   * 创建人名称
   */
  @ExcelProperty("创建人名称")
  private String createName;

  /**
   * 创建人登录名称
   */
  private String createBy;

  /**
   * 创建日期
   */
  @TableField(fill = FieldFill.INSERT)
  @ExcelProperty("创建日期")
  private LocalDateTime createDate;

  /**
   * 更新人名称
   */
  @ExcelProperty("更新人名称")
  private String updateName;

  /**
   * 更新人登录名称
   */
  private String updateBy;

  /**
   * 更新日期
   */
  @ExcelProperty("更新日期")
  @TableField(fill = FieldFill.UPDATE)
  private LocalDateTime updateDate;

  /**
   * 所属部门
   */
  @ExcelProperty("所属部门编码")
  private String sysOrgCode;

  /**
   * 所属公司
   */
  @ExcelProperty("所属公司编码")
  private String sysCompanyCode;

  /**
   * 仓库代码
   */
  @ExcelProperty("仓库代码")
  private String storeCode;

  /**
   * 仓库名称
   */
  @ExcelProperty("仓库名称")
  private String storeName;

  /**
   * 仓库属性
   */
  @ExcelProperty("仓库属性")
  private String storeText;
}
