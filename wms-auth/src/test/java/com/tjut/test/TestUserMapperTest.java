package com.tjut.test;


import com.tjut.auth.AuthApplication;
import com.tjut.auth.mapper.TSUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description TODO
 * @author codeXie
 * @date 2022/10/23 10:14
 * @version 1.0
 */
@SpringBootTest(classes = AuthApplication.class)
public class TestUserMapperTest {

 @Autowired//从容器中拿到courseTestMapper注入成员
 TSUserMapper tsUserMapper;



 @Test
 public void testCourseTest(){
  List<String> list = tsUserMapper.getFunIds("8a8ab0b246dc81120146dc8181a10054");
  System.out.println(list);
 }
}
