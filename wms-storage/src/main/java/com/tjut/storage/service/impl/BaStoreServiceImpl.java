package com.tjut.storage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjut.authBase.util.UserHolder;
import com.tjut.common.model.UserDto;
import com.tjut.common.resp.WmsResp;
import com.tjut.storage.mapper.BaStoreMapper;
import com.tjut.storage.model.po.BaStore;
import com.tjut.storage.model.po.MdBin;
import com.tjut.storage.model.vo.PageParam;
import com.tjut.storage.model.vo.StoreParam;
import com.tjut.storage.service.BaStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
public class BaStoreServiceImpl extends ServiceImpl<BaStoreMapper, BaStore> implements BaStoreService {
    @Override
    public WmsResp saveStore(BaStore baStore) {
        String username = UserHolder.getUser().getUsername();
        baStore.setCreateName(username);
        baStore.setCreateDate(LocalDateTime.now());
        boolean save = this.save(baStore);
        return save ? WmsResp.success("插入成功"):WmsResp.fail("插入失败");
    }

    @Override
    public WmsResp updateStore(BaStore baStore) {
        boolean update = this.updateById(baStore);
        return update ? WmsResp.success("修改成功"):WmsResp.fail("修改失败");
    }

    @Override
    public WmsResp delStore(List<String> ids) {
        boolean remove = this.removeByIds(ids);
        if(remove){
            return WmsResp.success("删除成功");
        }
        return WmsResp.fail("删除失败");
    }

    @Override
    public WmsResp getPage(PageParam page, StoreParam storeParam) {
        String storeCode = storeParam.getStoreCode();
        String storeName = storeParam.getStoreName();
        Page<BaStore> baPage = new Page<>(page.getIndex(), page.getSize());

        Page<BaStore> pageRes = this.lambdaQuery()
                .eq(!StringUtils.isEmpty(storeCode), BaStore::getStoreCode, storeCode)
                .eq(!StringUtils.isEmpty(storeName), BaStore::getStoreName, storeName)
                .page(baPage);

        return WmsResp.success(pageRes);
    }
}
