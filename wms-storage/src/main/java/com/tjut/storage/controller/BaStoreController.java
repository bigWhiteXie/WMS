package com.tjut.storage.controller;


import com.tjut.common.resp.WmsResp;
import com.tjut.storage.config.MqQueueConfig;
import com.tjut.storage.model.po.BaStore;
import com.tjut.storage.model.po.MdBin;
import com.tjut.storage.model.vo.BinParam;
import com.tjut.storage.model.vo.PageParam;
import com.tjut.storage.model.vo.StoreParam;
import com.tjut.storage.mq.MessageSender;
import com.tjut.storage.service.BaStoreService;
import com.tjut.storage.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Positive;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("baStore")
@Api(tags = "仓库定义")
public class BaStoreController {

    @Autowired
    private BaStoreService baStoreService;

    @Autowired
    private MessageSender messageSender;


    @ApiOperation("录入仓库信息")
    @PostMapping("save")
    public WmsResp saveStore(@RequestBody BaStore baStore){
        return baStoreService.saveStore(baStore);
    }

    @ApiOperation("编辑仓库信息")
    @PostMapping("update")
    public WmsResp updateStore(@RequestBody BaStore baStore){
        return baStoreService.updateStore(baStore);
    }

    @ApiOperation("删除仓库信息")
    @GetMapping("del")
    public WmsResp delStore(@ApiParam("仓库id列表") String[] ids){
        //String[] split = id.split(",");
        return baStoreService.delStore(Arrays.asList(ids));
    }

    @ApiOperation("分页查询仓库信息")
    @PostMapping("page")
    public WmsResp storeList(PageParam page, @RequestBody StoreParam storeParam){
        return baStoreService.getPage(page,storeParam);
    }

    @ApiOperation("导入excel")
    @PostMapping("/upload")
    public WmsResp<String> uploadExcel(@RequestPart(value = "file") MultipartFile file) {
        try {
            ExcelUtils.readExcelByMq(file, BaStore.class,messageSender, MqQueueConfig.EXCHANGE_STORAGE,"bin.import");
            return WmsResp.success("上传成功");
        } catch (IOException e) {
            return WmsResp.fail("上传失败");
        }catch (DuplicateKeyException e){
            log.error("上传键位冲突：{}",e.getMessage());
            return WmsResp.fail(e.getMessage());
        }
    }

    @ApiOperation("导出表格")
    @GetMapping("export")
    public void exportExcel(StoreParam storeParam, HttpServletResponse response){
        String storeCode = storeParam.getStoreCode();
        String storeName = storeParam.getStoreName();
        //条件查询待导出数据
        List<BaStore> list = baStoreService.lambdaQuery()
                .eq(!StringUtils.isEmpty(storeCode), BaStore::getStoreCode, storeCode)
                .eq(!StringUtils.isEmpty(storeName), BaStore::getStoreName, storeName).list();
        try {
            //导出表格给前端
            ExcelUtils.exportExcel(list,BaStore.class,"仓库定义",response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
