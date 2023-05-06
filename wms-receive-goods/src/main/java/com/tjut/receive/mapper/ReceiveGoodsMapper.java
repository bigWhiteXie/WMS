package com.tjut.receive.mapper;

import com.tjut.receive.model.dto.GoodType;
import com.tjut.receive.model.dto.QueryReceiptDto;
import com.tjut.receive.model.entity.WmIn;
import com.tjut.receive.model.entity.WmInNotice;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReceiveGoodsMapper {
    List<WmIn> getReceipt(QueryReceiptDto queryReceiptDto);

    boolean createInNoticeReceipt(WmInNotice wmInNotice);

    String getEmptyStorage(GoodType goodType);
}
