package com.tjut.shop.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjut.resp.WmsResp;
import com.tjut.shop.mapper.MdSupMapper;
import com.tjut.shop.model.po.DictGoodsKind;
import com.tjut.shop.model.po.MdCus;
import com.tjut.shop.model.po.MdGoods;
import com.tjut.shop.model.po.MdSup;
import com.tjut.shop.model.vo.GoodParam;
import com.tjut.shop.model.vo.PageParam;
import com.tjut.shop.model.vo.SupParam;
import com.tjut.shop.service.MdCusService;
import com.tjut.shop.service.MdSupService;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author qwh12138
 */

@Slf4j
@Service
public class MdSupServiceImpl extends ServiceImpl<MdSupMapper,MdSup> implements MdSupService{


    @Autowired
    private MdSupService mdSupService;

    @Override
    public WmsResp<List<String>> getAllProperties() {
        List<String> list = mdSupService.lambdaQuery().select(MdSup::getXingYeFenLei).list().stream().map((sup) -> {
            return sup.getXingYeFenLei();
        }).collect(Collectors.toList());
        return WmsResp.success(list);
    }

    @Override
    public WmsResp<List<String>> getAllEmails() {
        List<String> list = mdSupService.lambdaQuery().select(MdSup::getEmaildiZhi).list().stream().map((sup) -> {
            return sup.getEmaildiZhi();
        }).collect(Collectors.toList());
        return WmsResp.success(list);
    }


    @Override
    public WmsResp getPage(PageParam page, SupParam supParam) {
        Page<MdSup> page1 = new Page<>(page.getIndex(), page.getSize());
        Page<MdSup> res = this.lambdaQuery().
                eq(StringUtils.isNotBlank(supParam.getZhongWenQch()), MdSup::getZhongWenQch,supParam.getZhongWenQch()).
                eq(StringUtils.isNotBlank(supParam.getZhuJiMa()), MdSup::getZhuJiMa,supParam.getZhuJiMa()).
                eq(StringUtils.isNotBlank(supParam.getGysJianCheng()), MdSup::getGysJianCheng,supParam.getGysJianCheng()).
                eq(StringUtils.isNotBlank(supParam.getGysBianMa()), MdSup::getGysBianMa,supParam.getGysBianMa()).
                page(page1);

        return new WmsResp(200,res);
    }
}
