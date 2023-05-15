package com.tjut.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tjut.common.resp.WmsResp;
import com.tjut.storage.model.po.BaStore;
import com.tjut.storage.model.vo.PageParam;
import com.tjut.storage.model.vo.StoreParam;

import java.util.List;

public interface BaStoreService extends IService<BaStore> {
    WmsResp saveStore(BaStore baStore);

    WmsResp updateStore(BaStore baStore);

    WmsResp delStore(List<String> ids);

    WmsResp getPage(PageParam page, StoreParam storeParam);
}
