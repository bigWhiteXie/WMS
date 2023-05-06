package com.tjut.receive.service.Imp;

import com.tjut.receive.client.ShopClient;
import com.tjut.receive.mapper.ReceiveGoodsMapper;
import com.tjut.receive.model.dto.*;
import com.tjut.receive.model.entity.MdGoods;
import com.tjut.receive.model.entity.WmIn;
import com.tjut.receive.model.entity.WmInNotice;
import com.tjut.receive.service.ReceiveGoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReceiveGoodsServiceImpl implements ReceiveGoodsService {

    @Autowired
    ReceiveGoodsMapper receiveGoodsMapper;

    @Autowired
    ShopClient shopClient;
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
        // 创建入库通知单dto实体类
        NoticeReceiptDto noticeReceiptDto = new NoticeReceiptDto();
        if (receiptDto != null){
            BeanUtils.copyProperties(receiptDto,noticeReceiptDto);
        }
        //创建入库通知单entity
        WmInNotice wmInNotice = new WmInNotice();
        BeanUtils.copyProperties(noticeReceiptDto,wmInNotice);
        wmInNotice.setCreateName("龚宸");
        wmInNotice.setCreateBy("admin");
        wmInNotice.setCreateDate(LocalDateTime.now());
        wmInNotice.setUpdateName("龚宸");
        wmInNotice.setUpdateBy("admin");
        wmInNotice.setUpdateDate(LocalDateTime.now());
        //获取推荐库位
        String emptyStorage = getStorage(receiptDto.getGoodsCode());
        if (emptyStorage.isEmpty()){
            return false;
        }
        //插入库位代码
        wmInNotice.setStoreCode(emptyStorage);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        wmInNotice.setNoticeId(uuid);
        //向数据库插入入库通知单
        return receiveGoodsMapper.createInNoticeReceipt(wmInNotice);
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
        String emptyStorage = getEmptyStorage(goodType);
        return emptyStorage;
    }

    /**
     * 根据出货频率和商品种类查询可用库位 todo
     * @param goodType 商品属性
     * @return 可用库位
     */
    private String getEmptyStorage(GoodType goodType) {
        String kuWeiMingCheng;
        switch (Integer.parseInt(goodType.getOutFrequency())){
            case 10: kuWeiMingCheng = "A%"; break;
            case 9 : kuWeiMingCheng = "B%"; break;
            case 8 : kuWeiMingCheng = "C%"; break;
            default: kuWeiMingCheng = "D%"; break;
        }
        goodType.setOutFrequency(kuWeiMingCheng);
        if (kuWeiMingCheng != ""){
            String emptyStorage = receiveGoodsMapper.getEmptyStorage(goodType);
            return emptyStorage;
        }
        return receiveGoodsMapper.getEmptyStorage(goodType);
    }

    /**
     * 查询商品的出货频率和分类 todo
     * @param goodCode 商品编码
     * @return 商品的出货频率和分类
     */
    private GoodType getGoodType(String goodCode) {

        //准备查询条件
        GoodParam goodParam = new GoodParam();
        goodParam.setShpBianMa(goodCode);
        //feign远程调用shop分页查询接口
//        MdGoods mdGoods = shopClient.goodsList(1, 1, goodParam);
        MdGoods mdGoods = new MdGoods();
        mdGoods.setChpShuXing("肉类");
        mdGoods.setPinLv("10");
        mdGoods.setZhlKg("3");
        mdGoods.setTiJiCm("4");
        GoodType goodType = new GoodType();
        goodType.setType(mdGoods.getChpShuXing());
        goodType.setOutFrequency(mdGoods.getPinLv());
        goodType.setNet(Integer.parseInt(mdGoods.getZhlKg()));
        goodType.setVolume(Integer.parseInt(mdGoods.getTiJiCm()));
        return goodType;
    }
}
