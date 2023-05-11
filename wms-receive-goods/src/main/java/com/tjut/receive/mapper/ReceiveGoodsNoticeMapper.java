package com.tjut.receive.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tjut.receive.model.dto.GoodType;
import com.tjut.receive.model.entity.WmInNotice;
import org.springframework.stereotype.Component;

@Component
public interface ReceiveGoodsNoticeMapper extends BaseMapper<WmInNotice> {

    String getEmptyStorage(GoodType goodType);
}
