package com.tjut.receive.service;

import com.tjut.receive.model.dto.QueryReceiptDto;
import com.tjut.receive.model.dto.ReceiptDto;

import java.util.List;

public interface ReceiveGoodsService {

    List<ReceiptDto> getReceipt(QueryReceiptDto queryReceiptDto);

    boolean createInNoticeReceipt(ReceiptDto receiptDto);
}
