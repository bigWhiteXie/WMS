package com.tjut.receive.listener;

import com.tjut.receive.mapper.TestExcelMapper;
import com.tjut.receive.model.entity.TestExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class TestExcelListener {

    @Autowired
    TestExcelMapper testExcelMapper;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "receiveGoods.queue"),
            exchange = @Exchange(name = "receiveGoods.direct"),
            key = {"receive.good"}
    ))
    public void consumeMessage(List<TestExcel> testExcelList){
        long start = System.currentTimeMillis();
//        System.out.println(testExcelList);
        testExcelMapper.importToDb(testExcelList);
        long end = System.currentTimeMillis();
        log.info("批量单次花费时间：{}秒",(end-start)/1000);
    }
}
