package com.tjut.shop.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("客户分页条件查询")
public class CusParam {


    @ApiModelProperty("主键")
    private String id;
    /**
     * 创建人名称
     */
    @ApiModelProperty("创建人名称")
    private String createName;
    /**
     * 创建人登录名称
     */
    @ApiModelProperty("创建人登录名称")
    private String createBy;
    /**
     * 创建日期
     */
    @ApiModelProperty("创建日期")
    private Date createDate;
    /**
     * 更新人名称
     */
    @ApiModelProperty("更新人名称")
    private String updateName;
    /**
     * 更新人登录名称
     */
    @ApiModelProperty("更新人登录名称")
    private String updateBy;
    /**
     * 更新日期
     */
    @ApiModelProperty("更新日期")
    private Date updateDate;
    /**
     * 中文全称
     */
    @ApiModelProperty("中文全称")
    private String zhongWenQch;
    /**
     * 客户简称
     */
    @ApiModelProperty("客户简称")
    private String keHuJianCheng;
    /**
     * 客户编码
     */
    @ApiModelProperty("客户编码")
    private String keHuBianMa;
    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String diZhi;
    /**
     * 邮政编码
     */
    @ApiModelProperty("邮政编码")
    private String youZhengBianMa;
    /**
     * 主联系人
     */
    @ApiModelProperty("主联系人")
    private String zhuLianXiRen;
    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String dianHua;
    /**
     * 手机
     */
    @ApiModelProperty("手机")
    private String shouJi;
    /**
     * 传真
     */
    @ApiModelProperty("传真")
    private String chuanZhen;
    /**
     * Email地址
     */

    @ApiModelProperty("Email地址")
    private String emaildiZhi;
    /**
     * 注册日期
     */
    @ApiModelProperty("注册日期")
    private Date zhuCeRiQi;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String beiZhu;





}
