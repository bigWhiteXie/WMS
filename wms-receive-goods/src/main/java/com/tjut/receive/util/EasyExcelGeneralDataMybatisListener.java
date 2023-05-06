package com.tjut.receive.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.tjut.receive.model.entity.TestExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 读取Excel表格中数据的监听器
 */
@Slf4j
public class EasyExcelGeneralDataMybatisListener extends AnalysisEventListener<TestExcel> {

    //MQ
    private RabbitTemplate rabbitTemplate;

    //存储读入数据的缓存List
    private List<TestExcel> testExcelsList = new ArrayList<>();

    public EasyExcelGeneralDataMybatisListener() {
    }

    public EasyExcelGeneralDataMybatisListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void invoke(TestExcel testExcel, AnalysisContext analysisContext) {
        //将数据放入缓存区
        testExcelsList.add(testExcel);
        //当缓存区数据达到3000时，将数据放入MQ
        if (testExcelsList.size() >= 30000){
            publishMessage();
            testExcelsList.clear();
        }
    }

    //将数据发布到Rabbit MQ上
    private void publishMessage() {
        //定义全局唯一的消息ID，需要封装到CorrelationData中
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        correlationData.getFuture().addCallback(returnResult -> {
            if (returnResult.isAck()){
                //ack消息成功发送到exchange
                log.info("消息成功发送到exchange，id {}",correlationData.getId());
            }else {
                //nack消息发送到exchange失败
                log.info("消息发送到exchange失败，id {}，原因 {}",correlationData.getId(),returnResult.getReason());
            }
        }, ex -> {
            log.info("消息发送到exchange异常，id {}，原因 {}",correlationData.getId(),ex.getMessage());
        });
        rabbitTemplate.convertAndSend("receiveGoods.direct","receive.good",testExcelsList,correlationData);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        publishMessage();
        testExcelsList.clear();
    }
}
