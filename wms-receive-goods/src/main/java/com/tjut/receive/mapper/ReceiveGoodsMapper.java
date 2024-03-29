package com.tjut.receive.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tjut.receive.model.dto.GoodType;
import com.tjut.receive.model.dto.QueryReceiptDto;
import com.tjut.receive.model.entity.WmIn;
import com.tjut.receive.model.entity.WmInNotice;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReceiveGoodsMapper extends BaseMapper<WmIn> {
    List<WmIn> getReceipt(QueryReceiptDto queryReceiptDto);

}
