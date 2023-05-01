package com.tjut.receive.service;

import com.tjut.receive.model.dto.QueryReceiptDto;
import com.tjut.receive.model.dto.ReceiptDto;

import java.util.List;

public interface ReceiveGoodsService {

    public List<ReceiptDto> getReceipt(QueryReceiptDto queryReceiptDto);

    public boolean createInNoticeReceipt(ReceiptDto receiptDto);
}
