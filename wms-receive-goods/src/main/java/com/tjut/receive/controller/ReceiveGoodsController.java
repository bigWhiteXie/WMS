package com.tjut.receive.controller;

import com.tjut.receive.model.dto.GoodType;
import com.tjut.receive.model.dto.QueryReceiptDto;
import com.tjut.receive.model.dto.ReceiptDto;
import com.tjut.receive.model.entity.WmIn;
import com.tjut.receive.service.ReceiveGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.temporal.ValueRange;
import java.util.*;

@RestController
@RequestMapping("/in")
@Api(tags = "收货")
public class ReceiveGoodsController {

    @Autowired
    ReceiveGoodsService receiveGoodsService;

    /**
     * 分页查询入库单
     * @param queryReceiptDto 查询条件
     * @return 入库单集合
     */
    @ApiOperation("分页查询入库单")
    @PostMapping("/receipts")
    public List<ReceiptDto> getReceipt(@RequestBody QueryReceiptDto queryReceiptDto){
        return receiveGoodsService.getReceipt(queryReceiptDto);
    }

    /**
     * 创建入库单
     * @return 插入是否成功
     */
    @ApiOperation("创建入库单")
    @PostMapping("/receipt")
    public int createReceipt(@RequestBody ReceiptDto receiptDto){
        return receiveGoodsService.createReceipt(receiptDto);
    }

    /**
     * 点击收货，更新入库单状态，创建入库通知单
     * @param wmIn 入库单
     * @return 是否更新成功
     */
    @ApiOperation("更新入库单状态，创建入库通知单")
    @PostMapping("/update/receipt")
    public int updateReceipt(@RequestBody WmIn wmIn){
        QueryReceiptDto queryReceiptDto = new QueryReceiptDto();
        queryReceiptDto.setImNoticeId("QSD123");
        queryReceiptDto.setImData("2023-05-07 13:02:07");
        List<ReceiptDto> receipt = receiveGoodsService.getReceipt(queryReceiptDto);
        if (receipt.get(0) != null){
            BeanUtils.copyProperties(receipt.get(0),wmIn);
        }
        wmIn.setImSta("已完成");
        return receiveGoodsService.updateReceipt(wmIn);
    }

}
