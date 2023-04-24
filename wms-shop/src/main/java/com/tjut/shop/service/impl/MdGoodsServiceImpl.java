package com.tjut.shop.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjut.resp.WmsResp;
import com.tjut.shop.mapper.MdGoodsMapper;
import com.tjut.shop.model.po.MdGoods;
import com.tjut.shop.model.vo.GoodParam;
import com.tjut.shop.model.vo.PageParam;
import com.tjut.shop.service.MdCusService;
import com.tjut.shop.service.MdGoodsService;
import com.tjut.shop.util.ExcelMergeStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

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

    @Override
    public WmsResp<String> delGoods( List<String> ids) {
        boolean remove = this.removeByIds(ids);
        if(remove){
            return WmsResp.success("删除成功");
        }
        return WmsResp.fail("删除失败");
    }

    @Override
    public WmsResp<MdGoods> getGoodById(String id) {
        MdGoods goods = this.getById(id);
        return WmsResp.success(goods);
    }




}
