package com.tjut.shop.model.po;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import com.tjut.shop.annotation.ExcelMerge;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author codeXie
 */
@Data
@TableName("md_goods")
@ApiModel("商品实体类")
public class MdGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelIgnore
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(hidden = true)
    private String id;

    /**
     * 创建人名称
     */
    @ExcelProperty("创建人名称")
    @ApiModelProperty(hidden = true)
    private String createName;

    /**
     * 创建人登录名称
     */
    @ExcelProperty("登录名称")
    @ApiModelProperty(hidden = true)
    private String createBy;

    /**
     * 创建日期
     */
    @TableField(fill = FieldFill.INSERT)
    @ExcelProperty("创建日期")
    @ApiModelProperty(hidden = true)
    private LocalDateTime createDate;

    /**
     * 更新人名称
     */
    @ExcelProperty("更新人名称")
    @ApiModelProperty(hidden = true)
    private String updateName;

    /**
     * 更新人登录名称
     */
    @ExcelProperty("创建人登录名称")
    @ApiModelProperty(hidden = true)
    private String updateBy;

    /**
     * 更新日期
     */
    @ExcelProperty("更新日期")
    @ApiModelProperty(hidden = true)
    private LocalDateTime updateDate;

    /**
     * 所属部门
     */
    @ExcelProperty("所属部门")
    @ApiModelProperty(value = "所属部门")
    private String sysOrgCode;

    /**
     * 所属公司
     */
    @ExcelProperty("所属公司代码")
    @ApiModelProperty(value = "所属公司代码")
    private String sysCompanyCode;

    /**
     * 所属客户
     */
    @ExcelProperty("所属客户")
    @ApiModelProperty(value = "所属客户")
    private String suoShuKeHu;

    /**
     * 商品名称
     */
    @ExcelProperty("商品名称")
    @ApiModelProperty(value = "商品名称")
    private String shpMingCheng;

    /**
     * 商品简称
     */
    @ExcelProperty("商品简称")
    @ApiModelProperty(value = "商品简称")
    private String shpJianCheng;

    /**
     * 商品编码
     */
    @ExcelProperty("商品编码")
    @ApiModelProperty(value = "商品编码")
    private String shpBianMa;

    /**
     * 商品型号
     */
    @ExcelProperty("商品型号")
    @ApiModelProperty(value = "商品型号")
    private String shpXingHao;

    /**
     * 商品规格
     */
    @ExcelProperty("商品规格")
    @ApiModelProperty(value = "商品规格")
    private String shpGuiGe;

    /**
     * 商品颜色
     */
    @ExcelProperty("商品颜色")
    @ApiModelProperty(value = "商品颜色")
    private String shpYanSe;

    /**
     * 产品属性
     */
    @ExcelProperty("产品属性")
    @ApiModelProperty(value = "产品属性")
    private String chpShuXing;

    /**
     * 产品大类
     */
    @ExcelProperty("产品大类")
    @ApiModelProperty(value = "产品大类")
    private String cfWenCeng;

    /**
     * 拆零控制
     */
    @ExcelProperty("拆零控制")
    @ApiModelProperty(value = "拆零控制")
    private String chlKongZhi;

    /**
     * 码盘单层数量
     */
    @ExcelProperty("码盘单层数量")
    @ApiModelProperty(value = "码盘单层数量")
    private String mpDanCeng;

    /**
     * 码盘层高
     */
    @ExcelProperty("码盘层高")
    @ApiModelProperty(value = "码盘层高")
    private String mpCengGao;

    /**
     * 计费商品类
     */
    @ExcelMerge(merge = true)
    @ExcelProperty(value = {"商品信息","计费商品类"})
    @ApiModelProperty(value = "计费商品类")
    private String jfShpLei;

    /**
     * 商品品牌
     */
    @ExcelMerge(merge = true)
    @ExcelProperty(value = {"商品信息","商品品牌"})
    @ApiModelProperty(value = "商品品牌")
    private String shpPinPai;

    /**
     * 商品条码
     */
    @ExcelProperty("商品条码")
    @ApiModelProperty(value = "商品条码")
    private String shpTiaoMa;

    /**
     * 品牌图片
     */
    @ExcelProperty("品牌图片")
    private String ppTuPian;

    /**
     * 保质期
     */
    @ExcelProperty("保质期")
    @ApiModelProperty(value = "保质期")
    private String bzhiQi;

    /**
     * 单位
     */
    @ExcelProperty("单位")
    @ApiModelProperty(value = "单位")
    private String shlDanWei;

    /**
     * 拆零单位
     */
    @ExcelProperty("拆零单位")
    @ApiModelProperty(value = "拆零单位")
    private String jshDanWei;

    /**
     * 体积
     */
    @ExcelProperty("体积")
    @ApiModelProperty(value = "体积")
    private String tiJiCm;

    /**
     * 净重
     */
    @ExcelProperty("净重")
    @ApiModelProperty(value = "净重")
    private String zhlKg;

    /**
     * 拆零数量
     */
    @ExcelProperty("拆零数量")
    @ApiModelProperty(value = "拆零数量")
    private String chlShl;

    /**
     * 件数与体积比
     */
    @ExcelProperty("件数与体积比")
    @ApiModelProperty(value = "件数与体积比")
    private String jtiJiBi;

    /**
     * 件数与毛重比
     */
    @ExcelProperty("件数与毛重比")
    @ApiModelProperty(value = "件数与毛重比")
    private String jmZhongBi;

    /**
     * 件数与净重比
     */
    @ExcelProperty("件数与净重比")
    @ApiModelProperty(value = "件数与净重比")
    private String jjZhongBi;

    /**
     * 尺寸单位
     */
    @ExcelProperty("尺寸单位")
    @ApiModelProperty(value = "尺寸单位")
    private String chcDanWei;

    /**
     * 长单品
     */
    @ExcelProperty("长单品")
    @ApiModelProperty(value = "长单品")
    private String chDanPin;

    /**
     * 宽单品
     */
    @ExcelProperty("宽单品")
    @ApiModelProperty(value = "宽单品")
    private String kuDanPin;

    /**
     * 高单品
     */
    @ExcelProperty("高单品")
    @ApiModelProperty(value = "高单品")
    private String gaoDanPin;

    /**
     * 长整箱
     */
    @ExcelProperty("长整箱")
    @ApiModelProperty(value = "长")
    private String chZhXiang;

    /**
     * 宽整箱
     */
    @ExcelProperty("宽整箱")
    @ApiModelProperty(value = "宽")
    private String kuZhXiang;

    /**
     * 高整箱
     */
    @ExcelProperty("高整箱")
    @ApiModelProperty(value = "高")
    private String gaoZhXiang;

    /**
     * 商品描述
     */
    @ExcelProperty("商品描述")
    @ApiModelProperty(value = "商品描述")
    private String shpMiaoShu;

    /**
     * 停用
     */
    @ExcelProperty("状态")
    private String zhuangTai;

    /**
     * 毛重
     */
    @ExcelProperty("毛重")
    @ApiModelProperty(value = "毛重")
    private String zhlKgm;

    /**
     * 商品客户编码
     */
    @ExcelProperty("商品客户编码")
    @TableField("SHP_BIAN_MAKH")
    @ApiModelProperty(value = "商品客户编码")
    private String shpBianMakh;

    /**
     * 基准温度
     */
    @TableField("JIZHUN_WENDU")
    private String jizhunWendu;

    @ExcelIgnore
    @ApiModelProperty(hidden = true)
    private String ywMingCheng;

    @ExcelIgnore
    @ApiModelProperty(hidden = true)
    private String rwMingCheng;

    /**
     * 客户名称
     */
    @ExcelProperty("所属货主")
    @ApiModelProperty(value = "所属货主")
    private String cusName;

    @ExcelIgnore
    @ApiModelProperty(hidden = true)
    private String peisongdian;

    /**
     * 分类
     */
    @ExcelProperty("分类代码")
    @ApiModelProperty(value = "商品类目")
    private String categoryCode;

    @ExcelIgnore
    private String categoryId;

    @ExcelIgnore
    @ApiModelProperty(value = "最小库存")
    private String minStock;

    @ExcelIgnore
    @ApiModelProperty(value = "sku")
    private String sku;


}
