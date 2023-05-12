package com.tjut.shop.controller;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tjut.resp.WmsResp;
import com.tjut.shop.model.po.MdCus;
import com.tjut.shop.model.vo.CusParam;
import com.tjut.shop.model.vo.PageParam;
import com.tjut.shop.service.MdCusService;
import com.tjut.shop.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author codeXie
 */
@Slf4j
@RestController
@RequestMapping("/mdCus")
@Api(tags = "客户信息")
public class MdCusController {

    @Autowired
    private MdCusService  mdCusService;

    @ApiOperation("分页查询客户信息")
    @PostMapping("/page")
    public WmsResp cusList(PageParam page, @RequestBody CusParam cusParam) {
        return mdCusService.getPage(page, cusParam);
    }

    @ApiOperation("删除(批量、单个)客户记录")
    @GetMapping("/delete")
    public WmsResp<String> delGoods(@ApiParam("客户id列表") String[] ids) {
        return mdCusService.delCus(Arrays.asList(ids));
    }


    @ApiOperation("编辑、新增客户")
    @PostMapping("/save")
    public WmsResp<String> saveGood(@RequestBody MdCus cus) {
        return mdCusService.saveCus(cus);
    }



    @ApiOperation("查看单个客户信息")
    @PostMapping("/look")
    public WmsResp saveGood(@ApiParam("客户id") String id) {
        return mdCusService.lookCus(id);
    }


    @ApiOperation("导出表格")
    @GetMapping("/export")
    public void exportExcel(CusParam cusParam, HttpServletResponse response){
        //条件查询待导出数据

        LambdaQueryWrapper<MdCus> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(StringUtils.isNotBlank(cusParam.getKeHuBianMa()), MdCus::getKeHuBianMa, cusParam.getKeHuBianMa())
                .like(StringUtils.isNotBlank(cusParam.getZhongWenQch()), MdCus::getZhongWenQch, cusParam.getZhongWenQch())
                .orderByDesc(MdCus::getCreateDate);

        List<MdCus> cusList = mdCusService.list(queryWrapper);
        try {
            //导出表格给前端
            ExcelUtils.exportExcel(cusList, MdCus.class, "客户列表", response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @ApiOperation("导入excel")
    @PostMapping("/upload")
    public WmsResp<String> uploadExcel(@RequestPart(value = "file") MultipartFile file) {
        try {
            ExcelUtils.readExcel(file, MdCus.class, mdCusService);
            return WmsResp.success("上传成功");
        } catch (IOException e) {
            return WmsResp.fail("上传失败");
        }catch (DuplicateKeyException e){
            log.error("上传键位冲突：{}",e.getMessage());
            return WmsResp.fail(e.getMessage());
        }
    }

}
