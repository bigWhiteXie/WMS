package com.tjut.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tjut.resp.WmsResp;
import com.tjut.shop.model.po.MdGoods;
import com.tjut.shop.model.vo.GoodParam;
import com.tjut.shop.model.vo.PageParam;

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
}