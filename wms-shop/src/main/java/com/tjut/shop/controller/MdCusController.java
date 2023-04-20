package com.tjut.shop.controller;

import com.tjut.shop.service.MdCusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author codeXie
 */
@Slf4j
@RestController
@RequestMapping("mdCus")
public class MdCusController {

    @Autowired
    private MdCusService  mdCusService;
}
