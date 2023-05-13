package com.tjut.storage.model.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 储位定义
 * @author codeXie
 */
@Data
@TableName("md_bin")
public class MdBin implements Serializable {

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
     * 库位名称
     */
    @ExcelProperty("库位名称")
    private String kuWeiMingCheng;

    /**
     * 库位编码
     */
    @ExcelProperty("库位编码")
    private String kuWeiBianMa;

    /**
     * 库位条码
     */
    @ExcelProperty("库位条码")
    private String kuWeiTiaoMa;

    /**
     * 库位类型
     */
    @ExcelProperty("库位类型")
    private String kuWeiLeiXing;

    /**
     * 库位属性
     */
    @ExcelProperty("库位属性")
    private String kuWeiShuXing;

    /**
     * 上架次序
     */
    @ExcelProperty("上架次序")
    private String shangJiaCiXu;

    /**
     * 取货次序
     */
    @ExcelProperty("取货次序")
    private String quHuoCiXu;

    /**
     * 体积单位
     */
    @ExcelProperty("体积单位")
    private String tiJiDanWei;

    /**
     * 重量单位
     */
    @ExcelProperty("重量单位")
    private String zhongLiangDanWei;

    /**
     * 最大体积
     */
    @ExcelProperty("最大体积")
    private String zuiDaTiJi;

    /**
     * 最大重量
     */
    @ExcelProperty("最大重量")
    private String zuiDaZhongLiang;

    /**
     * 最大托盘
     */
    @ExcelProperty("最大托盘")
    private String zuiDaTuoPan;

    /**
     * 长度
     */
    @ExcelProperty("长度")
    private String chang;

    /**
     * 宽度
     */
    @ExcelProperty("宽度")
    private String kuan;

    /**
     * 高度
     */
    @ExcelProperty("高度")
    private String gao;

    /**
     * 停用
     */
    @ExcelProperty("停用")
    private String tingYong;

    /**
     * 仓库
     */
    @ExcelProperty("所属仓库")
    private String binStore;

    /**
     * 产品属性
     */
    @ExcelProperty("产品属性")
    private String goodsType;

    /**
     * 可用体积
     */
    @ExcelProperty("可用体积")
    private Integer useVolume;

    /**
     * 可用重量
     */
    @ExcelProperty("可用重量")
    private Integer useWeight;

    /**
     * 商品名称
     */
    @ExcelProperty("商品名称")
    private String goodName;

    /**
     * 商品编码
     */
    @ExcelProperty("商品编码")
    private String goodCode;

    /**
     * x坐标
     */
    @ExcelProperty("x坐标")
    private String x;

    /**
     * y坐标
     */
    @ExcelProperty("y坐标")
    private String y;

    /**
     * z坐标
     */
    @ExcelProperty("z坐标")
    private String z;


}
