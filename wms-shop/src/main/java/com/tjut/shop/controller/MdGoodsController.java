package com.tjut.shop.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.tjut.resp.WmsResp;
import com.tjut.shop.model.po.MdGoods;
import com.tjut.shop.model.vo.GoodParam;
import com.tjut.shop.model.vo.PageParam;
import com.tjut.shop.service.MdCusService;
import com.tjut.shop.service.MdGoodsService;
import com.tjut.shop.util.DataListener;
import com.tjut.shop.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

/**
 *商品Controller
 * @author codeXie
 */
@Slf4j
@RestController
@RequestMapping("goods")
@Api(tags = "商品信息")
public class MdGoodsController {

    @Autowired
    private MdGoodsService mdGoodsService;


    @ApiOperation("分页查询商品信息")
    @PostMapping("page")
    public WmsResp goodsList(PageParam page, @RequestBody GoodParam goodParam){
        return mdGoodsService.getPage(page,goodParam);
    }

    @ApiOperation("删除商品记录")
    @GetMapping("delete")
    public WmsResp<String> delGoods(@ApiParam("商品id列表") String[] ids){
        return mdGoodsService.delGoods(Arrays.asList(ids));
    }

    @ApiOperation("打印商品")
    @GetMapping("{id}")
    public WmsResp<MdGoods> printGood(@PathVariable("id") String id){
        return mdGoodsService.getGoodById(id);
    }

    @ApiOperation("导出表格")
    @GetMapping("export")
    public void exportExcel(  GoodParam goodParam, HttpServletResponse response){
        //条件查询待导出数据
        List<MdGoods> list = mdGoodsService.lambdaQuery().
                eq(StringUtils.isNotBlank(goodParam.getChpShuXing()), MdGoods::getChpShuXing, goodParam.getChpShuXing()).
                eq(StringUtils.isNotBlank(goodParam.getShpBianMa()), MdGoods::getShpBianMa, goodParam.getShpBianMa()).
                eq(StringUtils.isNotBlank(goodParam.getShpBianMakh()), MdGoods::getShpBianMakh, goodParam.getShpBianMakh()).
                eq(StringUtils.isNotBlank(goodParam.getShpMingCheng()), MdGoods::getShpMingCheng, goodParam.getShpMingCheng()).
                eq(StringUtils.isNotBlank(goodParam.getSysCompanyName()), MdGoods::getCusName, goodParam.getSysCompanyName()).
                eq(StringUtils.isNotBlank(goodParam.getChpShuXing()), MdGoods::getChpShuXing, goodParam.getChpShuXing()).
                list();
        try {
            //导出表格给前端
           ExcelUtils.exportExcel(list,MdGoods.class,"商品列表",response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @ApiOperation("导入excel")
    @PostMapping("/upload")
    public WmsResp<String> uploadExcel(@RequestPart(value = "file") MultipartFile file) {
        try {
            ExcelUtils.readExcel(file,MdGoods.class,mdGoodsService);
            return WmsResp.success("上传成功");
        } catch (IOException e) {
            return WmsResp.fail("上传失败");
        }catch (DuplicateKeyException e){
            log.error("上传键位冲突：{}",e.getMessage());
            return WmsResp.fail(e.getMessage());
        }
    }

    @ApiOperation("修改或导入商品")
    @PostMapping("save")
    public WmsResp<String> saveGood(@RequestBody MdGoods goods){
        return mdGoodsService.saveGood(goods);
    }


    @ApiOperation("所属货主下拉菜单")
    @GetMapping("company")
    public WmsResp<List<String>> getCompanies(){
        return mdGoodsService.getAllCompany();
    }

    @ApiOperation("产品大类下拉菜单")
    @GetMapping("categories")
    public WmsResp<List<String>> getAllKinds(){
        return mdGoodsService.getAllKinds();
    }

    @ApiOperation("商品单位下拉菜单")
    @GetMapping("sku")
    public WmsResp<List<String>> getAllSku(){
        return mdGoodsService.getAllSku();
    }

    @ApiOperation("商品属性下拉菜单")
    @GetMapping("attributes")
    public WmsResp<List<String>> getAllAttr(){
        return mdGoodsService.getAllAttr();
    }


}
