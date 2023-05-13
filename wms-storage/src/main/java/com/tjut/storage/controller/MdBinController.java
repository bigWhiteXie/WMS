package com.tjut.storage.controller;

import com.tjut.common.resp.WmsResp;
import com.tjut.storage.model.dto.BinDto;
import com.tjut.storage.model.po.MdBin;
import com.tjut.storage.model.vo.BinParam;
import com.tjut.storage.model.vo.PageParam;
import com.tjut.storage.mq.MessageSender;
import com.tjut.storage.config.MqQueueConfig;
import com.tjut.storage.service.MdBinService;
import com.tjut.storage.util.ExcelUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 储位管理
 * @author codeXie
 */
@Slf4j
@RestController
@RequestMapping("mdBin")
public class MdBinController {

    @Autowired
    private MdBinService  mdBinService;

    @Autowired
    private MessageSender messageSender;

    @ApiOperation("分页查询库位信息")
    @PostMapping("page")
    public WmsResp binList(PageParam page, @RequestBody BinParam binParam){
        return mdBinService.getPage(page,binParam);
    }

    @ApiOperation("编辑库位信息")
    @PostMapping("update")
    public WmsResp updateBin(@RequestBody BinDto binDto){
        return mdBinService.updateBin(binDto);
    }

    @ApiOperation("导入库位信息")
    @PostMapping("import")
    public WmsResp importBin(@RequestBody BinDto binDto){
        return mdBinService.importBin(binDto);
    }

    @ApiOperation("导入excel")
    @PostMapping("/upload")
    public WmsResp<String> uploadExcel(@RequestPart(value = "file") MultipartFile file) {
        try {
            ExcelUtils.readExcelByMq(file, MdBin.class,messageSender, MqQueueConfig.EXCHANGE_STORAGE,"bin.import");
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
    public void exportExcel(BinParam binParam, HttpServletResponse response){
        String binStore = binParam.getBinStore();
        String kuWeiBianMa = binParam.getKuWeiBianMa();
        String kuWeiLeiXing = binParam.getKuWeiLeiXing();
        String kuWeiTiaoMa = binParam.getKuWeiTiaoMa();
        String x = binParam.getX();
        String y = binParam.getY();
        String z = binParam.getZ();
        //条件查询待导出数据
        List<MdBin> list = mdBinService.lambdaQuery().eq(!StringUtils.isEmpty(binStore), MdBin::getBinStore, binStore)
                .eq(!StringUtils.isEmpty(kuWeiBianMa), MdBin::getKuWeiBianMa, kuWeiBianMa)
                .eq(!StringUtils.isEmpty(kuWeiLeiXing), MdBin::getKuWeiLeiXing, kuWeiLeiXing)
                .eq(!StringUtils.isEmpty(kuWeiTiaoMa), MdBin::getKuWeiTiaoMa, kuWeiTiaoMa)
                .eq(!StringUtils.isEmpty(x), MdBin::getX, x)
                .eq(!StringUtils.isEmpty(y), MdBin::getY, y)
                .eq(!StringUtils.isEmpty(z), MdBin::getZ, z).list();
        try {
            //导出表格给前端
            ExcelUtils.exportExcel(list,MdBin.class,"储位定义",response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
