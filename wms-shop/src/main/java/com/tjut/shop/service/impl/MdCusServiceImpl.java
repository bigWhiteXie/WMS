package com.tjut.shop.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjut.resp.WmsResp;
import com.tjut.shop.mapper.MdCusMapper;
import com.tjut.shop.model.po.MdCus;
import com.tjut.shop.model.vo.CusParam;
import com.tjut.shop.model.vo.PageParam;
import com.tjut.shop.service.MdCusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author codeXie
 */
@Slf4j
@Service
public class MdCusServiceImpl extends ServiceImpl<MdCusMapper, MdCus> implements MdCusService {

    @Override
    public WmsResp getPage(PageParam page, CusParam cusParam) {

        //
        Page<MdCus> pageInfo = new Page<>(page.getIndex(), page.getSize());
        LambdaQueryWrapper<MdCus> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(StringUtils.isNotBlank(cusParam.getKeHuBianMa()), MdCus::getKeHuBianMa, cusParam.getKeHuBianMa())
                .like(StringUtils.isNotBlank(cusParam.getZhongWenQch()), MdCus::getZhongWenQch, cusParam.getZhongWenQch())
                .orderByDesc(MdCus::getCreateDate);
        Page<MdCus> cusPage = this.page(pageInfo, queryWrapper);
        return WmsResp.success(cusPage);
    }

    @Override
    public WmsResp<String> delCus(List<String> ids) {
        boolean remove = this.removeByIds(ids);

        if(remove) {
            return WmsResp.success("客户信息删除成功！");
        }

        return WmsResp.fail("客户信息删除失败");
    }
}
