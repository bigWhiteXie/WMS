package com.tjut.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tjut.resp.WmsResp;
import com.tjut.shop.model.po.MdGoods;
import com.tjut.shop.model.po.MdSup;
import com.tjut.shop.model.vo.GoodParam;
import com.tjut.shop.model.vo.PageParam;
import com.tjut.shop.model.vo.SupParam;
import com.tjut.shop.service.MdSupService;
import com.tjut.shop.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author qwh12138
 */

@Slf4j
@RestController
@RequestMapping("mdSup")
@Api(tags = "供应商信息")
public class MdSupController {

    @Autowired
    private MdSupService mdSupService;

    //录入供应商
    @ApiOperation("录入供应商")
    @PostMapping("save")
    public WmsResp<String> saveSup(@RequestBody MdSup sup){
        log.info("新增供应商，供应商信息：{}",sup.toString());
        // 调用service保存供应商信息
        mdSupService.save(sup);
        return WmsResp.success("修改成功");
    }

    //修改供应商
    @ApiOperation("修改供应商")
    @PostMapping("update")
    public WmsResp<String> updateSup(@RequestBody MdSup sup){
        // 调用service保存供应商信息
        mdSupService.updateById(sup);
        return WmsResp.success("修改成功");
    }

    //删除供应商
    @ApiOperation("删除供应商信息")
    @GetMapping("delete")
    public WmsResp<String> delSup(@ApiParam("供应商id列表") String[] ids){
        log.info("删除供应商，id为：{}",ids);

        mdSupService.removeByIds(Arrays.asList(ids));
        return WmsResp.success("删除成功");
    }

    //查询供应商
    @ApiOperation("分页查询供应商信息")
    @PostMapping("page")
    public WmsResp<Page> supList(PageParam pageParam, @RequestBody SupParam supParam){
        log.info("page = {},pageSize = {},sup属性 = {}" ,pageParam.getIndex(),pageParam.getSize(),supParam);
        //分页构造器
        Page<MdSup> pageInfo = new Page<>(pageParam.getIndex(), pageParam.getSize());
        //条件构造器
        LambdaQueryWrapper<MdSup> queryWrapper = new LambdaQueryWrapper<>();
        //查询条件
        queryWrapper.eq(supParam.getZhongWenQch() != null,MdSup::getZhongWenQch,supParam.getZhongWenQch());
        queryWrapper.eq(supParam.getZhuJiMa() != null,MdSup::getZhuJiMa,supParam.getZhuJiMa());
        queryWrapper.eq(supParam.getGysJianCheng() != null,MdSup::getGysJianCheng,supParam.getGysJianCheng());
        queryWrapper.eq(supParam.getGysBianMa() != null,MdSup::getGysBianMa,supParam.getGysBianMa());

        //分页查询
        mdSupService.page(pageInfo,queryWrapper);

        return WmsResp.success(pageInfo);
    }


    //导入供应商
    @ApiOperation("导入excel")
    @PostMapping("/upload")
    public WmsResp<String> uploadExcel(@RequestPart(value = "file") MultipartFile file) {
        try {
            ExcelUtils.readExcel(file, MdSup.class,mdSupService);
            return WmsResp.success("上传成功");
        } catch (IOException e) {
            return WmsResp.fail("上传失败");
        }catch (DuplicateKeyException e){
            log.error("上传键位冲突：{}",e.getMessage());
            return WmsResp.fail(e.getMessage());
        }
    }
    //导出供应商
    @ApiOperation("导出表格")
    @GetMapping("export")
    public void exportExcel(SupParam supParam, HttpServletResponse response){
        //条件查询待导出数据
        List<MdSup> list = mdSupService.lambdaQuery().
                eq(supParam.getZhongWenQch() != null,MdSup::getZhongWenQch,supParam.getZhongWenQch()).
                eq(supParam.getZhuJiMa() != null,MdSup::getZhuJiMa,supParam.getZhuJiMa()).
                eq(supParam.getGysJianCheng() != null,MdSup::getGysJianCheng,supParam.getGysJianCheng()).
                eq(supParam.getGysBianMa() != null,MdSup::getGysBianMa,supParam.getGysBianMa()).
                list();
        try {
            //导出表格给前端
            ExcelUtils.exportExcel(list,MdSup.class,"供应商列表",response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @ApiOperation("企业属性下拉菜单")
    @GetMapping("property")
    public WmsResp<List<String>> getAllProperties(){
        return mdSupService.getAllProperties();
    }

    @ApiOperation("Email地址下拉菜单")
    @GetMapping("email")
    public WmsResp<List<String>> getAllEmails(){
        return mdSupService.getAllEmails();
    }

}
