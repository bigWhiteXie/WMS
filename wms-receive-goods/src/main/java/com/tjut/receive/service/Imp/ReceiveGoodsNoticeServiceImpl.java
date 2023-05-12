package com.tjut.receive.service.Imp;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjut.receive.client.ShopClient;
import com.tjut.receive.mapper.ReceiveGoodsNoticeMapper;
import com.tjut.receive.model.dto.*;
import com.tjut.receive.model.entity.MdGoods;
import com.tjut.receive.model.entity.WmInNotice;
import com.tjut.receive.service.ReceiveGoodsNoticeService;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReceiveGoodsNoticeServiceImpl extends ServiceImpl<ReceiveGoodsNoticeMapper, WmInNotice> implements ReceiveGoodsNoticeService {

    @Autowired
    ReceiveGoodsNoticeMapper receiveGoodsNoticeMapper;

    @Autowired
    ShopClient shopClient;

    /**
     * 更新入库通知单
     *
     * @param wmInNotice 入库通知单信息
     * @return 更新是否成功
     */
    @Override
    public int updateInNoticeReceipt(WmInNotice wmInNotice) {
        return receiveGoodsNoticeMapper.updateById(wmInNotice);
    }

    /**
     *  根据入库单号分页查询入库通知单
     * @param queryReceiptDto 查询条件
     * @return 入库通知单
     */
    @Override
    public List<WmInNotice> getNoticeReceiptByImNoticeId(QueryReceiptDto queryReceiptDto) {
        Page<WmInNotice> pageInfo = new Page<>(queryReceiptDto.getPage(),queryReceiptDto.getSize());
        Page<WmInNotice> page = this.lambdaQuery().eq(StringUtils.isNotBlank(queryReceiptDto.getImNoticeId()),
                WmInNotice::getImNoticeId, queryReceiptDto.getImNoticeId()).page(pageInfo);
        return page.getRecords();
    }

    /**
     * 推荐库位
     * @param goodCode 商品编码
     * @return 推荐的库位名称
     */
    public String getStorage(String goodCode){
        //查询商品的出货频率和分类
        GoodType goodType = getGoodType(goodCode);
        //根据出货频率和商品种类查询可用库位
        return getEmptyStorage(goodType);
    }

    /**
     * 根据出货频率和商品种类查询可用库位
     * @param goodType 商品属性
     * @return 可用库位
     */
    private String getEmptyStorage(@NotNull GoodType goodType) {
        String kuWeiMingCheng;
        switch (Integer.parseInt(goodType.getOutFrequency())){
            case 10: kuWeiMingCheng = "A%"; break;
            case 9 : kuWeiMingCheng = "B%"; break;
            case 8 : kuWeiMingCheng = "C%"; break;
            default: kuWeiMingCheng = "D%"; break;
        }
        goodType.setOutFrequency(kuWeiMingCheng);
        return receiveGoodsNoticeMapper.getEmptyStorage(goodType);
    }

    /**
     * 查询商品的出货频率和分类
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
        mdGoods.setZhlKg("1");
        mdGoods.setTiJiCm("4");
        GoodType goodType = new GoodType();
        goodType.setType(mdGoods.getChpShuXing());
        goodType.setOutFrequency(mdGoods.getPinLv());
        goodType.setNet(Integer.parseInt(mdGoods.getZhlKg()));
        goodType.setVolume(Integer.parseInt(mdGoods.getTiJiCm()));
        return goodType;
    }
}
