package com.tjut.receive.model.dto;

import lombok.Data;

@Data
public class GoodType {

    /**
     * 发货频率
     */
    private int outFrequency;
    /**
     * 商品大类
     */
    private String Type;
}
