package com.tjut.shop.controller;

import com.tjut.resp.WmsResp;
import com.tjut.shop.model.vo.GoodParam;
import com.tjut.shop.model.vo.PageParam;
import com.tjut.shop.service.MdGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *商品Controller
 * @author codeXie
 */
@Slf4j
@RestController
@RequestMapping("goods")
public class MdGoodsController {

    @Autowired
    private MdGoodsService mdGoodsService;


    @PostMapping("page")
    public WmsResp goodsList(PageParam page, @RequestBody GoodParam goodParam){
        return mdGoodsService.getPage(page,goodParam);
    }


}
