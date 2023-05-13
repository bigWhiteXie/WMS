package com.tjut.receive.client;

import com.tjut.receive.model.dto.GoodParam;
import com.tjut.common.resp.WmsResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("shop-service")
public interface ShopClient {
    @PostMapping("/shop/goods/page")
    WmsResp goodsList(@RequestParam("index") int index,@RequestParam("size") int size, @RequestBody GoodParam goodParam);
}
