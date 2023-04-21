package com.tjut.shop.controller;

import com.tjut.shop.service.MdSupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author qwh12138
 */

@Slf4j
@RestController
@RequestMapping("mdSup")
public class MdSupController {

    @Autowired
    private MdSupService mdSupService;
}
