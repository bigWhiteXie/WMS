package com.tjut.gateway.feignclients;

import com.tjut.common.resp.WmsResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "auth-service",fallbackFactory = AuthServiceClientFallbackFactory.class)
@RequestMapping("/auth")
public interface AuthServiceClient {

 @RequestMapping(value = "/menu")
 public WmsResp menu(@RequestParam(value = "userId",required=true) String userId) ;

 }