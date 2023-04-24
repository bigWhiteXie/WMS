package com.tjut.shop.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tjut.resp.WmsResp;
import com.tjut.shop.model.po.MdGoods;
import com.tjut.shop.model.vo.GoodParam;
import com.tjut.shop.model.vo.PageParam;
import com.tjut.shop.service.MdGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
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
        List<MdGoods> list = mdGoodsService.lambdaQuery().
                eq(StringUtils.isNotBlank(goodParam.getChpShuXing()), MdGoods::getChpShuXing, goodParam.getChpShuXing()).
                eq(StringUtils.isNotBlank(goodParam.getShpBianMa()), MdGoods::getShpBianMa, goodParam.getShpBianMa()).
                eq(StringUtils.isNotBlank(goodParam.getShpBianMakh()), MdGoods::getShpBianMakh, goodParam.getShpBianMakh()).
                eq(StringUtils.isNotBlank(goodParam.getShpMingCheng()), MdGoods::getShpMingCheng, goodParam.getShpMingCheng()).
                eq(StringUtils.isNotBlank(goodParam.getSysCompanyName()), MdGoods::getCusName, goodParam.getSysCompanyName()).
                eq(StringUtils.isNotBlank(goodParam.getChpShuXing()), MdGoods::getChpShuXing, goodParam.getChpShuXing()).
                list();
        try {
            this.setExcelResponseProp(response,"商品列表");
            EasyExcel.write(response.getOutputStream())
                    .head(MdGoods.class)
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet("商品列表")
                    .doWrite(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public WmsResp<String> uploadExcel(@RequestPart(value = "file") MultipartFile file) {
        try {
            List<MdGoods> goodsList = EasyExcel.read(file.getInputStream())
                    .head(MdGoods.class)
                    .sheet()
                    .doReadSync();
            mdGoodsService.saveOrUpdateBatch(goodsList);
            return WmsResp.success("上传成功");
        } catch (IOException e) {
            return WmsResp.fail("上传失败");
        }
    }


    private void setExcelResponseProp(HttpServletResponse response, String rawFileName) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(rawFileName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8 " + fileName + ".xlsx");
    }


}
