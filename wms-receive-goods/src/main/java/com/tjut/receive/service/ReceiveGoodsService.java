package com.tjut.receive.service;

import com.tjut.receive.model.dto.QueryReceiptDto;
import com.tjut.receive.model.dto.ReceiptDto;
import com.tjut.receive.model.entity.WmIn;

import java.util.List;

public interface ReceiveGoodsService {

    List<ReceiptDto> getReceipt(QueryReceiptDto queryReceiptDto);


    int createReceipt(ReceiptDto receiptDto);

    int updateReceipt(WmIn wmIn);

}
