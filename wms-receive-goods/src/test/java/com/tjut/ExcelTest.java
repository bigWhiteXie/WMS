package com.tjut;

import com.alibaba.excel.EasyExcel;
import com.tjut.receive.model.entity.TestExcel;
import com.tjut.receive.util.EasyExcelGeneralDataMybatisListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testExcel(){
        String fileName = "D:\\1.xls";
        long startTime = System.currentTimeMillis();
        EasyExcel.read(fileName, TestExcel.class,new EasyExcelGeneralDataMybatisListener(rabbitTemplate)).doReadAll();
        long endTime = System.currentTimeMillis();
        log.info("共用时间为：{}秒",(endTime - startTime)/1000);
    }
}
