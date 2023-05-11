package com.tjut.receive.service;

import com.tjut.receive.model.dto.QueryReceiptDto;
import com.tjut.receive.model.entity.WmInNotice;

import java.util.List;

public interface ReceiveGoodsNoticeService {
    int updateInNoticeReceipt(WmInNotice wmInNotice);

    List<WmInNotice> getNoticeReceiptByImNoticeId(QueryReceiptDto queryReceiptDto);

    String getStorage(String goodCode);
}
