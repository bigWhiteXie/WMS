package com.tjut.receive.service.Imp;

import com.tjut.receive.client.ShopClient;
import com.tjut.receive.mapper.ReceiveGoodsMapper;
import com.tjut.receive.mapper.ReceiveGoodsNoticeMapper;
import com.tjut.receive.model.dto.*;
import com.tjut.receive.model.entity.MdGoods;
import com.tjut.receive.model.entity.WmIn;
import com.tjut.receive.model.entity.WmInNotice;
import com.tjut.receive.service.ReceiveGoodsService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReceiveGoodsServiceImpl implements ReceiveGoodsService {

    @Autowired
    ReceiveGoodsMapper receiveGoodsMapper;

    @Autowired
    ReceiveGoodsNoticeMapper receiveGoodsNoticeMapper;

    /**
     * 分页查询入库单
     * @param queryReceiptDto 查询条件
     * @return 入库单信息
     */
    @Override
    public List<ReceiptDto> getReceipt(QueryReceiptDto queryReceiptDto) {
        queryReceiptDto.setNum((queryReceiptDto.getPage()-1)*queryReceiptDto.getSize());
        List<WmIn> receipts = receiveGoodsMapper.getReceipt(queryReceiptDto);
        List<ReceiptDto> list = new ArrayList<>();
        if (receipts.isEmpty()){
            return null;
        }
        for (WmIn r : receipts) {
            ReceiptDto receiptDto = new ReceiptDto();
            BeanUtils.copyProperties(r, receiptDto);
            list.add(receiptDto);
        }
        return list;
    }

    /**
     * 创建入库单
     * @param receiptDto 入库单dto
     * @return 是否创建成功
     */
    @Override
    public int createReceipt(ReceiptDto receiptDto) {
        WmIn wmIn = new WmIn();
        if (receiptDto != null){
            BeanUtils.copyProperties(receiptDto, wmIn);
        }
        wmIn.setCreateName("龚宸");
        wmIn.setCreateDate(LocalDateTime.now());
        wmIn.setCreateBy("admin");
        wmIn.setUpdateDate(LocalDateTime.now());
        return receiveGoodsMapper.insert(wmIn);
    }

    /**
     * 更新入库单
     * @param wmIn 入库单实体类
     * @return 是否更新成功
     */
    @Override
    @Transactional
    public int updateReceipt(@NotNull WmIn wmIn) {
        if (wmIn.getImSta().equals("已完成")){
            WmInNotice wmInNotice = new WmInNotice();
            BeanUtils.copyProperties(wmIn,wmInNotice);
            wmInNotice.setCreateName("龚宸");
            wmInNotice.setCreateBy("admin");
            wmInNotice.setCreateDate(LocalDateTime.now());
            wmInNotice.setUpdateName("龚宸");
            wmInNotice.setUpdateBy("admin");
            wmInNotice.setUpdateDate(LocalDateTime.now());
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            wmInNotice.setNoticeId(uuid);
            //创建入库通知单
            receiveGoodsNoticeMapper.insert(wmInNotice);
        }
        //更新入库单状态
        return receiveGoodsMapper.updateById(wmIn);
    }
}
