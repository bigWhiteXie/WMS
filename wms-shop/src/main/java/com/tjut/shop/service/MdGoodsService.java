package com.tjut.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tjut.resp.WmsResp;
import com.tjut.shop.model.po.MdGoods;
import com.tjut.shop.model.vo.GoodParam;
import com.tjut.shop.model.vo.PageParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author codeXie
 * @since 2023-04-20
 */
public interface MdGoodsService extends IService<MdGoods> {

    WmsResp getPage(PageParam page, GoodParam goodParam);

    WmsResp<String> delGoods(List<String> ids);

    WmsResp<MdGoods> getGoodById(String id);


    WmsResp<String> saveGood(MdGoods goods);

    WmsResp<List<String>> getAllCompany();

    WmsResp<List<String>> getAllKinds();

    WmsResp<List<String>> getAllSku();
}
