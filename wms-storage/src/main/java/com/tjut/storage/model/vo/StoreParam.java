package com.tjut.storage.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("仓库信息")
public class StoreParam implements Serializable {

    /**
     * 仓库代码
     */
    @ApiModelProperty("仓库代码")
    private String storeCode;

    /**
     * 仓库名称
     */
    @ApiModelProperty("仓库名称")
    private String storeName;
}
