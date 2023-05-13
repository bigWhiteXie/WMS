package com.tjut.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tjut.common.resp.WmsResp;
import com.tjut.storage.model.dto.BinDto;
import com.tjut.storage.model.po.MdBin;
import com.tjut.storage.model.vo.BinParam;
import com.tjut.storage.model.vo.PageParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author codeXie
 * @since 2023-05-13
 */
public interface MdBinService extends IService<MdBin> {

    WmsResp getPage(PageParam page, BinParam binParam);

    WmsResp updateBin(BinDto binDto);

    WmsResp importBin(BinDto binDto);
}
