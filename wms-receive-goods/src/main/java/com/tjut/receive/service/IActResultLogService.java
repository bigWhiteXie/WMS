package com.tjut.receive.service;

import com.tjut.receive.model.entity.TestExcel;

import java.util.List;

public interface IActResultLogService {
    void import2DBFromExcel10wByMybatis(List<TestExcel> testExcelsList);
}
