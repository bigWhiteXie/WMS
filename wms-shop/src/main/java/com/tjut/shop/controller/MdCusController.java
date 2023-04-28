package com.tjut.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tjut.resp.WmsResp;
import com.tjut.shop.model.po.MdCus;
import com.tjut.shop.model.vo.CusParam;
import com.tjut.shop.model.vo.PageParam;
import com.tjut.shop.service.MdCusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author codeXie
 */
@Slf4j
@RestController
@RequestMapping("mdCus")
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
    @GetMapping("delete")
    public WmsResp<String> delGoods(@ApiParam("客户id列表") String[] ids){
        return mdCusService.delCus(Arrays.asList(ids));
    }

}
