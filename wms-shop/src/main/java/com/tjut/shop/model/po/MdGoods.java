package com.tjut.shop.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("md_goods")
@ApiModel("客户类")
public class MdGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("客户id")
    private String id;

    /**
     * 创建人名称
     */
    private String createName;

    /**
     * 创建人登录名称
     */
    private String createBy;

    /**
     * 创建日期
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 更新人名称
     */
    private String updateName;

    /**
     * 更新人登录名称
     */
    private String updateBy;

    /**
     * 更新日期
     */
    private LocalDateTime updateDate;

    /**
     * 所属部门
     */
    private String sysOrgCode;

    /**
     * 所属公司
     */
    private String sysCompanyCode;

    /**
     * 所属客户
     */
    private String suoShuKeHu;

    /**
     * 商品名称
     */
    private String shpMingCheng;

    /**
     * 商品简称
     */
    private String shpJianCheng;

    /**
     * 商品编码
     */
    private String shpBianMa;

    /**
     * 商品型号
     */
    private String shpXingHao;

    /**
     * 商品规格
     */
    private String shpGuiGe;

    /**
     * 商品颜色
     */
    private String shpYanSe;

    /**
     * 产品属性
     */
    private String chpShuXing;

    /**
     * 产品大类
     */
    private String cfWenCeng;

    /**
     * 拆零控制
     */
    private String chlKongZhi;

    /**
     * 码盘单层数量
     */
    private String mpDanCeng;

    /**
     * 码盘层高
     */
    private String mpCengGao;

    /**
     * 计费商品类
     */
    private String jfShpLei;

    /**
     * 商品品牌
     */
    private String shpPinPai;

    /**
     * 商品条码
     */
    private String shpTiaoMa;

    /**
     * 品牌图片
     */
    private String ppTuPian;

    /**
     * 保质期
     */
    private String bzhiQi;

    /**
     * 单位
     */
    private String shlDanWei;

    /**
     * 拆零单位
     */
    private String jshDanWei;

    /**
     * 体积
     */
    private String tiJiCm;

    /**
     * 净重
     */
    private String zhlKg;

    /**
     * 拆零数量
     */
    private String chlShl;

    /**
     * 件数与体积比
     */
    private String jtiJiBi;

    /**
     * 件数与毛重比
     */
    private String jmZhongBi;

    /**
     * 件数与净重比
     */
    private String jjZhongBi;

    /**
     * 尺寸单位
     */
    private String chcDanWei;

    /**
     * 长单品
     */
    private String chDanPin;

    /**
     * 宽单品
     */
    private String kuDanPin;

    /**
     * 高单品
     */
    private String gaoDanPin;

    /**
     * 长整箱
     */
    private String chZhXiang;

    /**
     * 宽整箱
     */
    private String kuZhXiang;

    /**
     * 高整箱
     */
    private String gaoZhXiang;

    /**
     * 商品描述
     */
    private String shpMiaoShu;

    /**
     * 停用
     */
    private String zhuangTai;

    /**
     * 毛重
     */
    private String zhlKgm;

    /**
     * 商品客户编码
     */
    @TableField("SHP_BIAN_MAKH")
    private String shpBianMakh;

    /**
     * 基准温度
     */
    @TableField("JIZHUN_WENDU")
    private String jizhunWendu;

    private String ywMingCheng;

    private String rwMingCheng;

    /**
     * 客户名称
     */
    private String cusName;

    private String peisongdian;

    /**
     * 分类
     */
    private String categoryCode;

    private String categoryId;

    private String minStock;

    private String sku;


}
