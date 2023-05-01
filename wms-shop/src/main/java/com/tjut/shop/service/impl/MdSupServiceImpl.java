package com.tjut.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjut.resp.WmsResp;
import com.tjut.shop.mapper.MdSupMapper;
import com.tjut.shop.model.po.MdSup;
import com.tjut.shop.service.MdSupService;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 * @author qwh12138
 */

@Slf4j
@Service
public class MdSupServiceImpl extends ServiceImpl<MdSupMapper,MdSup> implements MdSupService{


    @Override
    public WmsResp<List<String>> getAllProperties() {
        return null;
    }

    @Override
    public WmsResp<List<String>> getAllEmails() {
        return null;
    }
}
