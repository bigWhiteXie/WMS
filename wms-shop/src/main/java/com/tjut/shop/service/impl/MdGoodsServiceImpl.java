package com.tjut.shop.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjut.resp.WmsResp;
import com.tjut.shop.mapper.MdGoodsMapper;
import com.tjut.shop.model.po.*;
import com.tjut.shop.model.vo.GoodParam;
import com.tjut.shop.model.vo.PageParam;
import com.tjut.shop.service.*;
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
import java.util.stream.Collectors;

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

    @Autowired
    private MdCusService mdCusService;

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

    @Override
    public WmsResp<String> saveGood(MdGoods goods) {
        //todo：校验所属货主、产品大类、产品属性和单位是否合法

        boolean update = this.saveOrUpdate(goods);
        return WmsResp.success("修改成功");
    }

    @Override
    public WmsResp<List<String>> getAllCompany() {
        List<String> list = mdCusService.lambdaQuery().select(MdCus::getZhongWenQch).list().stream().map((cus) -> {
            return cus.getZhongWenQch();
        }).collect(Collectors.toList());
        return WmsResp.success(list);
    }

    @Autowired
    DictGoodsAttService dictGoodsAttService;

    @Autowired
    DictGoodsKindService dictGoodsKindService;

    @Autowired
    DictEnterGoodsUnitService dictEnterGoodsUnitService;

    @Override
    public WmsResp<List<String>> getAllKinds() {
        List<String> list = dictGoodsKindService.lambdaQuery().select(DictGoodsKind::getName).list().
                stream().map((item) -> item.getName()).collect(Collectors.toList());
        return WmsResp.success(list);
    }

    @Override
    public WmsResp<List<String>> getAllSku() {
        List<String> list = dictEnterGoodsUnitService.lambdaQuery().select(DictEnterGoodsUnit::getName).list().
                stream().map((item) -> item.getName()).collect(Collectors.toList());
        return WmsResp.success(list);
    }

    @Override
    public WmsResp<List<String>> getAllAttr() {
        List<String> list = dictGoodsAttService.lambdaQuery().select(DictGoodsAtt::getName).list().
                stream().map((item) -> item.getName()).collect(Collectors.toList());
        return WmsResp.success(list);
    }


}
