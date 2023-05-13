package com.tjut.gateway.feignclients;

import com.tjut.common.resp.WmsResp;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author codeXie
 * @version 1.0
 * @description 认证服务的熔断降级策略
 * @date 2023/04/17 10:12
 */
@Slf4j
@Component
public class AuthServiceClientFallbackFactory implements FallbackFactory<AuthServiceClient> {

    //使用FallbackFactory可以获取异常信息
    @Override
    public AuthServiceClient create(Throwable throwable) {

        return new AuthServiceClient(){
            @Override
            public WmsResp menu(@RequestParam(value = "userId",required=true) String userId) {
                throwable.printStackTrace();
                //降级方法
                log.debug("调用认证服务获取菜单时发生熔断，异常信息:{}",throwable.getMessage());
                return null;
            }
        };
    }
}
