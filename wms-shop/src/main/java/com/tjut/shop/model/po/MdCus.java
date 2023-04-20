package com.tjut.shop.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("md_cus")
public class MdCus implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
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
     * 中文全称
     */
    private String zhongWenQch;

    /**
     * 助记码
     */
    private String zhuJiMa;

    /**
     * 客户简称
     */
    private String keHuJianCheng;

    /**
     * 客户编码
     */
    private String keHuBianMa;

    /**
     * 客户英文名称
     */
    private String keHuYingWen;

    /**
     * 曾用企业代码
     */
    private String zengYongQi;

    /**
     * 曾用企业名称
     */
    private String zengYongQiYe;

    /**
     * 客户状态
     */
    private String keHuZhuangTai;

    /**
     * 企业属性
     */
    private String xingYeFenLei;

    /**
     * 客户等级
     */
    private String keHuDengJi;

    /**
     * 所属行业
     */
    private String suoShuXingYe;

    /**
     * 首签日期
     */
    private LocalDateTime shouQianRiQi;

    /**
     * 终止合作时间
     */
    private LocalDateTime zhongZhiHeShiJian;

    /**
     * 申请时间
     */
    private LocalDateTime shenQingShiJian;

    /**
     * 客户属性
     */
    private String keHuShuXing;

    /**
     * 归属组织代码
     */
    private String guiShuZuZh;

    /**
     * 归属省份代码
     */
    private String guiShuSheng;

    /**
     * 归属市代码
     */
    private String guiShuShiDai;

    /**
     * 归属县区代码
     */
    private String guiShu;

    /**
     * 地址
     */
    private String diZhi;

    /**
     * 邮政编码
     */
    private String youZhengBianMa;

    /**
     * 主联系人
     */
    private String zhuLianXiRen;

    /**
     * 电话
     */
    private String dianHua;

    /**
     * 手机
     */
    private String shouJi;

    /**
     * 传真
     */
    private String chuanZhen;

    /**
     * Email地址
     */
    @TableField("Emaildi_zhi")
    private String emaildiZhi;

    /**
     * 网页地址
     */
    private String wangYeDiZhi;

    /**
     * 法人代表
     */
    private String faRenDaiBiao;

    /**
     * 法人身份证号
     */
    private String faRenShenFen;

    /**
     * 注册资金万元
     */
    private String zhuCeZiJin;

    /**
     * 币别
     */
    private String biBie;

    /**
     * 营业执照号
     */
    private String yingYeZhiZhao;

    /**
     * 税务登记证号
     */
    private String shuiWuDeng;

    /**
     * 组织机构代码证
     */
    private String zuZhiJiGou;

    /**
     * 道路运输经营许可证
     */
    private String daoLuYunShu;

    /**
     * 主营业务
     */
    private String zhuYingYeWu;

    /**
     * 合作意向
     */
    private String heYiXiang;

    /**
     * 批准机关
     */
    private String piZhunJiGuan;

    /**
     * 批准文号
     */
    private String piZhunWenHao;

    /**
     * 注册日期
     */
    private LocalDateTime zhuCeRiQi;

    /**
     * 备注
     */
    private String beiZhu;

    /**
     * 联系人1
     */
    private String zhuLianXiRen1;

    /**
     * 电话1
     */
    private String dianHua1;


}
