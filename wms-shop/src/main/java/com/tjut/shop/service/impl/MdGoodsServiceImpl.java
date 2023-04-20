package com.tjut.shop.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjut.resp.WmsResp;
import com.tjut.shop.mapper.MdGoodsMapper;
import com.tjut.shop.model.po.MdCus;
import com.tjut.shop.model.po.MdGoods;
import com.tjut.shop.model.vo.GoodParam;
import com.tjut.shop.model.vo.PageParam;
import com.tjut.shop.service.MdCusService;
import com.tjut.shop.service.MdGoodsService;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author codeXie
 */
@Slf4j
@Service
public class MdGoodsServiceImpl extends ServiceImpl<MdGoodsMapper, MdGoods> implements MdGoodsService {
    @Autowired
    MdGoodsMapper goodsMapper;

    @Autowired
    MdCusService cusService;

    @Override
    public WmsResp getPage( PageParam page, GoodParam goodParam) {

        Page<MdGoods> page1 = new Page<>(page.getIndex(), page.getSize());
        Page<MdGoods> res = this.lambdaQuery().
                eq(StringUtils.isNotBlank(goodParam.getChpShuXing()), MdGoods::getChpShuXing, goodParam.getChpShuXing()).
                eq(StringUtils.isNotBlank(goodParam.getShpBianMa()), MdGoods::getShpBianMa, goodParam.getShpBianMa()).
                eq(StringUtils.isNotBlank(goodParam.getShpBianMakh()), MdGoods::getShpBianMakh, goodParam.getShpBianMakh()).
                eq(StringUtils.isNotBlank(goodParam.getShpMingCheng()), MdGoods::getShpMingCheng, goodParam.getShpMingCheng()).
                eq(StringUtils.isNotBlank(goodParam.getSysCompanyName()), MdGoods::getCusName, goodParam.getSysCompanyName()).
                eq(StringUtils.isNotBlank(goodParam.getChpShuXing()), MdGoods::getChpShuXing, goodParam.getChpShuXing()).
                page(page1);



        return new WmsResp(200,res);
    }
}
