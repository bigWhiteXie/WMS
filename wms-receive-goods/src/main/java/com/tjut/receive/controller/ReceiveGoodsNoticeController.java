package com.tjut.receive.controller;

import com.tjut.receive.model.dto.NoticeReceiptDto;
import com.tjut.receive.model.dto.QueryReceiptDto;
import com.tjut.receive.model.dto.ReceiptDto;
import com.tjut.receive.model.entity.WmInNotice;
import com.tjut.receive.service.ReceiveGoodsNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/in")
public class ReceiveGoodsNoticeController {

    @Autowired
    public ReceiveGoodsNoticeService receiveGoodsNoticeService;

    /**
     * 点击上架，更新入库通知单
     *
     * @param wmInNotice 入库通知单信息
     * @return 更新是否成功
     */
    @PostMapping("/notice/receipt")
    public int updateInNoticeReceipt(@RequestBody WmInNotice wmInNotice){
        return receiveGoodsNoticeService.updateInNoticeReceipt(wmInNotice);
    }

    /**
     * 根据入库单号分页查询入库通知单
     * @param queryReceiptDto 分页查询条件
     * @return 入库通知单
     */
    @PostMapping("/notice/receipts")
    public List<WmInNotice> getNoticeReceipt(@RequestBody QueryReceiptDto queryReceiptDto){
        return receiveGoodsNoticeService.getNoticeReceiptByImNoticeId(queryReceiptDto);
    }

    /**
     * 获得推荐库位
     * @param noticeReceiptDto
     * @return
     */
    @PostMapping("/notice/empty/storage")
    public String getEmptyStorage(@RequestBody NoticeReceiptDto noticeReceiptDto){
        if (noticeReceiptDto.getGoodsCode() == null && noticeReceiptDto.getGoodsCode() == ""){
            return "error";
        }
        return receiveGoodsNoticeService.getStorage(noticeReceiptDto.getGoodsCode());
    }
}
