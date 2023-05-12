package com.tjut.receive.mapper;

import com.tjut.receive.model.entity.TestExcel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestExcelMapper {
    void importToDb(@Param("testExcelList") List<TestExcel> testExcelList);
}
