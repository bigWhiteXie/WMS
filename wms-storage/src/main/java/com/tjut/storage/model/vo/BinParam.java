package com.tjut.storage.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("储位信息")
public class BinParam implements Serializable {

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
     * 仓库
     */
    @ApiModelProperty("仓库")
    private String binStore;

    /**
     * x坐标
     */
    @ApiModelProperty("x坐标")
    private String x;

    /**
     * y坐标
     */
    @ApiModelProperty("y坐标")
    private String y;

    /**
     * z坐标
     */
    @ApiModelProperty("z坐标")
    private String z;
}
