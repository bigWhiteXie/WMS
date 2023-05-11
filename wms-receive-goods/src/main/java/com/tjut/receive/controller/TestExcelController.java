package com.tjut.receive.controller;

import com.alibaba.excel.EasyExcel;
import com.tjut.receive.model.entity.TestExcel;
import com.tjut.receive.util.EasyExcelGeneralDataMybatisListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RequestMapping("/excel")
@Slf4j
@RestController
public class TestExcelController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("testExcel")
    public void exportExcel(@RequestPart MultipartFile file) throws IOException {
//        String fileName = "D:\\1.xls";
        long startTime = System.currentTimeMillis();
        EasyExcel.read(file.getInputStream(), TestExcel.class,new EasyExcelGeneralDataMybatisListener(rabbitTemplate)).doReadAll();
        long endTime = System.currentTimeMillis();
        log.info("共用时间为：{}秒",(endTime - startTime)/1000);
        System.out.println("上传结束，去执行其他业务");
    }
}
