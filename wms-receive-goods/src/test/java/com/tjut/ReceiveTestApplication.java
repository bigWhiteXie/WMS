package com.tjut;

import com.tjut.receive.mapper.ReceiveGoodsMapper;
import com.tjut.receive.model.dto.GoodType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiveTestApplication {
    @Autowired
    ReceiveGoodsMapper receiveGoodsMapper;

    @Test
    public void testGetEmptyStorage(){
        String type = "肉类";
        String outFrequency = "A%";
        GoodType goodType = new GoodType();
        goodType.setType(type);
        goodType.setOutFrequency(outFrequency);
        String emptyStorage = receiveGoodsMapper.getEmptyStorage(goodType);
        System.out.println(emptyStorage);
    }
}
