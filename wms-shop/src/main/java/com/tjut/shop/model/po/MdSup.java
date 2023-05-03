package com.tjut.shop.model.po;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author qwh12138
 */

@Data
@TableName("md_sup")
@ApiModel("供应商实体类")
public class MdSup implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
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
     * 中文全称
     */
    @ExcelProperty("中文全称")
    @ApiModelProperty(value = "中文全称")
     private String zhongWenQch;

    /**
     * 助记码
     */
    @ExcelProperty("助记码")
    @ApiModelProperty(value = "助记码")
    private String zhuJiMa;

    /**
     * 供应商简称
     */
    @ExcelProperty("供应商简称")
    @ApiModelProperty(value = "供应商简称")
    private String gysJianCheng;

    /**
     * 供应商编码
     */
    @ExcelProperty("供应商编码")
    @ApiModelProperty(value = "供应商编码")
    private String gysBianMa;

    /**
     * 供应商英文名称
     */
    @ExcelProperty("供应商英文名称")
    @ApiModelProperty(value = "供应商英文名称")
    private String gysYingWen;

    /**
     * 曾用企业代码
     */
    @ExcelProperty("曾用企业代码")
    @ApiModelProperty(value = "曾用企业代码")
    private String zengYongQi;

    /**
     * 曾用企业名称
     */
    @ExcelProperty("曾用企业名称")
    @ApiModelProperty(value = "曾用企业名称")
    private String zengYongQiYe;

    /**
     * 停用
     */
    @ExcelProperty("供应商状态")
    @ApiModelProperty(value = "供应商状态")
    private String gysZhuangTai;

    /**
     * 企业属性
     */
    @ExcelProperty("企业属性")
    @ApiModelProperty(value = "企业属性")
    private String xingYeFenLei;

    /**
     * 供应商等级
     */
    @ExcelProperty("供应商等级")
    @ApiModelProperty(value = "供应商等级")
    private String gysDengJi;

    /**
     * 所属行业
     */
    @ExcelProperty("所属行业")
    @ApiModelProperty(value = "所属行业")
    private String suoShuXingYe;

    /**
     * 首签日期
     */
    @ExcelProperty("首签日期")
    @ApiModelProperty(value = "首签日期")
    private LocalDateTime shouQianRiQi;

    /**
     * 终止合作时间
     */
    @ExcelProperty("终止合作时间")
    @ApiModelProperty(value = "终止合作时间")
    private LocalDateTime zhongZhiHeShiJian;

    /**
     * 申请时间
     */
    @ExcelProperty("申请时间")
    @ApiModelProperty(value = "申请时间")
    private LocalDateTime shenQingShiJian;

    /**
     * 供应商属性
     */
    @ExcelProperty("供应商属性")
    @ApiModelProperty(value = "供应商属性")
    private String gysShuXing;

    /**
     * 归属组织代码
     */
    @ExcelProperty("归属组织代码")
    @ApiModelProperty(value = "归属组织代码")
    private String guiShuZuZh;

    /**
     * 归属省份代码
     */
    @ExcelProperty("归属省份代码")
    @ApiModelProperty(value = "归属省份代码")
    private String guiShuSheng;

    /**
     * 归属市代码
     */
    @ExcelProperty("归属市代码")
    @ApiModelProperty(value = "归属市代码")
    private String guiShuShiDai;

    /**
     * 归属县区代码
     */
    @ExcelProperty("归属县区代码")
    @ApiModelProperty(value = "归属县区代码")
    private String guiShu;

    /**
     * 地址
     */
    @ExcelProperty("地址")
    @ApiModelProperty(value = "地址")
    private String diZhi;

    /**
     * 邮政编码
     */
    @ExcelProperty("邮政编码")
    @ApiModelProperty(value = "邮政编码")
    private String youZhengBianMa;

    /**
     * 主联系人
     */
    @ExcelProperty("主联系人")
    @ApiModelProperty(value = "主联系人")
    private String zhuLianXiRen;

    /**
     * 电话
     */
    @ExcelProperty("电话")
    @ApiModelProperty(value = "电话")
    private String dianHua;

    /**
     * 手机
     */
    @ExcelProperty("手机")
    @ApiModelProperty(value = "手机")
    private String shouJi;

    /**
     * 传真
     */
    @ExcelProperty("传真")
    @ApiModelProperty(value = "传真")
    private String chuanZhen;

    /**
     * Email地址
     */
    @ExcelProperty("Email地址")
    @ApiModelProperty(value = "Email地址")
    private String EmaildiZhi;

    /**
     * 网页地址
     */
    @ExcelProperty("网页地址")
    @ApiModelProperty(value = "网页地址")
    private String wangYeDiZhi;

    /**
     * 法人代表
     */
    @ExcelProperty("法人代表")
    @ApiModelProperty(value = "法人代表")
    private String faRenDaiBiao;

    /**
     * 法人身份证号
     */
    @ExcelProperty("法人身份证号")
    @ApiModelProperty(value = "法人身份证号")
    private String faRenShenFen;

    /**
     * 注册资金万元
     */
    @ExcelProperty("注册资金万元")
    @ApiModelProperty(value = "注册资金万元")
    private String zhuCeZiJin;

    /**
     * 币别
     */
    @ExcelProperty("币别")
    @ApiModelProperty(value = "币别")
    private String biBie;

    /**
     * 营业执照号
     */
    @ExcelProperty("营业执照号")
    @ApiModelProperty(value = "营业执照号")
    private String yingYeZhiZhao;

    /**
     * 税务登记证号
     */
    @ExcelProperty("税务登记证号")
    @ApiModelProperty(value = "税务登记证号")
    private String shuiWuDeng;

    /**
     * 组织机构代码证
     */
    @ExcelProperty("组织机构代码证")
    @ApiModelProperty(value = "组织机构代码证")
    private String zuZhiJiGou;

    /**
     * 道路运输经营许可证
     */
    @ExcelProperty("道路运输经营许可证")
    @ApiModelProperty(value = "道路运输经营许可证")
    private String daoLuYunShu;

    /**
     * 主营业务
     */
    @ExcelProperty("主营业务")
    @ApiModelProperty(value = "主营业务")
    private String zhuYingYeWu;

    /**
     *  合作意向
     */
    @ExcelProperty("合作意向")
    @ApiModelProperty(value = "合作意向")
    private String heYiXiang;

    /**
     * 批准机关
     */
    @ExcelProperty("批准机关")
    @ApiModelProperty(value = "批准机关")
    private String piZhunJiGuan;

    /**
     *  批准文号
     */
    @ExcelProperty("批准文号")
    @ApiModelProperty(value = "批准文号")
    private String piZhunWenHao;

    /**
     * 注册日期
     */
    @ExcelProperty("注册日期")
    @ApiModelProperty(value = "注册日期")
    private LocalDateTime zhuCeRiQi ;

    /**
     * 备注
     */
    @ExcelProperty("备注")
    @ApiModelProperty(value = "备注")
    private String beiZhu;


}
