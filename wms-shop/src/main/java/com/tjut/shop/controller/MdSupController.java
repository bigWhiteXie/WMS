package com.tjut.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tjut.resp.WmsResp;
import com.tjut.shop.model.po.MdSup;
import com.tjut.shop.service.MdSupService;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Email;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author qwh12138
 */

@Slf4j
@RestController
@RequestMapping("mdSup")
public class MdSupController {

    @Autowired
    private MdSupService mdSupService;

    /**
     * 处理添加供应商的请求
     */
    @PostMapping
    public String addSup(HttpServletRequest request, @RequestBody MdSup mdSup) {
        log.info("新增供应商，供应商信息：{}",mdSup.toString());

        // 调用service保存供应商信息
        mdSupService.save(mdSup);

        return "success";
    }

    //编辑供应商
    @PutMapping
    public String update(HttpServletRequest request,@RequestBody MdSup mdSup){
        log.info(mdSup.toString());
        mdSupService.updateById(mdSup);
        return null;
    }

    //删除供应商
    @GetMapping("delete")
    public WmsResp<String> delSup(@ApiParam("商品id列表") String[] ids){
        return mdSupService.delSup(Arrays.asList(ids));
    }

    //批量删除供应商

    //查询供应商
    @GetMapping("/query")
    public List<MdSup> querySup(@RequestParam(required = false) String zhongWenQch,
                                @RequestParam(required = false) String zhuJiMa,
                                @RequestParam(required = false) String gysJianCheng,
                                @RequestParam(required = false) String gysBianMa) {
        log.info("查询供应商信息");
        LambdaQueryWrapper<MdSup> wrapper = new LambdaQueryWrapper<MdSup>();
        if (zhongWenQch != null) {
            wrapper.like(MdSup::getZhongWenQch, zhongWenQch);
        }
        if (zhuJiMa != null) {
            wrapper.like(MdSup::getZhuJiMa, zhuJiMa);
        }
        if (gysJianCheng != null) {
            wrapper.like(MdSup::getGysJianCheng, gysJianCheng);
        }
        if (gysBianMa != null) {
            wrapper.like(MdSup::getGysBianMa, gysBianMa);
        }
        List<MdSup> supList = mdSupService.list(wrapper);
        return supList;
    }
    //导入供应商

    //导出供应商
}
