package com.tjut.receive.controller;

import com.tjut.receive.model.dto.GoodType;
import com.tjut.receive.model.dto.QueryReceiptDto;
import com.tjut.receive.model.dto.ReceiptDto;
import com.tjut.receive.service.ReceiveGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("inWarehouse")
public class ReceiveGoodsController {

    @Autowired
    ReceiveGoodsService receiveGoodsService;

    /**
     * 分页查询入库单
     * @param queryReceiptDto
     * @return
     */
    @PostMapping("/receipt")
    public List<ReceiptDto> getReceipt(@RequestBody QueryReceiptDto queryReceiptDto){
        return receiveGoodsService.getReceipt(queryReceiptDto);
    }

    /**
     * 创建入库通知单
     * @param receiptDto 入库单信息
     * @return 创建是否成功
     */
    public boolean createInNoticeReceipt(ReceiptDto receiptDto){
        return receiveGoodsService.createInNoticeReceipt(receiptDto);
    }
}
