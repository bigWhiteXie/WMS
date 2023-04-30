package com.tjut.receive.mapper;

import com.tjut.receive.model.dto.QueryReceiptDto;
import com.tjut.receive.model.entity.WmIn;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReceiveGoodsMapper {
    public List<WmIn> getReceipt(QueryReceiptDto queryReceiptDto);
}
