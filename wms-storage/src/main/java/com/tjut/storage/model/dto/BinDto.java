package com.tjut.storage.model.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 储位DTO
 * @author codeXie
 */
@Data
@ApiModel("储位DTO")
public class BinDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 所属部门
     */
    @ApiModelProperty(value = "所属部门",required = true)
    private String sysOrgCode;

    /**
     * 所属客户
     */
    @ApiModelProperty("所属客户")
    private String sysCompanyCode;

    /**
     * 库位名称
     */
    @ApiModelProperty("库位名称")
    private String kuWeiMingCheng;

    /**
     * 库位编码
     */
    @ApiModelProperty("库位编码")
    private String kuWeiBianMa;

    /**
     * 库位条码
     */
    @ApiModelProperty("库位条码")
    private String kuWeiTiaoMa;

    /**
     * 库位类型
     */
    @ApiModelProperty("库位类型")
    private String kuWeiLeiXing;

    /**
     * 库位属性
     */
    @ApiModelProperty("库位属性")
    private String kuWeiShuXing;

    /**
     * 上架次序
     */
    @ApiModelProperty("上架次序")
    private String shangJiaCiXu;

    /**
     * 取货次序
     */
    @ApiModelProperty("取货次序")
    private String quHuoCiXu;

    /**
     * 体积单位
     */
    @ApiModelProperty("体积单位")
    private String tiJiDanWei;

    /**
     * 重量单位
     */
    @ApiModelProperty("重量单位")
    private String zhongLiangDanWei;

    /**
     * 最大体积
     */
    @ApiModelProperty("最大体积")
    private String zuiDaTiJi;

    /**
     * 最大重量
     */
    @ApiModelProperty("最大重量")
    private String zuiDaZhongLiang;

    /**
     * 最大托盘
     */
    @ApiModelProperty("最大托盘")
    private String zuiDaTuoPan;

    /**
     * 长度
     */
    @ApiModelProperty("长度")
    private String chang;

    /**
     * 宽度
     */
    @ApiModelProperty("宽度")
    private String kuan;

    /**
     * 高度
     */
    @ApiModelProperty("高度")
    private String gao;

    /**
     * 停用
     */
    @ApiModelProperty("是否停用：0 初始化、1 没停用、2 停用")
    private String tingYong;

    /**
     * 仓库
     */
    @ApiModelProperty("仓库")
    private String binStore;

    /**
     * 产品属性
     */
    @ApiModelProperty("产品属性")
    private String goodsType;

    /**
     * 可用体积
     */
    @ApiModelProperty("可用体积")
    private Integer useVolume;

    /**
     * 可用重量
     */
    @ApiModelProperty("可用重量")
    private Integer useWeight;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String goodName;

    /**
     * 商品编码
     */
    @ApiModelProperty("商品编码")
    private String goodCode;

    /**
     * x坐标
     */
    @ApiModelProperty("x")
    private String x;

    /**
     * y坐标
     */
    @ApiModelProperty("y")
    private String y;

    /**
     * z坐标
     */
    @ApiModelProperty("z")
    private String z;


}
