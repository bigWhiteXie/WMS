package com.tjut.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tjut.resp.WmsResp;
import com.tjut.shop.model.po.MdSup;

import java.util.List;

/**
 *
 * @author qwh12138
 */
public interface MdSupService extends IService<MdSup> {

    MdSup getByZhongWenQc();

    WmsResp<String> delSup(List<String> ids);
}
