package com.tjut.receive.service.Imp;

import com.tjut.receive.mapper.ReceiveGoodsMapper;
import com.tjut.receive.model.dto.GoodType;
import com.tjut.receive.model.dto.NoticeReceiptDto;
import com.tjut.receive.model.dto.QueryReceiptDto;
import com.tjut.receive.model.dto.ReceiptDto;
import com.tjut.receive.model.entity.WmIn;
import com.tjut.receive.service.ReceiveGoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiveGoodsServiceImpl implements ReceiveGoodsService {

    @Autowired
    ReceiveGoodsMapper receiveGoodsMapper;

    /**
     * 查询入库单
     * @param queryReceiptDto 查询条件
     * @return 入库单信息
     */
    @Override
    public List<ReceiptDto> getReceipt(QueryReceiptDto queryReceiptDto) {
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
     * 创建入库通知单
     * @param receiptDto 入库单信息
     * @return 插入是否成功
     */
    @Override
    public boolean createInNoticeReceipt(ReceiptDto receiptDto) {
        // 创建入库通知单实体类
        NoticeReceiptDto noticeReceiptDto = new NoticeReceiptDto();
        //获取推荐库位
        String emptyStorage = getStorage(receiptDto.getGoodsCode());
        //向数据库插入库通知单 todo
        return true;
    }

    /**
     * 推荐库位
     * @param goodCode 商品编码
     * @return
     */
    public String getStorage(String goodCode){
        //查询商品的出货频率和分类
        GoodType goodType = getGoodType(goodCode);
        //根据出货频率和商品种类查询可用库位
        String emptyStorage = getEmptyStorage(goodType.getType(), goodType.getOutFrequency());
        return emptyStorage;
    }

    /**
     * 根据出货频率和商品种类查询可用库位 todo
     * @param type 商品种类
     * @param outFrequency 出货频率
     * @return 可用库位
     */
    private String getEmptyStorage(String type, int outFrequency) {
        return null;
    }

    /**
     * 查询商品的出货频率和分类 todo
     * @param goodCode 商品编码
     * @return 商品的出货频率和分类
     */
    private GoodType getGoodType(String goodCode) {
        return null;
    }
}
