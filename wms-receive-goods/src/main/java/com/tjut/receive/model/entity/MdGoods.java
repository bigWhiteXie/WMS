package com.tjut.receive.model.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("商品实体类")
public class MdGoods implements Serializable {

    private static final long serialVersionUID = 1L;

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
    @ExcelProperty("创建日期")
    @ApiModelProperty(hidden = true)
    private LocalDateTime createDate;

    /**
     * 更新人名称
     */
    @ApiModelProperty(hidden = true)
    private String updateName;

    /**
     * 更新人登录名称
     */
    @ApiModelProperty(hidden = true)
    private String updateBy;

    /**
     * 更新日期
     */
    @ApiModelProperty(hidden = true)
    private LocalDateTime updateDate;

    /**
     * 所属部门
     */
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
    private String suoShuSup;

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
    @ExcelProperty(value = {"商品信息","计费商品类"})
    @ApiModelProperty(value = "计费商品类")
    private String jfShpLei;

    /**
     * 商品品牌
     */
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

    @ExcelProperty("出货频率")
    @ApiModelProperty(value = "出货频率")
    private String pinLv;

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

    @ExcelIgnore
    @ApiModelProperty(value = "sku")
    private String sku;


}
