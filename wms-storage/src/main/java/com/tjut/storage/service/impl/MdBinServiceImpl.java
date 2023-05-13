package com.tjut.storage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjut.common.model.UserDto;
import com.tjut.authBase.util.UserHolder;
import com.tjut.common.resp.WmsResp;
import com.tjut.storage.mapper.MdBinMapper;
import com.tjut.storage.model.dto.BinDto;
import com.tjut.storage.model.po.MdBin;
import com.tjut.storage.model.vo.BinParam;
import com.tjut.storage.model.vo.PageParam;
import com.tjut.storage.service.MdBinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author codeXie
 */
@Slf4j
@Service
public class MdBinServiceImpl extends ServiceImpl<MdBinMapper, MdBin> implements MdBinService {

    @Override
    public WmsResp getPage(PageParam page, BinParam binParam) {
        String binStore = binParam.getBinStore();
        String kuWeiBianMa = binParam.getKuWeiBianMa();
        String kuWeiLeiXing = binParam.getKuWeiLeiXing();
        String kuWeiTiaoMa = binParam.getKuWeiTiaoMa();
        String x = binParam.getX();
        String y = binParam.getY();
        String z = binParam.getZ();
        Page<MdBin> mbPage = new Page<>(page.getIndex(), page.getSize());

        Page<MdBin> pageRes = this.lambdaQuery().eq(!StringUtils.isEmpty(binStore), MdBin::getBinStore, binStore)
                .eq(!StringUtils.isEmpty(kuWeiBianMa), MdBin::getKuWeiBianMa, kuWeiBianMa)
                .eq(!StringUtils.isEmpty(kuWeiLeiXing), MdBin::getKuWeiLeiXing, kuWeiLeiXing)
                .eq(!StringUtils.isEmpty(kuWeiTiaoMa), MdBin::getKuWeiTiaoMa, kuWeiTiaoMa)
                .eq(!StringUtils.isEmpty(x), MdBin::getX, x)
                .eq(!StringUtils.isEmpty(y), MdBin::getY, y)
                .eq(!StringUtils.isEmpty(z), MdBin::getZ, z)
                .page(mbPage);

        return WmsResp.success(pageRes);
    }

    @Override
    public WmsResp updateBin(BinDto binDto) {
        //1.获取当前用户信息
        UserDto user = UserHolder.getUser();
        String username = user.getUsername();

        //2.将dto的信息拷贝到po中
        MdBin mdBin = new MdBin();
        BeanUtils.copyProperties(binDto,mdBin);

        //3.库位编码、条码不参与修改
        mdBin.setKuWeiBianMa(null);
        mdBin.setKuWeiTiaoMa(null);

        mdBin.setUpdateName(username);
        boolean update = this.updateById(mdBin);
        return update ? WmsResp.success("修改成功") : WmsResp.fail("修改失败");
    }

    @Override
    public WmsResp importBin(BinDto binDto) {
        //1.获取当前用户信息
        UserDto user = UserHolder.getUser();
        String username = user.getUsername();

        //2.将dto的信息拷贝到po中
        MdBin mdBin = new MdBin();
        BeanUtils.copyProperties(binDto,mdBin);

        mdBin.setCreateName(username);
        boolean save = this.save(mdBin);
        return save ? WmsResp.success("插入成功"):WmsResp.fail("插入失败");
    }


}
