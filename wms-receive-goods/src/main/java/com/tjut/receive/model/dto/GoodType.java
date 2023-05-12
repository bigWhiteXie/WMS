package com.tjut.receive.model.dto;

import lombok.Data;

@Data
public class GoodType {

    /**
     * 发货频率
     */
    private String outFrequency;
    /**
     * 商品大类
     */
    private String type;

    /**
     * 商品净重
     */
    private int net;

    /**
     * 商品体积
     */
    private int volume;
}
