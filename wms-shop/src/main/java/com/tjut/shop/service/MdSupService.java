package com.tjut.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tjut.resp.WmsResp;
import com.tjut.shop.model.po.MdSup;
import com.tjut.shop.model.vo.GoodParam;
import com.tjut.shop.model.vo.PageParam;
import com.tjut.shop.model.vo.SupParam;

import java.util.List;

/**
 *
 * @author qwh12138
 */
public interface MdSupService extends IService<MdSup> {


    WmsResp<List<String>> getAllProperties();

    WmsResp<List<String>> getAllEmails();

    WmsResp getPage(PageParam page, SupParam supParam);
}
