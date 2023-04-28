package com.tjut.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tjut.resp.WmsResp;
import com.tjut.shop.model.po.MdCus;
import com.tjut.shop.model.vo.CusParam;
import com.tjut.shop.model.vo.PageParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author codeXie
 * @since 2023-04-20
 */
public interface MdCusService extends IService<MdCus> {

    WmsResp getPage(PageParam page, CusParam cusParam);

    WmsResp<String> delCus(List<String> ids);
}
